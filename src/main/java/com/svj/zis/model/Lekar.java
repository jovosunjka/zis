
package com.svj.zis.model;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;


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
 *         &lt;element name="tip">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.svj.com/zis/osobe>tip">
 *                 &lt;anyAttribute processContents='lax'/>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="oblast_zastite">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.svj.com/zis/osobe>oblast_zastite">
 *                 &lt;anyAttribute processContents='lax'/>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tip",
    "oblastZastite"
})
@XmlRootElement(name = "lekar", namespace = "http://www.svj.com/zis/osobe")
public class Lekar
    extends TOsoba
{

    @XmlElement(namespace = "http://www.svj.com/zis/osobe", required = true, defaultValue = "opsta_praksa")
    protected Lekar.Tip tip;
    @XmlElement(name = "oblast_zastite", namespace = "http://www.svj.com/zis/osobe", required = true, defaultValue = "odrasli")
    protected Lekar.OblastZastite oblastZastite;

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link Lekar.Tip }
     *     
     */
    public Lekar.Tip getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lekar.Tip }
     *     
     */
    public void setTip(Lekar.Tip value) {
        this.tip = value;
    }

    /**
     * Gets the value of the oblastZastite property.
     * 
     * @return
     *     possible object is
     *     {@link Lekar.OblastZastite }
     *     
     */
    public Lekar.OblastZastite getOblastZastite() {
        return oblastZastite;
    }

    /**
     * Sets the value of the oblastZastite property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lekar.OblastZastite }
     *     
     */
    public void setOblastZastite(Lekar.OblastZastite value) {
        this.oblastZastite = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.svj.com/zis/osobe>oblast_zastite">
     *       &lt;anyAttribute processContents='lax'/>
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class OblastZastite {

        @XmlValue
        protected com.svj.zis.model.OblastZastite value;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link com.svj.zis.model.OblastZastite }
         *     
         */
        public com.svj.zis.model.OblastZastite getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link com.svj.zis.model.OblastZastite }
         *     
         */
        public void setValue(com.svj.zis.model.OblastZastite value) {
            this.value = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.svj.com/zis/osobe>tip">
     *       &lt;anyAttribute processContents='lax'/>
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Tip {

        @XmlValue
        protected com.svj.zis.model.Tip value;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link com.svj.zis.model.Tip }
         *     
         */
        public com.svj.zis.model.Tip getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link com.svj.zis.model.Tip }
         *     
         */
        public void setValue(com.svj.zis.model.Tip value) {
            this.value = value;
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
