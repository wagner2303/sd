
package br.ufmt.sd.serverws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="BuscaArquivoResult" type="{http://server.sd.ufmt.br/}ArrayOfItemBuscaNome" minOccurs="0"/>
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
    "buscaArquivoResult"
})
@XmlRootElement(name = "BuscaArquivoResponse")
public class BuscaArquivoResponse {

    @XmlElement(name = "BuscaArquivoResult")
    protected ArrayOfItemBuscaNome buscaArquivoResult;

    /**
     * Obtém o valor da propriedade buscaArquivoResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItemBuscaNome }
     *     
     */
    public ArrayOfItemBuscaNome getBuscaArquivoResult() {
        return buscaArquivoResult;
    }

    /**
     * Define o valor da propriedade buscaArquivoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItemBuscaNome }
     *     
     */
    public void setBuscaArquivoResult(ArrayOfItemBuscaNome value) {
        this.buscaArquivoResult = value;
    }

}
