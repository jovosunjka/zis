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
                        <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/@id"/></td>
                    </tr>
                    <tr>
                        <td><b>- Reg. Number:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/@reg_br"/></td>
                    </tr>
                    <tr>
                        <td><b>- Num. Health Card:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/></td>
                    </tr>
                    <tr>
                        <td><b>- Health Institution Sending:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:zdravstvena_ustanova_koja_salje"/></td>
                    </tr>
                    <tr>
                        <td><b>- Health Institution Receiving:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:zdravstvena_ustanova_koja_prima"/></td>
                    </tr>
                    <tr>
                        <td><b>- Date:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:datum"/></td>
                    </tr>
                    <tr>
                        <td><b>- Doctor:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <xsl:variable name="var_doctor_id" select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/@id"/>
                                    <xsl:variable name="var_doctor_id_num" select="str:tokenize(string($var_doctor_id),'/')[last()]"/>
                                    <xsl:variable name="var_doctor_type" select="str:tokenize(string($var_doctor_id),'/')[last()-1]"/>
                                    <td>
                                        <a href="http://localhost:8081/api/search/{$var_doctor_type}/{$var_doctor_id_num}">
                                            <xsl:value-of select="$var_doctor_id"/>
                                            <!--<xsl:apply-templates />-->
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/dokumenti:ime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/dokumenti:prezime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Doctor's Signature:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:lekar/dokumenti:potpis_lekara"/></td>
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
                                                <td>
                                                    <a href="http://localhost:8081/api/search/{$var_pacijent_type}/{$var_pacijent_id_num}">
                                                        <xsl:value-of select="$var_pacijent_id"/>
                                                        <!--<xsl:apply-templates />-->
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:ime"/></td>
                                            </tr>
                                            <tr>
                                                <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:nosilac_osiguranja/dokumenti:prezime"/></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- Reason Of Insurance:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_osiguranju/dokumenti:osnov_osiguranja"/></td>
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
                                    <td>
                                        <a href="http://localhost:8081/api/search/{$var_specialist_type}/{$var_specialist_id_num}">
                                            <xsl:value-of select="$var_specialist_id"/>
                                            <!--<xsl:apply-templates />-->
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:ime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:prezime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Doctor Specialist For:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:specijalista/dokumenti:lekar_specijalista_za"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Review Information:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Purpose Of Review:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:svrha_pregleda"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Performed At A Health Institution:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:obavljen_u_zdravstvenoj_ustanovi"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Date And Time Of Registration:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:datum_i_vreme_prijave"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Date And Time Of Completion:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:podaci_o_pregledu/dokumenti:datum_i_vreme_zavrsetka"/></td>
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
                                                <td>
                                                    <a href="http://localhost:8081/api/search/{$var_osiguranik_type}/{$var_osiguranik_id_num}">
                                                        <xsl:value-of select="$var_osiguranik_id"/>
                                                        <!--<xsl:apply-templates />-->
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:osiguranik/dokumenti:ime"/></td>
                                            </tr>
                                            <tr>
                                                <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:osiguranik/dokumenti:prezime"/></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- Suffering From:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:boluje_od"/></td>
                                    <td><b>- Medical Result:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:nalaz"/></td>
                                    <td><b>- Opinion:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:misljenje"/></td>
                                    <td><b>- Date:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:datum"/></td>
                                    <td><b>- Doctor Spicialist's Signature:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:potpis_lekara"/></td>
                                    <td><b>- Seal:</b></td> <td><xsl:value-of select="dokumenti:uput_za_specijalisticki_pregled/dokumenti:izvestaj/dokumenti:pecat"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>