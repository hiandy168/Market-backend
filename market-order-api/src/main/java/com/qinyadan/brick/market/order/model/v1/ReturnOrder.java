package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.util.List;

public class ReturnOrder implements Serializable {

	private String orderNo;

	private List<Item> itemList;

	public static class Item implements Serializable {
		private String itemCode;
		private Integer itemNumber;

		public String getItemCode() {
			return itemCode;
		}

		public void setItemCode(String itemCode) {
			this.itemCode = itemCode;
		}

		public Integer getItemNumber() {
			return itemNumber;
		}

		public void setItemNumber(Integer itemNumber) {
			this.itemNumber = itemNumber;
		}

	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
