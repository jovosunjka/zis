<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">


            <xsl:for-each select="kolekcije:izvestaji/dokumenti:izvestaj">
                <br/>
                <br/>
                <table border-collapse="collapse" border="1px solid red">

                    <tr>
                        <td><b>- Id:</b></td><td><xsl:value-of select="@id"/></td>
                    </tr>
                    <tr>
                        <td><b>- Mark:</b></td><td><xsl:value-of select="@oznaka"/></td>
                    </tr>
                    <tr>
                        <td><b>- Diagnosis:</b></td><td><xsl:value-of select="dokumenti:dijagnoza"/></td>
                    </tr>
                    <tr>
                        <td><b>- Anamnesis:</b></td><td><xsl:apply-templates select="dokumenti:anamneza"/></td> <!--https://stackoverflow.com/questions/1525285/xslt-mixed-content-node-->
                    </tr>
                    <tr>
                        <td><b>- Therapy:</b></td><td><xsl:apply-templates select="dokumenti:terapija"/></td> <!--https://stackoverflow.com/questions/1525285/xslt-mixed-content-node-->
                    </tr>
                    <tr>
                        <td><b>- Doctor:</b></td><td><xsl:value-of select="dokumenti:lekar/dokumenti:ime"/> <xsl:text> </xsl:text> <xsl:value-of select="dokumenti:lekar/dokumenti:prezime"/></td>
                    </tr>
                    <tr>
                        <td><b>- Date:</b></td><td><xsl:value-of select="dokumenti:datum"/></td>
                    </tr>
                </table>
            </xsl:for-each>
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