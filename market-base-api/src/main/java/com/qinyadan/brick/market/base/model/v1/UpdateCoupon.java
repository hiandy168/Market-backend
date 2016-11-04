package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UpdateCoupon implements Serializable {

	private Integer id;
	private Integer couponType;
	private Integer couponCategory;
	private String couponDesc;
	private String couponNumber;
	private String couponPassword;
	private Date beginTime;
	private Date endTime;
	private BigDecimal couponValue;
	private BigDecimal userPrice;
	private Integer isUsed;
	private Integer isUseful;
	private Integer isGift;
	private String notes;
	private Integer paymentType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCouponType() {
		return couponType;
	}
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	public Integer getCouponCategory() {
		return couponCategory;
	}
	public void setCouponCategory(Integer couponCategory) {
		this.couponCategory = couponCategory;
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
	public String getCouponPassword() {
		return couponPassword;
	}
	public void setCouponPassword(String couponPassword) {
		this.couponPassword = couponPassword;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public BigDecimal getCouponValue() {
		return couponValue;
	}
	public void setCouponValue(BigDecimal couponValue) {
		this.couponValue = couponValue;
	}
	public BigDecimal getUserPrice() {
		return userPrice;
	}
	public void setUserPrice(BigDecimal userPrice) {
		this.userPrice = userPrice;
	}
	public Integer getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}
	public Integer getIsUseful() {
		return isUseful;
	}
	public void setIsUseful(Integer isUseful) {
		this.isUseful = isUseful;
	}
	public Integer getIsGift() {
		return isGift;
	}
	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	
}
