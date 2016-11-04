package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdCategory implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 类别名称
	 */
	private String categoryName;

	/**
	 * 上级类别
	 */
	private Integer parentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
		if (parentId == null) {
			return;
		}
	}
}