
package br.ufmt.sd.serverws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getListaClienteDResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getListaClienteDResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClienteD" type="{http://server.sd.ufmt.br/}ClienteD" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListaClienteDResponse", propOrder = {
    "clienteD"
})
public class GetListaClienteDResponse {

    @XmlElement(name = "ClienteD", nillable = true)
    protected List<ClienteD> clienteD;

    /**
     * Gets the value of the clienteD property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clienteD property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClienteD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClienteD }
     * 
     * 
     */
    public List<ClienteD> getClienteD() {
        if (clienteD == null) {
            clienteD = new ArrayList<ClienteD>();
        }
        return this.clienteD;
    }

}
