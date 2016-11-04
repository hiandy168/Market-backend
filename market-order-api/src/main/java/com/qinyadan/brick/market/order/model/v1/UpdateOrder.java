package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UpdateOrder implements Serializable {

	private String orderNo;

	private Integer id;
	/**
	 * 1-卡，2-劵，3-常规
	 */
	private Integer orderType;

	/**
	 * 1-微信订单，2-商城订单，3-客服下单，4-采摘订单
	 */
	private Integer orderSource;

	/**
	 * 客户名称
	 */
	private String name;

	/**
	 * 客户代码
	 */
	private String memberCode;

	/**
	 * 客户联系方式
	 */
	private String phone;

	/**
	 * 付款方式
	 */
	private Integer paymentMode;

	/**
	 * 附加付款方式
	 */
	private Integer otherPaymentMode;

	/**
	 * 支付关系编号（卡号/券号）
	 */
	private String paymentRelationNo;

	/**
	 * 收货人手机
	 */
	private String consigneePhone;

	/**
	 * 收货人姓名
	 */
	private String consigneeName;

	/**
	 * 收货人地址
	 */
	private String consigneeAddress;

	/**
	 * 订单备注
	 */
	private String remark;

	/**
	 * 折扣
	 */
	private Integer discount;

	/**
	 * 是否显示金额
	 */
	private Integer isShowAmount;

	/**
	 * 操作人
	 */
	private Integer createUserId;

	/**
	 * 单位
	 */
	private Integer companyId;
	/**
	 * 客户经理
	 */
	private Integer managerId;
	/**
	 * 折扣金额
	 */
	private BigDecimal discountPrice;
	/**
	 * 订单总金额（劵直接取,卡、常规订单后台在计算金额）
	 */
	private BigDecimal totalPrice;

	private Date appointmentTime;
	private List<OrderItem> orderItemList;

	public static class OrderItem implements Serializable {
		private String itemCode;
		private Integer orderItemId;
		private BigDecimal itemQty;

		public String getItemCode() {
			return itemCode;
		}

		public void setItemCode(String itemCode) {
			this.itemCode = itemCode;
		}

		public Integer getOrderItemId() {
			return orderItemId;
		}

		public void setOrderItemId(Integer orderItemId) {
			this.orderItemId = orderItemId;
		}

		public BigDecimal getItemQty() {
			return itemQty;
		}

		public void setItemQty(BigDecimal itemQty) {
			this.itemQty = itemQty;
		}
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Integer getOtherPaymentMode() {
		return otherPaymentMode;
	}

	public void setOtherPaymentMode(Integer otherPaymentMode) {
		this.otherPaymentMode = otherPaymentMode;
	}

	public String getPaymentRelationNo() {
		return paymentRelationNo;
	}

	public void setPaymentRelationNo(String paymentRelationNo) {
		this.paymentRelationNo = paymentRelationNo;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getIsShowAmount() {
		return isShowAmount;
	}

	public void setIsShowAmount(Integer isShowAmount) {
		this.isShowAmount = isShowAmount;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	

}
