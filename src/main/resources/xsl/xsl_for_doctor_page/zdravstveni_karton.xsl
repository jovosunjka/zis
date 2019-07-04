<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
                exclude-result-prefixes="xs"
                version="2.0">

    <xsl:template match="/">
        <table>
            <tr> <th colspan="2"><b>Health card:</b></th> </tr>
            <tr> <td>- Id:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/@id"/></td> </tr>
            <tr> <td>- Num Of Health Card:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/@broj_kartona"/></td> </tr>
            <tr> <td>- Num Of Health Book:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/@broj_zdrastvene_knjizice"/></td> </tr>
            <tr>
                <td>- Patient:</td>
                <td>
                    <table>
                        <!--https://itnext.io/working-with-angular-5-template-reference-variable-e5aa59fb9af-->
                        <tr> <td>- Id:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:pacijent/@id"/></td> </tr>
                        <tr> <td>- Jmbg:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/@jmbg}" id="jmbg"/></td> </tr>
                        <tr> <td>- Lbo:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/@lbo}" id="lbo"/></td> </tr>
                        <tr> <td>- First Name:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:ime}" id="firstName"/></td> </tr>
                        <tr> <td>- Last Name:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:prezime}" id="lastName"/></td> </tr>
                        <tr> <td>- Name Of One Parent:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:ime_jednog_roditelja}" id="nameOfOneParent"/></td> </tr>
                        <tr> <td>- Date Of Birth:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:datum_rodjenja}" id="dateOfBirth"/></td> </tr>
                        <tr>
                            <td>- Address:</td>
                            <td>
                                <table>
                                    <tr> <td>- Street:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:ulica}" id="street"/></td></tr>
                                    <tr> <td>- Number:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:broj}" id="number"/></td></tr>
                                    <tr> <td>- City:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:mesto}" id="city"/></td></tr>
                                    <tr> <td>- Township:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:opstina}" id="township"/></td></tr>
                                </table>
                            </td>
                        </tr>
                        <tr> <td>- Phone Number:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:telefon}" id="phoneNumber"/></td> </tr>
                        <tr> <td>- Our:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:our}" id="our"/></td> </tr>
                        <tr> <td>- Sex:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:pol}" id="sex"/></td> </tr>
                        <tr> <td>- Marital Status:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:bracno_stanje}" id="maritalStatus"/></td> </tr>
                        <tr> <td>- Reason For Exemption From Participation:</td> <td><input type="text" value="{dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:osnov_oslobadjanja_od_participacije}" id="reasonForExemptionFromParticipation"/></td> </tr>
                    </table>
                </td>
            </tr>
        </table>
    </xsl:template>

</xsl:stylesheet>