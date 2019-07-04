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
                        <tr> <td>- Id:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:pacijent/@id"/></td> </tr>
                        <tr> <td>- Jmbg:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/@jmbg"/></td> </tr>
                        <tr> <td>- Lbo:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/@lbo"/></td> </tr>
                        <tr> <td>- First Name:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:ime"/></td> </tr>
                        <tr> <td>- Last Name:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:prezime"/></td> </tr>
                        <tr> <td>- Name Of One Parent:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:ime_jednog_roditelja"/></td> </tr>
                        <tr> <td>- Date Of Birth:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:datum_rodjenja"/></td> </tr>
                        <tr>
                            <td>- Address:</td>
                            <td>
                                <table>
                                    <tr> <td>- Street:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:ulica"/></td></tr>
                                    <tr> <td>- Number:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:broj"/></td></tr>
                                    <tr> <td>- City:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:mesto"/></td></tr>
                                    <tr> <td>- Township:</td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:opstina"/></td></tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </xsl:template>

</xsl:stylesheet>