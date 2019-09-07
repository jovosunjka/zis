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
                    <tr><th colspan="2"><b>Report:</b></th></tr>
                    <tr>
                        <td><b>- Id:</b></td>
                        <xsl:variable name="var_id" select="dokumenti:izvestaj/@id"/>
                        <xsl:if test="not(contains($var_id, '%1$s'))">
                            <td><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_id, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_id"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:izvestaj/@id"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Mark:</b></td>
                        <xsl:variable name="var_oznaka" select="dokumenti:izvestaj/@oznaka"/>
                        <xsl:if test="not(contains($var_oznaka, '%1$s'))">
                            <td><xsl:value-of select="$var_oznaka"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_oznaka, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_oznaka"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:izvestaj/@oznaka"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Diagnosis:</b></td>
                        <xsl:variable name="var_oznaka" select="dokumenti:izvestaj/dokumenti:dijagnoza"/>
                        <xsl:if test="not(contains($var_oznaka, '%1$s'))">
                            <td><xsl:value-of select="$var_oznaka"/></td>
                        </xsl:if>
                        <xsl:if test="contains($var_oznaka, '%1$s')">
                            <td bgcolor="red"><xsl:value-of select="$var_oznaka"/></td>
                        </xsl:if>
                        <!--<td><xsl:value-of select="dokumenti:izvestaj/dokumenti:dijagnoza"/></td>-->
                    </tr>
                    <tr>
                        <td><b>- Anamnesis:</b></td><td><xsl:apply-templates select="dokumenti:izvestaj/dokumenti:anamneza"/></td> <!--https://stackoverflow.com/questions/1525285/xslt-mixed-content-node-->
                    </tr>
                    <tr>
                        <td><b>- Therapy:</b></td><td><xsl:apply-templates select="dokumenti:izvestaj/dokumenti:terapija"/></td> <!--https://stackoverflow.com/questions/1525285/xslt-mixed-content-node-->
                    </tr>
                    <tr>
                        <td>- Patient:</td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <xsl:variable name="var_patient_id" select="dokumenti:izvestaj/dokumenti:osigurano_lice/@id"/>
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
                                        <td bgcolor="red">
                                            <a href="http://localhost:8081/api/search/{$var_patient_type}/{$var_patient_id_num}">
                                                <xsl:value-of select="$var_patient_id"/>
                                                <!--<xsl:apply-templates />-->
                                            </a>
                                        </td>
                                    </xsl:if>
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td>
                                    <xsl:variable name="var_patient_first_name" select="dokumenti:izvestaj/dokumenti:osigurano_lice/dokumenti:ime"/>
                                    <xsl:if test="not(contains($var_patient_first_name, '%1$s'))">
                                        <td><xsl:value-of select="$var_patient_first_name"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_patient_first_name, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_patient_first_name"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:izvestaj/dokumenti:osigurano_lice/dokumenti:ime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td>
                                    <xsl:variable name="var_patient_last_name" select="dokumenti:izvestaj/dokumenti:osigurano_lice/dokumenti:prezime"/>
                                    <xsl:if test="not(contains($var_patient_last_name, '%1$s'))">
                                        <td><xsl:value-of select="$var_patient_last_name"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_patient_last_name, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_patient_last_name"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:izvestaj/dokumenti:osigurano_lice/dokumenti:prezime"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>- Doctor:</td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <xsl:variable name="var_doctor_id" select="dokumenti:izvestaj/dokumenti:lekar/@id"/>
                                    <xsl:variable name="var_doctor_id_num" select="str:tokenize(string(dokumenti:izvestaj/dokumenti:lekar/@id),'/')[last()]"/>
                                    <xsl:variable name="var_doctor_type" select="str:tokenize(string(dokumenti:izvestaj/dokumenti:lekar/@id),'/')[last()-1]"/>
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
                                </tr>
                                <tr>
                                    <td><b>- First Name:</b></td>
                                    <xsl:variable name="var_doctor_first_name" select="dokumenti:izvestaj/dokumenti:lekar/dokumenti:ime"/>
                                    <xsl:if test="not(contains($var_doctor_first_name, '%1$s'))">
                                        <td><xsl:value-of select="$var_doctor_first_name"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_doctor_first_name, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_doctor_first_name"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:izvestaj/dokumenti:lekar/dokumenti:ime"/></td>-->
                                </tr>
                                <tr>
                                    <td><b>- Last Name:</b></td>
                                    <xsl:variable name="var_doctor_last_name" select="dokumenti:izvestaj/dokumenti:lekar/dokumenti:prezime"/>
                                    <xsl:if test="not(contains($var_doctor_last_name, '%1$s'))">
                                        <td><xsl:value-of select="$var_doctor_last_name"/></td>
                                    </xsl:if>
                                    <xsl:if test="contains($var_doctor_last_name, '%1$s')">
                                        <td bgcolor="red"><xsl:value-of select="$var_doctor_last_name"/></td>
                                    </xsl:if>
                                    <!--<td><xsl:value-of select="dokumenti:izvestaj/dokumenti:lekar/dokumenti:prezime"/></td>-->
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><b>- Date:</b></td><td><xsl:value-of select="dokumenti:izvestaj/dokumenti:datum"/></td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="dokumenti:anamneza">
        <p>
            <xsl:apply-templates />
        </p>
    </xsl:template>

    <xsl:template match="dokumenti:terapija">
        <p>
            <xsl:apply-templates />
        </p>
    </xsl:template>

    <xsl:template match="dokumenti:anamneza//text()">
        <xsl:variable name="var_txt1" select="."/>
        <xsl:if test="not(contains($var_txt1, '%1$s'))">
            <span><xsl:copy-of select="$var_txt1" /></span>
        </xsl:if>
        <xsl:if test="contains($var_txt1, '%1$s')">
            <span bgcolor="red"><xsl:copy-of select="$var_txt1" /></span><span><xsl:copy-of select="$var_txt1" /></span>
        </xsl:if>
    </xsl:template>
    <xsl:template match="dokumenti:terapija//text()">
        <xsl:variable name="var_txt2" select="."/>
        <xsl:if test="not(contains($var_txt2, '%1$s'))">
            <span><xsl:copy-of select="$var_txt2" /></span>
        </xsl:if>
        <xsl:if test="contains($var_txt2, '%1$s')">
            <span bgcolor="red"><xsl:copy-of select="$var_txt2" /></span><span><xsl:copy-of select="$var_txt2" /></span>
        </xsl:if>
    </xsl:template>

    <xsl:template match="dokumenti:anamneza//dokumenti:link">
        <xsl:variable name="var_id_num" select="str:tokenize(string(@href),'/')[last()]"/>
        <xsl:variable name="var_type" select="str:tokenize(string(@href),'/')[last()-1]"/>
        <a href="http://localhost:8081/api/search/{$var_type}/{$var_id_num}">
            <xsl:value-of select="@href"/>
            <!--<xsl:apply-templates />-->
        </a>
    </xsl:template>

    <xsl:template match="dokumenti:terapija//dokumenti:link">
        <xsl:variable name="var_id_num" select="str:tokenize(string(@href),'/')[last()]"/>
        <xsl:variable name="var_type" select="str:tokenize(string(@href),'/')[last()-1]"/>
        <a href="http://localhost:8081/api/search/{$var_type}/{$var_id_num}">
            <xsl:value-of select="@href"/>
            <!--<xsl:apply-templates />-->
        </a>
    </xsl:template>

</xsl:stylesheet>