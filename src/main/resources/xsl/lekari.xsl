<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:osobe="http://www.svj.com/zis/osobe"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
        <table border="1">
            <tr> <th><b>Id</b></th> <th><b>First Name</b></th> <th><b>Last Name</b></th> </tr>
            <xsl:for-each select="kolekcije:lekari/osobe:lekar">
                <tr> 
                    <td><xsl:value-of select="@id"/></td> 
                    <td><xsl:value-of select="osobe:ime"/></td> 
                    <td><xsl:value-of select="osobe:prezime"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
    
</xsl:stylesheet>