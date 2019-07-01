
package com.svj.zis.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for oblast_zastite.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="oblast_zastite">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="deca"/>
 *     &lt;enumeration value="odrasli"/>
 *     &lt;enumeration value="zene"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "oblast_zastite", namespace = "http://www.svj.com/zis/osobe")
@XmlEnum
public enum OblastZastite {

    @XmlEnumValue("deca")
    DECA("deca"),
    @XmlEnumValue("odrasli")
    ODRASLI("odrasli"),
    @XmlEnumValue("zene")
    ZENE("zene");
    private final String value;

    OblastZastite(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OblastZastite fromValue(String v) {
        for (OblastZastite c: OblastZastite.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
