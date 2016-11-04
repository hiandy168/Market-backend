package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class SysOrganization implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6164075926024924645L;
	

	/**
	 * 物理主键
	 */
	private Integer id;

	/**
	 * 组织名称
	 */
	private String name;

	/**
	 * 
	 */
	private String description;

	/**
	 * 
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		if (name == null) {
			return;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		if (description == null) {
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