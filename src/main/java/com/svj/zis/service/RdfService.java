package com.svj.zis.service;

import com.svj.zis.model.rdf.SparqlVarNameAndValue;

import java.io.IOException;
import java.util.List;

public interface RdfService {

    List<SparqlVarNameAndValue> advancedSearch(String idOfHealthCard, String text) throws IOException;
}
