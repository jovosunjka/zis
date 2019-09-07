<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
        <html>
            <head></head>
            <body bgcolor="black">
                <table bgcolor="yellow">
                    <tr><th colspan="2"><b>Medicament:</b></th></tr>
                    <tr>
                        <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:lek/@id"/></td>
                    </tr>
                    <tr>
                        <td><b>- Name:</b></td> <td><xsl:value-of select="dokumenti:lek/dokumenti:naziv"/></td>
                    </tr>
                    <tr>
                        <td><b>- Code:</b></td> <td><xsl:value-of select="dokumenti:lek/dokumenti:sifra"/></td>
                    </tr>
                    <tr>
                        <td><b>- Diagnosis:</b></td> <td><xsl:value-of select="dokumenti:lek/dokumenti:dijagnoza"/></td>
                    </tr>
                    <tr>
                        <td><b>- Purpose:</b></td> <td><xsl:value-of select="dokumenti:lek/dokumenti:namena"/></td>
                    </tr>
                    <tr>
                        <td><b>- Active:</b></td> <td><xsl:value-of select="dokumenti:lek/@aktivan"/></td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>