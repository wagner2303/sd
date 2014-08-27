/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.sd.frontendsd;

import br.ufmt.sd.frontendsd.listeners.DownloadListener;
import br.ufmt.sd.frontendsd.listeners.ThreadListener;
import br.ufmt.sd.serverws.ClienteD;
import br.ufmt.sd.serverws.DescricaoArquivo;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author baby
 */
public class DownloaderArquivo implements Runnable, ThreadListener {

    private File arquivo;
    private DescricaoArquivo descricaoArquivo;
    private String nomeOriginal;
    private ArrayList<ClienteD> clientesD;
//    private Float porcentagemConcluida;
    private boolean[] partesConcluidas;
    private Thread[] threads = new Thread[5];
    private DownloadListener listener;
    private int numThreads;

    public DownloaderArquivo() {
    }

    public DownloaderArquivo(File arquivo, DescricaoArquivo descricaoArquivo, String nomeOriginal, ArrayList<ClienteD> clientesD, DownloadListener listener) {
        this.arquivo = arquivo;
        this.descricaoArquivo = descricaoArquivo;
        this.nomeOriginal = nomeOriginal;
        this.clientesD = clientesD;
        this.partesConcluidas = new boolean[Long.valueOf(this.descricaoArquivo.getTamanho() / 1024 + 1).intValue()];
        this.listener = listener;
        this.numThreads = 0;
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
//        this.partesConcluidas = new boolean[getDescricaoArquivo().getTamanho().intValue()];
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

//    public Float getPorcentagemConcluida() {
//        return porcentagemConcluida;
//    }

//    public void setPorcentagemConcluida(Float porcentagemConcluida) {
//        this.porcentagemConcluida = porcentagemConcluida;
//    }

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

    @Override
    public void run() {
        int conexoes = 0;
        for (int index = 0; index < 5; index++) {
            threads[index] = new Thread(new DownloaderParte(clientesD, getFirstPart(), arquivo, getDescricaoArquivo().getMd5Arquivo(), this, index));
            threads[index].start();
        }
    }

    @Override
    public void notify(int index, int parte) {
        partesConcluidas[parte] = true;
        if (hasPartes()) {
            threads[index] = new Thread(new DownloaderParte(clientesD, getFirstPart(), arquivo, getDescricaoArquivo().getMd5Arquivo(), this, index));
            threads[index].start();
        }else{
            System.out.print(index + " ");
            if(numThreads < 5){
                numThreads = numThreads + 1;
            }else{
                listener.finished();
            }
        }
    }

}
