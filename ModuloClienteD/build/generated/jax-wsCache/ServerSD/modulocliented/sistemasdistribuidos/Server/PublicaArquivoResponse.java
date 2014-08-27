
package modulocliented.sistemasdistribuidos.Server;

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
 *         &lt;element name="publicaArquivoResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "publicaArquivoResult"
})
@XmlRootElement(name = "publicaArquivoResponse")
public class PublicaArquivoResponse {

    protected boolean publicaArquivoResult;

    /**
     * Obtém o valor da propriedade publicaArquivoResult.
     * 
     */
    public boolean isPublicaArquivoResult() {
        return publicaArquivoResult;
    }

    /**
     * Define o valor da propriedade publicaArquivoResult.
     * 
     */
    public void setPublicaArquivoResult(boolean value) {
        this.publicaArquivoResult = value;
    }

}
