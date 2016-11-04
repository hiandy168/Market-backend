package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;

public class RefundOrder implements Serializable {

	private String orderNo;
	private BigDecimal amount;
	private String remark;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
