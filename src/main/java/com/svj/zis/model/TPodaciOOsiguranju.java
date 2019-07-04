
package com.svj.zis.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="nosilac_osiguranja">
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
    protected TPodaciOOsiguranju.NosilacOsiguranja nosilacOsiguranja;
    @XmlElement(name = "osnov_osiguranja", required = true)
    protected String osnovOsiguranja;

    /**
     * Gets the value of the nosilacOsiguranja property.
     * 
     * @return
     *     possible object is
     *     {@link TPodaciOOsiguranju.NosilacOsiguranja }
     *     
     */
    public TPodaciOOsiguranju.NosilacOsiguranja getNosilacOsiguranja() {
        return nosilacOsiguranja;
    }

    /**
     * Sets the value of the nosilacOsiguranja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPodaciOOsiguranju.NosilacOsiguranja }
     *     
     */
    public void setNosilacOsiguranja(TPodaciOOsiguranju.NosilacOsiguranja value) {
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
    public static class NosilacOsiguranja {

        @XmlElement(required = true)
        protected String ime;
        @XmlElement(required = true)
        protected String prezime;
        @XmlElement(required = true)
        protected TPodaciOOsiguranju.NosilacOsiguranja.Pacijent pacijent;

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
         *     {@link TPodaciOOsiguranju.NosilacOsiguranja.Pacijent }
         *     
         */
        public TPodaciOOsiguranju.NosilacOsiguranja.Pacijent getPacijent() {
            return pacijent;
        }

        /**
         * Sets the value of the pacijent property.
         * 
         * @param value
         *     allowed object is
         *     {@link TPodaciOOsiguranju.NosilacOsiguranja.Pacijent }
         *     
         */
        public void setPacijent(TPodaciOOsiguranju.NosilacOsiguranja.Pacijent value) {
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
