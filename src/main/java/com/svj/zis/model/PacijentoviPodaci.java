
package com.svj.zis.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 *     &lt;extension base="{http://www.svj.com/zis/osobe}TOsoba">
 *       &lt;sequence>
 *         &lt;element name="ime_jednog_roditelja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element ref="{http://www.svj.com/zis/osobe}adresa"/>
 *         &lt;element name="telefon" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="our" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pol" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="musko"/>
 *               &lt;enumeration value="zensko"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="bracno_stanje" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="neozenjen"/>
 *               &lt;enumeration value="neudata"/>
 *               &lt;enumeration value="ozenjen"/>
 *               &lt;enumeration value="udata"/>
 *               &lt;enumeration value="udovac"/>
 *               &lt;enumeration value="udovica"/>
 *               &lt;enumeration value="razveden"/>
 *               &lt;enumeration value="razvedena"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="osnov_oslobadjanja_od_participacije" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="lbo" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{11,11}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="jmbg" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{13,13}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "imeJednogRoditelja",
    "datumRodjenja",
    "adresa",
    "telefon",
    "our",
    "pol",
    "bracnoStanje",
    "osnovOslobadjanjaOdParticipacije"
})
@XmlRootElement(name = "pacijentovi_podaci", namespace = "http://www.svj.com/zis/osobe")
public class PacijentoviPodaci
    extends TOsoba
{

    @XmlElement(name = "ime_jednog_roditelja", namespace = "http://www.svj.com/zis/osobe", required = true)
    protected String imeJednogRoditelja;
    @XmlElement(name = "datum_rodjenja", namespace = "http://www.svj.com/zis/osobe", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(namespace = "http://www.svj.com/zis/osobe", required = true)
    protected Adresa adresa;
    @XmlElement(namespace = "http://www.svj.com/zis/osobe")
    protected String telefon;
    @XmlElement(namespace = "http://www.svj.com/zis/osobe")
    protected String our;
    @XmlElement(namespace = "http://www.svj.com/zis/osobe")
    protected String pol;
    @XmlElement(name = "bracno_stanje", namespace = "http://www.svj.com/zis/osobe")
    protected String bracnoStanje;
    @XmlElementRef(name = "osnov_oslobadjanja_od_participacije", namespace = "http://www.svj.com/zis/osobe", type = JAXBElement.class, required = false)
    protected JAXBElement<String> osnovOslobadjanjaOdParticipacije;
    @XmlAttribute(name = "lbo", required = true)
    protected String lbo;
    @XmlAttribute(name = "jmbg", required = true)
    protected String jmbg;

    /**
     * Gets the value of the imeJednogRoditelja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImeJednogRoditelja() {
        return imeJednogRoditelja;
    }

    /**
     * Sets the value of the imeJednogRoditelja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImeJednogRoditelja(String value) {
        this.imeJednogRoditelja = value;
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
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link Adresa }
     *     
     */
    public Adresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Adresa }
     *     
     */
    public void setAdresa(Adresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the telefon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Sets the value of the telefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefon(String value) {
        this.telefon = value;
    }

    /**
     * Gets the value of the our property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOur() {
        return our;
    }

    /**
     * Sets the value of the our property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOur(String value) {
        this.our = value;
    }

    /**
     * Gets the value of the pol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPol() {
        return pol;
    }

    /**
     * Sets the value of the pol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPol(String value) {
        this.pol = value;
    }

    /**
     * Gets the value of the bracnoStanje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBracnoStanje() {
        return bracnoStanje;
    }

    /**
     * Sets the value of the bracnoStanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBracnoStanje(String value) {
        this.bracnoStanje = value;
    }

    /**
     * Gets the value of the osnovOslobadjanjaOdParticipacije property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOsnovOslobadjanjaOdParticipacije() {
        return osnovOslobadjanjaOdParticipacije;
    }

    /**
     * Sets the value of the osnovOslobadjanjaOdParticipacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOsnovOslobadjanjaOdParticipacije(JAXBElement<String> value) {
        this.osnovOslobadjanjaOdParticipacije = value;
    }

    /**
     * Gets the value of the lbo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLbo() {
        return lbo;
    }

    /**
     * Sets the value of the lbo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLbo(String value) {
        this.lbo = value;
    }

    /**
     * Gets the value of the jmbg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJmbg() {
        return jmbg;
    }

    /**
     * Sets the value of the jmbg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJmbg(String value) {
        this.jmbg = value;
    }

}
