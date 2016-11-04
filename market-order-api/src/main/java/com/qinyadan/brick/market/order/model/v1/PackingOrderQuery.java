package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;


public class PackingOrderQuery implements Serializable {

	private Integer orderId;
	private String orderNo;
	private Integer orderItemId;
	private String keyword;
	private String itemCode;
	private String[] orderNos;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String[] getOrderNos() {
		return orderNos;
	}
	public void setOrderNos(String[] orderNos) {
		this.orderNos = orderNos;
	}
	
}
