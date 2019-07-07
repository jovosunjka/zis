package com.svj.zis.util.mapper;


//import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;


// https://dzone.com/articles/jaxb-and-namespace-prefixes


/**
 * Ovaj mapper ce nam srediti da prefiksi u xml fajlovima koje cuvamo u exist-db, budu bas onakvi kakve mi zelimo (tj. isti ko
 * u fajlovima koji se nalaze u /resources/xml), a ne da exist-db dodeljuje neke svoje (npr. ns2)
 * */
public class KolekcijeOsobeDokumentiNamespaceMapper extends NamespacePrefixMapper {

    private static final String KOLEKCIJE_PREFIX = "kolekcije";
    private static final String KOLEKCIJE_URI = "http://www.svj.com/zis/kolekcije";

    private static final String OSOBE_PREFIX = "osobe";
    private static final String OSOBE_URI = "http://www.svj.com/zis/osobe";

    private static final String DOKUMENTI_PREFIX = "dokumenti";
    private static final String DOKUMENTI_URI = "http://www.svj.com/zis/dokumenti";

    private static final String XMLSchema_PREFIX = "xs";
    private static final String XMLSchema_URI = "http://www.w3.org/2001/XMLSchema#";

    private static final String PREDICATE_PREFIX = "pred";
    private static final String PREDICATE_URI = "http://www.svj.com/zis/predicate/";

    private static final String RDFA_PREFIX = ""; // DEFAULT NAMESPACE
    private static final String RDFA_URI = "http://www.w3.org/ns/rdfa#";


    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if(RDFA_URI.equals(namespaceUri)) {
            return RDFA_PREFIX;
        }
        else if(PREDICATE_URI.equals(namespaceUri)) {
            return PREDICATE_PREFIX;
        }
        else if(XMLSchema_URI.equals(namespaceUri)) {
            return XMLSchema_PREFIX;
        }
        else if(KOLEKCIJE_URI.equals(namespaceUri)) {
            return KOLEKCIJE_PREFIX;
        }
        else if(OSOBE_URI.equals(namespaceUri)) {
            return OSOBE_PREFIX;
        }
        else if(DOKUMENTI_URI.equals(namespaceUri)) {
            return DOKUMENTI_PREFIX;
        }
        return suggestion;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris() {
        return new String[] {RDFA_URI, PREDICATE_URI, XMLSchema_URI, KOLEKCIJE_URI, OSOBE_URI, DOKUMENTI_URI };
    }

}
