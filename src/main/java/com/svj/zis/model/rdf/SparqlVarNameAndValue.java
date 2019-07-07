package com.svj.zis.model.rdf;

public class SparqlVarNameAndValue {

    private String varName;
    private String value;

    public SparqlVarNameAndValue() {

    }

    public SparqlVarNameAndValue(String varName, String value) {
        this.varName = varName;
        this.value = value;
    }


    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
