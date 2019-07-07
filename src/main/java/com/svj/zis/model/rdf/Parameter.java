package com.svj.zis.model.rdf;

public class Parameter {
    private String attribute;
    private String value;
    private String operator;

    public Parameter() {

    }

    public Parameter(String attribute, String value, String operator) {
        this.attribute = attribute;
        this.value = value;
        this.operator = operator;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
