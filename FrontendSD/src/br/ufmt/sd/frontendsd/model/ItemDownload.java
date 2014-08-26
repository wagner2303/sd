/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.sd.frontendsd.model;

import br.ufmt.sd.frontendsd.DownloaderArquivo;
import br.ufmt.sd.frontendsd.listeners.DownloadListener;
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
    private Float tamanho;
    private Float baixados;
    private Float porcentagem;
    private String status;
    private Thread downloader;

    public ItemDownload(File arquivo, DescricaoArquivo descricaoArquivo, String nomeOriginal, ArrayList<ClienteD> clientesD) {
        nomeArquivo = arquivo.getName();
        tamanho = descricaoArquivo.getTamanho() / 1024f;
        baixados = 0.0f;
        porcentagem = 0.0f;
        status = "iniciando...";
        downloader = new Thread(new DownloaderArquivo(arquivo, descricaoArquivo, nomeOriginal, clientesD));
    }

    public void start() {
        downloader.start();
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public Float getTamanho() {
        return tamanho;
    }

    public Float getBaixados() {
        return baixados;
    }

    public Float getPorcentagem() {
        return porcentagem;
    }

    public String getStatus() {
        return status;
    }

    public Thread getDownloader() {
        return downloader;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void setTamanho(Float tamanho) {
        this.tamanho = tamanho;
    }

    public void setBaixados(Float baixados) {
        this.baixados = baixados;
    }

    public void setPorcentagem(Float porcentagem) {
        this.porcentagem = porcentagem;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void finished() {
        status = "Concluido";
    }

    @Override
    public void finishedParte() {
        status = "Baixando";
        baixados += 1f;
        //atualizaPorcentagem
        porcentagem = (baixados / tamanho) * 100;
        if (porcentagem > 100f) {
            porcentagem = 100f;
        } else {
        }
    }

}
