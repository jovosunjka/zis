
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
 *         &lt;element name="lekar">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="potpis_lekara" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="pecat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="podaci_o_osiguranju" type="{http://www.svj.com/zis/dokumenti}TPodaci_o_osiguranju"/>
 *         &lt;element name="specijalista">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="lekar">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="lekar_specijalista_za" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="podaci_o_pregledu">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="svrha_pregleda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="obavljen_u_zdravstvenoj_ustanovi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="datum_i_vreme_prijave" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="datum_i_vreme_zavrsetka" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="izvestaj">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="osiguranik">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="pacijent">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="boluje_od" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="nalaz" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="misljenje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="potpis_lekara" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="pecat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "lekar",
    "pecat",
    "datum",
    "podaciOOsiguranju",
    "specijalista",
    "podaciOPregledu",
    "izvestaj"
})
@XmlRootElement(name = "uput_za_specijalisticki_pregled")
public class UputZaSpecijalistickiPregled {

    @XmlElement(name = "zdravstvena_ustanova_koja_salje", required = true)
    protected String zdravstvenaUstanovaKojaSalje;
    @XmlElement(name = "zdravstvena_ustanova_koja_prima", required = true)
    protected String zdravstvenaUstanovaKojaPrima;
    @XmlElement(name = "zdravstveni_karton", required = true)
    protected UputZaSpecijalistickiPregled.ZdravstveniKarton zdravstveniKarton;
    @XmlElement(required = true)
    protected UputZaSpecijalistickiPregled.Lekar lekar;
    @XmlElement(required = true)
    protected String pecat;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(name = "podaci_o_osiguranju", required = true)
    protected TPodaciOOsiguranju podaciOOsiguranju;
    @XmlElement(required = true)
    protected UputZaSpecijalistickiPregled.Specijalista specijalista;
    @XmlElement(name = "podaci_o_pregledu", required = true)
    protected UputZaSpecijalistickiPregled.PodaciOPregledu podaciOPregledu;
    @XmlElement(required = true)
    protected UputZaSpecijalistickiPregled.Izvestaj izvestaj;
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
     *     {@link UputZaSpecijalistickiPregled.ZdravstveniKarton }
     *     
     */
    public UputZaSpecijalistickiPregled.ZdravstveniKarton getZdravstveniKarton() {
        return zdravstveniKarton;
    }

    /**
     * Sets the value of the zdravstveniKarton property.
     * 
     * @param value
     *     allowed object is
     *     {@link UputZaSpecijalistickiPregled.ZdravstveniKarton }
     *     
     */
    public void setZdravstveniKarton(UputZaSpecijalistickiPregled.ZdravstveniKarton value) {
        this.zdravstveniKarton = value;
    }

    /**
     * Gets the value of the lekar property.
     * 
     * @return
     *     possible object is
     *     {@link UputZaSpecijalistickiPregled.Lekar }
     *     
     */
    public UputZaSpecijalistickiPregled.Lekar getLekar() {
        return lekar;
    }

    /**
     * Sets the value of the lekar property.
     * 
     * @param value
     *     allowed object is
     *     {@link UputZaSpecijalistickiPregled.Lekar }
     *     
     */
    public void setLekar(UputZaSpecijalistickiPregled.Lekar value) {
        this.lekar = value;
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
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
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
     * Gets the value of the specijalista property.
     * 
     * @return
     *     possible object is
     *     {@link UputZaSpecijalistickiPregled.Specijalista }
     *     
     */
    public UputZaSpecijalistickiPregled.Specijalista getSpecijalista() {
        return specijalista;
    }

    /**
     * Sets the value of the specijalista property.
     * 
     * @param value
     *     allowed object is
     *     {@link UputZaSpecijalistickiPregled.Specijalista }
     *     
     */
    public void setSpecijalista(UputZaSpecijalistickiPregled.Specijalista value) {
        this.specijalista = value;
    }

    /**
     * Gets the value of the podaciOPregledu property.
     * 
     * @return
     *     possible object is
     *     {@link UputZaSpecijalistickiPregled.PodaciOPregledu }
     *     
     */
    public UputZaSpecijalistickiPregled.PodaciOPregledu getPodaciOPregledu() {
        return podaciOPregledu;
    }

    /**
     * Sets the value of the podaciOPregledu property.
     * 
     * @param value
     *     allowed object is
     *     {@link UputZaSpecijalistickiPregled.PodaciOPregledu }
     *     
     */
    public void setPodaciOPregledu(UputZaSpecijalistickiPregled.PodaciOPregledu value) {
        this.podaciOPregledu = value;
    }

    /**
     * Gets the value of the izvestaj property.
     * 
     * @return
     *     possible object is
     *     {@link UputZaSpecijalistickiPregled.Izvestaj }
     *     
     */
    public UputZaSpecijalistickiPregled.Izvestaj getIzvestaj() {
        return izvestaj;
    }

    /**
     * Sets the value of the izvestaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link UputZaSpecijalistickiPregled.Izvestaj }
     *     
     */
    public void setIzvestaj(UputZaSpecijalistickiPregled.Izvestaj value) {
        this.izvestaj = value;
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
     *       &lt;sequence>
     *         &lt;element name="osiguranik">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="pacijent">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="boluje_od" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="nalaz" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="misljenje" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="potpis_lekara" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "osiguranik",
        "bolujeOd",
        "nalaz",
        "misljenje",
        "datum",
        "potpisLekara",
        "pecat"
    })
    public static class Izvestaj {

