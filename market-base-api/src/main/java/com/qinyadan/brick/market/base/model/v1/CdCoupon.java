package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CdCoupon implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 卡或者劵,1-卡，2-劵
	 */
	private Integer couponType;

	/**
	 * 卡/劵类型
	 */
	private Integer couponCategory;

	/**
	 * 卡号
	 */
	private String couponNumber;

	/**
	 * 密码
	 */
	private String couponPassword;

	/**
	 * 固定金额
	 */
	private BigDecimal couponValue;

	/**
	 * 可用余额
	 */
	private BigDecimal userPrice;

	/**
	 * 0-未使用，1-已使用,2-已作废
	 */
	private Integer isUsed;

	/**
	 * 0-无效，1-有效
	 */
	private Integer isUseful;

	/**
	 * 是否赠送。0-否，1-是
	 */
	private Integer isGift;

	/**
	 * 是否发卡，0-未发，1-已发
	 */
	private Integer isSend;

	/**
	 * 是否预付款 1-预付款,2-后付款
	 */
	private Integer paymentType;

	/**
	 * 所属单位
	 */
	private Integer cdCompanyId;

	/**
	 * 客服经理
	 */
	private Integer cdUserId;

	/**
	 * 描述
	 */
	private String couponDesc;

	/**
	 * 有效开始时间
	 */
	private Date beginTime;

	/**
	 * 有效结束时间
	 */
	private Date endTime;

	/**
	 * 
	 */
	private String notes;

	/**
	 * 0-未完结，1-完结
	 */
	private Integer isOver;

	/**
	 * 发卡批次
	 */
	private String batch;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
		if (couponType == null) {
			return;
		}
	}

	public Integer getCouponCategory() {
		return couponCategory;
	}

	public void setCouponCategory(Integer couponCategory) {
		this.couponCategory = couponCategory;
		if (couponCategory == null) {
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

	public String getCouponPassword() {
		return couponPassword;
	}

	public void setCouponPassword(String couponPassword) {
		this.couponPassword = couponPassword;
		if (couponPassword == null) {
			return;
		}
	}

	public BigDecimal getCouponValue() {
		return couponValue;
	}

	public void setCouponValue(BigDecimal couponValue) {
		this.couponValue = couponValue;
		if (couponValue == null) {
			return;
		}
	}

	public BigDecimal getUserPrice() {
		return userPrice;
	}

	public void setUserPrice(BigDecimal userPrice) {
		this.userPrice = userPrice;
		if (userPrice == null) {
			return;
		}
	}

	public Integer getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
		if (isUsed == null) {
			return;
		}
	}

	public Integer getIsUseful() {
		return isUseful;
	}

	public void setIsUseful(Integer isUseful) {
		this.isUseful = isUseful;
		if (isUseful == null) {
			return;
		}
	}

	public Integer getIsGift() {
		return isGift;
	}

	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
		if (isGift == null) {
			return;
		}
	}

	public Integer getIsSend() {
		return isSend;
	}

	public void setIsSend(Integer isSend) {
		this.isSend = isSend;
		if (isSend == null) {
			return;
		}
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
		if (paymentType == null) {
			return;
		}
	}

	public Integer getCdCompanyId() {
		return cdCompanyId;
	}

	public void setCdCompanyId(Integer cdCompanyId) {
		this.cdCompanyId = cdCompanyId;
		if (cdCompanyId == null) {
			return;
		}
	}

	public Integer getCdUserId() {
		return cdUserId;
	}

	public void setCdUserId(Integer cdUserId) {
		this.cdUserId = cdUserId;
		if (cdUserId == null) {
			return;
		}
	}

	public String getCouponDesc() {
		return couponDesc;
	}

	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
		if (couponDesc == null) {
			return;
		}
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		if (beginTime == null) {
			return;
		}
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
		if (endTime == null) {
			return;
		}
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
		if (notes == null) {
			return;
		}
	}

	public Integer getIsOver() {
		return isOver;
	}

	public void setIsOver(Integer isOver) {
		this.isOver = isOver;
		if (isOver == null) {
			return;
		}
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
		if (batch == null) {
			return;
		}
	}
}