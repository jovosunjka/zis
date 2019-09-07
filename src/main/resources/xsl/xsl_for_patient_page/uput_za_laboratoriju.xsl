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
                    <tr><th colspan="2"><b>Referral For Lab:</b></th></tr>
                    <tr>
                        <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/@id"/></td>
                    </tr>
                    <tr>
                        <td><b>- Reg. Number:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/@reg_br"/></td>
                    </tr>
                    <tr>
                        <td><b>- Num. Health Card:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/></td>
                    </tr>
                    <tr>
                        <td><b>- Health Institution Sending:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:zdravstvena_ustanova_koja_salje"/></td>
                    </tr>
                    <tr>
                        <td><b>- Health Institution Receiving:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:zdravstvena_ustanova_koja_prima"/></td>
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
                                                <td><b>- Id:</b></td>
                                                <xsl:variable name="var_pacijent_id" select="dokumenti:uput_za_laboratoriju/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:pacijent/@id"/>
                                                <xsl:variable name="var_pacijent_id_num" select="str:tokenize(string($var_pacijent_id),'/')[last()]"/>
                                                <xsl:variable name="var_pacijent_type" select="str:tokenize(string($var_pacijent_id),'/')[last()-1]"/>
                                                <td>
                                                    <a href="http://localhost:8081/api/search/{$var_pacijent_type}/{$var_pacijent_id_num}">
                                                        <xsl:value-of select="$var_pacijent_id"/>
                                                        <!--<xsl:apply-templates />-->
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:ime"/></td>
                                            </tr>
                                            <tr>
                                                <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:prezime"/></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- Reason Of Insurance:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:podaci_o_osiguranju/dokumenti:osnov_osiguranja"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Clinical Diagnosis:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:klinicka_dijagnoza"/></td>
                    </tr>
                    <tr>
                        <td><b>- When The Material Is Taken:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:kad_je_uzet_materijal"/></td>
                    </tr>
                    <tr>
                        <td><b>- Who Sends The Material:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <xsl:variable name="var_ko_salje_materijal_id" select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_materijal/dokumenti:pacijent/@id"/>
                                    <xsl:variable name="var_ko_salje_materijal_id_num" select="str:tokenize(string($var_ko_salje_materijal_id),'/')[last()]"/>
                                    <xsl:variable name="var_ko_salje_materijal_type" select="str:tokenize(string($var_ko_salje_materijal_id),'/')[last()-1]"/>
                                    <td>
                                        <a href="http://localhost:8081/api/search/{$var_ko_salje_materijal_type}/{$var_ko_salje_materijal_id_num}">
                                            <xsl:value-of select="$var_ko_salje_materijal_id"/>
                                            <!--<xsl:apply-templates />-->
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_materijal/dokumenti:ime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_materijal/dokumenti:prezime"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Who Sends On Reviewing:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <xsl:variable name="var_ko_salje_na_pregled_id" select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_na_pregled/dokumenti:lekar/@id"/>
                                    <xsl:variable name="var_ko_salje_na_pregled_id_num" select="str:tokenize(string($var_ko_salje_na_pregled_id),'/')[last()]"/>
                                    <xsl:variable name="var_ko_salje_na_pregled_type" select="str:tokenize(string($var_ko_salje_na_pregled_id),'/')[last()-1]"/>
                                    <td>
                                        <a href="http://localhost:8081/api/search/{$var_ko_salje_na_pregled_type}/{$var_ko_salje_na_pregled_id_num}">
                                            <xsl:value-of select="$var_ko_salje_na_pregled_id"/>
                                            <!--<xsl:apply-templates />-->
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_na_pregled/dokumenti:ime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_na_pregled/dokumenti:prezime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Doctor's Signature:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_na_pregled/dokumenti:potpis_lekara"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Type Of Review:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:tip_pregleda"/></td>
                    </tr>
                    <tr>
                        <td><b>- Date:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:datum"/></td>
                    </tr>
                    <tr>
                        <td><b>- Seal:</b></td> <td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:pecat"/></td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>