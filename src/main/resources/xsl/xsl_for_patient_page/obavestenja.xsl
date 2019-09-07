<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:osobe="http://www.svj.com/zis/osobe"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
        <table border="2">
            <tr> <th><b>Message</b></th> <th><b>Date And Time</b></th></tr>
            <xsl:for-each select="osobe:obavestenja/osobe:obavestenje">
                <tr>
                    <td><xsl:value-of select="text()"/></td>
                    <td><xsl:value-of select="@datum"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
    
</xsl:stylesheet>