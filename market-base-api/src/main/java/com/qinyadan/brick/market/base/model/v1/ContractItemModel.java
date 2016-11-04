package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;

public  class ContractItemModel implements Serializable {
	
	private Integer id;
	private String itemCode;
    private String itemName;
    private BigDecimal sellPrice;
    private String categoryName;
    private String contractTypeName;
    private String discountText;
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
    /**
     * 合同折扣
     */
    private BigDecimal discount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getContractTypeName() {
		return contractTypeName;
	}
	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}
	public String getDiscountText() {
		return discountText;
	}
	public void setDiscountText(String discountText) {
		this.discountText = discountText;
	}
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
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
    
    
}
