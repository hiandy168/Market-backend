package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.util.Date;

public class ScanModel implements Serializable {

	private String orderNo;
	private Integer taskStatus;
	/**
	 *
	 */
	private Integer id;

	/**
	 * 商品条码
	 */
	private String upc;

	/**
	 * 订单商品ID
	 */
	private Integer orderItemId;

	/**
	 * 扫描时间
	 */
	private Date scanTime;

	/**
	 * 装箱ID
	 */
	private Integer packingId;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Date getScanTime() {
		return scanTime;
	}

	public void setScanTime(Date scanTime) {
		this.scanTime = scanTime;
	}

	public Integer getPackingId() {
		return packingId;
	}

	public void setPackingId(Integer packingId) {
		this.packingId = packingId;
	}

}
