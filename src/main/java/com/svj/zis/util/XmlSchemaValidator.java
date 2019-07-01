package com.svj.zis.util;


import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;

public class XmlSchemaValidator {

    public static void validate(String xml, String path) throws Exception {
        final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        final Schema schema = factory.newSchema(new StreamSource(new FileInputStream(path)));
        final Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new StringReader(xml)));
    }
}
