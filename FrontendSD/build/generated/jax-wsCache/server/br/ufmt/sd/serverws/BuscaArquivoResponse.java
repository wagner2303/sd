
package br.ufmt.sd.serverws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de buscaArquivoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="buscaArquivoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemBuscaName" type="{http://server.sd.ufmt.br/}ItemBuscaNome" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscaArquivoResponse", propOrder = {
    "itemBuscaName"
})
public class BuscaArquivoResponse {

    @XmlElement(name = "ItemBuscaName", nillable = true)
    protected List<ItemBuscaNome> itemBuscaName;

    /**
     * Gets the value of the itemBuscaName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemBuscaName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemBuscaName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemBuscaNome }
     * 
     * 
     */
    public List<ItemBuscaNome> getItemBuscaName() {
        if (itemBuscaName == null) {
            itemBuscaName = new ArrayList<ItemBuscaNome>();
        }
        return this.itemBuscaName;
    }

}
