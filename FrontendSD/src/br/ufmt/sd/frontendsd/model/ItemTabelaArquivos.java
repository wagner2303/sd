/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmt.sd.frontendsd.model;

import br.ufmt.sd.serverws.ItemBuscaNome;

/**
 *
 * @author baby
 */
public class ItemTabelaArquivos {
    private String nomeArquivo;
    private Long tamanho;
    private String md5Arquivo;

    public ItemTabelaArquivos(ItemBuscaNome itemBuscaNome){
        this.nomeArquivo = itemBuscaNome.getNome();
        this.tamanho = itemBuscaNome.getDescricaoArquivo().getTamanho();
        this.md5Arquivo = itemBuscaNome.getDescricaoArquivo().getMd5Arquivo();
    }
    public ItemTabelaArquivos(String nomeArquivo, Long tamanho, String md5Arquivo) {
        this.nomeArquivo = nomeArquivo;
        this.tamanho = tamanho;
        this.md5Arquivo = md5Arquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public Long getTamanho() {
        return tamanho;
    }

    public String getMd5Arquivo() {
        return md5Arquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void setTamanho(Long tamanho) {
        this.tamanho = tamanho;
    }

    public void setMd5Arquivo(String md5Arquivo) {
        this.md5Arquivo = md5Arquivo;
    }
    
    
}
