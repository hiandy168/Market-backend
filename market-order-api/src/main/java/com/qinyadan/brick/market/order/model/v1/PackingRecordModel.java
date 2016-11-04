package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.util.Date;

public class PackingRecordModel implements Serializable {
	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 商品条码
	 */
	private String upc;

	/**
	 * 扫描时间
	 */
	private Date scanTime;

	/**
	 * 装箱ID
	 */
	private Integer packingId;

	/**
	 * 装箱编号
	 */
	private String packingNo;

	/**
	 * 商品名称
	 */
	private String itemName;

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
	
	
}
