/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.sd.frontendsd.model;

import br.ufmt.sd.frontendsd.DownloaderArquivo;
import br.ufmt.sd.frontendsd.listeners.DownloadListener;
import br.ufmt.sd.frontendsd.listeners.ItemDownloadListener;
import br.ufmt.sd.frontendsd.model.enums.StatusDownload;
import br.ufmt.sd.serverws.ClienteD;
import br.ufmt.sd.serverws.DescricaoArquivo;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author baby
 */
public class ItemDownload implements DownloadListener {

    private String nomeArquivo;
    private Long tamanho;
    private StatusDownload status;
    private Thread downloader;
    private ItemDownloadListener downloadListener;

    public ItemDownload(File arquivo, 
            DescricaoArquivo descricaoArquivo, 
            String nomeOriginal, 
            ArrayList<ClienteD> clientesD, 
            ItemDownloadListener downloadListener) {
        nomeArquivo = arquivo.getName();
        tamanho = descricaoArquivo.getTamanho() / 1024;
        this.downloadListener = downloadListener;
//        status = StatusDownload.Baixando;
        downloader = new Thread(new DownloaderArquivo(arquivo, descricaoArquivo, nomeOriginal, clientesD, this));
    }

    public void start() {
        downloader.start();
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public Long getTamanho() {
        return tamanho;
    }

    public StatusDownload getStatus() {
        return status;
    }

    public Thread getDownloader() {
        return downloader;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void setTamanho(Long tamanho) {
        this.tamanho = tamanho;
    }

    public void setStatus(StatusDownload status) {
        this.status = status;
    }

    @Override
    public void finished() {
        setStatus(StatusDownload.Concluído);
        downloadListener.updateTable();
    }

}
