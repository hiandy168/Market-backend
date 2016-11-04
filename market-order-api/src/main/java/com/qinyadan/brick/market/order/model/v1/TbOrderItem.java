package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbOrderItem implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 订单编号
	 */
	private String orderNo;

	/**
	 * 
	 */
	private Integer itemId;

	/**
	 * 商品编码
	 */
	private String itemCode;

	/**
	 * 商品名称
	 */
	private String itemName;

	/**
	 * 商品单价
	 */
	private BigDecimal itemPrice;

	/**
	 * 商品数量
	 */
	private BigDecimal itemQty;

	/**
	 * 商品单位
	 */
	private String itemUnit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
		if (orderNo == null) {
			return;
		}
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
		if (itemId == null) {
			return;
		}
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
		if (itemCode == null) {
			return;
		}
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
		if (itemName == null) {
			return;
		}
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
		if (itemPrice == null) {
			return;
		}
	}

	public BigDecimal getItemQty() {
		return itemQty;
	}

	public void setItemQty(BigDecimal itemQty) {
		this.itemQty = itemQty;
		if (itemQty == null) {
			return;
		}
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
		if (itemUnit == null) {
			return;
		}
	}
}