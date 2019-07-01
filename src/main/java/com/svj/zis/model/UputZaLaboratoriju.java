
package com.svj.zis.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="zdravstveni_karton">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="broj_zdravstvenog_kartona" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;pattern value="[a-zA-Z]{2}[0-9]{3}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="podaci_o_osiguranju" type="{http://www.svj.com/zis/dokumenti}TPodaci_o_osiguranju"/>
 *         &lt;element name="klinicka_dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="kad_je_uzet_materijal" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ko_salje_materijal" type="{http://www.svj.com/zis/osobe}TOsoba"/>
 *         &lt;element name="ko_salje_na_pregled" type="{http://www.svj.com/zis/osobe}TOsoba"/>
 *         &lt;element name="tip_pregleda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="reg_br" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[0-9]{10}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
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
    "zdravstveniKarton",
    "podaciOOsiguranju",
    "klinickaDijagnoza",
    "kadJeUzetMaterijal",
    "koSaljeMaterijal",
    "koSaljeNaPregled",
    "tipPregleda"
})
@XmlRootElement(name = "uput_za_laboratoriju")
public class UputZaLaboratoriju {

    @XmlElement(name = "zdravstvena_ustanova_koja_salje", required = true)
    protected String zdravstvenaUstanovaKojaSalje;
    @XmlElement(name = "zdravstvena_ustanova_koja_prima", required = true)
    protected String zdravstvenaUstanovaKojaPrima;
    @XmlElement(name = "zdravstveni_karton", required = true)
    protected UputZaLaboratoriju.ZdravstveniKarton zdravstveniKarton;
    @XmlElement(name = "podaci_o_osiguranju", required = true)
    protected TPodaciOOsiguranju podaciOOsiguranju;
    @XmlElement(name = "klinicka_dijagnoza", required = true)
    protected String klinickaDijagnoza;
    @XmlElement(name = "kad_je_uzet_materijal", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar kadJeUzetMaterijal;
    @XmlElement(name = "ko_salje_materijal", required = true)
    protected TOsoba koSaljeMaterijal;
    @XmlElement(name = "ko_salje_na_pregled", required = true)
    protected TOsoba koSaljeNaPregled;
    @XmlElement(name = "tip_pregleda", required = true)
    protected String tipPregleda;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String id;
    @XmlAttribute(name = "reg_br", required = true)
    protected String regBr;

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
     * Gets the value of the zdravstveniKarton property.
     * 
     * @return
     *     possible object is
     *     {@link UputZaLaboratoriju.ZdravstveniKarton }
     *     
     */
    public UputZaLaboratoriju.ZdravstveniKarton getZdravstveniKarton() {
        return zdravstveniKarton;
    }

    /**
     * Sets the value of the zdravstveniKarton property.
     * 
     * @param value
     *     allowed object is
     *     {@link UputZaLaboratoriju.ZdravstveniKarton }
     *     
     */
    public void setZdravstveniKarton(UputZaLaboratoriju.ZdravstveniKarton value) {
        this.zdravstveniKarton = value;
    }

    /**
     * Gets the value of the podaciOOsiguranju property.
     * 
     * @return
     *     possible object is
     *     {@link TPodaciOOsiguranju }
     *     
     */
    public TPodaciOOsiguranju getPodaciOOsiguranju() {
        return podaciOOsiguranju;
    }

    /**
     * Sets the value of the podaciOOsiguranju property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPodaciOOsiguranju }
     *     
     */
    public void setPodaciOOsiguranju(TPodaciOOsiguranju value) {
        this.podaciOOsiguranju = value;
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
     * Gets the value of the koSaljeMaterijal property.
     * 
     * @return
     *     possible object is
     *     {@link TOsoba }
     *     
     */
    public TOsoba getKoSaljeMaterijal() {
        return koSaljeMaterijal;
    }

    /**
     * Sets the value of the koSaljeMaterijal property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOsoba }
     *     
     */
    public void setKoSaljeMaterijal(TOsoba value) {
        this.koSaljeMaterijal = value;
    }

    /**
     * Gets the value of the koSaljeNaPregled property.
     * 
     * @return
     *     possible object is
     *     {@link TOsoba }
     *     
     */
    public TOsoba getKoSaljeNaPregled() {
        return koSaljeNaPregled;
    }

    /**
     * Sets the value of the koSaljeNaPregled property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOsoba }
     *     
     */
    public void setKoSaljeNaPregled(TOsoba value) {
        this.koSaljeNaPregled = value;
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

    /**
     * Gets the value of the regBr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegBr() {
        return regBr;
    }

    /**
     * Sets the value of the regBr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegBr(String value) {
        this.regBr = value;
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
     *       &lt;attribute name="broj_zdravstvenog_kartona" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;pattern value="[a-zA-Z]{2}[0-9]{3}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ZdravstveniKarton {

        @XmlAttribute(name = "broj_zdravstvenog_kartona", required = true)
        protected String brojZdravstvenogKartona;

        /**
         * Gets the value of the brojZdravstvenogKartona property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrojZdravstvenogKartona() {
            return brojZdravstvenogKartona;
        }

        /**
         * Sets the value of the brojZdravstvenogKartona property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrojZdravstvenogKartona(String value) {
            this.brojZdravstvenogKartona = value;
        }

    }

}
