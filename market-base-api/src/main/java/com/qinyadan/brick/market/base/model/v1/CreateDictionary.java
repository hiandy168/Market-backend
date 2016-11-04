package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;


public class CreateDictionary implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5821428931263305000L;

	/**
     * 字典
     */
    private Integer sysDictionaryId;

    /**
     * 显示值
     */
    private String showValue;

    /**
     * 实际值
     */
    private String realValue;

    /**
     * 排位
     */
    private Integer sortValue;

    /**
     * 0-禁用，1-启用
     */
    private Integer available;

    public Integer getSysDictionaryId() {
        return sysDictionaryId;
    }

    public void setSysDictionaryId(Integer sysDictionaryId) {
        this.sysDictionaryId = sysDictionaryId;
    }

    public String getShowValue() {
        return showValue;
    }

    public void setShowValue(String showValue) {
        this.showValue = showValue;
    }

    public String getRealValue() {
        return realValue;
    }

    public void setRealValue(String realValue) {
        this.realValue = realValue;
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
