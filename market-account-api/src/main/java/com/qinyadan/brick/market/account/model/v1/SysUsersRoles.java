package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class SysUsersRoles implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7902741131227591666L;
	

	/**
	 * 物理主键
	 */
	private Integer id;

	/**
	 * 用户表关联主键
	 */
	private Integer userId;

	/**
	 * 角色表关联主键
	 */
	private Integer roleId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
		if (roleId == null) {
			return;
		}
	}
}