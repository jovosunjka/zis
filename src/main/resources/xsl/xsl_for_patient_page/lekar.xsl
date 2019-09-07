<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:osobe="http://www.svj.com/zis/osobe"
                exclude-result-prefixes="xs"
                version="2.0">

    <xsl:template match="/">
        <html>
            <body bgcolor="black">
                <table bgcolor="yellow">
                    <tr> <th colspan="2"><b>Doctor:</b></th> </tr>
                    <tr>
                        <td>- Id:</td>
                        <td><xsl:value-of select="osobe:lekar/@id"/></td>
                    </tr>
                    <tr>
                        <td>- First Name:</td>
                        <td><xsl:value-of select="osobe:lekar/osobe:ime"/></td>
                    </tr>
                    <tr>
                        <td>- Last Name:</td>
                        <td><xsl:value-of select="osobe:lekar/osobe:prezime"/></td>
                    </tr>
                    <tr>
                        <td>- Type:</td>
                        <td><xsl:value-of select="osobe:lekar/osobe:tip"/></td>

                    </tr>
                    <tr>
                        <td>- Protection Area:</td>
                        <td><xsl:value-of select="osobe:lekar/osobe:oblast_zastite"/></td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>