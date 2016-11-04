package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;

public class PackingOrderItemModel implements Serializable {

	private String itemCode;
	private String itemName;
	private String packingStatusDesc;
	private BigDecimal itemQty;
	private BigDecimal packedItemQty;
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
	public String getPackingStatusDesc() {
		return packingStatusDesc;
	}
	public void setPackingStatusDesc(String packingStatusDesc) {
		this.packingStatusDesc = packingStatusDesc;
	}
	public BigDecimal getItemQty() {
		return itemQty;
	}
	public void setItemQty(BigDecimal itemQty) {
		this.itemQty = itemQty;
	}
	public BigDecimal getPackedItemQty() {
		return packedItemQty;
	}
	public void setPackedItemQty(BigDecimal packedItemQty) {
		this.packedItemQty = packedItemQty;
	}
	
	

}
