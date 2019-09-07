
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
 *         &lt;element name="rp" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    @XmlElement(required = true, nillable = true)
    protected String rp;

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
     *     {@link String }
     *     
     */
    public String getRp() {
        return rp;
    }

    /**
     * Sets the value of the rp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRp(String value) {
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
