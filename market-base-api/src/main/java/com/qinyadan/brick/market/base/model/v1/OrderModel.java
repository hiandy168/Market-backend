package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderModel implements Serializable {

	/**
	 * 订单ID
	 */
	private Integer id;

	/**
	 * 订单类型
	 */
	private Integer orderType;

	/**
	 * 订单类型描述
	 */
	private String orderTypeDesc;

	/**
	 * 订单来源：1-微信订单，2-商城订单，3-客服下单，4-采摘订单
	 */
	private Integer orderSource;

	/**
	 * 订单来源描述
	 */
	private String orderSourceDesc;

	/**
	 * 付款方式
	 */
	private Integer paymentMode;

	/**
	 * 付款方式描述
	 */
	private String paymentModeDesc;

	/**
	 * 订单编码
	 */
	private String orderNo;

	/**
	 * 订单状态
	 */
	private String orderStatus;

	/**
	 * 装箱任务负责人名称
	 */
	private String packingTaskUsername;
	/**
	 * 装箱任务负责人ID
	 */
	private Integer packingTaskUserId;

	/**
	 * 订单装箱任务状态
	 */
	private Integer packingTaskStatus;
	/**
	 * 装箱任务状态描述
	 */
	private String packingTaskStatusDesc;

	/**
	 * 装箱任务分配时间
	 */
	private Date packingTaskCreateTime;

	/**
	 * 装箱任务开始时间
	 */
	private Date packingTaskStartTime;

	/**
	 * 装箱任务完成时间
	 */
	private Date packingTaskEndTime;

	/**
	 * 订单状态描述
	 */
	private String orderStatusDesc;

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
	 * 运送方式 1-快递，2-自提
	 */
	private Integer transportMode;

	/**
	 * 订单备注
	 */
	private String remark;

	/**
	 * 折扣价
	 */
	private BigDecimal discountPrice;

	/**
	 * 订单总金额
	 */
	private BigDecimal totalAmount;

	/**
	 * 订单创建时间
	 */
	private Date createTime;

	/**
	 * 订单创建人ID
	 */
	private Integer createUserId;

	/**
	 * 配送时间
	 */
	private Date appointmentTime;

	/**
	 * 支付卡（券）号
	 */
	private String couponNumber;

	/**
	 * 快递商
	 */
	private String expressName;

	private Integer despatchExpressId;

	/**
	 * 项目经理
	 */
	private String managerName;
	/**
	 * 单位
	 */
	private String companyName;

	/**
	 * 总箱数
	 */
	private List<PackingModel> packingModels;

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

	public String getOrderTypeDesc() {
		return orderTypeDesc;
	}

	public void setOrderTypeDesc(String orderTypeDesc) {
		this.orderTypeDesc = orderTypeDesc;
	}

	public Integer getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}

	public String getOrderSourceDesc() {
		return orderSourceDesc;
	}

	public void setOrderSourceDesc(String orderSourceDesc) {
		this.orderSourceDesc = orderSourceDesc;
	}

	public Integer getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentModeDesc() {
		return paymentModeDesc;
	}

	public void setPaymentModeDesc(String paymentModeDesc) {
		this.paymentModeDesc = paymentModeDesc;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPackingTaskUsername() {
		return packingTaskUsername;
	}

	public void setPackingTaskUsername(String packingTaskUsername) {
		this.packingTaskUsername = packingTaskUsername;
	}

	public Integer getPackingTaskUserId() {
		return packingTaskUserId;
	}

	public void setPackingTaskUserId(Integer packingTaskUserId) {
		this.packingTaskUserId = packingTaskUserId;
	}

	public Integer getPackingTaskStatus() {
		return packingTaskStatus;
	}

	public void setPackingTaskStatus(Integer packingTaskStatus) {
		this.packingTaskStatus = packingTaskStatus;
	}

	public String getPackingTaskStatusDesc() {
		return packingTaskStatusDesc;
	}

	public void setPackingTaskStatusDesc(String packingTaskStatusDesc) {
		this.packingTaskStatusDesc = packingTaskStatusDesc;
	}

	public Date getPackingTaskCreateTime() {
		return packingTaskCreateTime;
	}

	public void setPackingTaskCreateTime(Date packingTaskCreateTime) {
		this.packingTaskCreateTime = packingTaskCreateTime;
	}

	public Date getPackingTaskStartTime() {
		return packingTaskStartTime;
	}

	public void setPackingTaskStartTime(Date packingTaskStartTime) {
		this.packingTaskStartTime = packingTaskStartTime;
	}

	public Date getPackingTaskEndTime() {
		return packingTaskEndTime;
	}

	public void setPackingTaskEndTime(Date packingTaskEndTime) {
		this.packingTaskEndTime = packingTaskEndTime;
	}

	public String getOrderStatusDesc() {
		return orderStatusDesc;
	}

	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
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

	public Integer getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(Integer transportMode) {
		this.transportMode = transportMode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getCouponNumber() {
		return couponNumber;
	}

	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public Integer getDespatchExpressId() {
		return despatchExpressId;
	}

	public void setDespatchExpressId(Integer despatchExpressId) {
		this.despatchExpressId = despatchExpressId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<PackingModel> getPackingModels() {
		return packingModels;
	}

	public void setPackingModels(List<PackingModel> packingModels) {
		this.packingModels = packingModels;
	}
	
}
