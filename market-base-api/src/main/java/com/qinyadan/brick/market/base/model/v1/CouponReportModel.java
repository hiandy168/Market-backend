package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 */
public class CouponReportModel implements Serializable {

	/**
	 * 卡或者劵,1-卡，2-劵
	 */
	private Integer couponType;

	private String categoryName;

	private Integer couponCategoryId;
	/**
	 * 卡描述
	 */
	private String couponDesc;

	/**
	 * 卡号
	 */
	private String couponNumber;

	/**
	 * 卡值：初始金额,初始次数
	 */
	private BigDecimal couponValue;

	/**
	 * 密码
	 */
	private String couponPassword;

	/**
	 * 是否预付款 1-预付款,2-后付款
	 */
	private Integer paymentType;

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCouponDesc() {
		return couponDesc;
	}

	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}

	public String getCouponNumber() {
		return couponNumber;
	}

	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
	}

	public BigDecimal getCouponValue() {
		return couponValue;
	}

	public void setCouponValue(BigDecimal couponValue) {
		this.couponValue = couponValue;
	}

	public String getCouponPassword() {
		return couponPassword;
	}

	public void setCouponPassword(String couponPassword) {
		this.couponPassword = couponPassword;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getCouponCategoryId() {
		return couponCategoryId;
	}

	public void setCouponCategoryId(Integer couponCategoryId) {
		this.couponCategoryId = couponCategoryId;
	}

}
