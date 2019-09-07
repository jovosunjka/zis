<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
        <label for="id_select_review">Free Reviews - Choose review:</label>
        <select id="id_select_review">
            <xsl:for-each select="kolekcije:pregledi/dokumenti:pregled">
                <option value="{@id}">
                    <xsl:value-of select="@id"/>,
                    <xsl:value-of select="dokumenti:datum_i_vreme"/>
                </option>
            </xsl:for-each>
        </select>
        <!--
        <table border="2">
            <tr> <th><b>Id</b></th> <th><b>Date And Time</b></th></tr>
            <xsl:for-each select="kolekcije:pregledi/dokumenti:pregled">
                <tr> 
                    <td><xsl:value-of select="@id"/></td> 
                    <td><xsl:value-of select="dokumenti:datum_i_vreme"/></td>
                </tr>
            </xsl:for-each>
        </table>
        -->
    </xsl:template>
    
</xsl:stylesheet>