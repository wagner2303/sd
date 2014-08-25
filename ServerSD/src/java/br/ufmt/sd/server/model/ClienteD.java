/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmt.sd.server.model;

import br.ufmt.sd.server.resources.Cliented;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author adrian
 */
@XmlType(name = "ClienteD")
public class ClienteD {
    @XmlElement(name = "endereco")
    private String endereco;
    
    @XmlElement(name = "velocidadeConexao")
    private Double velocidadeConexao;

    public ClienteD(Cliented c) {
        this.endereco = c.getEndereco();
        this.velocidadeConexao = c.getVelocidadeconexao();
    }

    public ClienteD() {
    }
    
    public String getEndereco() {
        return endereco;
    }

    public Double getVelocidadeConexao() {
        return velocidadeConexao;
    }
    
}
