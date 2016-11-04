package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;

public class PackingQuery implements Serializable {

	private String orderNo;
	private String keyword;
	private String packingStatus;
	private String packingNo;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPackingStatus() {
		return packingStatus;
	}
	public void setPackingStatus(String packingStatus) {
		this.packingStatus = packingStatus;
	}
	public String getPackingNo() {
		return packingNo;
	}
	public void setPackingNo(String packingNo) {
		this.packingNo = packingNo;
	}
	
	

}
