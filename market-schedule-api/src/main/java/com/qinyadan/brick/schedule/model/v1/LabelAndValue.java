package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class LabelAndValue implements Serializable{
	
    private String label;
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
