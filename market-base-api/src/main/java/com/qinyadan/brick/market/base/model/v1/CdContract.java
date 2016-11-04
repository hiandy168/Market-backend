package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CdContract implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 合同编号
	 */
	private String contractCode;

	/**
	 * 合同名称
	 */
	private String contractName;

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
	 * 0-未作废，1-作废
	 */
	private Integer isDel;

	/**
	 * 0-未审核，1-审核
	 */
	private Integer isAuditor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
		if (contractCode == null) {
			return;
		}
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
		if (contractName == null) {
			return;
		}
	}

	public Integer getCdMemberId() {
		return cdMemberId;
	}

	public void setCdMemberId(Integer cdMemberId) {
		this.cdMemberId = cdMemberId;
		if (cdMemberId == null) {
			return;
		}
	}

	public Integer getCdCompanyId() {
		return cdCompanyId;
	}

	public void setCdCompanyId(Integer cdCompanyId) {
		this.cdCompanyId = cdCompanyId;
		if (cdCompanyId == null) {
			return;
		}
	}

	public Integer getScope() {
		return scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
		if (scope == null) {
			return;
		}
	}

	public BigDecimal getContractPrice() {
		return contractPrice;
	}

	public void setContractPrice(BigDecimal contractPrice) {
		this.contractPrice = contractPrice;
		if (contractPrice == null) {
			return;
		}
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		if (beginTime == null) {
			return;
		}
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
		if (endTime == null) {
			return;
		}
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
		if (isDel == null) {
			return;
		}
	}

	public Integer getIsAuditor() {
		return isAuditor;
	}

	public void setIsAuditor(Integer isAuditor) {
		this.isAuditor = isAuditor;
		if (isAuditor == null) {
			return;
		}
	}
}