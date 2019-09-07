<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:str="http://exslt.org/strings"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
        <table id="id_table_reviews" border="2">
            <tr> <th><b>Id</b></th> <th><b>First Name</b></th> <th><b>Last Name</b></th> <th><b>Date</b></th> <th><b>Time</b></th> </tr>
            <xsl:for-each select="kolekcije:pregledi/dokumenti:pregled">
				<xsl:variable name="var_date_and_time" select="dokumenti:datum_i_vreme"/>
				<xsl:variable name="var_date" select="str:tokenize(string($var_date_and_time),'T')[1]"/>
				<xsl:variable name="var_time" select="str:tokenize(string($var_date_and_time),'T')[2]"/>
				<xsl:variable name="var_time_length" select="string-length($var_time)" />
				<xsl:variable name="var_first_name" select="dokumenti:pacijent/dokumenti:ime"/>
				<xsl:variable name="var_last_name" select="dokumenti:pacijent/dokumenti:prezime"/>
				<xsl:variable name="var_time_tokens" select="str:tokenize($var_time,':')"/>

                <tr>
                    <td class="reviewId"><xsl:value-of select="@id"/> </td>
					
					<xsl:if test="$var_first_name = ''">
						<td>Unknown</td>
					</xsl:if>
					<xsl:if test="$var_first_name != ''">
						<td><xsl:value-of select="$var_first_name"/></td>
					</xsl:if>
					
					<xsl:if test="$var_last_name = ''">
						<td>Unknown</td>
					</xsl:if>
					<xsl:if test="$var_last_name != ''">
						<td><xsl:value-of select="$var_last_name"/></td>
					</xsl:if>
                    
                    <td><input type="date" value="{$var_date}"/></td>

					<xsl:if test="$var_time_length = 5">
						<td><input type="time" value="{$var_time}"/></td>
					</xsl:if>
					<xsl:if test="$var_time_length = 8">
						<td><input type="time" value="{$var_time_tokens[1]}:{$var_time_tokens[2]}"/></td>
					</xsl:if>
					<xsl:if test="$var_time_length != 5 and $var_time_length != 8">
						<td>Invalid date and time</td>
					</xsl:if>

					<!--<td><button class="btn btn-danger" onclick="this.parentNode.parentNode.remove()"></button></td>-->
                </tr>
            </xsl:for-each>

        </table>
    </xsl:template>
    
</xsl:stylesheet>