package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CompanyCustomerManager implements Serializable{
	private Integer customerMangerId;
	private String customerManger;
	public Integer getCustomerMangerId() {
		return customerMangerId;
	}
	public void setCustomerMangerId(Integer customerMangerId) {
		this.customerMangerId = customerMangerId;
	}
	public String getCustomerManger() {
		return customerManger;
	}
	public void setCustomerManger(String customerManger) {
		this.customerManger = customerManger;
	}
	
}
