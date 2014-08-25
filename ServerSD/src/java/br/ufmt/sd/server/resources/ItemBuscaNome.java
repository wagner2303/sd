/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmt.sd.server.resources;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adrian
 */
@Entity
@Table(name = "itembuscanome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemBuscaNome.findAll", query = "SELECT i FROM ItemBuscaNome i"),
    @NamedQuery(name = "ItemBuscaNome.findByIditembuscanome", query = "SELECT i FROM ItemBuscaNome i WHERE i.iditembuscanome = :iditembuscanome"),
    @NamedQuery(name = "ItemBuscaNome.findByNome", query = "SELECT i FROM ItemBuscaNome i WHERE UPPER(i.nome) LIKE :nome")})
public class ItemBuscaNome implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditembuscanome")
    private Integer iditembuscanome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "md5arquivo", referencedColumnName = "md5arquivo")
    @ManyToOne(optional = false)
    private DescricaoArquivo md5arquivo;

    public ItemBuscaNome() {
    }

    public ItemBuscaNome(Integer iditembuscanome) {
        this.iditembuscanome = iditembuscanome;
    }

    public ItemBuscaNome(Integer iditembuscanome, String nome) {
        this.iditembuscanome = iditembuscanome;
        this.nome = nome;
    }

    public Integer getIditembuscanome() {
        return iditembuscanome;
    }

    public void setIditembuscanome(Integer iditembuscanome) {
        this.iditembuscanome = iditembuscanome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DescricaoArquivo getMd5arquivo() {
        return md5arquivo;
    }

    public void setMd5arquivo(DescricaoArquivo md5arquivo) {
        this.md5arquivo = md5arquivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditembuscanome != null ? iditembuscanome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemBuscaNome)) {
            return false;
        }
        ItemBuscaNome other = (ItemBuscaNome) object;
        if ((this.iditembuscanome == null && other.iditembuscanome != null) || (this.iditembuscanome != null && !this.iditembuscanome.equals(other.iditembuscanome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufmt.sd.server.resources.ItemBuscaNome[ iditembuscanome=" + iditembuscanome + " ]";
    }
    
}
