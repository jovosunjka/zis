<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:str="http://exslt.org/strings"
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
                        <td><b>- Id:</b></td>
                        <xsl:variable name="var_id" select="dokumenti:lek/@id"/>
                        <xsl:if test="not(contains($var_id, '%1$s'))">
                            <td><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_id, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lek/@id"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Name:</b></td>
                        <xsl:variable name="var_name" select="dokumenti:lek/dokumenti:naziv"/>
                        <xsl:if test="not(contains($var_name, '%1$s'))">
                            <td><xsl:value-of select="$var_name"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_name, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_name"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lek/dokumenti:naziv"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Code:</b></td>
                        <xsl:variable name="var_sifra" select="dokumenti:lek/dokumenti:sifra"/>
                        <xsl:if test="not(contains($var_sifra, '%1$s'))">
                            <td><xsl:value-of select="$var_sifra"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_sifra, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_sifra"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lek/dokumenti:sifra"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Diagnosis:</b></td>
                        <xsl:variable name="var_dijagnoza" select="dokumenti:lek/dokumenti:dijagnoza"/>
                        <xsl:if test="not(contains($var_dijagnoza, '%1$s'))">
                            <td><xsl:value-of select="$var_dijagnoza"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_dijagnoza, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_dijagnoza"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lek/dokumenti:dijagnoza"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Purpose:</b></td>
                        <xsl:variable name="var_namena" select="dokumenti:lek/dokumenti:namena"/>
                        <xsl:if test="not(contains($var_namena, '%1$s'))">
                            <td><xsl:value-of select="$var_namena"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_namena, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_namena"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lek/dokumenti:namena"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Active:</b></td>
                        <xsl:variable name="var_aktivan" select="dokumenti:lek/@aktivan"/>
                        <xsl:if test="not(contains($var_aktivan, '%1$s'))">
                            <td><xsl:value-of select="$var_aktivan"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_aktivan, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_aktivan"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lek/@aktivan"/></td>-->
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>