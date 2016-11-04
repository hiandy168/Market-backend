package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CouponQuery implements Serializable {

	private String keyword;
	private String couponNumber;
	private String password;
	private Integer couponType;
	private Integer couponCategoryId;
	private Integer categoryType;
	private Integer isSend;
	private Integer cdCompanyId;
	private Integer customerMangerId;
	private Integer isUseful;
	private Integer isOver;
	private Integer managerId;
	private String batch;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getCouponType() {
		return couponType;
	}
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	public Integer getCouponCategoryId() {
		return couponCategoryId;
	}
	public void setCouponCategoryId(Integer couponCategoryId) {
		this.couponCategoryId = couponCategoryId;
	}
	public Integer getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}
	public Integer getIsSend() {
		return isSend;
	}
	public void setIsSend(Integer isSend) {
		this.isSend = isSend;
	}
	public Integer getCdCompanyId() {
		return cdCompanyId;
	}
	public void setCdCompanyId(Integer cdCompanyId) {
		this.cdCompanyId = cdCompanyId;
	}
	public Integer getCustomerMangerId() {
		return customerMangerId;
	}
	public void setCustomerMangerId(Integer customerMangerId) {
		this.customerMangerId = customerMangerId;
	}
	public Integer getIsUseful() {
		return isUseful;
	}
	public void setIsUseful(Integer isUseful) {
		this.isUseful = isUseful;
	}
	public Integer getIsOver() {
		return isOver;
	}
	public void setIsOver(Integer isOver) {
		this.isOver = isOver;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	
}
