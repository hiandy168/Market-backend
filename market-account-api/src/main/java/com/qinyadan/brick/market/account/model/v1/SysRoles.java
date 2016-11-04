package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class SysRoles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2252807430145097223L;

	/**
	 * 物理主键
	 */
	private Integer id;

	/**
	 * 角色
	 */
	private String role;

	/**
	 * 角色描述
	 */
	private String description;

	/**
	 * 是否启用：0-禁用，1-启用
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
		if (role == null) {
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