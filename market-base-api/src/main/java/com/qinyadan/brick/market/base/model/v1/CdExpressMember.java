package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdExpressMember implements Serializable {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getCdExpressId() {
		return cdExpressId;
	}

	public void setCdExpressId(Integer cdExpressId) {
		this.cdExpressId = cdExpressId;
		if (cdExpressId == null) {
			return;
		}
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
		if (memberName == null) {
			return;
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		if (phone == null) {
			return;
		}
	}
}