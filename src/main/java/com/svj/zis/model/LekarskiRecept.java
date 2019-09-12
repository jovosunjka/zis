
package com.svj.zis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


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
 *         &lt;element name="osigurano_lice">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
 *         &lt;element ref="{http://www.svj.com/zis/dokumenti}ustanova"/>
 *         &lt;element name="zdravstveni_karton">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                 &lt;attribute name="broj_zdravstvenog_kartona" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;pattern value="[a-zA-Z]{2}[0-9]{3}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="broj_zdrastvene_knjizice" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;pattern value="[0-9]{11}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="osnov_oslobadjanja_od_participacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.svj.com/zis/dokumenti}podaci_o_lekaru"/>
 *         &lt;element name="propisani_lek" type="{http://www.svj.com/zis/dokumenti}TPodaci_o_leku"/>
 *         &lt;element name="izdati_lek" type="{http://www.svj.com/zis/dokumenti}TPodaci_o_leku"/>
 *         &lt;element name="dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="redni_broj" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kolicina" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="potpis_farmaceuta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lek_primio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rp">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="link" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                           &lt;anyAttribute processContents='lax'/>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "osiguranoLice",
    "ustanova",
    "zdravstveniKarton",
    "osnovOslobadjanjaOdParticipacije",
    "podaciOLekaru",
    "propisaniLek",
    "izdatiLek",
    "dijagnoza",
    "redniBroj",
    "kolicina",
    "potpisFarmaceuta",
    "lekPrimio",
    "rp"
})
@XmlRootElement(name = "lekarski_recept")
public class LekarskiRecept {

    @XmlElement(name = "osigurano_lice", required = true)
    protected LekarskiRecept.OsiguranoLice osiguranoLice;
    @XmlElement(required = true)
    protected Ustanova ustanova;
    @XmlElement(name = "zdravstveni_karton", required = true)
    protected LekarskiRecept.ZdravstveniKarton zdravstveniKarton;
    @XmlElement(name = "osnov_oslobadjanja_od_participacije", required = true)
    protected String osnovOslobadjanjaOdParticipacije;
    @XmlElement(name = "podaci_o_lekaru", required = true)
    protected PodaciOLekaru podaciOLekaru;
    @XmlElement(name = "propisani_lek", required = true)
    protected TPodaciOLeku propisaniLek;
    @XmlElement(name = "izdati_lek", required = true)
    protected TPodaciOLeku izdatiLek;
    @XmlElement(required = true)
    protected String dijagnoza;
    @XmlElement(name = "redni_broj")
    protected int redniBroj;
    protected int kolicina;
    @XmlElement(name = "potpis_farmaceuta", required = true, nillable = true)
    protected String potpisFarmaceuta;
    @XmlElement(name = "lek_primio", required = true)
    protected String lekPrimio;
    @XmlElement(required = true)
    protected LekarskiRecept.Rp rp;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String id;

    /**
     * Gets the value of the osiguranoLice property.
     * 
     * @return
     *     possible object is
     *     {@link LekarskiRecept.OsiguranoLice }
     *     
     */
    public LekarskiRecept.OsiguranoLice getOsiguranoLice() {
        return osiguranoLice;
    }

    /**
     * Sets the value of the osiguranoLice property.
     * 
     * @param value
     *     allowed object is
     *     {@link LekarskiRecept.OsiguranoLice }
     *     
     */
    public void setOsiguranoLice(LekarskiRecept.OsiguranoLice value) {
        this.osiguranoLice = value;
    }

    /**
     * Gets the value of the ustanova property.
     * 
     * @return
     *     possible object is
     *     {@link Ustanova }
     *     
     */
    public Ustanova getUstanova() {
        return ustanova;
    }

    /**
     * Sets the value of the ustanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ustanova }
     *     
     */
    public void setUstanova(Ustanova value) {
        this.ustanova = value;
    }

    /**
     * Gets the value of the zdravstveniKarton property.
     * 
     * @return
     *     possible object is
     *     {@link LekarskiRecept.ZdravstveniKarton }
     *     
     */
    public LekarskiRecept.ZdravstveniKarton getZdravstveniKarton() {
        return zdravstveniKarton;
    }

    /**
     * Sets the value of the zdravstveniKarton property.
     * 
     * @param value
     *     allowed object is
     *     {@link LekarskiRecept.ZdravstveniKarton }
     *     
     */
    public void setZdravstveniKarton(LekarskiRecept.ZdravstveniKarton value) {
        this.zdravstveniKarton = value;
    }

    /**
     * Gets the value of the osnovOslobadjanjaOdParticipacije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsnovOslobadjanjaOdParticipacije() {
        return osnovOslobadjanjaOdParticipacije;
    }

    /**
     * Sets the value of the osnovOslobadjanjaOdParticipacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsnovOslobadjanjaOdParticipacije(String value) {
        this.osnovOslobadjanjaOdParticipacije = value;
    }

    /**
     * Gets the value of the podaciOLekaru property.
     * 
     * @return
     *     possible object is
     *     {@link PodaciOLekaru }
     *     
     */
    public PodaciOLekaru getPodaciOLekaru() {
        return podaciOLekaru;
    }

    /**
     * Sets the value of the podaciOLekaru property.
     * 
     * @param value
     *     allowed object is
     *     {@link PodaciOLekaru }
     *     
     */
    public void setPodaciOLekaru(PodaciOLekaru value) {
        this.podaciOLekaru = value;
    }

    /**
     * Gets the value of the propisaniLek property.
     * 
     * @return
     *     possible object is
     *     {@link TPodaciOLeku }
     *     
     */
    public TPodaciOLeku getPropisaniLek() {
        return propisaniLek;
    }

