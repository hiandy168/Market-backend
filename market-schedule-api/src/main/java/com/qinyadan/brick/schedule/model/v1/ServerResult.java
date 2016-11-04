package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;
import java.util.List;


public class ServerResult implements Serializable{
    private List<LabelAndValue> list;

    public List<LabelAndValue> getList() {
        return list;
    }

    public void setList(List<LabelAndValue> list) {
        this.list = list;
    }
}
