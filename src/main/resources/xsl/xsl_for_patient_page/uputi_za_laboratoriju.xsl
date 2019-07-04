<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    xmlns:osobe="http://www.svj.com/zis/osobe"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
            <xsl:for-each select="kolekcije:uputi_za_laboratoriju/dokumenti:uput_za_laboratoriju">
                <br/>
                <br/>
                <table border-collapse="collapse" border="1px solid blue">
                    <tr>
                        <td><b>- Id:</b></td> <td><xsl:value-of select="@id"/></td>
                    </tr>
                    <tr>
                        <td><b>- Reg. Number:</b></td> <td><xsl:value-of select="@reg_br"/></td>
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
                        <td><b>- Clinical Diagnosis:</b></td> <td><xsl:value-of select="dokumenti:klinicka_dijagnoza"/></td>
                    </tr>
                    <tr>
                        <td><b>- When The Material Is Taken:</b></td> <td><xsl:value-of select="dokumenti:kad_je_uzet_materijal"/></td>
                    </tr>
                    <tr>
                        <td><b>- Who Sends The Material:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:ko_salje_materijal/dokumenti:pacijent/@id"/></td>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:ko_salje_materijal/dokumenti:ime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:ko_salje_materijal/dokumenti:prezime"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Who Sends On Reviewing:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:ko_salje_na_pregled/dokumenti:lekar/@id"/></td>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:ko_salje_na_pregled/dokumenti:ime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:ko_salje_na_pregled/dokumenti:prezime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Doctor's Signature:</b></td> <td><xsl:value-of select="dokumenti:ko_salje_na_pregled/dokumenti:potpis_lekara"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Type Of Review:</b></td> <td><xsl:value-of select="dokumenti:tip_pregleda"/></td>
                    </tr>
                    <tr>
                        <td><b>- Date:</b></td> <td><xsl:value-of select="dokumenti:datum"/></td>
                    </tr>
                    <tr>
                        <td><b>- Seal:</b></td> <td><xsl:value-of select="dokumenti:pecat"/></td>
                    </tr>
                </table>
            </xsl:for-each>

    </xsl:template>
    
</xsl:stylesheet>