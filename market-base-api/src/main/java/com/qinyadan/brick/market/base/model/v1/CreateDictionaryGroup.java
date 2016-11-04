package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CreateDictionaryGroup implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1464450022346430644L;

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
}
