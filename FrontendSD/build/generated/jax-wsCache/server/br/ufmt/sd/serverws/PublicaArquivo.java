
package br.ufmt.sd.serverws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de publicaArquivo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="publicaArquivo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arquivo" type="{http://server.sd.ufmt.br/}ItemBuscaNome" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publicaArquivo", propOrder = {
    "arquivo",
    "arg1"
})
public class PublicaArquivo {

    protected ItemBuscaNome arquivo;
    protected String arg1;

    /**
     * Obtém o valor da propriedade arquivo.
     * 
     * @return
     *     possible object is
     *     {@link ItemBuscaNome }
     *     
     */
    public ItemBuscaNome getArquivo() {
        return arquivo;
    }

    /**
     * Define o valor da propriedade arquivo.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemBuscaNome }
     *     
     */
    public void setArquivo(ItemBuscaNome value) {
        this.arquivo = value;
    }

    /**
     * Obtém o valor da propriedade arg1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg1() {
        return arg1;
    }

    /**
     * Define o valor da propriedade arg1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg1(String value) {
        this.arg1 = value;
    }

}
