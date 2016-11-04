package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;

public class CdContractItem implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 产品合同
	 */
	private Integer cdContractId;

	/**
	 * 优惠方式
	 */
	private Integer contractType;

	/**
	 * 当合同适用范围为1的时候，每种产品要设定对应的合同价
	 */
	private Integer cdItemId;

	/**
	 * 折扣
	 */
	private BigDecimal discount;

	/**
	 * 合同价格
	 */
	private BigDecimal contractValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getCdContractId() {
		return cdContractId;
	}

	public void setCdContractId(Integer cdContractId) {
		this.cdContractId = cdContractId;
		if (cdContractId == null) {
			return;
		}
	}

	public Integer getContractType() {
		return contractType;
	}

	public void setContractType(Integer contractType) {
		this.contractType = contractType;
		if (contractType == null) {
			return;
		}
	}

	public Integer getCdItemId() {
		return cdItemId;
	}

	public void setCdItemId(Integer cdItemId) {
		this.cdItemId = cdItemId;
		if (cdItemId == null) {
			return;
		}
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
		if (discount == null) {
			return;
		}
	}

	public BigDecimal getContractValue() {
		return contractValue;
	}

	public void setContractValue(BigDecimal contractValue) {
		this.contractValue = contractValue;
		if (contractValue == null) {
			return;
		}
	}
}