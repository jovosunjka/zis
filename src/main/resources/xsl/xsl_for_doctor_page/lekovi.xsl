<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:kolekcije="http://www.svj.com/zis/kolekcije"
    xmlns:dokumenti="http://www.svj.com/zis/dokumenti"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
		<label for="id_select_medicaments">Choose medicament:</label>
		<select id="id_select_medicaments">
			<xsl:for-each select="kolekcije:lekovi/dokumenti:lek">
                <option value="{dokumenti:sifra},{dokumenti:naziv}">
					<xsl:value-of select="@id"/>,
                    <xsl:value-of select="dokumenti:sifra"/>,
                    <xsl:value-of select="dokumenti:naziv"/>
                </option>
            </xsl:for-each>
		</select>
    </xsl:template>
    
</xsl:stylesheet>