
package br.ufmt.sd.serverws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DescricaoArquivo" type="{http://server.sd.ufmt.br/}DescricaoArquivo" minOccurs="0"/>
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
    "nome",
    "descricaoArquivo"
})
public class ItemBuscaNome {

    protected String nome;
    @XmlElement(name = "DescricaoArquivo")
    protected DescricaoArquivo descricaoArquivo;

    /**
     * Obtém o valor da propriedade nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o valor da propriedade nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

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

}
