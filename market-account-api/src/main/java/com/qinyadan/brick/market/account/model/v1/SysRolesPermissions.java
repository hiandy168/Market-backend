package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class SysRolesPermissions implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1225187508874619762L;
	
	

	/**
	 * 物理主键
	 */
	private Integer id;

	/**
	 * 角色表关联主键
	 */
	private Integer roleId;

	/**
	 * 权限表关联主键
	 */
	private Integer permissionId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
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

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
		if (permissionId == null) {
			return;
		}
	}
}