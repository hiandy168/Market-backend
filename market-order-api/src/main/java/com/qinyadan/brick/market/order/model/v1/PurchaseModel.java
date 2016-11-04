package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;

public class PurchaseModel implements Serializable {

	private int purchaseId;
	private String purchaseCode;
	private Integer purchaseStatus;
	private String purchaseStatusDesc;
	private int cdItemId;
	private String itemName;
	private String itemCode;
	private String itemUnit;
	private BigDecimal totalItemQty;
	private BigDecimal totalWeight;
	private int distributeValue;
	private int packageValue;
	private int packingValue;
	private String sellUnit;
	private String spec;

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public Integer getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(Integer purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public String getPurchaseStatusDesc() {
		return purchaseStatusDesc;
	}

	public void setPurchaseStatusDesc(String purchaseStatusDesc) {
		this.purchaseStatusDesc = purchaseStatusDesc;
	}

	public int getCdItemId() {
		return cdItemId;
	}

	public void setCdItemId(int cdItemId) {
		this.cdItemId = cdItemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public BigDecimal getTotalItemQty() {
		return totalItemQty;
	}

	public void setTotalItemQty(BigDecimal totalItemQty) {
		this.totalItemQty = totalItemQty;
	}

	public BigDecimal getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}

	public int getDistributeValue() {
		return distributeValue;
	}

	public void setDistributeValue(int distributeValue) {
		this.distributeValue = distributeValue;
	}

	public int getPackageValue() {
		return packageValue;
	}

	public void setPackageValue(int packageValue) {
		this.packageValue = packageValue;
	}

	public int getPackingValue() {
		return packingValue;
	}

	public void setPackingValue(int packingValue) {
		this.packingValue = packingValue;
	}

	public String getSellUnit() {
		return sellUnit;
	}

	public void setSellUnit(String sellUnit) {
		this.sellUnit = sellUnit;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

}
