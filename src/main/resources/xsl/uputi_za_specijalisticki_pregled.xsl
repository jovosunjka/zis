<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    xmlns:osobe="http://www.svj.com/zis/osobe"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
            <xsl:for-each select="kolekcije:uputi_za_specijalisticki_pregled/dokumenti:uput_za_specijalisticki_pregled">
                <br/>
                <br/>
                <table>
                    <tr>
                        <td><b>- Id:</b></td> <td><xsl:value-of select="@id"/></td>
                    </tr>
                    <tr>
                        <td><b>- Reg. Number:</b></td> <td><xsl:value-of select="@reg_br"/></td>Receiving
                    </tr>
                    <tr>
                        <td><b>- Num. Health Card:</b></td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/></td>
                    </tr>
                    <tr>
                        <td><b>- Health Institution Sending:</b></td> <td><xsl:value-of select="dokumenti:zdravstvena_ustanova_koja_salje"/></td>
                    </tr>
                    <tr>
                        <td><b>- Health Institution Receiving:</b></td> <td><xsl:value-of select="dokumenti:zdravstvena_ustanova_koja_prima"/></td>
                    </tr>
                    <tr>
                        <td><b>- Date:</b></td> <td><xsl:value-of select="dokumenti:datum"/></td>
                    </tr>
                    <tr>
                        <td><b>- Doctor's Signature:</b></td> <td><xsl:value-of select="dokumenti:potpis_lekara"/></td>
                    </tr>
                    <tr>
                        <td><b>- Insurance Data:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Insurance Carrier:</b></td>
                                    <td>
                                        <table>
                                            <tr>
                                                <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/@id"/></td>
                                            </tr>
                                            <tr>
                                                <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/osobe:ime"/></td>
                                            </tr>
                                            <tr>
                                                <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/osobe:prezime"/></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- Reason Of Insurance:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_osiguranju/dokumenti:osnov_osiguranja"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Doctor Specialist:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:specijalista/@id"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Doctor Specialist For:</b></td> <td><xsl:value-of select="dokumenti:specijalista/dokumenti:lekar_specijalista_za"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Review Information:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Purpose Of Review:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_pregledu/dokumenti:svrha_pregleda"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Performed At A Health Institution:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_pregledu/dokumenti:obavljen_u_zdravstvenoj_ustanovi"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Date And Time Of Registration:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_pregledu/dokumenti:datum_i_vreme_prijave"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Date And Time Of Completion:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_pregledu/dokumenti:datum_i_vreme_zavrsetka"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Report:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Insured Person:</b></td>
                                    <td>
                                        <table>
                                            <tr>
                                                <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:osiguranik/@id"/></td>
                                            </tr>
                                            <tr>
                                                <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:osiguranik/osobe:ime"/></td>
                                            </tr>
                                            <tr>
                                                <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:osiguranik/osobe:prezime"/></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- Suffering From:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:boluje_od"/></td>
                                    <td><b>- Medical Result:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:nalaz"/></td>
                                    <td><b>- Opinion:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:misljenje"/></td>
                                    <td><b>- Date:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:datum"/></td>
                                    <td><b>- Doctor Spicialist's Signature:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:potpis_lekara"/></td>
                                    <td><b>- Seal:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:pecat"/></td>
                                </tr>
                            </table>
                        </td>
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