package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdMemberCouponRelation implements Serializable {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 客户代码
	 */
	private Integer cdMemberId;

	/**
	 * 卡号
	 */
	private String couponNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getCdMemberId() {
		return cdMemberId;
	}

	public void setCdMemberId(Integer cdMemberId) {
		this.cdMemberId = cdMemberId;
		if (cdMemberId == null) {
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
}