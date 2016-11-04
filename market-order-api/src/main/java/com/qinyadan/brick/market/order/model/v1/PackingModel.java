package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.util.Date;

public class PackingModel implements Serializable {

	private Integer id;
	private String orderNo;
	private String packingNo;
	private Date packingTime;
	private Integer packingStatus;
	private String packingStatusDesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getPackingTime() {
		return packingTime;
	}
	public void setPackingTime(Date packingTime) {
		this.packingTime = packingTime;
	}
	public Integer getPackingStatus() {
		return packingStatus;
	}
	public void setPackingStatus(Integer packingStatus) {
		this.packingStatus = packingStatus;
	}
	public String getPackingStatusDesc() {
		return packingStatusDesc;
	}
	public void setPackingStatusDesc(String packingStatusDesc) {
		this.packingStatusDesc = packingStatusDesc;
	}
	
	
}
