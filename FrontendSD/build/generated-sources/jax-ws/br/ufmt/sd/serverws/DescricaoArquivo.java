
package br.ufmt.sd.serverws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de DescricaoArquivo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DescricaoArquivo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tamanho" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="md5Arquivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DescricaoArquivo", propOrder = {
    "tamanho",
    "md5Arquivo"
})
public class DescricaoArquivo {

    protected Long tamanho;
    protected String md5Arquivo;

    /**
     * Obtém o valor da propriedade tamanho.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTamanho() {
        return tamanho;
    }

    /**
     * Define o valor da propriedade tamanho.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTamanho(Long value) {
        this.tamanho = value;
    }

    /**
     * Obtém o valor da propriedade md5Arquivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMd5Arquivo() {
        return md5Arquivo;
    }

    /**
     * Define o valor da propriedade md5Arquivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMd5Arquivo(String value) {
        this.md5Arquivo = value;
    }

}
