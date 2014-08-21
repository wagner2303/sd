
package br.ufmt.sd.serverws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de buscaArquivo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="buscaArquivo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="termo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscaArquivo", propOrder = {
    "termo"
})
public class BuscaArquivo {

    protected String termo;

    /**
     * Obtém o valor da propriedade termo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermo() {
        return termo;
    }

    /**
     * Define o valor da propriedade termo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermo(String value) {
        this.termo = value;
    }

}
