/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.sd.frontendsd;

import br.ufmt.sd.serverws.ClienteD;
import br.ufmt.sd.serverws.DescricaoArquivo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baby
 */
public class DownloaderArquivo implements Runnable {

    private File arquivo;
    private DescricaoArquivo descricaoArquivo;
    private String nomeOriginal;
    private ArrayList<ClienteD> clientesD;
    private Float porcentagemConcluida;
    private boolean[] partesConcluidas;

    public DownloaderArquivo() {
    }

    public DownloaderArquivo(File arquivo, DescricaoArquivo descricaoArquivo, String nomeOriginal, ArrayList<ClienteD> clientesD) {
        this.arquivo = arquivo;
        this.descricaoArquivo = descricaoArquivo;
        this.nomeOriginal = nomeOriginal;
        this.clientesD = clientesD;
        this.partesConcluidas = new boolean[Long.valueOf(this.descricaoArquivo.getTamanho() / 1024 + 1).intValue()];
        for (int i = 0; i < partesConcluidas.length; i++) {
            partesConcluidas[i] = false;
        }

    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public final DescricaoArquivo getDescricaoArquivo() {
        return descricaoArquivo;
    }

    public void setDescricaoArquivo(DescricaoArquivo descricaoArquivo) {
        this.descricaoArquivo = descricaoArquivo;
        this.partesConcluidas = new boolean[getDescricaoArquivo().getTamanho().intValue()];
        for (int i = 0; i < partesConcluidas.length; i++) {
            partesConcluidas[i] = false;
        }
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public ArrayList<ClienteD> getClientesD() {
        return clientesD;
    }

    public void setClientesD(ArrayList<ClienteD> clientesD) {
        this.clientesD = clientesD;
    }

    public Float getPorcentagemConcluida() {
        return porcentagemConcluida;
    }

    public void setPorcentagemConcluida(Float porcentagemConcluida) {
        this.porcentagemConcluida = porcentagemConcluida;
    }

    private boolean hasPartes() {
        int i = 0;
        while (i < partesConcluidas.length) {
            if (partesConcluidas[i] == false) {
                return true;
            }
            i++;
        }
        return false;
    }

    private int getFirstPart() {
        int i = 0;
        while (i < partesConcluidas.length) {
            if (partesConcluidas[i] == false) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public void writeToFile(String filePath, byte[] data, int position)
            throws IOException {

        RandomAccessFile file = new RandomAccessFile(filePath, "rwd");
        file.seek(position);
//        file.write(data, 0, quantidade);
        file.write(data);
        file.close();

    }

    @Override
    public void run() {
        int conexoes = 0;
        // TODO
        Socket socket;
        try {
            socket = new Socket(getClientesD().get(0).getEndereco(), 5678);
            PrintStream writer = new PrintStream(socket.getOutputStream());
            InputStream reader = socket.getInputStream();
            while (hasPartes()) {
                // 192.168.0.5
                writer.println(getDescricaoArquivo().getMd5Arquivo());
                
                int parte = getFirstPart();
                writer.println(getFirstPart());
                
                System.out.print(parte + "\t");
                byte[] buffer = new byte[1024];
//                int bytes = 1024;
//                if((parte + 1)* 1024 > descricaoArquivo.getTamanho()){
//                    bytes = descricaoArquivo.getTamanho().intValue() - parte*1024;
//                }
                System.out.println(reader.read(buffer));
                writeToFile(arquivo.getAbsolutePath(), buffer, parte * 1024);
//                socket.close();
                partesConcluidas[parte] = true;
            }
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(DownloaderArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
