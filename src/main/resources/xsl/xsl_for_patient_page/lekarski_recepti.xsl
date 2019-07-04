<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
            <xsl:for-each select="kolekcije:lekarski_recepti/dokumenti:lekarski_recept">
                <br/>
                <br/>
                <table border-collapse="collapse" border="1px solid red">
                    <tr>
                        <td><b>- Id:</b></td> <td><xsl:value-of select="@id"/></td>
                    </tr>
                    <tr>
                        <td><b>- Health card:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Num. Health Card:</b></td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/@broj_zdravstvenog_kartona"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Num. Health Book:</b></td> <td><xsl:value-of select="dokumenti:zdravstveni_karton/@broj_zdrastvene_knjizice"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Insured Person:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:osigurano_lice/dokumenti:pacijent/@id"/></td>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:osigurano_lice/dokumenti:ime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:osigurano_lice/dokumenti:prezime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Date Of Birth:</b></td> <td><xsl:value-of select="dokumenti:osigurano_lice/dokumenti:datum_rodjenja"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Institution:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Name Of Health Institution:</b></td> <td><xsl:value-of select="dokumenti:ustanova/dokumenti:naziv_zdrastvene_ustanove"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Country:</b></td> <td><xsl:value-of select="dokumenti:ustanova/dokumenti:drzava"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                    <tr>
                        <td><b>- Reason For Exemption From Participation:</b></td> <td><xsl:value-of select="dokumenti:osnov_oslobadjanja_od_participacije"/></td>
                    </tr>

                    <tr>
                        <td><b>- Doctor's Information:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_lekaru/dokumenti:lekar/@id"/></td>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_lekaru/dokumenti:ime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Last name:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_lekaru/dokumenti:prezime"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Doctor's Signature:</b></td> <td><xsl:value-of select="dokumenti:podaci_o_lekaru/dokumenti:potpis_lekara"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                    <tr>
                        <td><b>- Prescribed Medicament:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:propisani_lek/dokumenti:lek/@id"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Name:</b></td> <td><xsl:value-of select="dokumenti:propisani_lek/dokumenti:naziv"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Code:</b></td> <td><xsl:value-of select="dokumenti:propisani_lek/dokumenti:sifra"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Date:</b></td> <td><xsl:value-of select="dokumenti:propisani_lek/dokumenti:datum"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                    <tr>
                        <td><b>- Given Medicament:</b></td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td> <td><xsl:value-of select="dokumenti:izdati_lek/dokumenti:lek/@id"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Name:</b></td> <td><xsl:value-of select="dokumenti:izdati_lek/dokumenti:naziv"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Code:</b></td> <td><xsl:value-of select="dokumenti:izdati_lek/dokumenti:sifra"/></td>
                                </tr>
                                <tr>
                                    <td><b>- Date:</b></td> <td><xsl:value-of select="dokumenti:izdati_lek/dokumenti:datum"/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>


                    <tr>
                        <td><b>- Diagnosis:</b></td> <td><xsl:value-of select="dokumenti:dijagnoza"/></td>
                    </tr>
                    <tr>
                        <td><b>- Serial Number:</b></td> <td><xsl:value-of select="dokumenti:redni_broj"/></td>
                    </tr>
                    <tr>
                        <td><b>- Quantity:</b></td> <td><xsl:value-of select="dokumenti:kolicina"/></td>
                    </tr>
                    <tr>
                        <td><b>- Pharmacist's Signature:</b></td> <td><xsl:value-of select="dokumenti:potpis_farmaceuta"/></td>
                    </tr>
                    <tr>
                        <td><b>- Medicament Received:</b></td> <td><xsl:value-of select="dokumenti:lek_primio"/></td>
                    </tr>
                    <tr>
                        <td><b>- Rp:</b></td> <td><xsl:value-of select="dokumenti:rp"/></td>
                    </tr>
                </table>
            </xsl:for-each>

    </xsl:template>
    
</xsl:stylesheet>