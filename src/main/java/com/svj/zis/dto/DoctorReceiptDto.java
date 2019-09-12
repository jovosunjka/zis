
package com.svj.zis.dto;

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
 *         &lt;element name="ustanova">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naziv_zdrastvene_ustanove" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="drzava" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="potpis_lekara" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="propisani_lek">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sifra" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="redni_broj" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kolicina" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ustanova",
    "potpisLekara",
    "propisaniLek",
    "dijagnoza",
    "redniBroj",
    "kolicina",
    "rp"
})
@XmlRootElement(name = "doctor_receipt_dto")
public class DoctorReceiptDto {

    @XmlElement(required = true)
    protected DoctorReceiptDto.Ustanova ustanova;
    @XmlElement(name = "potpis_lekara", required = true)
    protected String potpisLekara;
    @XmlElement(name = "propisani_lek", required = true)
    protected DoctorReceiptDto.PropisaniLek propisaniLek;
    @XmlElement(required = true)
    protected String dijagnoza;
    @XmlElement(name = "redni_broj")
    protected int redniBroj;
    protected int kolicina;
    @XmlElement(required = true)
    protected DoctorReceiptDto.Rp rp;

    /**
     * Gets the value of the ustanova property.
     * 
     * @return
     *     possible object is
     *     {@link DoctorReceiptDto.Ustanova }
     *     
     */
    public DoctorReceiptDto.Ustanova getUstanova() {
        return ustanova;
    }

    /**
     * Sets the value of the ustanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoctorReceiptDto.Ustanova }
     *     
     */
    public void setUstanova(DoctorReceiptDto.Ustanova value) {
        this.ustanova = value;
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
     * Gets the value of the propisaniLek property.
     * 
     * @return
     *     possible object is
     *     {@link DoctorReceiptDto.PropisaniLek }
     *     
     */
    public DoctorReceiptDto.PropisaniLek getPropisaniLek() {
        return propisaniLek;
    }

    /**
     * Sets the value of the propisaniLek property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoctorReceiptDto.PropisaniLek }
     *     
     */
    public void setPropisaniLek(DoctorReceiptDto.PropisaniLek value) {
        this.propisaniLek = value;
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
     * Gets the value of the rp property.
     * 
     * @return
     *     possible object is
     *     {@link DoctorReceiptDto.Rp }
     *     
     */
    public DoctorReceiptDto.Rp getRp() {
        return rp;
    }

    /**
     * Sets the value of the rp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoctorReceiptDto.Rp }
     *     
     */
    public void setRp(DoctorReceiptDto.Rp value) {
        this.rp = value;
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
     *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="sifra" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
        "naziv",
        "sifra"
    })
    public static class PropisaniLek {

        @XmlElement(required = true)
        protected String naziv;
        protected long sifra;

        /**
         * Gets the value of the naziv property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaziv() {
            return naziv;
        }

        /**
         * Sets the value of the naziv property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaziv(String value) {
            this.naziv = value;
        }

        /**
         * Gets the value of the sifra property.
         * 
         */
        public long getSifra() {
            return sifra;
        }

        /**
         * Sets the value of the sifra property.
         * 
         */
        public void setSifra(long value) {
            this.sifra = value;
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

        @XmlElementRef(name = "link", namespace = "http://www.svj.com/zis/dto", type = JAXBElement.class, required = false)
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
         * {@link JAXBElement }{@code <}{@link DoctorReceiptDto.Rp.Link }{@code >}
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
    public static class Ustanova {

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

}
