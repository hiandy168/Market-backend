package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.util.List;

public class PackingTask implements Serializable {

	/**
	 * 订单号集合
	 */
	private List<String> orderNos;
	/**
	 * 装箱任务负责人ID
	 */
	private Integer packingTaskUserId;
	public List<String> getOrderNos() {
		return orderNos;
	}
	public void setOrderNos(List<String> orderNos) {
		this.orderNos = orderNos;
	}
	public Integer getPackingTaskUserId() {
		return packingTaskUserId;
	}
	public void setPackingTaskUserId(Integer packingTaskUserId) {
		this.packingTaskUserId = packingTaskUserId;
	}
	
	

}
