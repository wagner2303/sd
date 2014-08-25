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
@XmlType(name = "ItemBuscaNome")
public class ItemBuscaNome {

    @XmlElement(name = "nome")
    private String nome;
    @XmlElement(name = "DescricaoArquivo")
    private DescricaoArquivo md5arquivo;

    public ItemBuscaNome(br.ufmt.sd.server.resources.ItemBuscaNome i) {
        this.nome = i.getNome();
        this.md5arquivo = new DescricaoArquivo(i.getMd5arquivo());
    }

    public ItemBuscaNome() {
    }
    
    public String getNome() {
        return nome;
    }

}
