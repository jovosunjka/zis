
package com.svj.zis.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="zdravstvena_ustanova_koja_salje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zdravstvena_ustanova_koja_prima" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lekarov_potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pecat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="specijalista">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "zdravstvenaUstanovaKojaSalje",
    "zdravstvenaUstanovaKojaPrima",
    "lekarovPotpis",
    "pecat",
    "specijalista"
})
@XmlRootElement(name = "uput_za_specijalisticki_pregled_dto")
public class UputZaSpecijalistickiPregledDto {

    @XmlElement(name = "zdravstvena_ustanova_koja_salje", required = true)
    protected String zdravstvenaUstanovaKojaSalje;
    @XmlElement(name = "zdravstvena_ustanova_koja_prima", required = true)
    protected String zdravstvenaUstanovaKojaPrima;
    @XmlElement(name = "lekarov_potpis", required = true)
    protected String lekarovPotpis;
    @XmlElement(required = true)
    protected String pecat;
    @XmlElement(required = true)
    protected UputZaSpecijalistickiPregledDto.Specijalista specijalista;

    /**
     * Gets the value of the zdravstvenaUstanovaKojaSalje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdravstvenaUstanovaKojaSalje() {
        return zdravstvenaUstanovaKojaSalje;
    }

    /**
     * Sets the value of the zdravstvenaUstanovaKojaSalje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdravstvenaUstanovaKojaSalje(String value) {
        this.zdravstvenaUstanovaKojaSalje = value;
    }

    /**
     * Gets the value of the zdravstvenaUstanovaKojaPrima property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdravstvenaUstanovaKojaPrima() {
        return zdravstvenaUstanovaKojaPrima;
    }

    /**
     * Sets the value of the zdravstvenaUstanovaKojaPrima property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdravstvenaUstanovaKojaPrima(String value) {
        this.zdravstvenaUstanovaKojaPrima = value;
    }

    /**
     * Gets the value of the lekarovPotpis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLekarovPotpis() {
        return lekarovPotpis;
    }

    /**
     * Sets the value of the lekarovPotpis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLekarovPotpis(String value) {
        this.lekarovPotpis = value;
    }

    /**
     * Gets the value of the pecat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPecat() {
        return pecat;
    }

    /**
     * Sets the value of the pecat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPecat(String value) {
        this.pecat = value;
    }

    /**
     * Gets the value of the specijalista property.
     * 
     * @return
     *     possible object is
     *     {@link UputZaSpecijalistickiPregledDto.Specijalista }
     *     
     */
    public UputZaSpecijalistickiPregledDto.Specijalista getSpecijalista() {
        return specijalista;
    }

    /**
     * Sets the value of the specijalista property.
     * 
     * @param value
     *     allowed object is
     *     {@link UputZaSpecijalistickiPregledDto.Specijalista }
     *     
     */
    public void setSpecijalista(UputZaSpecijalistickiPregledDto.Specijalista value) {
        this.specijalista = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Specijalista {

        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String id;

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

    }

}
