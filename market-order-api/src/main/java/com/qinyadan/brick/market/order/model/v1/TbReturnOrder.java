package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.util.Date;

public class TbReturnOrder implements Serializable {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 订单编号
	 */
	private String orderNo;

	/**
	 * 退货时间
	 */
	private Date returnTime;

	/**
	 * 订单退货状态
	 */
	private Integer returnStatus;

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

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
		if (returnTime == null) {
			return;
		}
	}

	public Integer getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(Integer returnStatus) {
		this.returnStatus = returnStatus;
		if (returnStatus == null) {
			return;
		}
	}
}