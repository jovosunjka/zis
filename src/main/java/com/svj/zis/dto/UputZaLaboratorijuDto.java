
package com.svj.zis.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="klinicka_dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="kad_je_uzet_materijal" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="tip_pregleda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lekarov_potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pecat" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "klinickaDijagnoza",
    "kadJeUzetMaterijal",
    "tipPregleda",
    "lekarovPotpis",
    "pecat"
})
@XmlRootElement(name = "uput_za_laboratoriju_dto")
public class UputZaLaboratorijuDto {

    @XmlElement(name = "zdravstvena_ustanova_koja_salje", required = true)
    protected String zdravstvenaUstanovaKojaSalje;
    @XmlElement(name = "zdravstvena_ustanova_koja_prima", required = true)
    protected String zdravstvenaUstanovaKojaPrima;
    @XmlElement(name = "klinicka_dijagnoza", required = true)
    protected String klinickaDijagnoza;
    @XmlElement(name = "kad_je_uzet_materijal", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar kadJeUzetMaterijal;
    @XmlElement(name = "tip_pregleda", required = true)
    protected String tipPregleda;
    @XmlElement(name = "lekarov_potpis", required = true)
    protected String lekarovPotpis;
    @XmlElement(required = true)
    protected String pecat;

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
     * Gets the value of the klinickaDijagnoza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKlinickaDijagnoza() {
        return klinickaDijagnoza;
    }

    /**
     * Sets the value of the klinickaDijagnoza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKlinickaDijagnoza(String value) {
        this.klinickaDijagnoza = value;
    }

    /**
     * Gets the value of the kadJeUzetMaterijal property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getKadJeUzetMaterijal() {
        return kadJeUzetMaterijal;
    }

    /**
     * Sets the value of the kadJeUzetMaterijal property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setKadJeUzetMaterijal(XMLGregorianCalendar value) {
        this.kadJeUzetMaterijal = value;
    }

    /**
     * Gets the value of the tipPregleda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipPregleda() {
        return tipPregleda;
    }

    /**
     * Sets the value of the tipPregleda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipPregleda(String value) {
        this.tipPregleda = value;
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

}
