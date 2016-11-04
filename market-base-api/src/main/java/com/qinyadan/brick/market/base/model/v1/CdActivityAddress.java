package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.util.Date;

public class CdActivityAddress implements Serializable {

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 卡号
	 */
	private String couponNumber;

	/**
	 * 
	 */
	private String consignmentName;

	/**
	 * 收货手机号
	 */
	private String consignmentPhone;

	/**
	 * 收货地址
	 */
	private String consignmentAddress;

	/**
	 * 赠送日期
	 */
	private Date sendTime;

	/**
	 * 赠送份数
	 */
	private Integer sendCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getCouponNumber() {
		return couponNumber;
	}

	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
		if (couponNumber == null) {
			return;
		}
	}

	public String getConsignmentName() {
		return consignmentName;
	}

	public void setConsignmentName(String consignmentName) {
		this.consignmentName = consignmentName;
		if (consignmentName == null) {
			return;
		}
	}

	public String getConsignmentPhone() {
		return consignmentPhone;
	}

	public void setConsignmentPhone(String consignmentPhone) {
		this.consignmentPhone = consignmentPhone;
		if (consignmentPhone == null) {
			return;
		}
	}

	public String getConsignmentAddress() {
		return consignmentAddress;
	}

	public void setConsignmentAddress(String consignmentAddress) {
		this.consignmentAddress = consignmentAddress;
		if (consignmentAddress == null) {
			return;
		}
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
		if (sendTime == null) {
			return;
		}
	}

	public Integer getSendCount() {
		return sendCount;
	}

	public void setSendCount(Integer sendCount) {
		this.sendCount = sendCount;
		if (sendCount == null) {
			return;
		}
	}
}