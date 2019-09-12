package com.svj.zis.xml2pdf.xslfo;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.core.io.ClassPathResource;
import org.xml.sax.SAXException;

import net.sf.saxon.TransformerFactoryImpl;

/**
 * 
 * Primer demonstrira koriscenje Apache FOP programskog API-a za 
 * renderovanje PDF-a primenom XSL-FO transformacije na XML dokumentu.
 *
 */
public class XSLFOTransformer {
	
	private FopFactory fopFactory;
	
	private TransformerFactory transformerFactory;

	private static DocumentBuilderFactory documentFactory;

	static {
		/* Inicijalizacija DOM fabrike */
		documentFactory = DocumentBuilderFactory.newInstance();
		documentFactory.setNamespaceAware(true);
		documentFactory.setIgnoringComments(true);
		documentFactory.setIgnoringElementContentWhitespace(true);

	}

	public static final String INPUT_FILE = "data/xsl-fo/bookstore.xml";
	
	public static final String XSL_FILE = "data/xsl-fo/bookstore_fo.xsl";
	
	public static final String OUTPUT_FILE = "bookstore.pdf";

	private ClassPathResource fop = new ClassPathResource("fop.xconf");
	private static ClassPathResource xmlResource = new ClassPathResource("xml/izvestaji.xml");
	private static ClassPathResource xslResoure = new ClassPathResource("xsl/xsl_for_patient_page/lek.xsl");
	
	
	public XSLFOTransformer() throws SAXException, IOException {
		
		// Initialize FOP factory object
		fopFactory = FopFactory.newInstance(fop.getFile());
		
		// Setup the XSLT transformer factory
		transformerFactory = new TransformerFactoryImpl();
	}

	private void generatePDF(String xml /*File xmlFile*/, File xslFile) throws Exception {

		System.out.println("[INFO] " + XSLFOTransformer.class.getSimpleName());
		
		// Point to the XSL-FO file
		// File xslFile = new File(XSL_FILE);

		// Create transformation source
		StreamSource transformSource = new StreamSource(xslFile);
		
		// Initialize the transformation subject
		//StreamSource source = new StreamSource(new File(INPUT_FILE));
		//StreamSource source = new StreamSource(xmlFile);
		DOMSource source = new DOMSource(buildDocument(xml));

		// Initialize user agent needed for the transformation
		FOUserAgent userAgent = fopFactory.newFOUserAgent();
		
		// Create the output stream to store the results
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		// Initialize the XSL-FO transformer object
		Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);
		
		// Construct FOP instance with desired output format
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);

		// Resulting SAX events 
		Result res = new SAXResult(fop.getDefaultHandler());

		// Start XSLT transformation and FOP processing
		xslFoTransformer.transform(source, res);

		// Generate PDF file
		File pdfFile = new File(OUTPUT_FILE);
		if (!pdfFile.getParentFile().exists()) {
			System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
			pdfFile.getParentFile().mkdir();
		}
		
		OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfFile));
		out.write(outStream.toByteArray());

		System.out.println("[INFO] File \"" + pdfFile.getCanonicalPath() + "\" generated successfully.");
		out.close();
		
		System.out.println("[INFO] End.");

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


	public static void main(String[] args) throws Exception {
		new XSLFOTransformer().generatePDF(/*xmlResource.getFile()*/ "<?xml-stylesheet type=\"text/xsl\" href=\"src/main/resources/xsl/xsl_for_patient_page/recepti.xsl\"?>" +
				"<dokumenti:lek xmlns:dokumenti=\"http://www.svj.com/zis/dokumenti\" id=\"http://www.svj.com/zis/dokumenti/lek/2\" aktivan=\"true\" about=\"http://www.svj.com/zis/dokumenti/lek/1\">\n" +
				"        <dokumenti:naziv datatype=\"xs:string\" property=\"pred:nazivLeka\">ACTAPAX</dokumenti:naziv>\n" +
				"        <dokumenti:sifra datatype=\"xs:string\" property=\"pred:sifraLeka\">1072915</dokumenti:sifra>\n" +
				"        <dokumenti:dijagnoza datatype=\"xs:string\" property=\"pred:lekDijagnoza\">F411</dokumenti:dijagnoza>\n" +
				"        <dokumenti:namena datatype=\"xs:string\" property=\"pred:lekNamena\">Anksiozni generalizovani poremećaj</dokumenti:namena>\n" +
				"    </dokumenti:lek>", xslResoure.getFile());
	}

}
