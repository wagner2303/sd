/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.sd.frontendsd;

import br.ufmt.sd.serverws.ClienteD;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baby
 */
public class DownloaderParte implements Runnable {

    private ArrayList<ClienteD> clientesD;
    private int parte;
    private File arquivo;
    private String md5;
    private ThreadListener listener;
    private int index;
    private Random r;

    @Override
    public void run() {
        try {
            Socket socket = new Socket(getRandomCliente().getEndereco(), 5678);

            PrintStream writer = new PrintStream(socket.getOutputStream());
            InputStream reader = socket.getInputStream();
            writer.println(md5);

            writer.println(parte);

            byte[] buffer = new byte[1024];

            reader.read(buffer);
            writeToFile(buffer, parte * 1024);
            socket.close();
            listener.notify(index, parte);

        } catch (IOException ex) {
            Logger.getLogger(DownloaderParte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeToFile(byte[] data, int position)
            throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(arquivo.getAbsolutePath(), "rwd")) {
            file.seek(position);
            file.write(data);
        }
    }

    private ClienteD getRandomCliente() {
        ClienteD clienteD;
        int i = r.nextInt(getClientesD().size());
        clienteD = getClientesD().get(
                i
        );
        return clienteD;
    }

    public DownloaderParte(ArrayList<ClienteD> clientesD, int parte, File arquivo, String md5, ThreadListener listener, int index) {
        this.clientesD = clientesD;
        this.parte = parte;
        this.arquivo = arquivo;
        this.listener = listener;
        this.index = index;
        this.md5 = md5;
        r = new Random();
    }

    public ArrayList<ClienteD> getClientesD() {
        return clientesD;
    }

    public int getParte() {
        return parte;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setClientesD(ArrayList<ClienteD> clientesD) {
        this.clientesD = clientesD;
    }

    public void setParte(int parte) {
        this.parte = parte;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public String getMd5() {
        return md5;
    }

    public ThreadListener getListener() {
        return listener;
    }

    public int getIndex() {
        return index;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public void setListener(ThreadListener listener) {
        this.listener = listener;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
