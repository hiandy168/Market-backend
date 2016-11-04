package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;

public class PackingOrderModel implements Serializable {

	private Integer orderItemId;
	private String orderNo;
	private String packingNo;
	private String itemName;
	private String packingStatusDesc;
	private BigDecimal itemQty;
	private BigDecimal packedItemQty;
	public Integer getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPackingNo() {
		return packingNo;
	}
	public void setPackingNo(String packingNo) {
		this.packingNo = packingNo;
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
