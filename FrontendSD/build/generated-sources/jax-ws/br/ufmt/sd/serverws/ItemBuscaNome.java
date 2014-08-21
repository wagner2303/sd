
package br.ufmt.sd.serverws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ItemBuscaNome complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ItemBuscaNome">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descricaoArquivo" type="{http://server.sd.ufmt.br/}DescricaoArquivo" minOccurs="0"/>
 *         &lt;element name="nomeArquivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemBuscaNome", propOrder = {
    "descricaoArquivo",
    "nomeArquivo"
})
public class ItemBuscaNome {

    protected DescricaoArquivo descricaoArquivo;
    protected String nomeArquivo;

    /**
     * Obtém o valor da propriedade descricaoArquivo.
     * 
     * @return
     *     possible object is
     *     {@link DescricaoArquivo }
     *     
     */
    public DescricaoArquivo getDescricaoArquivo() {
        return descricaoArquivo;
    }

    /**
     * Define o valor da propriedade descricaoArquivo.
     * 
     * @param value
     *     allowed object is
     *     {@link DescricaoArquivo }
     *     
     */
    public void setDescricaoArquivo(DescricaoArquivo value) {
        this.descricaoArquivo = value;
    }

    /**
     * Obtém o valor da propriedade nomeArquivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    /**
     * Define o valor da propriedade nomeArquivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeArquivo(String value) {
        this.nomeArquivo = value;
    }

}
