
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
 *         &lt;element ref="{http://www.svj.com/zis/osobe}lekar" maxOccurs="unbounded" minOccurs="0"/>
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
    "lekar"
})
@XmlRootElement(name = "lekari", namespace = "http://www.svj.com/zis/kolekcije")
public class Lekari {

    @XmlElement(namespace = "http://www.svj.com/zis/osobe")
    protected List<Lekar> lekar;

    /**
     * Gets the value of the lekar property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lekar property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLekar().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Lekar }
     * 
     * 
     */
    public List<Lekar> getLekar() {
        if (lekar == null) {
            lekar = new ArrayList<Lekar>();
        }
        return this.lekar;
    }

}
