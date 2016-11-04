package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdManagerCompany implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 单位
     */
    private Integer cdCompanyId;

    /**
     * 客户经理
     */
    private Integer cdManagerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if(id == null){
              return;
        }
    }

    public Integer getCdCompanyId() {
        return cdCompanyId;
    }

    public void setCdCompanyId(Integer cdCompanyId) {
        this.cdCompanyId = cdCompanyId;
        if(cdCompanyId == null){
              return;
        }
    }

    public Integer getCdManagerId() {
        return cdManagerId;
    }

    public void setCdManagerId(Integer cdManagerId) {
        this.cdManagerId = cdManagerId;
        if(cdManagerId == null){
              return;
        }
    }
}