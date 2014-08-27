
package br.ufmt.sd.serverws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getClientesDResult" type="{http://server.sd.ufmt.br/}ArrayOfClienteD" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getClientesDResult"
})
@XmlRootElement(name = "getClientesDResponse")
public class GetClientesDResponse {

    protected ArrayOfClienteD getClientesDResult;

    /**
     * Obtém o valor da propriedade getClientesDResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClienteD }
     *     
     */
    public ArrayOfClienteD getGetClientesDResult() {
        return getClientesDResult;
    }

    /**
     * Define o valor da propriedade getClientesDResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClienteD }
     *     
     */
    public void setGetClientesDResult(ArrayOfClienteD value) {
        this.getClientesDResult = value;
    }

}
