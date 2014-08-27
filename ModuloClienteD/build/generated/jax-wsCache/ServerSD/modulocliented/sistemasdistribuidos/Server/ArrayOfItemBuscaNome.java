
package modulocliented.sistemasdistribuidos.Server;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ArrayOfItemBuscaNome complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfItemBuscaNome">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemBuscaNome" type="{http://server.sd.ufmt.br/}ItemBuscaNome" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfItemBuscaNome", propOrder = {
    "itemBuscaNome"
})
public class ArrayOfItemBuscaNome {

    @XmlElement(name = "ItemBuscaNome", nillable = true)
    protected List<ItemBuscaNome> itemBuscaNome;

    /**
     * Gets the value of the itemBuscaNome property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemBuscaNome property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemBuscaNome().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemBuscaNome }
     * 
     * 
     */
    public List<ItemBuscaNome> getItemBuscaNome() {
        if (itemBuscaNome == null) {
            itemBuscaNome = new ArrayList<ItemBuscaNome>();
        }
        return this.itemBuscaNome;
    }

}
