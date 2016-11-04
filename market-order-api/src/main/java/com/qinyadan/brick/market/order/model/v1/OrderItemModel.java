package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;

public class OrderItemModel implements Serializable {

	/**
	 * 订单编码
	 */
	private String orderNo;

	/**
	 * 商品名称
	 */
	private String itemName;

	/**
	 * 商品编号
	 */
	private String itemCode;

	/**
	 * 订单商品数量
	 */
	private String itemQty;

	/**
	 * 已装箱数量
	 */
	private Integer packedQty;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public String getItemQty() {
		return itemQty;
	}

	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}

	public Integer getPackedQty() {
		return packedQty;
	}

	public void setPackedQty(Integer packedQty) {
		this.packedQty = packedQty;
	}
	
}
