package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.util.List;

public class CouponActivityAddressHead implements Serializable {
	/**
	 * 卡
	 */
	private String couponNumber;

	private List<CouponActivityAddress> couponActivityAddressList;

	public String getCouponNumber() {
		return couponNumber;
	}

	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
	}

	public List<CouponActivityAddress> getCouponActivityAddressList() {
		return couponActivityAddressList;
	}

	public void setCouponActivityAddressList(List<CouponActivityAddress> couponActivityAddressList) {
		this.couponActivityAddressList = couponActivityAddressList;
	}
	
	

}
