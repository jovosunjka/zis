
package com.svj.zis.dto;

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
 *         &lt;element name="dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="anamneza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="terapija" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "dijagnoza",
    "anamneza",
    "terapija"
})
@XmlRootElement(name = "report_dto")
public class ReportDto {

    @XmlElement(required = true)
    protected String dijagnoza;
    @XmlElement(required = true)
    protected String anamneza;
    @XmlElement(required = true)
    protected String terapija;

    /**
     * Gets the value of the dijagnoza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDijagnoza() {
        return dijagnoza;
    }

    /**
     * Sets the value of the dijagnoza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDijagnoza(String value) {
        this.dijagnoza = value;
    }

    /**
     * Gets the value of the anamneza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnamneza() {
        return anamneza;
    }

    /**
     * Sets the value of the anamneza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnamneza(String value) {
        this.anamneza = value;
    }

    /**
     * Gets the value of the terapija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerapija() {
        return terapija;
    }

    /**
     * Sets the value of the terapija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerapija(String value) {
        this.terapija = value;
    }

}
