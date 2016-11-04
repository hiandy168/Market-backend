package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public  class UserGroup implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4594937491374303649L;
	
	private String userGorup;
	private Integer userGroupId;
	
	public String getUserGorup() {
		return userGorup;
	}
	public void setUserGorup(String userGorup) {
		this.userGorup = userGorup;
	}
	public Integer getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}
	
}
