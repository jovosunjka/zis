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
                        <td><b>- Id:</b></td>
                        <xsl:variable name="var_id" select="dokumenti:uput_za_laboratoriju/@id"/>
                        <xsl:if test="not(contains($var_id, '%1$s'))">
                            <td><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_id, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/@id"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Reg. Number:</b></td>
                        <xsl:variable name="var_reg_br" select="dokumenti:uput_za_laboratoriju/@reg_br"/>
                        <xsl:if test="not(contains($var_reg_br, '%1$s'))">
                            <td><xsl:value-of select="$var_reg_br"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_reg_br, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_reg_br"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/@reg_br"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Num. Health Card:</b></td>
                        <xsl:variable name="var_broj_zdravstvenog_kartona" select="dokumenti:uput_za_laboratoriju/dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/>
                        <xsl:if test="not(contains($var_broj_zdravstvenog_kartona, '%1$s'))">
                            <td><xsl:value-of select="$var_broj_zdravstvenog_kartona"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_broj_zdravstvenog_kartona, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_broj_zdravstvenog_kartona"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Health Institution Sending:</b></td>
                        <xsl:variable name="var_zdravstvena_ustanova_koja_salje" select="dokumenti:uput_za_laboratoriju/dokumenti:zdravstvena_ustanova_koja_salje"/>
                        <xsl:if test="not(contains($var_zdravstvena_ustanova_koja_salje, '%1$s'))">
                            <td><xsl:value-of select="$var_zdravstvena_ustanova_koja_salje"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_zdravstvena_ustanova_koja_salje, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_zdravstvena_ustanova_koja_salje"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:zdravstvena_ustanova_koja_salje"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Health Institution Receiving:</b></td>
                        <xsl:variable name="var_zdravstvena_ustanova_koja_prima" select="dokumenti:uput_za_laboratoriju/dokumenti:zdravstvena_ustanova_koja_prima"/>
                        <xsl:if test="not(contains($var_zdravstvena_ustanova_koja_prima, '%1$s'))">
                            <td><xsl:value-of select="$var_zdravstvena_ustanova_koja_prima"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_zdravstvena_ustanova_koja_prima, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_zdravstvena_ustanova_koja_prima"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:zdravstvena_ustanova_koja_prima"/></td>-->
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
                                                <xsl:if test="not(contains($var_pacijent_id, '%1$s'))">
                                                    <td>
                                                        <a href="http://localhost:8081/api/search/{$var_pacijent_type}/{$var_pacijent_id_num}">
                                                            <xsl:value-of select="$var_pacijent_id"/>
                                                            <!--<xsl:apply-templates />-->
                                                        </a>
                                                    </td>
                                                </xsl:if>
                                                <xsl:if test="contains($var_pacijent_id, '%1$s')">
                                                    <td bgcolor="red">
                                                        <a href="http://localhost:8081/api/search/{$var_pacijent_type}/{$var_pacijent_id_num}">
                                                            <xsl:value-of select="$var_pacijent_id"/>
                                                            <!--<xsl:apply-templates />-->
                                                        </a>
                                                    </td>
                                                </xsl:if>
                                            </tr>
                                            <tr>
                                                <td><b>- First Name:</b></td>
                                                <xsl:variable name="var_pacijent_ime" select="dokumenti:uput_za_laboratoriju/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:ime"/>
                                                <xsl:if test="not(contains($var_pacijent_ime, '%1$s'))">
                                                    <td><xsl:value-of select="$var_pacijent_ime"/></td>
                                                </xsl:if>
                                                <xsl:if test="contains($var_pacijent_ime, '%1$s')">
                                                    <td bgcolor="red"><xsl:value-of select="$var_pacijent_ime"/></td>
                                                </xsl:if>
                                                <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/osobe:ime"/></td>-->
                                            </tr>
                                            <tr>
                                                <td><b>- Last Name:</b></td>
                                                <xsl:variable name="var_pacijent_prezime" select="dokumenti:uput_za_laboratoriju/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:prezime"/>
                                                <xsl:if test="not(contains($var_pacijent_prezime, '%1$s'))">
                                                    <td><xsl:value-of select="$var_pacijent_prezime"/></td>
                                                </xsl:if>
                                                <xsl:if test="contains($var_pacijent_prezime, '%1$s')">
                                                    <td bgcolor="red"><xsl:value-of select="$var_pacijent_prezime"/></td>
                                                </xsl:if>
                                                <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/osobe:prezime"/></td>-->
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- Reason Of Insurance:</b></td>
                                    <xsl:variable name="var_osnov_osiguranja" select="dokumenti:uput_za_laboratoriju/dokumenti:podaci_o_osiguranju/dokumenti:osnov_osiguranja"/>
                                    <xsl:if test="not(contains($var_osnov_osiguranja, '%1$s'))">
                                        <td><xsl:value-of select="$var_osnov_osiguranja"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_osnov_osiguranja, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_osnov_osiguranja"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:podaci_o_osiguranju/dokumenti:osnov_osiguranja"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Clinical Diagnosis:</b></td>
                        <xsl:variable name="var_klinicka_dijagnoza" select="dokumenti:uput_za_laboratoriju/dokumenti:klinicka_dijagnoza"/>
                        <xsl:if test="not(contains($var_klinicka_dijagnoza, '%1$s'))">
                            <td><xsl:value-of select="$var_klinicka_dijagnoza"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_klinicka_dijagnoza, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_klinicka_dijagnoza"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:klinicka_dijagnoza"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- When The Material Is Taken:</b></td>
                        <xsl:variable name="var_kad_je_uzet_materijal" select="dokumenti:uput_za_laboratoriju/dokumenti:kad_je_uzet_materijal"/>
                        <xsl:if test="not(contains($var_kad_je_uzet_materijal, '%1$s'))">
                            <td><xsl:value-of select="$var_kad_je_uzet_materijal"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_kad_je_uzet_materijal, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_kad_je_uzet_materijal"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:kad_je_uzet_materijal"/></td>-->
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
                                    <xsl:if test="not(contains($var_ko_salje_materijal_id, '%1$s'))">
                                        <td>
                                            <a href="http://localhost:8081/api/search/{$var_ko_salje_materijal_type}/{$var_ko_salje_materijal_id_num}">
                                                <xsl:value-of select="$var_ko_salje_materijal_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_ko_salje_materijal_id, '%1$s')">
                                        <td bgcolor="red">
                                            <a href="http://localhost:8081/api/search/{$var_ko_salje_materijal_type}/{$var_ko_salje_materijal_id_num}">
                                                <xsl:value-of select="$var_ko_salje_materijal_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td>
                                    <xsl:variable name="var_ko_salje_materijal_ime" select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_materijal/dokumenti:ime"/>
                                    <xsl:if test="not(contains($var_ko_salje_materijal_ime, '%1$s'))">
                                        <td><xsl:value-of select="$var_ko_salje_materijal_ime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_ko_salje_materijal_ime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_ko_salje_materijal_ime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_materijal/dokumenti:ime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td>
                                    <xsl:variable name="var_ko_salje_materijal_prezime" select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_materijal/dokumenti:prezime"/>
                                    <xsl:if test="not(contains($var_ko_salje_materijal_prezime, '%1$s'))">
                                        <td><xsl:value-of select="$var_ko_salje_materijal_prezime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_ko_salje_materijal_prezime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_ko_salje_materijal_prezime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_materijal/dokumenti:prezime"/></td>-->
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
                                    <xsl:if test="not(contains($var_ko_salje_na_pregled_id, '%1$s'))">
                                        <td>
                                            <a href="http://localhost:8081/api/search/{$var_ko_salje_na_pregled_type}/{$var_ko_salje_na_pregled_id_num}">
                                                <xsl:value-of select="$var_ko_salje_na_pregled_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_ko_salje_na_pregled_id, '%1$s')">
                                        <td bgcolor="red">
                                            <a href="http://localhost:8081/api/search/{$var_ko_salje_na_pregled_type}/{$var_ko_salje_na_pregled_id_num}">
                                                <xsl:value-of select="$var_ko_salje_na_pregled_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td>
                                    <xsl:variable name="var_ko_salje_na_pregled_ime" select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_na_pregled/dokumenti:ime"/>
                                    <xsl:if test="not(contains($var_ko_salje_na_pregled_ime, '%1$s'))">
                                        <td><xsl:value-of select="$var_ko_salje_na_pregled_ime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_ko_salje_na_pregled_ime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_ko_salje_na_pregled_ime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_na_pregled/dokumenti:ime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td>
                                    <xsl:variable name="var_ko_salje_na_pregled_prezime" select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_na_pregled/dokumenti:prezime"/>
                                    <xsl:if test="not(contains($var_ko_salje_na_pregled_prezime, '%1$s'))">
                                        <td><xsl:value-of select="$var_ko_salje_na_pregled_prezime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_ko_salje_na_pregled_prezime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_ko_salje_na_pregled_prezime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_na_pregled/dokumenti:prezime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Doctor's Signature:</b></td>
                                    <xsl:variable name="var_potpis_lekara" select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_na_pregled/dokumenti:potpis_lekara"/>
                                    <xsl:if test="not(contains($var_potpis_lekara, '%1$s'))">
                                        <td><xsl:value-of select="$var_potpis_lekara"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_potpis_lekara, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_potpis_lekara"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:ko_salje_na_pregled/dokumenti:potpis_lekara"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Type Of Review:</b></td>
                        <xsl:variable name="var_tip_pregleda" select="dokumenti:uput_za_laboratoriju/dokumenti:tip_pregleda"/>
                        <xsl:if test="not(contains($var_tip_pregleda, '%1$s'))">
                            <td><xsl:value-of select="$var_tip_pregleda"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_tip_pregleda, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_tip_pregleda"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:tip_pregleda"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Date:</b></td>
                        <xsl:variable name="var_datum" select="dokumenti:uput_za_laboratoriju/dokumenti:datum"/>
                        <xsl:if test="not(contains($var_datum, '%1$s'))">
                            <td><xsl:value-of select="$var_datum"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_datum, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_datum"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:datum"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Seal:</b></td>
                        <xsl:variable name="var_pecat" select="dokumenti:uput_za_laboratoriju/dokumenti:pecat"/>
                        <xsl:if test="not(contains($var_pecat, '%1$s'))">
                            <td><xsl:value-of select="$var_pecat"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_pecat, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_pecat"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_laboratoriju/dokumenti:pecat"/></td>-->
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>