package com.svj.zis.service;

import com.svj.zis.model.rdf.SparqlVarNameAndValue;
import com.svj.zis.repository.RdfRepository;
import com.svj.zis.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RdfServiceImpl implements RdfService {

    @Autowired
    private RdfRepository rdfRepository;

    private ResourceRepository resourceRepository;
    private ClassPathResource advancedSearchSparqlResource = new ClassPathResource("sparql/patient_advanced_search.rq");


    @Override
    public List<SparqlVarNameAndValue> advancedSearch(String numberOfHealthCard, String text) throws IOException {
        String sparqlFileString = resourceRepository.loadFileContent(advancedSearchSparqlResource.getFile().getPath());
        return rdfRepository.advancedSearch(sparqlFileString, numberOfHealthCard, text);
    }
}
