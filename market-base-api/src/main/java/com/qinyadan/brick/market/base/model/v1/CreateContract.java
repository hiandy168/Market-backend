package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CreateContract implements Serializable {
	/**
	 * 合同名称
	 */
	private String contractName;
	/**
	 * 合同编号
	 */
	private String contractCode;
	/**
	 * 合同价的客户
	 */
	private Integer cdMemberId;

	/**
	 * 合同价的单位
	 */
	private Integer cdCompanyId;

	/**
	 * 1-部分产品，2-全部产品
	 */
	private Integer scope;

	/**
	 * 仅当适用范围为全部产品时适用
	 */
	private BigDecimal contractPrice;

	/**
	 * 合同开始时间
	 */
	private Date beginTime;

	/**
	 * 合同结束时间
	 */
	private Date endTime;

	/**
	 * 0-未审核，1-审核
	 */
	private Integer isAuditor;

	/**
	 * 合同明细
	 */
	private List<CreateContractItem> contractItemList;

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public Integer getCdMemberId() {
		return cdMemberId;
	}

	public void setCdMemberId(Integer cdMemberId) {
		this.cdMemberId = cdMemberId;
	}

	public Integer getCdCompanyId() {
		return cdCompanyId;
	}

	public void setCdCompanyId(Integer cdCompanyId) {
		this.cdCompanyId = cdCompanyId;
	}

	public Integer getScope() {
		return scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

	public BigDecimal getContractPrice() {
		return contractPrice;
	}

	public void setContractPrice(BigDecimal contractPrice) {
		this.contractPrice = contractPrice;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getIsAuditor() {
		return isAuditor;
	}

	public void setIsAuditor(Integer isAuditor) {
		this.isAuditor = isAuditor;
	}

	public List<CreateContractItem> getContractItemList() {
		return contractItemList;
	}

	public void setContractItemList(List<CreateContractItem> contractItemList) {
		this.contractItemList = contractItemList;
	}
	
}
