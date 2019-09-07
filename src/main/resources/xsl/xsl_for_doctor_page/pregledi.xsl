<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:str="http://exslt.org/strings"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
        <table border="2">
            <tr> <th><b>Id</b></th> <th><b>First Name</b></th> <th><b>Last Name</b></th> <th><b>Date And Time</b></th> <th><b>View Health Card</b></th> <th><b> Make Report</b></th> <th><b>Make Doctor Receipt</b></th> <th><b> Make Referral For Specialist Examination</b></th> <th><b> Make Referral For Lab</b></th> </tr>
            <xsl:for-each select="kolekcije:pregledi/dokumenti:pregled">
                <tr>
                    <td><xsl:value-of select="@id"/> </td>
                    <td><xsl:value-of select="dokumenti:pacijent/dokumenti:ime"/></td>
                    <td><xsl:value-of select="dokumenti:pacijent/dokumenti:prezime"/></td>
                    <td><xsl:value-of select="dokumenti:datum_i_vreme"/></td>
                    <td><xsl:call-template name="template_for_tag_a_view_health_card"/></td>
                    <td><xsl:call-template name="template_for_tag_a_make_report"/></td>
                    <td><xsl:call-template name="template_for_tag_a_make_receipt"/></td>
                    <td><xsl:call-template name="template_for_tag_a_make_referral_for_spec_exam"/></td>
                    <td><xsl:call-template name="template_for_tag_a_make_referral_for_lab"/></td>
                </tr>
            </xsl:for-each>

        </table>
    </xsl:template>

    <xsl:template name="template_for_tag_a_view_health_card" match="/kolekcije:pregledi/dokumenti:pregled/dokumenti:pacijent">
        <xsl:variable name="idOfPatientNum" select="str:tokenize(string(@id),'/')[last()]"/>
        <a href="http://localhost:4200/patient/{$idOfPatientNum}">link</a>
    </xsl:template>

    <xsl:template name="template_for_tag_a_make_report" match="/kolekcije:pregledi/dokumenti:pregled/dokumenti:pacijent">
        <xsl:variable name="idOfPatientNum" select="str:tokenize(string(@id),'/')[last()]"/>
        <a href="http://localhost:4200/make-report/{$idOfPatientNum}">link</a>
    </xsl:template>

    <xsl:template name="template_for_tag_a_make_receipt" match="/kolekcije:pregledi/dokumenti:pregled/dokumenti:pacijent">
        <xsl:variable name="idOfPatientNum" select="str:tokenize(string(@id),'/')[last()]"/>
        <a href="http://localhost:4200/make-receipt/{$idOfPatientNum}">link</a>
    </xsl:template>

    <xsl:template name="template_for_tag_a_make_referral_for_spec_exam" match="/kolekcije:pregledi/dokumenti:pregled/dokumenti:pacijent">
        <xsl:variable name="idOfPatientNum" select="str:tokenize(string(@id),'/')[last()]"/>
        <a href="http://localhost:4200/make-referral-for-spec-exam/{$idOfPatientNum}">link</a>
    </xsl:template>

    <xsl:template name="template_for_tag_a_make_referral_for_lab" match="/kolekcije:pregledi/dokumenti:pregled/dokumenti:pacijent">
        <xsl:variable name="idOfPatientNum" select="str:tokenize(string(@id),'/')[last()]"/>
        <a href="http://localhost:4200/make-referral-for-lab/{$idOfPatientNum}">link</a>
    </xsl:template>
    
</xsl:stylesheet>