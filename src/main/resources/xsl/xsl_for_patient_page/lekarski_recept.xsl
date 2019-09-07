<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:str="http://exslt.org/strings"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
        <html>
            <body bgcolor="black">
                <table bgcolor="yellow">
                    <tr><th colspan="2"><b>Doctor's Receipt:</b></th></tr>
                    <tr>
                        <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/@id"/></td>
                    </tr>
                    <tr>
                        <td><b>- Health card:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Num. Health Card:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Num. Health Book:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:zdravstveni_karton/@broj_zdrastvene_knjizice"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Insured Person:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <td>
                                        <xsl:variable name="var_patient_id" select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:pacijent/@id"/>
                                        <xsl:variable name="var_patient_id_num" select="str:tokenize(string($var_patient_id),'/')[last()]"/>
                                        <xsl:variable name="var_patient_type" select="str:tokenize(string($var_patient_id),'/')[last()-1]"/>
                                        <a href="http://localhost:8081/api/search/{$var_patient_type}/{$var_patient_id_num}">
                                            <xsl:value-of select="$var_patient_id"/>
                                            <!--<xsl:apply-templates />-->
                                        </a>
                                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:pacijent/@id"/></td>-->
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:ime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:prezime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Date Of Birth:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:datum_rodjenja"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Institution:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Name Of Health Institution:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:ustanova/dokumenti:naziv_zdrastvene_ustanove"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Country:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:ustanova/dokumenti:drzava"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                    <tr>
                        <td><b>- Reason For Exemption From Participation:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:osnov_oslobadjanja_od_participacije"/></td>
                    </tr>

                    <tr>
                        <td><b>- Doctor's Information:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <td>
                                        <xsl:variable name="var_doctor_id_num" select="str:tokenize(string(dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:lekar/@id),'/')[last()]"/>
                                        <xsl:variable name="var_doctor_type" select="str:tokenize(string(dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:lekar/@id),'/')[last()-1]"/>
                                        <a href="http://localhost:8081/api/search/{$var_doctor_type}/{$var_doctor_id_num}">
                                            <xsl:value-of select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:lekar/@id"/>
                                            <!--<xsl:apply-templates />-->
                                        </a>
                                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:lekar/@id"/></td></td>-->
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:ime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Last name:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:prezime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Doctor's Signature:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:potpis_lekara"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                    <tr>
                        <td><b>- Prescribed Medicament:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <td>
                                        <xsl:variable name="var_prescribed_medicament_id" select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:lek/@id"/>
                                        <xsl:variable name="var_prescribed_medicament_id_num" select="str:tokenize(string($var_prescribed_medicament_id),'/')[last()]"/>
                                        <xsl:variable name="var_prescribed_medicament_type" select="str:tokenize(string($var_prescribed_medicament_id),'/')[last()-1]"/>
                                        <a href="http://localhost:8081/api/search/{$var_prescribed_medicament_type}/{$var_prescribed_medicament_id_num}">
                                            <xsl:value-of select="$var_prescribed_medicament_id"/>
                                            <!--<xsl:apply-templates />-->
                                        </a>
                                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:lek/@id"/></td>-->
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- Name:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:naziv"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Code:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:sifra"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Date:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:datum"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                    <tr>
                        <td><b>- Given Medicament:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <td>
                                        <xsl:variable name="var_given_medicament_id" select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:lek/@id"/>
                                        <xsl:variable name="var_given_medicament_id_num" select="str:tokenize(string($var_given_medicament_id),'/')[last()]"/>
                                        <xsl:variable name="var_given_medicament_type" select="str:tokenize(string($var_given_medicament_id),'/')[last()-1]"/>
                                        <a href="http://localhost:8081/api/search/{$var_given_medicament_type}/{$var_given_medicament_id_num}">
                                            <xsl:value-of select="$var_given_medicament_id"/>
                                            <!--<xsl:apply-templates />-->
                                        </a>
                                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:lek/@id"/></td>-->
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>- Name:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:naziv"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Code:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:sifra"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Date:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:datum"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>


                    <tr>
                        <td><b>- Diagnosis:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:dijagnoza"/></td>
                    </tr>
                    <tr>
                        <td><b>- Serial Number:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:redni_broj"/></td>
                    </tr>
                    <tr>
                        <td><b>- Quantity:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:kolicina"/></td>
                    </tr>
                    <tr>
                        <td><b>- Pharmacist's Signature:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:potpis_farmaceuta"/></td>
                    </tr>
                    <tr>
                        <td><b>- Medicament Received:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:lek_primio"/></td>
                    </tr>
                    <tr>
                        <td><b>- Rp:</b></td> <td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:rp"/></td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>