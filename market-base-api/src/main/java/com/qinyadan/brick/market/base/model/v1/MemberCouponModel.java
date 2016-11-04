package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;

public class MemberCouponModel implements Serializable{
	private String couponNumber;
	private BigDecimal userPrice;
	public String getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
	}
	public BigDecimal getUserPrice() {
		return userPrice;
	}
	public void setUserPrice(BigDecimal userPrice) {
		this.userPrice = userPrice;
	}
}
