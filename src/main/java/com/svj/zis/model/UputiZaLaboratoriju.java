
package com.svj.zis.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.svj.com/zis/dokumenti}uput_za_laboratoriju" maxOccurs="unbounded" minOccurs="0"/>
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
    "uputZaLaboratoriju"
})
@XmlRootElement(name = "uputi_za_laboratoriju", namespace = "http://www.svj.com/zis/kolekcije")
public class UputiZaLaboratoriju {

    @XmlElement(name = "uput_za_laboratoriju")
    protected List<UputZaLaboratoriju> uputZaLaboratoriju;

    /**
     * Gets the value of the uputZaLaboratoriju property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uputZaLaboratoriju property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUputZaLaboratoriju().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UputZaLaboratoriju }
     * 
     * 
     */
    public List<UputZaLaboratoriju> getUputZaLaboratoriju() {
        if (uputZaLaboratoriju == null) {
            uputZaLaboratoriju = new ArrayList<UputZaLaboratoriju>();
        }
        return this.uputZaLaboratoriju;
    }

}
