/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.sd.server.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author adrian
 */
@XmlType(name = "DescricaoArquivo")
public class DescricaoArquivo {

    @XmlElement(name = "md5Arquivo")
    private String md5arquivo;
    
    @XmlElement(name = "tamanho")
    private long tamanho;

    public DescricaoArquivo(br.ufmt.sd.server.resources.DescricaoArquivo d) {
        this.md5arquivo = d.getMd5arquivo();
        this.tamanho = d.getTamanho();
    }  

    public DescricaoArquivo() {
    
    }
    
    public String getMd5arquivo() {
        return md5arquivo;
    }

    public long getTamanho() {
        return tamanho;
    }    
}
