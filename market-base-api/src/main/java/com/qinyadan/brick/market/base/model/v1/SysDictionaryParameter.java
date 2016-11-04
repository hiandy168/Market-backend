package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class SysDictionaryParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 232979674045146899L;
	

	/**
	 * 
	 */
	private Integer id;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getSysDictionaryId() {
		return sysDictionaryId;
	}

	public void setSysDictionaryId(Integer sysDictionaryId) {
		this.sysDictionaryId = sysDictionaryId;
		if (sysDictionaryId == null) {
			return;
		}
	}

	public String getShowValue() {
		return showValue;
	}

	public void setShowValue(String showValue) {
		this.showValue = showValue;
		if (showValue == null) {
			return;
		}
	}

	public String getRealValue() {
		return realValue;
	}

	public void setRealValue(String realValue) {
		this.realValue = realValue;
		if (realValue == null) {
			return;
		}
	}

	public Integer getSortValue() {
		return sortValue;
	}

	public void setSortValue(Integer sortValue) {
		this.sortValue = sortValue;
		if (sortValue == null) {
			return;
		}
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
		if (available == null) {
			return;
		}
	}
}