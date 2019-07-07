package com.svj.zis.repository;

import com.svj.zis.model.rdf.SparqlVarNameAndValue;
import com.svj.zis.util.ExistAuthenticationUtilities;
import com.svj.zis.util.JenaAuthenticationUtilities;
import com.svj.zis.util.MetadataExtractor;
import com.svj.zis.util.SparqlUtil;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class RdfRepository {

    private final String SPARQL_NAMED_GRAPH_URI = "/com/svj/zis";

    public void extractMetadata(File xmlFile) throws Exception {
        System.out.println("[INFO] " + RdfRepository.class.getSimpleName());

        JenaAuthenticationUtilities.JenaConnectionProperties conn = JenaAuthenticationUtilities.loadProperties();

        // Referencing XML file with RDF data in attributes
        //String xmlFilePath = "data/xml/contacts.xml";

        String xmlFileName = xmlFile.getName();
        xmlFileName = xmlFileName.substring(0, xmlFileName.length()-4);
        String rdfFilePath = xmlFile.getParentFile().getParentFile().getPath() + File.separator + "rdfa"
                + File.separator + xmlFileName+".rdfa";

        // Automatic extraction of RDF triples from XML file
        MetadataExtractor metadataExtractor = new MetadataExtractor();

        System.out.println("[INFO] Extracting metadata from RDFa attributes...");
        metadataExtractor.extractMetadata(new FileInputStream(xmlFile), new FileOutputStream(new File(rdfFilePath)));


        // Loading a default model with extracted metadata
        Model model = ModelFactory.createDefaultModel();
        model.read(rdfFilePath);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Extracted metadata as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);


        // Writing the named graph
        System.out.println("[INFO] Populating named graph \"" + SPARQL_NAMED_GRAPH_URI + "\" with extracted metadata.");
        String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
        processor.execute();



        // Read the triples from the named graph
        System.out.println();
        System.out.println("[INFO] Retrieving triples from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");

        System.out.println("[INFO] Selecting the triples from the named graph \"" + SPARQL_NAMED_GRAPH_URI + "\".");
        String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);


        // Query the collection, dump output response as XML
        ResultSet results = query.execSelect();

        ResultSetFormatter.out(System.out, results);

        query.close() ;

        System.out.println("[INFO] End.");
    }

    public List<SparqlVarNameAndValue> advancedSearch(String sparqlFileString, String numberOfHealthCard, String text) throws IOException {
        JenaAuthenticationUtilities.JenaConnectionProperties conn = JenaAuthenticationUtilities.loadProperties();

        String sparqlQuery = String.format(sparqlFileString,
                conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI);

        System.out.println("Sparql Query:");
        System.out.println(sparqlQuery);

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

        // Query the SPARQL endpoint, iterate over the result set...
        System.out.println("[INFO] Showing the results for SPARQL query using the result handler.\n");
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;

        List<SparqlVarNameAndValue> uris = new ArrayList<SparqlVarNameAndValue>();

        while (results.hasNext()) {

            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();

            // Retrieve variable bindings
            while (variableBindings.hasNext()) {

                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                uris.add(new SparqlVarNameAndValue(varName, varValue.toString()));
                System.out.println(varName + ": " + varValue);

            }
            System.out.println();
        }

        query.close();

        System.out.println("[INFO] End.");

        return uris;
    }
}
