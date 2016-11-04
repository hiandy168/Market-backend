package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.util.Date;

public class TbPackingRecord implements Serializable {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
		if (upc == null) {
			return;
		}
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
		if (orderItemId == null) {
			return;
		}
	}

	public Date getScanTime() {
		return scanTime;
	}

	public void setScanTime(Date scanTime) {
		this.scanTime = scanTime;
		if (scanTime == null) {
			return;
		}
	}

	public Integer getPackingId() {
		return packingId;
	}

	public void setPackingId(Integer packingId) {
		this.packingId = packingId;
		if (packingId == null) {
			return;
		}
	}
}