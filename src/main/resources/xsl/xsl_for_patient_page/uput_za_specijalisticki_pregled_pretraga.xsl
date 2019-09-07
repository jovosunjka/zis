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
                    <tr><th colspan="2"><b>Referral For Specialist Examination:</b></th></tr>
                    <tr>
                        <td><b>- Id:</b></td>
                        <xsl:variable name="var_id" select="dokumenti:uput_za_specijalisticki_pregled/@id"/>
                        <xsl:if test="not(contains($var_id, '%1$s'))">
                            <td><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_id, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/@id"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Reg. Number:</b></td>
                        <xsl:variable name="var_reg_br" select="dokumenti:uput_za_specijalisticki_pregled/@reg_br"/>
                        <xsl:if test="not(contains($var_reg_br, '%1$s'))">
                            <td><xsl:value-of select="$var_reg_br"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_reg_br, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_reg_br"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/@reg_br"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Num. Health Card:</b></td>
                        <xsl:variable name="var_broj_zdravstvenog_kartona" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/>
                        <xsl:if test="not(contains($var_broj_zdravstvenog_kartona, '%1$s'))">
                            <td><xsl:value-of select="$var_broj_zdravstvenog_kartona"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_broj_zdravstvenog_kartona, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_broj_zdravstvenog_kartona"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Health Institution Sending:</b></td>
                        <xsl:variable name="var_zdravstvena_ustanova_koja_salje" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:zdravstvena_ustanova_koja_salje"/>
                        <xsl:if test="not(contains($var_zdravstvena_ustanova_koja_salje, '%1$s'))">
                            <td><xsl:value-of select="$var_zdravstvena_ustanova_koja_salje"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_zdravstvena_ustanova_koja_salje, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_zdravstvena_ustanova_koja_salje"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:zdravstvena_ustanova_koja_salje"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Health Institution Receiving:</b></td>
                        <xsl:variable name="var_zdravstvena_ustanova_koja_prima" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:zdravstvena_ustanova_koja_prima"/>
                        <xsl:if test="not(contains($var_zdravstvena_ustanova_koja_prima, '%1$s'))">
                            <td><xsl:value-of select="$var_zdravstvena_ustanova_koja_prima"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_zdravstvena_ustanova_koja_prima, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_zdravstvena_ustanova_koja_prima"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:zdravstvena_ustanova_koja_prima"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Date:</b></td>
                        <xsl:variable name="var_datum" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:datum"/>
                        <xsl:if test="not(contains($var_datum, '%1$s'))">
                            <td><xsl:value-of select="$var_datum"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_datum, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_datum"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:datum"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Doctor:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <xsl:variable name="var_doctor_id" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/@id"/>
                                    <xsl:variable name="var_doctor_id_num" select="str:tokenize(string($var_doctor_id),'/')[last()]"/>
                                    <xsl:variable name="var_doctor_type" select="str:tokenize(string($var_doctor_id),'/')[last()-1]"/>
                                    <xsl:if test="not(contains($var_doctor_id, '%1$s'))">
                                        <td>
                                            <a href="http://localhost:8081/api/search/{$var_doctor_type}/{$var_doctor_id_num}">
                                                <xsl:value-of select="$var_doctor_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_doctor_id, '%1$s')">
                                        <td bgcolor="red">
                                            <a href="http://localhost:8081/api/search/{$var_doctor_type}/{$var_doctor_id_num}">
                                                <xsl:value-of select="$var_doctor_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/@id"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td>
                                    <xsl:variable name="var_lekar_ime" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/dokumenti:ime"/>
                                    <xsl:if test="not(contains($var_lekar_ime, '%1$s'))">
                                        <td><xsl:value-of select="$var_lekar_ime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_lekar_ime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_lekar_ime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/dokumenti:ime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td>
                                    <xsl:variable name="var_lekar_prezime" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/dokumenti:prezime"/>
                                    <xsl:if test="not(contains($var_lekar_prezime, '%1$s'))">
                                        <td><xsl:value-of select="$var_lekar_prezime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_lekar_prezime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_lekar_prezime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/dokumenti:prezime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Doctor's Signature:</b></td>
                                    <xsl:variable name="var_potpis_lekara" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/dokumenti:potpis_lekara"/>
                                    <xsl:if test="not(contains($var_potpis_lekara, '%1$s'))">
                                        <td><xsl:value-of select="$var_potpis_lekara"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_potpis_lekara, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_potpis_lekara"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/dokumenti:potpis_lekara"/></td>-->
                                </tr>
                            </table>
                        </td>
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
                                                <xsl:variable name="var_pacijent_id" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:pacijent/@id"/>
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
                                                <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:pacijent/@id"/></td>-->
                                            </tr>
                                            <tr>
                                                <td><b>- First Name:</b></td>
                                                <xsl:variable name="var_pacijent_ime" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:ime"/>
                                                <xsl:if test="not(contains($var_pacijent_ime, '%1$s'))">
                                                    <td><xsl:value-of select="$var_pacijent_ime"/></td>
                                                </xsl:if>
                                                <xsl:if test="contains($var_pacijent_ime, '%1$s')">
                                                    <td bgcolor="red"><xsl:value-of select="$var_pacijent_ime"/></td>
                                                </xsl:if>
                                                <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:ime"/></td>-->
                                            </tr>
                                            <tr>
                                                <td><b>- Last Name:</b></td>
                                                <xsl:variable name="var_pacijent_prezime" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:prezime"/>
                                                <xsl:if test="not(contains($var_pacijent_prezime, '%1$s'))">
                                                    <td><xsl:value-of select="$var_pacijent_prezime"/></td>
                                                </xsl:if>
                                                <xsl:if test="contains($var_pacijent_prezime, '%1$s')">
                                                    <td bgcolor="red"><xsl:value-of select="$var_pacijent_prezime"/></td>
                                                </xsl:if>
                                                <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:prezime"/></td>-->
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- Reason Of Insurance:</b></td>
                                    <xsl:variable name="var_osnov_osiguranja" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:osnov_osiguranja"/>
                                    <xsl:if test="not(contains($var_osnov_osiguranja, '%1$s'))">
                                        <td><xsl:value-of select="$var_osnov_osiguranja"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_osnov_osiguranja, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_osnov_osiguranja"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:osnov_osiguranja"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Doctor Specialist:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <xsl:variable name="var_specialist_id" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:lekar/@id"/>
                                    <xsl:variable name="var_specialist_id_num" select="str:tokenize(string($var_specialist_id),'/')[last()]"/>
                                    <xsl:variable name="var_specialist_type" select="str:tokenize(string($var_specialist_id),'/')[last()-1]"/>
                                    <xsl:if test="not(contains($var_specialist_id, '%1$s'))">
                                        <td>
                                            <a href="http://localhost:8081/api/search/{$var_specialist_type}/{$var_specialist_id_num}">
                                                <xsl:value-of select="$var_specialist_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_specialist_id, '%1$s')">
                                        <td bgcolor="red">
                                            <a href="http://localhost:8081/api/search/{$var_specialist_type}/{$var_specialist_id_num}">
                                                <xsl:value-of select="$var_specialist_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:lekar/@id"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td>
                                    <xsl:variable name="var_specijalista_ime" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:ime"/>
                                    <xsl:if test="not(contains($var_specijalista_ime, '%1$s'))">
                                        <td><xsl:value-of select="$var_specijalista_ime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_specijalista_ime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_specijalista_ime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:ime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td>
                                    <xsl:variable name="var_specijalista_prezime" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:prezime"/>
                                    <xsl:if test="not(contains($var_specijalista_prezime, '%1$s'))">
                                        <td><xsl:value-of select="$var_specijalista_prezime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_specijalista_prezime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_specijalista_prezime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:prezime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Doctor Specialist For:</b></td>
                                    <xsl:variable name="var_lekar_specijalista_za" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:lekar_specijalista_za"/>
                                    <xsl:if test="not(contains($var_lekar_specijalista_za, '%1$s'))">
                                        <td><xsl:value-of select="$var_lekar_specijalista_za"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_lekar_specijalista_za, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_lekar_specijalista_za"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:lekar_specijalista_za"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Review Information:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Purpose Of Review:</b></td>
                                    <xsl:variable name="var_svrha_pregleda" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:svrha_pregleda"/>
                                    <xsl:if test="not(contains($var_svrha_pregleda, '%1$s'))">
                                        <td><xsl:value-of select="$var_svrha_pregleda"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_svrha_pregleda, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_svrha_pregleda"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:svrha_pregleda"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Performed At A Health Institution:</b></td>
                                    <xsl:variable name="var_obavljen_u_zdravstvenoj_ustanovi" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:obavljen_u_zdravstvenoj_ustanovi"/>
                                    <xsl:if test="not(contains($var_obavljen_u_zdravstvenoj_ustanovi, '%1$s'))">
                                        <td><xsl:value-of select="$var_obavljen_u_zdravstvenoj_ustanovi"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_obavljen_u_zdravstvenoj_ustanovi, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_obavljen_u_zdravstvenoj_ustanovi"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:obavljen_u_zdravstvenoj_ustanovi"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Date And Time Of Registration:</b></td>
                                    <xsl:variable name="var_datum_i_vreme_prijave" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:datum_i_vreme_prijave"/>
                                    <xsl:if test="not(contains($var_datum_i_vreme_prijave, '%1$s'))">
                                        <td><xsl:value-of select="$var_datum_i_vreme_prijave"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_datum_i_vreme_prijave, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_datum_i_vreme_prijave"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:datum_i_vreme_prijave"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Date And Time Of Completion:</b></td>
                                    <xsl:variable name="var_datum_i_vreme_zavrsetka" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:datum_i_vreme_zavrsetka"/>
                                    <xsl:if test="not(contains($var_datum_i_vreme_zavrsetka, '%1$s'))">
                                        <td><xsl:value-of select="$var_datum_i_vreme_zavrsetka"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_datum_i_vreme_zavrsetka, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_datum_i_vreme_zavrsetka"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:datum_i_vreme_zavrsetka"/></td>-->
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
                                                <td><b>- Id:</b></td>
                                                <xsl:variable name="var_osiguranik_id" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:osiguranik/dokumenti:pacijent/@id"/>
                                                <xsl:variable name="var_osiguranik_id_num" select="str:tokenize(string($var_osiguranik_id),'/')[last()]"/>
                                                <xsl:variable name="var_osiguranik_type" select="str:tokenize(string($var_osiguranik_id),'/')[last()-1]"/>
                                                <xsl:if test="not(contains($var_osiguranik_id, '%1$s'))">
                                                    <td>
                                                        <a href="http://localhost:8081/api/search/{$var_osiguranik_type}/{$var_osiguranik_id_num}">
                                                            <xsl:value-of select="$var_osiguranik_id"/>
                                                            <!--<xsl:apply-templates />-->
                                                        </a>
                                                    </td>
                                                </xsl:if>
                                                <xsl:if test="contains($var_osiguranik_id, '%1$s')">
                                                    <td bgcolor="red">
                                                        <a href="http://localhost:8081/api/search/{$var_osiguranik_type}/{$var_osiguranik_id_num}">
                                                            <xsl:value-of select="$var_osiguranik_id"/>
                                                            <!--<xsl:apply-templates />-->
                                                        </a>
                                                    </td>
                                                </xsl:if>
                                                <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:osiguranik/dokumenti:pacijent/@id"/></td>-->
                                            </tr>
                                            <tr>
                                                <td><b>- First Name:</b></td>
                                                <xsl:variable name="var_osiguranik_ime" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:osiguranik/dokumenti:ime"/>
                                                <xsl:if test="not(contains($var_osiguranik_ime, '%1$s'))">
                                                    <td><xsl:value-of select="$var_osiguranik_ime"/></td>
                                                </xsl:if>
                                                <xsl:if test="contains($var_osiguranik_ime, '%1$s')">
                                                    <td bgcolor="red"><xsl:value-of select="$var_osiguranik_ime"/></td>
                                                </xsl:if>
                                                <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:osiguranik/dokumenti:ime"/></td>-->
                                            </tr>
                                            <tr>
                                                <td><b>- Last Name:</b></td>
                                                <xsl:variable name="var_osiguranik_prezime" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:osiguranik/dokumenti:prezime"/>
                                                <xsl:if test="not(contains($var_osiguranik_prezime, '%1$s'))">
                                                    <td><xsl:value-of select="$var_osiguranik_prezime"/></td>
                                                </xsl:if>
                                                <xsl:if test="contains($var_osiguranik_prezime, '%1$s')">
                                                    <td bgcolor="red"><xsl:value-of select="$var_osiguranik_prezime"/></td>
                                                </xsl:if>
                                                <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:osiguranik/dokumenti:prezime"/></td>-->
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- Suffering From:</b></td>
                                    <xsl:variable name="var_boluje_od" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:boluje_od"/>
                                    <xsl:if test="not(contains($var_boluje_od, '%1$s'))">
                                        <td><xsl:value-of select="$var_boluje_od"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_boluje_od, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_boluje_od"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:boluje_od"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Medical Result:</b></td>
                                    <xsl:variable name="var_nalaz" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:nalaz"/>
                                    <xsl:if test="not(contains($var_nalaz, '%1$s'))">
                                        <td><xsl:value-of select="$var_nalaz"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_nalaz, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_nalaz"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:nalaz"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Opinion:</b></td>
                                    <xsl:variable name="var_misljenje" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:misljenje"/>
                                    <xsl:if test="not(contains($var_misljenje, '%1$s'))">
                                        <td><xsl:value-of select="$var_misljenje"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_misljenje, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_misljenje"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:misljenje"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Date:</b></td>
                                    <xsl:variable name="var_datum2" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:datum"/>
                                    <xsl:if test="not(contains($var_datum2, '%1$s'))">
                                        <td><xsl:value-of select="$var_datum2"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_datum2, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_datum2"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:datum"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Doctor Spicialist's Signature:</b></td>
                                    <xsl:variable name="var_potpis_lekara2" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:potpis_lekara"/>
                                    <xsl:if test="not(contains($var_potpis_lekara2, '%1$s'))">
                                        <td><xsl:value-of select="$var_potpis_lekara2"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_potpis_lekara2, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_potpis_lekara2"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:potpis_lekara"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Seal:</b></td>
                                    <xsl:variable name="var_pecat" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:pecat"/>
                                    <xsl:if test="not(contains($var_pecat, '%1$s'))">
                                        <td><xsl:value-of select="$var_pecat"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_pecat, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_pecat"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:pecat"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>