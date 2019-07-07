package com.svj.zis.service;

import com.svj.zis.repository.RdfRepository;
import com.svj.zis.repository.SearchRdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceIml implements SearchService {

    @Autowired
    private SearchRdfRepository searchRdfRepository;

    @Autowired
    private RdfRepository rdfRepository;


    @Override
    public String getResource(String id) {
        return null;
    }
}
