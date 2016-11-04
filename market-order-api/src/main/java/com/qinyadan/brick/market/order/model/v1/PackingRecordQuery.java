package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;

public class PackingRecordQuery implements Serializable {
	/**
	 * ID
	 */
	private Integer id;

	private String keyword;

	private Integer orderItemId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	

}
