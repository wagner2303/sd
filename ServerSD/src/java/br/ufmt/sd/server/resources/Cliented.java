/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmt.sd.server.resources;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adrian
 */
@Entity
@Table(name = "cliented")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliented.findAll", query = "SELECT c FROM Cliented c"),
    @NamedQuery(name = "Cliented.findByEndereco", query = "SELECT c FROM Cliented c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "Cliented.findByVelocidadeconexao", query = "SELECT c FROM Cliented c WHERE c.velocidadeconexao = :velocidadeconexao")})
public class Cliented implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "endereco")
    private String endereco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "velocidadeconexao")
    private Double velocidadeconexao;
    @JoinTable(name = "cliente_descricaoarquivo", joinColumns = {
        @JoinColumn(name = "endereco", referencedColumnName = "endereco")}, inverseJoinColumns = {
        @JoinColumn(name = "md5arquivo", referencedColumnName = "md5arquivo")})
    @ManyToMany
    private List<DescricaoArquivo> descricaoArquivoList;

    public Cliented() {
    }

    public Cliented(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getVelocidadeconexao() {
        return velocidadeconexao;
    }

    public void setVelocidadeconexao(Double velocidadeconexao) {
        this.velocidadeconexao = velocidadeconexao;
    }

    @XmlTransient
    public List<DescricaoArquivo> getDescricaoArquivoList() {
        return descricaoArquivoList;
    }

    public void setDescricaoArquivoList(List<DescricaoArquivo> descricaoArquivoList) {
        this.descricaoArquivoList = descricaoArquivoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (endereco != null ? endereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliented)) {
            return false;
        }
        Cliented other = (Cliented) object;
        if ((this.endereco == null && other.endereco != null) || (this.endereco != null && !this.endereco.equals(other.endereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufmt.sd.server.resources.Cliented[ endereco=" + endereco + " ]";
    }
    
}
