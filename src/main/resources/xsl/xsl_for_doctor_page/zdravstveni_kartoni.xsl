<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:str="http://exslt.org/strings"
                xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
                xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
                exclude-result-prefixes="xs"
                version="2.0">

    <xsl:template match="/">
        <table border="2">
            <tr> <th><b>Id</b></th> <th><b>First Name</b></th> <th><b>Last Name</b></th> <th><b>View Health Card</b></th> <th><b> Edit Health Card</b></th> </tr>
            <xsl:for-each select="kolekcije:zdravstveni_kartoni/dokumenti:zdravstveni_karton">
                <tr>
                    <xsl:variable name="var_pacijent_id" select="dokumenti:pacijentovi_podaci/dokumenti:pacijent/@id"/>
                    <xsl:variable name="var_pacijent_id_num" select="str:tokenize(string($var_pacijent_id),'/')[last()]"/>
                    <xsl:variable name="var_pacijent_type" select="str:tokenize(string($var_pacijent_id),'/')[last()-1]"/>
                    <td>
                        <a href="http://localhost:8081/api/search/{$var_pacijent_type}/{$var_pacijent_id_num}">
                            <xsl:value-of select="$var_pacijent_id"/>
                            <!--<xsl:apply-templates />-->
                        </a>
                    </td>
                    <td><xsl:value-of select="dokumenti:pacijentovi_podaci/dokumenti:ime"/></td>
                    <td><xsl:value-of select="dokumenti:pacijentovi_podaci/dokumenti:prezime"/></td>
                    <td><xsl:call-template name="template_for_tag_a_view_health_card"/></td>
                    <td><xsl:call-template name="template_for_tag_a_edit_health_card"/></td>
                </tr>
            </xsl:for-each>

        </table>
    </xsl:template>

    <xsl:template name="template_for_tag_a_view_health_card" match="/kolekcije:zdravstveni_kartoni/dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:pacijent">
        <xsl:variable name="idOfPatientNum" select="str:tokenize(string(@id),'/')[last()]"/>
        <a href="http://localhost:4200/patient/{$idOfPatientNum}">link</a>
    </xsl:template>

    <xsl:template name="template_for_tag_a_edit_health_card" match="/kolekcije:zdravstveni_kartoni/dokumenti:zdravstveni_karton">
        <xsl:variable name="idOfPatientNum" select="str:tokenize(string(@broj_kartona),'/')[last()]"/>
        <a href="http://localhost:4200/edit-health-card/{$idOfPatientNum}">link</a>
    </xsl:template>

</xsl:stylesheet>