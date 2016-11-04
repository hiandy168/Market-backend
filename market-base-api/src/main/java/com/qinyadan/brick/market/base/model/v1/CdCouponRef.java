package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdCouponRef implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 卡劵
	 */
	private Integer cdCouponId;

	/**
	 * 卡号
	 */
	private String couponNumber;

	/**
	 * 拓展类型
	 */
	private String refType;

	/**
	 * 拓展描述
	 */
	private String refName;

	/**
	 * 拓展值
	 */
	private String refValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getCdCouponId() {
		return cdCouponId;
	}

	public void setCdCouponId(Integer cdCouponId) {
		this.cdCouponId = cdCouponId;
		if (cdCouponId == null) {
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

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
		if (refType == null) {
			return;
		}
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
		if (refName == null) {
			return;
		}
	}

	public String getRefValue() {
		return refValue;
	}

	public void setRefValue(String refValue) {
		this.refValue = refValue;
		if (refValue == null) {
			return;
		}
	}
}