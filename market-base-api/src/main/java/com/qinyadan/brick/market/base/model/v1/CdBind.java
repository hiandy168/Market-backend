package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdBind implements Serializable {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * 微信唯一识别号
	 */
	private String openId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
		if (openId == null) {
			return;
		}
	}
}