package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.util.Date;

public class TbPacking implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 装箱码
	 */
	private String packingNo;

	/**
	 * 装箱时间
	 */
	private Date packingTime;

	/**
	 * 装箱库内状态：0-在库，1-出库
	 */
	private Integer packingStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getPackingNo() {
		return packingNo;
	}

	public void setPackingNo(String packingNo) {
		this.packingNo = packingNo;
		if (packingNo == null) {
			return;
		}
	}

	public Date getPackingTime() {
		return packingTime;
	}

	public void setPackingTime(Date packingTime) {
		this.packingTime = packingTime;
		if (packingTime == null) {
			return;
		}
	}

	public Integer getPackingStatus() {
		return packingStatus;
	}

	public void setPackingStatus(Integer packingStatus) {
		this.packingStatus = packingStatus;
		if (packingStatus == null) {
			return;
		}
	}
}