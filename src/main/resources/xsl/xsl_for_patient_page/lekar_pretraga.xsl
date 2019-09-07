<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:osobe="http://www.svj.com/zis/osobe"
                exclude-result-prefixes="xs"
                version="2.0">

    <xsl:template match="/">
        <html>
            <head></head>
            <body bgcolor="black">
                <table bgcolor="yellow">
                    <tr> <th colspan="2"><b>Doctor:</b></th> </tr>
                    <tr>
                        <td>- Id:</td>
                        <xsl:variable name="var_id" select="osobe:lekar/@id"/>
                        <xsl:if test="not(contains($var_id, '%1$s'))">
                            <td><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_id, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                    </tr>
                    <tr>
                        <td>- First Name:</td>
                        <xsl:variable name="var_ime" select="osobe:lekar/osobe:ime"/>
                        <xsl:if test="not(contains($var_ime, '%1$s'))">
                            <td><xsl:value-of select="$var_ime"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_ime, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_ime"/></td>
                        </xsl:if>
                    </tr>
                    <tr>
                        <td>- Last Name:</td>
                        <xsl:variable name="var_prezime" select="osobe:lekar/osobe:prezime"/>
                        <xsl:if test="not(contains($var_prezime, '%1$s'))">
                            <td><xsl:value-of select="$var_prezime"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_prezime, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_prezime"/></td>
                        </xsl:if>
                    </tr>
                    <tr>
                        <td>- Type:</td>
                        <xsl:variable name="var_tip" select="osobe:lekar/osobe:tip"/>
                        <xsl:if test="not(contains($var_tip, '%1$s'))">
                            <td><xsl:value-of select="$var_tip"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_tip, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_tip"/></td>
                        </xsl:if>
                    </tr>
                    <tr>
                        <td>- Protection Area:</td>
                        <xsl:variable name="var_oblast_zastite" select="osobe:lekar/osobe:oblast_zastite"/>
                        <xsl:if test="not(contains($var_oblast_zastite, '%1$s'))">
                            <td><xsl:value-of select="$var_oblast_zastite"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_oblast_zastite, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_oblast_zastite"/></td>
                        </xsl:if>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>