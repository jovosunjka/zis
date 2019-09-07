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
                        <td><b>- Id:</b></td>
                        <xsl:variable name="var_id" select="dokumenti:lekarski_recept/@id"/>
                        <xsl:if test="not(contains($var_id, '%1$s'))">
                            <td><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_id, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/@id"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Health card:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Num. Health Card:</b></td>
                                    <xsl:variable name="var_broj_zdravstvenog_kartona" select="dokumenti:lekarski_recept/dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/>
                                    <xsl:if test="not(contains($var_broj_zdravstvenog_kartona, '%1$s'))">
                                        <td><xsl:value-of select="$var_broj_zdravstvenog_kartona"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_broj_zdravstvenog_kartona, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_broj_zdravstvenog_kartona"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Num. Health Book:</b></td>
                                    <xsl:variable name="var_broj_zdrastvene_knjizice" select="dokumenti:lekarski_recept/dokumenti:zdravstveni_karton/@broj_zdrastvene_knjizice"/>
                                    <xsl:if test="not(contains($var_broj_zdrastvene_knjizice, '%1$s'))">
                                        <td><xsl:value-of select="$var_broj_zdrastvene_knjizice"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_broj_zdrastvene_knjizice, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_broj_zdrastvene_knjizice"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:zdravstveni_karton/@broj_zdrastvene_knjizice"/></td>-->
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
                                    <xsl:variable name="var_patient_id" select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:pacijent/@id"/>
                                    <xsl:variable name="var_patient_id_num" select="str:tokenize(string($var_patient_id),'/')[last()]"/>
                                    <xsl:variable name="var_patient_type" select="str:tokenize(string($var_patient_id),'/')[last()-1]"/>
                                    <xsl:if test="not(contains($var_patient_id, '%1$s'))">
                                        <td>
                                            <a href="http://localhost:8081/api/search/{$var_patient_type}/{$var_patient_id_num}">
                                                <xsl:value-of select="$var_patient_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_patient_id, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_patient_id"/>
                                            <a href="http://localhost:8081/api/search/{$var_patient_type}/{$var_patient_id_num}">
                                                <xsl:value-of select="$var_patient_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:pacijent/@id"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td>
                                    <xsl:variable name="var_pacijent_ime" select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:ime"/>
                                    <xsl:if test="not(contains($var_pacijent_ime, '%1$s'))">
                                        <td><xsl:value-of select="$var_pacijent_ime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_pacijent_ime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_pacijent_ime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:ime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td>
                                    <xsl:variable name="var_pacijent_prezime" select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:prezime"/>
                                    <xsl:if test="not(contains($var_pacijent_prezime, '%1$s'))">
                                        <td><xsl:value-of select="$var_pacijent_prezime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_pacijent_prezime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_pacijent_prezime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:prezime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Date Of Birth:</b></td>
                                    <xsl:variable name="var_pacijent_datum_rodjenja" select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:datum_rodjenja"/>
                                    <xsl:if test="not(contains($var_pacijent_datum_rodjenja, '%1$s'))">
                                        <td><xsl:value-of select="$var_pacijent_datum_rodjenja"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_pacijent_datum_rodjenja, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_pacijent_datum_rodjenja"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:osigurano_lice/dokumenti:datum_rodjenja"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Institution:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Name Of Health Institution:</b></td>
                                    <xsl:variable name="var_naziv_zdrastvene_ustanove" select="dokumenti:lekarski_recept/dokumenti:ustanova/dokumenti:naziv_zdrastvene_ustanove"/>
                                    <xsl:if test="not(contains($var_naziv_zdrastvene_ustanove, '%1$s'))">
                                        <td><xsl:value-of select="$var_naziv_zdrastvene_ustanove"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_naziv_zdrastvene_ustanove, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_naziv_zdrastvene_ustanove"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:ustanova/dokumenti:naziv_zdrastvene_ustanove"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Country:</b></td>
                                    <xsl:variable name="var_drzava" select="dokumenti:lekarski_recept/dokumenti:ustanova/dokumenti:drzava"/>
                                    <xsl:if test="not(contains($var_drzava, '%1$s'))">
                                        <td><xsl:value-of select="$var_drzava"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_drzava, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_drzava"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:ustanova/dokumenti:drzava"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>

                    <tr>
                        <td><b>- Reason For Exemption From Participation:</b></td>
                        <xsl:variable name="var_osnov_oslobadjanja_od_participacije" select="dokumenti:lekarski_recept/dokumenti:osnov_oslobadjanja_od_participacije"/>
                        <xsl:if test="not(contains($var_osnov_oslobadjanja_od_participacije, '%1$s'))">
                            <td><xsl:value-of select="$var_osnov_oslobadjanja_od_participacije"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_osnov_oslobadjanja_od_participacije, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_osnov_oslobadjanja_od_participacije"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:osnov_oslobadjanja_od_participacije"/></td>-->
                    </tr>

                    <tr>
                        <td><b>- Doctor's Information:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <xsl:variable name="var_doctor_id" select="dokumenti:izvestaj/dokumenti:lekar/@id"/>
                                    <xsl:variable name="var_doctor_id_num" select="str:tokenize(string(dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:lekar/@id),'/')[last()]"/>
                                    <xsl:variable name="var_doctor_type" select="str:tokenize(string(dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:lekar/@id),'/')[last()-1]"/>
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
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:lekar/@id"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td>
                                    <xsl:variable name="var_lekar_ime" select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:ime"/>
                                    <xsl:if test="not(contains($var_lekar_ime, '%1$s'))">
                                        <td><xsl:value-of select="$var_lekar_ime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_lekar_ime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_lekar_ime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:ime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Last name:</b></td>
                                    <xsl:variable name="var_lekar_prezime" select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:prezime"/>
                                    <xsl:if test="not(contains($var_lekar_prezime, '%1$s'))">
                                        <td><xsl:value-of select="$var_lekar_prezime"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_lekar_prezime, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_lekar_prezime"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:prezime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Doctor's Signature:</b></td>
                                    <xsl:variable name="var_potpis_lekara" select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:potpis_lekara"/>
                                    <xsl:if test="not(contains($var_potpis_lekara, '%1$s'))">
                                        <td><xsl:value-of select="$var_potpis_lekara"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_potpis_lekara, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_potpis_lekara"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:podaci_o_lekaru/dokumenti:potpis_lekara"/></td>-->
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
                                    <xsl:variable name="var_prescribed_medicament_id" select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:lek/@id"/>
                                    <xsl:variable name="var_prescribed_medicament_id_num" select="str:tokenize(string($var_prescribed_medicament_id),'/')[last()]"/>
                                    <xsl:variable name="var_prescribed_medicament_type" select="str:tokenize(string($var_prescribed_medicament_id),'/')[last()-1]"/>
                                    <xsl:if test="not(contains($var_prescribed_medicament_id, '%1$s'))">
                                        <td>
                                            <a href="http://localhost:8081/api/search/{$var_prescribed_medicament_type}/{$var_prescribed_medicament_id_num}">
                                                <xsl:value-of select="$var_prescribed_medicament_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_prescribed_medicament_id, '%1$s')">
                                        <td bgcolor="red">
                                            <a href="http://localhost:8081/api/search/{$var_prescribed_medicament_type}/{$var_prescribed_medicament_id_num}">
                                                <xsl:value-of select="$var_prescribed_medicament_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:lek/@id"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Name:</b></td>
                                    <xsl:variable name="var_propisani_lek_naziv" select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:naziv"/>
                                    <xsl:if test="not(contains($var_propisani_lek_naziv, '%1$s'))">
                                        <td><xsl:value-of select="$var_propisani_lek_naziv"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_propisani_lek_naziv, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_propisani_lek_naziv"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:naziv"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Code:</b></td>
                                    <xsl:variable name="var_propisani_lek_sifra" select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:sifra"/>
                                    <xsl:if test="not(contains($var_propisani_lek_sifra, '%1$s'))">
                                        <td><xsl:value-of select="$var_propisani_lek_sifra"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_propisani_lek_sifra, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_propisani_lek_sifra"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:sifra"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Date:</b></td>
                                    <xsl:variable name="var_propisani_lek_datum" select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:datum"/>
                                    <xsl:if test="not(contains($var_propisani_lek_datum, '%1$s'))">
                                        <td><xsl:value-of select="$var_propisani_lek_datum"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_propisani_lek_datum, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_propisani_lek_datum"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:propisani_lek/dokumenti:datum"/></td>-->
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
                                    <xsl:variable name="var_given_medicament_id" select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:lek/@id"/>
                                    <xsl:variable name="var_given_medicament_id_num" select="str:tokenize(string($var_given_medicament_id),'/')[last()]"/>
                                    <xsl:variable name="var_given_medicament_type" select="str:tokenize(string($var_given_medicament_id),'/')[last()-1]"/>
                                    <xsl:if test="not(contains($var_given_medicament_id, '%1$s'))">
                                        <td>
                                            <a href="http://localhost:8081/api/search/{$var_given_medicament_type}/{$var_given_medicament_id_num}">
                                                <xsl:value-of select="$var_given_medicament_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_given_medicament_id, '%1$s')">
                                        <td bgcolor="red">
                                            <a href="http://localhost:8081/api/search/{$var_given_medicament_type}/{$var_given_medicament_id_num}">
                                                <xsl:value-of select="$var_given_medicament_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:lek/@id"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Name:</b></td>
                                    <xsl:variable name="var_izdati_lek_naziv" select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:naziv"/>
                                    <xsl:if test="not(contains($var_izdati_lek_naziv, '%1$s'))">
                                        <td><xsl:value-of select="$var_izdati_lek_naziv"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_izdati_lek_naziv, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_izdati_lek_naziv"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:naziv"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Code:</b></td>
                                    <xsl:variable name="var_izdati_lek_sifra" select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:sifra"/>
                                    <xsl:if test="not(contains($var_izdati_lek_sifra, '%1$s'))">
                                        <td><xsl:value-of select="$var_izdati_lek_sifra"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_izdati_lek_sifra, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_izdati_lek_sifra"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:sifra"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Date:</b></td>
                                    <xsl:variable name="var_izdati_lek_datum" select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:datum"/>
                                    <xsl:if test="not(contains($var_izdati_lek_datum, '%1$s'))">
                                        <td><xsl:value-of select="$var_izdati_lek_datum"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_izdati_lek_datum, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_izdati_lek_datum"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:izdati_lek/dokumenti:datum"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>


                    <tr>
                        <td><b>- Diagnosis:</b></td>
                        <xsl:variable name="var_dijagnoza" select="dokumenti:lekarski_recept/dokumenti:dijagnoza"/>
                        <xsl:if test="not(contains($var_dijagnoza, '%1$s'))">
                            <td><xsl:value-of select="$var_dijagnoza"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_dijagnoza, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_dijagnoza"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:dijagnoza"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Serial Number:</b></td>
                        <xsl:variable name="var_redni_broj" select="dokumenti:lekarski_recept/dokumenti:redni_broj"/>
                        <xsl:if test="not(contains($var_redni_broj, '%1$s'))">
                            <td><xsl:value-of select="$var_redni_broj"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_redni_broj, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_redni_broj"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:redni_broj"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Quantity:</b></td>
                        <xsl:variable name="var_kolicina" select="dokumenti:lekarski_recept/dokumenti:kolicina"/>
                        <xsl:if test="not(contains($var_kolicina, '%1$s'))">
                            <td><xsl:value-of select="$var_kolicina"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_kolicina, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_kolicina"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:kolicina"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Pharmacist's Signature:</b></td>
                        <xsl:variable name="var_potpis_farmaceuta" select="dokumenti:lekarski_recept/dokumenti:potpis_farmaceuta"/>
                        <xsl:if test="not(contains($var_potpis_farmaceuta, '%1$s'))">
                            <td><xsl:value-of select="$var_potpis_farmaceuta"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_potpis_farmaceuta, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_potpis_farmaceuta"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:potpis_farmaceuta"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Medicament Received:</b></td>
                        <xsl:variable name="var_lek_primio" select="dokumenti:lekarski_recept/dokumenti:lek_primio"/>
                        <xsl:if test="not(contains($var_lek_primio, '%1$s'))">
                            <td><xsl:value-of select="$var_lek_primio"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_lek_primio, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_lek_primio"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:lek_primio"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Rp:</b></td>
                        <xsl:variable name="var_rp" select="dokumenti:lekarski_recept/dokumenti:rp"/>
                        <xsl:if test="not(contains($var_rp, '%1$s'))">
                            <td><xsl:value-of select="$var_rp"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_rp, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_rp"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:lekarski_recept/dokumenti:rp"/></td>-->
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>