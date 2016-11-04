package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbOrder implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 订单编号
	 */
	private String orderNo;

	/**
	 * 1-卡，2-劵，3-常规，4-活动
	 */
	private Integer orderType;

	/**
	 * 1-微信订单，2-商城订单，3-客服下单，4-采摘订单
	 */
	private Integer orderSource;

	/**
	 * 1-预付款，2-后付款，3-免费
	 */
	private Integer paymentMode;

	/**
	 * 附加付款方式
	 */
	private Integer otherPaymentMode;

	/**
	 * 客户代码
	 */
	private String memberCode;

	/**
	 * 订单状态
	 */
	private String orderStatus;

	/**
	 * 交易状态：0-待支付，1-已支付
	 */
	private Integer payStatus;

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
	 * 邮政编码
	 */
	private String postcode;

	/**
	 * 运送方式 1-快递，2-自提
	 */
	private Integer transportMode;

	/**
	 * 订单备注
	 */
	private String remark;

	/**
	 * 订单总金额
	 */
	private BigDecimal totalAmount;

	/**
	 * 订单创建时间
	 */
	private Date createTime;

	/**
	 * 预约时间
	 */
	private Date appointmentTime;

	/**
	 * 订单创建人ID
	 */
	private Integer createUserId;

	/**
	 * 发运快递
	 */
	private Integer despatchExpressId;

	/**
	 * 快递员ID
	 */
	private Integer expressMemberId;

	/**
	 * 折扣金额
	 */
	private BigDecimal discountPrice;

	/**
	 * 客户经理
	 */
	private Integer managerId;

	/**
	 * 单位ID
	 */
	private Integer companyId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
		if (orderNo == null) {
			return;
		}
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
		if (orderType == null) {
			return;
		}
	}

	public Integer getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
		if (orderSource == null) {
			return;
		}
	}

	public Integer getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
		if (paymentMode == null) {
			return;
		}
	}

	public Integer getOtherPaymentMode() {
		return otherPaymentMode;
	}

	public void setOtherPaymentMode(Integer otherPaymentMode) {
		this.otherPaymentMode = otherPaymentMode;
		if (otherPaymentMode == null) {
			return;
		}
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
		if (memberCode == null) {
			return;
		}
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
		if (orderStatus == null) {
			return;
		}
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
		if (payStatus == null) {
			return;
		}
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
		if (consigneePhone == null) {
			return;
		}
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
		if (consigneeName == null) {
			return;
		}
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
		if (consigneeAddress == null) {
			return;
		}
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
		if (postcode == null) {
			return;
		}
	}

	public Integer getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(Integer transportMode) {
		this.transportMode = transportMode;
		if (transportMode == null) {
			return;
		}
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
		if (remark == null) {
			return;
		}
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
		if (totalAmount == null) {
			return;
		}
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		if (createTime == null) {
			return;
		}
	}

	public Date getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
		if (appointmentTime == null) {
			return;
		}
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
		if (createUserId == null) {
			return;
		}
	}

	public Integer getDespatchExpressId() {
		return despatchExpressId;
	}

	public void setDespatchExpressId(Integer despatchExpressId) {
		this.despatchExpressId = despatchExpressId;
		if (despatchExpressId == null) {
			return;
		}
	}

	public Integer getExpressMemberId() {
		return expressMemberId;
	}

	public void setExpressMemberId(Integer expressMemberId) {
		this.expressMemberId = expressMemberId;
		if (expressMemberId == null) {
			return;
		}
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
		if (discountPrice == null) {
			return;
		}
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
		if (managerId == null) {
			return;
		}
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
		if (companyId == null) {
			return;
		}
	}
}