package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderReport implements Serializable {

	private Date createTime;
	private String couponNumber;
	private String companyName;
	private String managerName;
	private String orderNo;
	private Date appointmentTime;
	private String consigneeName;
	private String consigneePhone;
	private String consigneeAddress;
	private BigDecimal totalAmount;
	private String paymentModeDesc;
	private BigDecimal payAmount;
	private String otherPaymentModeDesc;
	private BigDecimal otherPayAmount;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
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
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentModeDesc() {
		return paymentModeDesc;
	}
	public void setPaymentModeDesc(String paymentModeDesc) {
		this.paymentModeDesc = paymentModeDesc;
	}
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	public String getOtherPaymentModeDesc() {
		return otherPaymentModeDesc;
	}
	public void setOtherPaymentModeDesc(String otherPaymentModeDesc) {
		this.otherPaymentModeDesc = otherPaymentModeDesc;
	}
	public BigDecimal getOtherPayAmount() {
		return otherPayAmount;
	}
	public void setOtherPayAmount(BigDecimal otherPayAmount) {
		this.otherPayAmount = otherPayAmount;
	}
	
	
}
