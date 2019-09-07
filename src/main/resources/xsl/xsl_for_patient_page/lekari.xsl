<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:osobe="http://www.svj.com/zis/osobe"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
		<label for="id_select_doctor">Choose doctor:</label>
		<select id="id_select_doctor">
			<xsl:for-each select="kolekcije:lekari/osobe:lekar">
                <option value="{@id}"> 
					<xsl:value-of select="@id"/>,
                    <xsl:value-of select="osobe:ime"/>, 
                    <xsl:value-of select="osobe:prezime"/>
                </option>
            </xsl:for-each>
		</select>
        <!--
		<table border="2">
            <tr> <th><b>Id</b></th> <th><b>First Name</b></th> <th><b>Last Name</b></th> </tr>
            <xsl:for-each select="kolekcije:lekari/osobe:lekar">
                <xsl:variable name="var_lekar_id" select="@id"/>
                <xsl:variable name="var_lekar_id_num" select="str:tokenize(string($var_lekar_id),'/')[last()]"/>
                <xsl:variable name="var_lekar_type" select="str:tokenize(string($var_lekar_id),'/')[last()-1]"/>
                <tr> 
                    <td><a href="http://localhost:8081/api/search/{$var_lekar_type}/{$var_lekar_id_num}">
                        <xsl:value-of select="$var_lekar_id"/>
                    </a></td>
                    <td><xsl:value-of select="osobe:ime"/></td> 
                    <td><xsl:value-of select="osobe:prezime"/></td>
                </tr>
            </xsl:for-each>
        </table>
		-->
    </xsl:template>
    
</xsl:stylesheet>