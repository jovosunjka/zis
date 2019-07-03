<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
        <table border="2">
            <tr> <th><b>Id</b></th> <th><b>Mark</b></th> <th><b>Diagnosis</b></th> <th><b>Anamnesis</b></th> <th><b>Therapy</b></th> <th><b>Date</b></th> </tr>
            <xsl:for-each select="kolekcije:izvestaji/dokumenti:izvestaj">
                <tr> 
                    <td><xsl:value-of select="@id"/></td>
                    <td><xsl:value-of select="@oznaka"/></td>
                    <td><xsl:value-of select="dokumenti:dijagnoza"/></td>
                    <td><xsl:apply-templates select="dokumenti:anamneza"/></td> <!--https://stackoverflow.com/questions/1525285/xslt-mixed-content-node-->
                    <td><xsl:apply-templates select="dokumenti:terapija"/></td> <!--https://stackoverflow.com/questions/1525285/xslt-mixed-content-node-->
                    <td><xsl:value-of select="dokumenti:datum"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>

    <xsl:template match="dokumenti:anamneza">
        <p>
            <xsl:apply-templates />
        </p>
    </xsl:template>

    <xsl:template match="dokumenti:terapija">
        <p>
            <xsl:apply-templates />
        </p>
    </xsl:template>

    <xsl:template match="dokumenti:anamneza//text()">
        <xsl:copy-of select="." />
    </xsl:template>
    <xsl:template match="dokumenti:terapija//text()">
        <xsl:copy-of select="." />
    </xsl:template>

    <xsl:template match="dokumenti:anamneza//dokumenti:link">
        <a href="{@href}">
            <xsl:value-of select="@href"/>
            <!--<xsl:apply-templates />-->
        </a>
    </xsl:template>

    <xsl:template match="dokumenti:terapija//dokumenti:link">
        <a href="{@href}">
            <xsl:value-of select="@href"/>
            <!--<xsl:apply-templates />-->
        </a>
    </xsl:template>
    
</xsl:stylesheet>