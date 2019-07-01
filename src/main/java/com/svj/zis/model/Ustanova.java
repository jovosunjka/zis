
package com.svj.zis.model;

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
 *         &lt;element name="naziv_zdrastvene_ustanove" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="drzava" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "nazivZdrastveneUstanove",
    "drzava"
})
@XmlRootElement(name = "ustanova")
public class Ustanova {

    @XmlElement(name = "naziv_zdrastvene_ustanove", required = true)
    protected String nazivZdrastveneUstanove;
    @XmlElement(required = true)
    protected String drzava;

    /**
     * Gets the value of the nazivZdrastveneUstanove property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivZdrastveneUstanove() {
        return nazivZdrastveneUstanove;
    }

    /**
     * Sets the value of the nazivZdrastveneUstanove property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivZdrastveneUstanove(String value) {
        this.nazivZdrastveneUstanove = value;
    }

    /**
     * Gets the value of the drzava property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzava() {
        return drzava;
    }

    /**
     * Sets the value of the drzava property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzava(String value) {
        this.drzava = value;
    }

}