    /**
     * Sets the value of the propisaniLek property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPodaciOLeku }
     *     
     */
    public void setPropisaniLek(TPodaciOLeku value) {
        this.propisaniLek = value;
    }

    /**
     * Gets the value of the izdatiLek property.
     * 
     * @return
     *     possible object is
     *     {@link TPodaciOLeku }
     *     
     */
    public TPodaciOLeku getIzdatiLek() {
        return izdatiLek;
    }

    /**
     * Sets the value of the izdatiLek property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPodaciOLeku }
     *     
     */
    public void setIzdatiLek(TPodaciOLeku value) {
        this.izdatiLek = value;
    }

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
     * Gets the value of the redniBroj property.
     * 
     */
    public int getRedniBroj() {
        return redniBroj;
    }

    /**
     * Sets the value of the redniBroj property.
     * 
     */
    public void setRedniBroj(int value) {
        this.redniBroj = value;
    }

    /**
     * Gets the value of the kolicina property.
     * 
     */
    public int getKolicina() {
        return kolicina;
    }

    /**
     * Sets the value of the kolicina property.
     * 
     */
    public void setKolicina(int value) {
        this.kolicina = value;
    }

    /**
     * Gets the value of the potpisFarmaceuta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPotpisFarmaceuta() {
        return potpisFarmaceuta;
    }

    /**
     * Sets the value of the potpisFarmaceuta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPotpisFarmaceuta(String value) {
        this.potpisFarmaceuta = value;
    }

    /**
     * Gets the value of the lekPrimio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLekPrimio() {
        return lekPrimio;
    }

    /**
     * Sets the value of the lekPrimio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLekPrimio(String value) {
        this.lekPrimio = value;
    }

    /**
     * Gets the value of the rp property.
     * 
     * @return
     *     possible object is
     *     {@link LekarskiRecept.Rp }
     *     
     */
    public LekarskiRecept.Rp getRp() {
        return rp;
    }

    /**
     * Sets the value of the rp property.
     * 
     * @param value
     *     allowed object is
     *     {@link LekarskiRecept.Rp }
     *     
     */
    public void setRp(LekarskiRecept.Rp value) {
        this.rp = value;
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
     *         &lt;element name="datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
        "datumRodjenja",
        "pacijent"
    })
    public static class OsiguranoLice {

        @XmlElement(required = true)
        protected String ime;
        @XmlElement(required = true)
        protected String prezime;
        @XmlElement(name = "datum_rodjenja", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumRodjenja;
        @XmlElement(required = true)
        protected LekarskiRecept.OsiguranoLice.Pacijent pacijent;

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
         * Gets the value of the datumRodjenja property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumRodjenja() {
            return datumRodjenja;
        }

        /**
         * Sets the value of the datumRodjenja property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumRodjenja(XMLGregorianCalendar value) {
            this.datumRodjenja = value;
        }

        /**
         * Gets the value of the pacijent property.
         * 
         * @return
         *     possible object is
         *     {@link LekarskiRecept.OsiguranoLice.Pacijent }
         *     
         */
        public LekarskiRecept.OsiguranoLice.Pacijent getPacijent() {
            return pacijent;
        }

        /**
         * Sets the value of the pacijent property.
         * 
         * @param value
         *     allowed object is
         *     {@link LekarskiRecept.OsiguranoLice.Pacijent }
         *     
         */
        public void setPacijent(LekarskiRecept.OsiguranoLice.Pacijent value) {
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
     *         &lt;element name="link" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *                 &lt;anyAttribute processContents='lax'/>
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
        "content"
    })
    public static class Rp {

        @XmlElementRef(name = "link", namespace = "http://www.svj.com/zis/dokumenti", type = JAXBElement.class, required = false)
        @XmlMixed
        protected List<Serializable> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link LekarskiRecept.Rp.Link }{@code >}
         * {@link String }
         * 
         * 
         */
        public List<Serializable> getContent() {
            if (content == null) {
                content = new ArrayList<Serializable>();
            }
            return this.content;
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
         *       &lt;anyAttribute processContents='lax'/>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Link {

            @XmlAttribute(name = "id", required = true)
            @XmlSchemaType(name = "anyURI")
            protected String id;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

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
             * Gets a map that contains attributes that aren't bound to any typed property on this class.
             * 
             * <p>
             * the map is keyed by the name of the attribute and 
             * the value is the string value of the attribute.
             * 
             * the map returned by this method is live, and you can add new attribute
             * by updating the map directly. Because of this design, there's no setter.
             * 
             * 
             * @return
             *     always non-null
             */
            public Map<QName, String> getOtherAttributes() {
                return otherAttributes;
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
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *       &lt;attribute name="broj_zdravstvenog_kartona" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;pattern value="[a-zA-Z]{2}[0-9]{3}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="broj_zdrastvene_knjizice" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;pattern value="[0-9]{11}"/>
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

        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String id;
        @XmlAttribute(name = "broj_zdravstvenog_kartona", required = true)
        protected String brojZdravstvenogKartona;
        @XmlAttribute(name = "broj_zdrastvene_knjizice", required = true)
        protected String brojZdrastveneKnjizice;

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

        /**
         * Gets the value of the brojZdrastveneKnjizice property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrojZdrastveneKnjizice() {
            return brojZdrastveneKnjizice;
        }

        /**
         * Sets the value of the brojZdrastveneKnjizice property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrojZdrastveneKnjizice(String value) {
            this.brojZdrastveneKnjizice = value;
        }

    }

}
