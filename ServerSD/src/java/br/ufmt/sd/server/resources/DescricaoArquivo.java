/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmt.sd.server.resources;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "descricaoarquivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescricaoArquivo.findAll", query = "SELECT d FROM DescricaoArquivo d"),
    @NamedQuery(name = "DescricaoArquivo.findByMd5arquivo", query = "SELECT d FROM DescricaoArquivo d WHERE d.md5arquivo = :md5arquivo"),
    @NamedQuery(name = "DescricaoArquivo.findByTamanho", query = "SELECT d FROM DescricaoArquivo d WHERE d.tamanho = :tamanho")})
public class DescricaoArquivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "md5arquivo")
    private String md5arquivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tamanho")
    private long tamanho;
    @ManyToMany(mappedBy = "descricaoArquivoList")
    private List<Cliented> clientedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "md5arquivo")
    private List<ItemBuscaNome> itemBuscaNomeList;

    public DescricaoArquivo() {
    }

    public DescricaoArquivo(String md5arquivo) {
        this.md5arquivo = md5arquivo;
    }

    public DescricaoArquivo(String md5arquivo, long tamanho) {
        this.md5arquivo = md5arquivo;
        this.tamanho = tamanho;
    }

    public String getMd5arquivo() {
        return md5arquivo;
    }

    public void setMd5arquivo(String md5arquivo) {
        this.md5arquivo = md5arquivo;
    }

    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }

    @XmlTransient
    public List<Cliented> getClientedList() {
        return clientedList;
    }

    public void setClientedList(List<Cliented> clientedList) {
        this.clientedList = clientedList;
    }

    @XmlTransient
    public List<ItemBuscaNome> getItemBuscaNomeList() {
        return itemBuscaNomeList;
    }

    public void setItemBuscaNomeList(List<ItemBuscaNome> itemBuscaNomeList) {
        this.itemBuscaNomeList = itemBuscaNomeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (md5arquivo != null ? md5arquivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescricaoArquivo)) {
            return false;
        }
        DescricaoArquivo other = (DescricaoArquivo) object;
        if ((this.md5arquivo == null && other.md5arquivo != null) || (this.md5arquivo != null && !this.md5arquivo.equals(other.md5arquivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufmt.sd.server.resources.DescricaoArquivo[ md5arquivo=" + md5arquivo + " ]";
    }
    
}
