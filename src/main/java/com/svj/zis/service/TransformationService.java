package com.svj.zis.service;

import javax.xml.transform.TransformerException;
import java.io.File;

public interface TransformationService {
    String generateHTML(String xml, File xslFile) throws TransformerException;

    String generateHTML(String xml, String xslFile) throws TransformerException;
}
