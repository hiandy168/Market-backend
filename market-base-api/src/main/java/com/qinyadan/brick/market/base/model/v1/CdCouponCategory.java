package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdCouponCategory implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 类别类型(1-卡，2-劵)
	 */
	private Integer categoryType;

	/**
	 * 类别名称
	 */
	private String categoryName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
		if (categoryType == null) {
			return;
		}
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
		if (categoryName == null) {
			return;
		}
	}
}