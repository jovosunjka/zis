package com.svj.zis.service;

import org.springframework.stereotype.Service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;

@Service
public class TransformationServiceImpl implements TransformationService {

    private static DocumentBuilderFactory documentFactory;

    private static TransformerFactory transformerFactory;

    static {
        /* Inicijalizacija DOM fabrike */
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);

        /* Inicijalizacija Transformer fabrike */
        transformerFactory = TransformerFactory.newInstance();

    }

    @Override
    public String generateHTML(String xml, File xslFile) throws TransformerException {
        // Initialize Transformer instance
        StreamSource transformSource = new StreamSource(xslFile);
        Transformer transformer = transformerFactory.newTransformer(transformSource);
        transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Generate XHTML
        transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

        // Transform DOM to HTML
        DOMSource source = new DOMSource(buildDocument(xml));
        StringWriter outWriter = new StringWriter();
        StreamResult result = new StreamResult( outWriter );
        transformer.transform(source, result);
        StringBuffer sb = outWriter.getBuffer();
        String finalString = sb.toString();

        return finalString;
    }

    @Override
    public String generateHTML(String xml, String xslFile) throws TransformerException {
        // Initialize Transformer instance
        InputStream xslInputStream = new ByteArrayInputStream(xslFile.getBytes());
        StreamSource transformSource = new StreamSource(xslInputStream);
        Transformer transformer = transformerFactory.newTransformer(transformSource);
        transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Generate XHTML
        transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

        // Transform DOM to HTML
        DOMSource source = new DOMSource(buildDocument(xml));
        StringWriter outWriter = new StringWriter();
        StreamResult result = new StreamResult( outWriter );
        transformer.transform(source, result);
        StringBuffer sb = outWriter.getBuffer();
        String finalString = sb.toString();

        return finalString;
    }

    public org.w3c.dom.Document buildDocument(String xml) {
        InputStream xmlInputStream = new ByteArrayInputStream(xml.getBytes());

        org.w3c.dom.Document document = null;
        try {

            DocumentBuilder builder = documentFactory.newDocumentBuilder();
            document = builder.parse(xmlInputStream);

            if (document != null)
                System.out.println("[INFO] File parsed with no errors.");
            else
                System.out.println("[WARN] Document is null.");

        } catch (Exception e) {
            return null;

        }

        return document;
    }
}
