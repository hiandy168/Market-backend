package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdCompany implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 单位编号
	 */
	private String companyCode;

	/**
	 * 单位名称
	 */
	private String companyName;

	/**
	 * 单位地址
	 */
	private String companyAddress;

	/**
	 * 单位联系人
	 */
	private String companyLeader;

	/**
	 * 联系人电话
	 */
	private String companyLeaderTel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
		if (companyCode == null) {
			return;
		}
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
		if (companyName == null) {
			return;
		}
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
		if (companyAddress == null) {
			return;
		}
	}

	public String getCompanyLeader() {
		return companyLeader;
	}

	public void setCompanyLeader(String companyLeader) {
		this.companyLeader = companyLeader;
		if (companyLeader == null) {
			return;
		}
	}

	public String getCompanyLeaderTel() {
		return companyLeaderTel;
	}

	public void setCompanyLeaderTel(String companyLeaderTel) {
		this.companyLeaderTel = companyLeaderTel;
		if (companyLeaderTel == null) {
			return;
		}
	}
}