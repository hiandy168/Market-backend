package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class UserGroupRelation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9119362129235955328L;
	
	private String username;
	private String email;
	private String userId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
