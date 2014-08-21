/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmt.sd.frontendsd;

import br.ufmt.sd.serverws.ClienteD;
import br.ufmt.sd.serverws.DescricaoArquivo;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author baby
 */
public class DownloaderArquivo {
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
        this.partesConcluidas = new boolean[getDescricaoArquivo().getTamanho().intValue()];
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

    public DescricaoArquivo getDescricaoArquivo() {
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
        
    
}
