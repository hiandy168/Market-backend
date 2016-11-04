package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;

public class TbReturnOrderItem implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 退货订单表主键
	 */
	private Integer returnOrderId;

	/**
	 * 商品代码
	 */
	private String itemCode;

	/**
	 * 商品退货数量
	 */
	private Integer itemNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getReturnOrderId() {
		return returnOrderId;
	}

	public void setReturnOrderId(Integer returnOrderId) {
		this.returnOrderId = returnOrderId;
		if (returnOrderId == null) {
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

	public Integer getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
		if (itemNumber == null) {
			return;
		}
	}
}