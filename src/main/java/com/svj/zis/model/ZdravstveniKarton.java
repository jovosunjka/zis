
package com.svj.zis.model;

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
 *         &lt;element ref="{http://www.svj.com/zis/osobe}pacijentovi_podaci"/>
 *         &lt;element name="odabrani_lekar">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="broj_kartona" use="required">
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
@XmlType(name = "", propOrder = {
    "pacijentoviPodaci",
    "odabraniLekar"
})
@XmlRootElement(name = "zdravstveni_karton")
public class ZdravstveniKarton {

    @XmlElement(name = "pacijentovi_podaci", namespace = "http://www.svj.com/zis/osobe", required = true)
    protected PacijentoviPodaci pacijentoviPodaci;
    @XmlElement(name = "odabrani_lekar", required = true)
    protected ZdravstveniKarton.OdabraniLekar odabraniLekar;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String id;
    @XmlAttribute(name = "broj_kartona", required = true)
    protected String brojKartona;
    @XmlAttribute(name = "broj_zdrastvene_knjizice", required = true)
    protected String brojZdrastveneKnjizice;

    /**
     * Gets the value of the pacijentoviPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link PacijentoviPodaci }
     *     
     */
    public PacijentoviPodaci getPacijentoviPodaci() {
        return pacijentoviPodaci;
    }

    /**
     * Sets the value of the pacijentoviPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link PacijentoviPodaci }
     *     
     */
    public void setPacijentoviPodaci(PacijentoviPodaci value) {
        this.pacijentoviPodaci = value;
    }

    /**
     * Gets the value of the odabraniLekar property.
     * 
     * @return
     *     possible object is
     *     {@link ZdravstveniKarton.OdabraniLekar }
     *     
     */
    public ZdravstveniKarton.OdabraniLekar getOdabraniLekar() {
        return odabraniLekar;
    }

    /**
     * Sets the value of the odabraniLekar property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZdravstveniKarton.OdabraniLekar }
     *     
     */
    public void setOdabraniLekar(ZdravstveniKarton.OdabraniLekar value) {
        this.odabraniLekar = value;
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
     * Gets the value of the brojKartona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojKartona() {
        return brojKartona;
    }

    /**
     * Sets the value of the brojKartona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojKartona(String value) {
        this.brojKartona = value;
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
    public static class OdabraniLekar {

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
