package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class SysDictionary implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -3222674701040861330L;

	/**
     * 
     */
    private Integer id;

    /**
     * 字典编号
     */
    private String dictionaryCode;

    /**
     * 字典描述
     */
    private String dictionaryDesc;

    /**
     * 是否启用
     */
    private Integer available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if(id == null){
              return;
        }
    }

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
        if(dictionaryCode == null){
              return;
        }
    }

    public String getDictionaryDesc() {
        return dictionaryDesc;
    }

    public void setDictionaryDesc(String dictionaryDesc) {
        this.dictionaryDesc = dictionaryDesc;
        if(dictionaryDesc == null){
              return;
        }
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
        if(available == null){
              return;
        }
    }
}