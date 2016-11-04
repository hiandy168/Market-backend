package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdExpress implements Serializable {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 快递编号
	 */
	private String expressCode;

	/**
	 * 快递公司名
	 */
	private String expressName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
		if (expressCode == null) {
			return;
		}
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
		if (expressName == null) {
			return;
		}
	}
}