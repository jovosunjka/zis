
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
 *         &lt;element name="jmbg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d{13,13}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="lbo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d{11,11}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ime_jednog_roditelja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ulica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="broj">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="opstina" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "jmbg",
    "lbo",
    "ime",
    "prezime",
    "imeJednogRoditelja",
    "datumRodjenja",
    "ulica",
    "broj",
    "mesto",
    "opstina",
    "telefon",
    "our",
    "pol",
    "bracnoStanje",
    "osnovOslobadjanjaOdParticipacije"
})
@XmlRootElement(name = "basic_info_dto")
public class BasicInfoDto {

    @XmlElement(required = true)
    protected String jmbg;
    @XmlElement(required = true)
    protected String lbo;
    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    @XmlElement(name = "ime_jednog_roditelja", required = true)
    protected String imeJednogRoditelja;
    @XmlElement(name = "datum_rodjenja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(required = true)
    protected String ulica;
    protected int broj;
    @XmlElement(required = true)
    protected String mesto;
    @XmlElement(required = true)
    protected String opstina;
    protected String telefon;
    protected String our;
    protected String pol;
    @XmlElement(name = "bracno_stanje")
    protected String bracnoStanje;
    @XmlElement(name = "osnov_oslobadjanja_od_participacije")
    protected String osnovOslobadjanjaOdParticipacije;

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
     * Gets the value of the ulica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the broj property.
     * 
     */
    public int getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     * 
     */
    public void setBroj(int value) {
        this.broj = value;
    }

    /**
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the opstina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpstina() {
        return opstina;
    }

    /**
     * Sets the value of the opstina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpstina(String value) {
        this.opstina = value;
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

}