        @XmlElement(required = true)
        protected UputZaSpecijalistickiPregled.Izvestaj.Osiguranik osiguranik;
        @XmlElement(name = "boluje_od", required = true)
        protected String bolujeOd;
        @XmlElement(required = true)
        protected String nalaz;
        @XmlElement(required = true)
        protected String misljenje;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datum;
        @XmlElement(name = "potpis_lekara", required = true)
        protected String potpisLekara;
        @XmlElement(required = true)
        protected String pecat;

        /**
         * Gets the value of the osiguranik property.
         * 
         * @return
         *     possible object is
         *     {@link UputZaSpecijalistickiPregled.Izvestaj.Osiguranik }
         *     
         */
        public UputZaSpecijalistickiPregled.Izvestaj.Osiguranik getOsiguranik() {
            return osiguranik;
        }

        /**
         * Sets the value of the osiguranik property.
         * 
         * @param value
         *     allowed object is
         *     {@link UputZaSpecijalistickiPregled.Izvestaj.Osiguranik }
         *     
         */
        public void setOsiguranik(UputZaSpecijalistickiPregled.Izvestaj.Osiguranik value) {
            this.osiguranik = value;
        }

        /**
         * Gets the value of the bolujeOd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBolujeOd() {
            return bolujeOd;
        }

        /**
         * Sets the value of the bolujeOd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBolujeOd(String value) {
            this.bolujeOd = value;
        }

        /**
         * Gets the value of the nalaz property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNalaz() {
            return nalaz;
        }

        /**
         * Sets the value of the nalaz property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNalaz(String value) {
            this.nalaz = value;
        }

        /**
         * Gets the value of the misljenje property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMisljenje() {
            return misljenje;
        }

        /**
         * Sets the value of the misljenje property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMisljenje(String value) {
            this.misljenje = value;
        }

        /**
         * Gets the value of the datum property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatum() {
            return datum;
        }

        /**
         * Sets the value of the datum property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatum(XMLGregorianCalendar value) {
            this.datum = value;
        }

        /**
         * Gets the value of the potpisLekara property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPotpisLekara() {
            return potpisLekara;
        }

        /**
         * Sets the value of the potpisLekara property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPotpisLekara(String value) {
            this.potpisLekara = value;
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="pacijent">
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
            "ime",
            "prezime",
            "pacijent"
        })
        public static class Osiguranik {

            @XmlElement(required = true)
            protected String ime;
            @XmlElement(required = true)
            protected String prezime;
            @XmlElement(required = true)
            protected UputZaSpecijalistickiPregled.Izvestaj.Osiguranik.Pacijent pacijent;

            /**
             * Gets the value of the ime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIme() {
                return ime;
            }

            /**
             * Sets the value of the ime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIme(String value) {
                this.ime = value;
            }

            /**
             * Gets the value of the prezime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPrezime() {
                return prezime;
            }

            /**
             * Sets the value of the prezime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPrezime(String value) {
                this.prezime = value;
            }

            /**
             * Gets the value of the pacijent property.
             * 
             * @return
             *     possible object is
             *     {@link UputZaSpecijalistickiPregled.Izvestaj.Osiguranik.Pacijent }
             *     
             */
            public UputZaSpecijalistickiPregled.Izvestaj.Osiguranik.Pacijent getPacijent() {
                return pacijent;
            }

            /**
             * Sets the value of the pacijent property.
             * 
             * @param value
             *     allowed object is
             *     {@link UputZaSpecijalistickiPregled.Izvestaj.Osiguranik.Pacijent }
             *     
             */
            public void setPacijent(UputZaSpecijalistickiPregled.Izvestaj.Osiguranik.Pacijent value) {
                this.pacijent = value;
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
            public static class Pacijent {

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
     *       &lt;sequence>
     *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="potpis_lekara" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ime",
        "prezime",
        "potpisLekara"
    })
    public static class Lekar {

        @XmlElement(required = true)
        protected String ime;
        @XmlElement(required = true)
        protected String prezime;
        @XmlElement(name = "potpis_lekara", required = true)
        protected String potpisLekara;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String id;

