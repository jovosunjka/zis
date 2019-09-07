<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
                exclude-result-prefixes="xs"
                version="2.0">

    <xsl:template match="/">
        <html>
            <body bgcolor="black">
                <table bgcolor="yellow">
                    <tr> <th colspan="2"><b>Patient:</b></th> </tr>
                    <tr>
                        <td>- Id:</td>
                        <xsl:variable name="var_patient_id" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:pacijent/@id"/>
                        <xsl:if test="not(contains($var_patient_id, '%1$s'))">
                            <td><xsl:value-of select="$var_patient_id"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_patient_id, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_patient_id"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:pacijent/@id"/></td>-->
                    </tr>
                    <tr>
                        <td>- Jmbg:</td>
                        <xsl:variable name="var_jmbg" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/@jmbg"/>
                        <xsl:if test="not(contains($var_jmbg, '%1$s'))">
                            <td><xsl:value-of select="$var_jmbg"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_jmbg, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_jmbg"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/@jmbg"/></td>-->
                    </tr>
                    <tr>
                        <td>- Lbo:</td>
                        <xsl:variable name="var_lbo" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/@lbo"/>
                        <xsl:if test="not(contains($var_lbo, '%1$s'))">
                            <td><xsl:value-of select="$var_lbo"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_lbo, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_lbo"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/@lbo"/></td>-->
                    </tr>
                    <tr>
                        <td>- First Name:</td>
                        <xsl:variable name="var_ime" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:ime"/>
                        <xsl:if test="not(contains($var_ime, '%1$s'))">
                            <td><xsl:value-of select="$var_ime"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_ime, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_ime"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:ime"/></td>-->
                    </tr>
                    <tr>
                        <td>- Last Name:</td>
                        <xsl:variable name="var_prezime" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:prezime"/>
                        <xsl:if test="not(contains($var_prezime, '%1$s'))">
                            <td><xsl:value-of select="$var_prezime"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_prezime, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_prezime"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:prezime"/></td>-->
                    </tr>
                    <tr>
                        <td>- Name Of One Parent:</td>
                        <xsl:variable name="var_ime_jednog_roditelja" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:ime_jednog_roditelja"/>
                        <xsl:if test="not(contains($var_ime_jednog_roditelja, '%1$s'))">
                            <td><xsl:value-of select="$var_ime_jednog_roditelja"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_ime_jednog_roditelja, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_ime_jednog_roditelja"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:ime_jednog_roditelja"/></td>-->
                    </tr>
                    <tr>
                        <td>- Date Of Birth:</td>
                        <xsl:variable name="var_datum_rodjenja" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:datum_rodjenja"/>
                        <xsl:if test="not(contains($var_datum_rodjenja, '%1$s'))">
                            <td><xsl:value-of select="$var_datum_rodjenja"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_datum_rodjenja, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_datum_rodjenja"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:datum_rodjenja"/></td>-->
                    </tr>
                    <tr>
                        <td>- Address:</td>
                        <td>
                            <table>
                                <tr>
                                    <td>- Street:</td>
                                    <xsl:variable name="var_ulica" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:ulica"/>
                                    <xsl:if test="not(contains($var_ulica, '%1$s'))">
                                        <td><xsl:value-of select="$var_ulica"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_ulica, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_ulica"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:ulica"/></td>-->
                                </tr>
                                <tr>
                                    <td>- Number:</td>
                                    <xsl:variable name="var_broj" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:broj"/>
                                    <xsl:if test="not(contains($var_broj, '%1$s'))">
                                        <td><xsl:value-of select="$var_broj"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_broj, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_broj"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:broj"/></td>-->
                                </tr>
                                <tr>
                                    <td>- City:</td>
                                    <xsl:variable name="var_mesto" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:mesto"/>
                                    <xsl:if test="not(contains($var_mesto, '%1$s'))">
                                        <td><xsl:value-of select="$var_mesto"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_mesto, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_mesto"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:mesto"/></td>-->
                                </tr>
                                <tr>
                                    <td>- Township:</td>
                                    <xsl:variable name="var_opstina" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:opstina"/>
                                    <xsl:if test="not(contains($var_opstina, '%1$s'))">
                                        <td><xsl:value-of select="$var_opstina"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_opstina, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_opstina"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:opstina"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>- Phone Number:</td>
                        <xsl:variable name="var_telefon" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:telefon"/>
                        <xsl:if test="not(contains($var_telefon, '%1$s'))">
                            <td><xsl:value-of select="$var_telefon"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_telefon, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_telefon"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:telefon"/></td>-->
                    </tr>
                    <tr>
                        <td>- Our:</td>
                        <xsl:variable name="var_our" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:our"/>
                        <xsl:if test="not(contains($var_our, '%1$s'))">
                            <td><xsl:value-of select="$var_our"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_our, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_our"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:our"/></td>-->
                    </tr>
                    <tr>
                        <td>- Sex:</td>
                        <xsl:variable name="var_pol" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:pol"/>
                        <xsl:if test="not(contains($var_pol, '%1$s'))">
                            <td><xsl:value-of select="$var_pol"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_pol, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_pol"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:pol"/></td>-->
                    </tr>
                    <tr>
                        <td>- Marital Status:</td>
                        <xsl:variable name="var_bracno_stanje" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:bracno_stanje"/>
                        <xsl:if test="not(contains($var_bracno_stanje, '%1$s'))">
                            <td><xsl:value-of select="$var_bracno_stanje"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_bracno_stanje, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_bracno_stanje"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:bracno_stanje"/></td>-->
                    </tr>
                    <tr>
                        <td>- Reason For Exemption From Participation:</td>
                        <xsl:variable name="var_osnov_oslobadjanja_od_participacije" select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:osnov_oslobadjanja_od_participacije"/>
                        <xsl:if test="not(contains($var_osnov_oslobadjanja_od_participacije, '%1$s'))">
                            <td><xsl:value-of select="$var_osnov_oslobadjanja_od_participacije"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_osnov_oslobadjanja_od_participacije, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_osnov_oslobadjanja_od_participacije"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:osnov_oslobadjanja_od_participacije"/></td>-->
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>