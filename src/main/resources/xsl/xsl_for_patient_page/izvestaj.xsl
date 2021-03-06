<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:str="http://exslt.org/strings"
                xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
                exclude-result-prefixes="xs"
                version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <script>
                    function getDateTimeStr() {
                        var today = new Date();
                        var date = today.getDate() + '.' + (today.getMonth() + 1 ) + '.' + today.getFullYear();
                        var time = today.getHours() + ';' + today.getMinutes() + ';' + today.getSeconds();
                        var dateTime = date + '-' + time;
                        return dateTime;
                    }

                    function downloadHtml(htmlText) {
                        var element = document.createElement('a');
                        element.setAttribute('href', 'data:text/html;charset=utf-8,' + encodeURIComponent(htmlText));
                        var dateTimeStr = getDateTimeStr();
                        element.setAttribute('download', 'Report_' + dateTimeStr + '.html');

                        element.style.display = 'none';
                        document.body.appendChild(element);

                        element.click();

                        document.body.removeChild(element);
                    }

                    function downloadPdf(pdf) {
                        var element = document.createElement('a');
                        element.setAttribute('href', 'data:application/pdf;charset=utf-8,' + encodeURIComponent(pdf));
                        var dateTimeStr = getDateTimeStr();
                        element.setAttribute('download', 'Report_' + dateTimeStr + '.pdf');

                        element.style.display = 'none';
                        document.body.appendChild(element);

                        element.click();

                        document.body.removeChild(element);
                    }


                    function httpGetAsync(url) {
                        var xmlHttp = new XMLHttpRequest();
                        xmlHttp.onreadystatechange = function() {
                            if (xmlHttp.readyState == 4) {
                                if (xmlHttp.status == 200) {
                                    if (url.indexOf('pdf') != -1) {
                                        downloadPdf(xmlHttp.responseText);
                                    } else {
                                        downloadHtml(xmlHttp.responseText)
                                    }

                                }
                            }
                        };
                        xmlHttp.open('GET', url, true);
                        xmlHttp.send(null);
                    }
                </script>
            </head>
            <body bgcolor="black">
                <tabel>
                    <tr>
                        <td>
                            <button onclick="httpGetAsync(window.location.href)">Download HTML</button>
                        </td>
                        <td>
                            <button onclick="httpGetAsync(window.location.href+'/pdf')">Download PDF</button>
                        </td>
                    </tr>
                </tabel>

                <table bgcolor="yellow">
                    <tr><th colspan="2"><b>Report:</b></th></tr>
                    <tr>
                        <td><b>- Id:</b></td><td><xsl:value-of select="dokumenti:izvestaj/@id"/></td>
                    </tr>
                    <tr>
                        <td><b>- Mark:</b></td><td><xsl:value-of select="dokumenti:izvestaj/@oznaka"/></td>
                    </tr>
                    <tr>
                        <td><b>- Diagnosis:</b></td><td><xsl:value-of select="dokumenti:izvestaj/dokumenti:dijagnoza"/></td>
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
                                    <td>
                                        <xsl:variable name="var_patient_id_num" select="str:tokenize(string(dokumenti:izvestaj/dokumenti:osigurano_lice/@id),'/')[last()]"/>
                                        <xsl:variable name="var_patient_type" select="str:tokenize(string(dokumenti:izvestaj/dokumenti:osigurano_lice/@id),'/')[last()-1]"/>
                                        <a href="http://localhost:8081/api/search/{$var_patient_type}/{$var_patient_id_num}">
                                            <xsl:value-of select="dokumenti:izvestaj/dokumenti:osigurano_lice/@id"/>
                                            <!--<xsl:apply-templates />-->
                                        </a>
                                    <!--<td><xsl:value-of select="dokumenti:izvestaj/dokumenti:osigurano_lice/@id"/></td>-->
                                    </td>
                                </tr>
                                <tr> <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:osigurano_lice/dokumenti:ime"/></td> </tr>
                                <tr> <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:osigurano_lice/dokumenti:prezime"/></td> </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>- Doctor:</td>
                        <td>
                            <table>
                                <tr>
                                    <td><b>- Id:</b></td>
                                    <td>
                                        <xsl:variable name="var_doctor_id_num" select="str:tokenize(string(dokumenti:izvestaj/dokumenti:lekar/@id),'/')[last()]"/>
                                        <xsl:variable name="var_doctor_type" select="str:tokenize(string(dokumenti:izvestaj/dokumenti:lekar/@id),'/')[last()-1]"/>
                                        <a href="http://localhost:8081/api/search/{$var_doctor_type}/{$var_doctor_id_num}">
                                            <xsl:value-of select="dokumenti:izvestaj/dokumenti:lekar/@id"/>
                                            <!--<xsl:apply-templates />-->
                                        </a>
                                        <!--<td><xsl:value-of select="dokumenti:izvestaj/dokumenti:lekar/@id"/></td>-->
                                    </td>
                                </tr>
                                <tr> <td><b>- First Name:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:lekar/dokumenti:ime"/></td> </tr>
                                <tr> <td><b>- Last Name:</b></td> <td><xsl:value-of select="dokumenti:izvestaj/dokumenti:lekar/dokumenti:prezime"/></td> </tr>
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
        <xsl:copy-of select="." />
    </xsl:template>
    <xsl:template match="dokumenti:terapija//text()">
        <xsl:copy-of select="." />
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