package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class ExpressMemberModel implements Serializable {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 快递商id
	 */
	private Integer cdExpressId;

	/**
	 * 快递员姓名
	 */
	private String memberName;

	/**
	 * 电话号码
	 */
	private String phone;

	private String expressName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCdExpressId() {
		return cdExpressId;
	}

	public void setCdExpressId(Integer cdExpressId) {
		this.cdExpressId = cdExpressId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}
	
	
}
