
package com.svj.zis.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tip.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tip">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="opsta_praksa"/>
 *     &lt;enumeration value="ginekolog"/>
 *     &lt;enumeration value="pedijatar"/>
 *     &lt;enumeration value="dermatolog"/>
 *     &lt;enumeration value="stomatolog"/>
 *     &lt;enumeration value="drugo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tip", namespace = "http://www.svj.com/zis/osobe")
@XmlEnum
public enum Tip {

    @XmlEnumValue("opsta_praksa")
    OPSTA_PRAKSA("opsta_praksa"),
    @XmlEnumValue("ginekolog")
    GINEKOLOG("ginekolog"),
    @XmlEnumValue("pedijatar")
    PEDIJATAR("pedijatar"),
    @XmlEnumValue("dermatolog")
    DERMATOLOG("dermatolog"),
    @XmlEnumValue("stomatolog")
    STOMATOLOG("stomatolog"),
    @XmlEnumValue("drugo")
    DRUGO("drugo");
    private final String value;

    Tip(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Tip fromValue(String v) {
        for (Tip c: Tip.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
