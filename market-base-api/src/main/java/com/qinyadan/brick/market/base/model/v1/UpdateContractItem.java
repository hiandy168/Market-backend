package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;


public class UpdateContractItem implements Serializable {

	private Integer addType;// 添加方式
	private Integer cdCategoryId;
	private String itemCode;
	/**
	 * 1-固定价格，2-固定金额
	 */
	private Integer contractType;

	/**
	 * 产品合同
	 */
	private Integer cdContractId;

	/**
	 * 当合同适用范围为1的时候，每种产品要设定对应的合同价
	 */
	private Integer cdItemId;

	/**
	 * 合同价格
	 */
	private BigDecimal contractValue;

	public Integer getContractType() {
		return contractType;
	}

	public void setContractType(Integer contractType) {
		this.contractType = contractType;
	}

	public Integer getCdContractId() {
		return cdContractId;
	}

	public void setCdContractId(Integer cdContractId) {
		this.cdContractId = cdContractId;
	}

	public Integer getCdItemId() {
		return cdItemId;
	}

	public void setCdItemId(Integer cdItemId) {
		this.cdItemId = cdItemId;
	}

	public BigDecimal getContractValue() {
		return contractValue;
	}

	public void setContractValue(BigDecimal contractValue) {
		this.contractValue = contractValue;
	}

	public Integer getCdCategoryId() {
		return cdCategoryId;
	}

	public void setCdCategoryId(Integer cdCategoryId) {
		this.cdCategoryId = cdCategoryId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getAddType() {
		return addType;
	}

	public void setAddType(Integer addType) {
		this.addType = addType;
	}

}