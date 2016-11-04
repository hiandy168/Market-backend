package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.util.List;

/**
 */
public class ExpressTask implements Serializable {

	/**
	 * 订单号集合
	 */
	private List<String> orderNos;
	/**
	 * 快递商ID
	 */
	private Integer expressId;
	
	public List<String> getOrderNos() {
		return orderNos;
	}
	public void setOrderNos(List<String> orderNos) {
		this.orderNos = orderNos;
	}
	public Integer getExpressId() {
		return expressId;
	}
	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}
	
	

}