        /**
         * Gets the value of the ime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIme() {
            return ime;
        }

        /**
         * Sets the value of the ime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIme(String value) {
            this.ime = value;
        }

        /**
         * Gets the value of the prezime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrezime() {
            return prezime;
        }

        /**
         * Sets the value of the prezime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrezime(String value) {
            this.prezime = value;
        }

        /**
         * Gets the value of the potpisLekara property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPotpisLekara() {
            return potpisLekara;
        }

        /**
         * Sets the value of the potpisLekara property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPotpisLekara(String value) {
            this.potpisLekara = value;
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
     *       &lt;sequence>
     *         &lt;element name="svrha_pregleda" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="obavljen_u_zdravstvenoj_ustanovi" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="datum_i_vreme_prijave" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="datum_i_vreme_zavrsetka" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
        "svrhaPregleda",
        "obavljenUZdravstvenojUstanovi",
        "datumIVremePrijave",
        "datumIVremeZavrsetka"
    })
    public static class PodaciOPregledu {

        @XmlElement(name = "svrha_pregleda", required = true)
        protected String svrhaPregleda;
        @XmlElement(name = "obavljen_u_zdravstvenoj_ustanovi", required = true)
        protected String obavljenUZdravstvenojUstanovi;
        @XmlElement(name = "datum_i_vreme_prijave", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar datumIVremePrijave;
        @XmlElement(name = "datum_i_vreme_zavrsetka", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar datumIVremeZavrsetka;

        /**
         * Gets the value of the svrhaPregleda property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSvrhaPregleda() {
            return svrhaPregleda;
        }

        /**
         * Sets the value of the svrhaPregleda property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSvrhaPregleda(String value) {
            this.svrhaPregleda = value;
        }

        /**
         * Gets the value of the obavljenUZdravstvenojUstanovi property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObavljenUZdravstvenojUstanovi() {
            return obavljenUZdravstvenojUstanovi;
        }

        /**
         * Sets the value of the obavljenUZdravstvenojUstanovi property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObavljenUZdravstvenojUstanovi(String value) {
            this.obavljenUZdravstvenojUstanovi = value;
        }

        /**
         * Gets the value of the datumIVremePrijave property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumIVremePrijave() {
            return datumIVremePrijave;
        }

        /**
         * Sets the value of the datumIVremePrijave property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumIVremePrijave(XMLGregorianCalendar value) {
            this.datumIVremePrijave = value;
        }

        /**
         * Gets the value of the datumIVremeZavrsetka property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumIVremeZavrsetka() {
            return datumIVremeZavrsetka;
        }

        /**
         * Sets the value of the datumIVremeZavrsetka property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumIVremeZavrsetka(XMLGregorianCalendar value) {
            this.datumIVremeZavrsetka = value;
        }

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
     *       &lt;sequence>
     *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="lekar">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="lekar_specijalista_za" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "ime",
        "prezime",
        "lekar",
        "lekarSpecijalistaZa"
    })
    public static class Specijalista {

        @XmlElement(required = true)
        protected String ime;
        @XmlElement(required = true)
        protected String prezime;
        @XmlElement(required = true)
        protected UputZaSpecijalistickiPregled.Specijalista.Lekar lekar;
        @XmlElement(name = "lekar_specijalista_za", required = true)
        protected String lekarSpecijalistaZa;

        /**
         * Gets the value of the ime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIme() {
            return ime;
        }

        /**
         * Sets the value of the ime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIme(String value) {
            this.ime = value;
        }

        /**
         * Gets the value of the prezime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrezime() {
            return prezime;
        }

        /**
         * Sets the value of the prezime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrezime(String value) {
            this.prezime = value;
        }

        /**
         * Gets the value of the lekar property.
         * 
         * @return
         *     possible object is
         *     {@link UputZaSpecijalistickiPregled.Specijalista.Lekar }
         *     
         */
        public UputZaSpecijalistickiPregled.Specijalista.Lekar getLekar() {
            return lekar;
        }

        /**
         * Sets the value of the lekar property.
         * 
         * @param value
         *     allowed object is
         *     {@link UputZaSpecijalistickiPregled.Specijalista.Lekar }
         *     
         */
        public void setLekar(UputZaSpecijalistickiPregled.Specijalista.Lekar value) {
            this.lekar = value;
        }

        /**
         * Gets the value of the lekarSpecijalistaZa property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLekarSpecijalistaZa() {
            return lekarSpecijalistaZa;
        }

        /**
         * Sets the value of the lekarSpecijalistaZa property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLekarSpecijalistaZa(String value) {
            this.lekarSpecijalistaZa = value;
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
        public static class Lekar {

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
