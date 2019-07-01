
package com.svj.zis.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPodaci_o_osiguranju complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPodaci_o_osiguranju">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nosilac_osiguranja" type="{http://www.svj.com/zis/osobe}TOsoba"/>
 *         &lt;element name="osnov_osiguranja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPodaci_o_osiguranju", propOrder = {
    "nosilacOsiguranja",
    "osnovOsiguranja"
})
public class TPodaciOOsiguranju {

    @XmlElement(name = "nosilac_osiguranja", required = true)
    protected TOsoba nosilacOsiguranja;
    @XmlElement(name = "osnov_osiguranja", required = true)
    protected String osnovOsiguranja;

    /**
     * Gets the value of the nosilacOsiguranja property.
     * 
     * @return
     *     possible object is
     *     {@link TOsoba }
     *     
     */
    public TOsoba getNosilacOsiguranja() {
        return nosilacOsiguranja;
    }

    /**
     * Sets the value of the nosilacOsiguranja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOsoba }
     *     
     */
    public void setNosilacOsiguranja(TOsoba value) {
        this.nosilacOsiguranja = value;
    }

    /**
     * Gets the value of the osnovOsiguranja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsnovOsiguranja() {
        return osnovOsiguranja;
    }

    /**
     * Sets the value of the osnovOsiguranja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsnovOsiguranja(String value) {
        this.osnovOsiguranja = value;
    }

}
