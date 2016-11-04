package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.util.Date;

public class CouponActivityAddress implements Serializable {

	/**
	 * 收货人
	 */
	private String consignmentName;
	/**
	 * 手机号
	 */
	private String consignmentPhone;
	/**
	 * 地址
	 */
	private String consignmentAddress;

	/**
	 * 赠送时间
	 */
	private Date sendTime;

	/**
	 * 赠送数量
	 */
	private Integer sendCount;

	public String getConsignmentName() {
		return consignmentName;
	}

	public void setConsignmentName(String consignmentName) {
		this.consignmentName = consignmentName;
	}

	public String getConsignmentPhone() {
		return consignmentPhone;
	}

	public void setConsignmentPhone(String consignmentPhone) {
		this.consignmentPhone = consignmentPhone;
	}

	public String getConsignmentAddress() {
		return consignmentAddress;
	}

	public void setConsignmentAddress(String consignmentAddress) {
		this.consignmentAddress = consignmentAddress;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getSendCount() {
		return sendCount;
	}

	public void setSendCount(Integer sendCount) {
		this.sendCount = sendCount;
	}

}
