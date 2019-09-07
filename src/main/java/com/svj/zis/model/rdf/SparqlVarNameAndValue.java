package com.svj.zis.model.rdf;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SparqlVarNameAndValue that = (SparqlVarNameAndValue) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
