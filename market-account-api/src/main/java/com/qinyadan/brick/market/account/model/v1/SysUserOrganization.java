package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class SysUserOrganization implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7097665045276312272L;
	

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 部门
	 */
	private Integer organizationId;

	/**
	 * 用户
	 */
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		if (organizationId == null) {
			return;
		}
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
		if (userId == null) {
			return;
		}
	}
}