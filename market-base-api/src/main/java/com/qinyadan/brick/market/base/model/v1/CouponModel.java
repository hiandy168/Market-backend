package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CouponModel implements Serializable {

	/**
	 *
	 */
	private Integer id;

	/**
	 * 卡或者劵,1-卡，2-劵
	 */
	private Integer couponType;

	private String couponTypeDesc;

	private Integer couponCategoryId;

	private Integer couponCategory;

	private Integer memberId;

	private String categoryName;

	/**
	 * 卡描述
	 */
	private String couponDesc;

	/**
	 * 卡号
	 */
	private String couponNumber;

	/**
	 * 可用金额/可用次数
	 */
	private BigDecimal userPrice;

	/**
	 * 卡值：初始金额,初始次数
	 */
	private BigDecimal couponValue;

	/**
	 * 最低赠送金额
	 */
	private Integer lowestPrice;

	/**
	 * 密码
	 */
	private String couponPassword;

	/**
	 * 有效开始时间
	 */
	private Date beginTime;

	/**
	 * 有效结束时间
	 */
	private Date endTime;

	/**
	 * 0-未使用，1-已使用
	 */
	private Integer isUsed;

	private String isUsedDesc;

	/**
	 * 0-无效，1-有效
	 */
	private Integer isUseful;
	/**
	 * 0-无效，1-有效
	 */
	private Integer isSend;

	/**
	 * 客服经理id
	 */
	private Integer managerId;
	/**
	 * 发放单位Id
	 */
	private Integer companyId;
	/**
	 * 发放单位
	 */
	private String companyName;

	/**
	 * 发放客户经理
	 */
	private String managerName;
	/**
	 * 是否预付款 1-预付款,2-后付款
	 */
	private Integer paymentType;

	private String consignmentName;

	private String consignmentPhone;

	private String consignmentAddress;

	private Date sendTime;

	private String receivedPrice;

	private String batch;

	private String isUsefulDesc;

	/**
	 * 0-非赠送，1-赠送
	 */
	private Integer isGift;

	/**
	 *
	 */
	private String isGiftDesc;
	/**
	 *
	 */
	private String notes;
	/**
	 * 活动id
	 */
	private int cdActivityId;

	private List<CouponRelationItem> relationItemList;

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

	public String getCouponTypeDesc() {
		return couponTypeDesc;
	}

	public void setCouponTypeDesc(String couponTypeDesc) {
		this.couponTypeDesc = couponTypeDesc;
	}

	public Integer getCouponCategoryId() {
		return couponCategoryId;
	}

	public void setCouponCategoryId(Integer couponCategoryId) {
		this.couponCategoryId = couponCategoryId;
	}

	public Integer getCouponCategory() {
		return couponCategory;
	}

	public void setCouponCategory(Integer couponCategory) {
		this.couponCategory = couponCategory;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public BigDecimal getUserPrice() {
		return userPrice;
	}

	public void setUserPrice(BigDecimal userPrice) {
		this.userPrice = userPrice;
	}

	public BigDecimal getCouponValue() {
		return couponValue;
	}

	public void setCouponValue(BigDecimal couponValue) {
		this.couponValue = couponValue;
	}

	public Integer getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(Integer lowestPrice) {
		this.lowestPrice = lowestPrice;
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

	public Integer getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}

	public String getIsUsedDesc() {
		return isUsedDesc;
	}

	public void setIsUsedDesc(String isUsedDesc) {
		this.isUsedDesc = isUsedDesc;
	}

	public Integer getIsUseful() {
		return isUseful;
	}

	public void setIsUseful(Integer isUseful) {
		this.isUseful = isUseful;
	}

	public Integer getIsSend() {
		return isSend;
	}

	public void setIsSend(Integer isSend) {
		this.isSend = isSend;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

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

	public String getReceivedPrice() {
		return receivedPrice;
	}

	public void setReceivedPrice(String receivedPrice) {
		this.receivedPrice = receivedPrice;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getIsUsefulDesc() {
		return isUsefulDesc;
	}

	public void setIsUsefulDesc(String isUsefulDesc) {
		this.isUsefulDesc = isUsefulDesc;
	}

	public Integer getIsGift() {
		return isGift;
	}

	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}

	public String getIsGiftDesc() {
		return isGiftDesc;
	}

	public void setIsGiftDesc(String isGiftDesc) {
		this.isGiftDesc = isGiftDesc;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getCdActivityId() {
		return cdActivityId;
	}

	public void setCdActivityId(int cdActivityId) {
		this.cdActivityId = cdActivityId;
	}

	public List<CouponRelationItem> getRelationItemList() {
		return relationItemList;
	}

	public void setRelationItemList(List<CouponRelationItem> relationItemList) {
		this.relationItemList = relationItemList;
	}
	
	
}
