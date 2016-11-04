package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;


public class DictionaryGroup implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6447594753238015568L;
	/**
     * 物理主键
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

    /**
     * 启用状态描述
     */
    private String availableDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }

    public String getDictionaryDesc() {
        return dictionaryDesc;
    }

    public void setDictionaryDesc(String dictionaryDesc) {
        this.dictionaryDesc = dictionaryDesc;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getAvailableDesc() {
        return availableDesc;
    }

    public void setAvailableDesc(String availableDesc) {
        this.availableDesc = availableDesc;
    }
}
