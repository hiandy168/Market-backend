package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class GroupPermissionRelation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1285483985674810514L;
	private String groupId;
	private String permissionCode;
	private String permissionDescription;
	private String permissionId;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
}
