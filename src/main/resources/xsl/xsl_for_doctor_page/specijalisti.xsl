<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:osobe="http://www.svj.com/zis/osobe"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
		<label for="id_select_specialist">Choose specialist:</label>
		<select id="id_select_specialist">
			<xsl:for-each select="kolekcije:lekari/osobe:lekar">
                <option value="{@id}"> 
					<xsl:value-of select="@id"/>,
                    <xsl:value-of select="osobe:ime"/>, 
                    <xsl:value-of select="osobe:prezime"/>,
                    <xsl:value-of select="osobe:tip"/>
                </option>
            </xsl:for-each>
		</select>
    </xsl:template>
    
</xsl:stylesheet>