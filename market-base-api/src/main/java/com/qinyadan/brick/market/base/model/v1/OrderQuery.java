package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class OrderQuery implements Serializable {

	private Integer id;
	private String orderNo;
	private String[] orderNos;
	private String keyword;
	private Integer orderStatus;
	private Integer packingTaskStatus;
	private Integer packingTaskUserId;
	private String packingTaskCreateTimeStart;
	private String packingTaskCreateTimeEnd;
	private Integer createUserId;
	private boolean isHasPackingTaskUserId;
	private Integer managerId;
	private Integer companyId;
	private String consigneeName;
	private boolean hasNoShowCancel;

	private String orderCreateTimeStart;
	private String orderCreateTimeEnd;
	private String despatchExpressCode;

	private Integer despatchExpressId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String[] getOrderNos() {
		return orderNos;
	}

	public void setOrderNos(String[] orderNos) {
		this.orderNos = orderNos;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getPackingTaskStatus() {
		return packingTaskStatus;
	}

	public void setPackingTaskStatus(Integer packingTaskStatus) {
		this.packingTaskStatus = packingTaskStatus;
	}

	public Integer getPackingTaskUserId() {
		return packingTaskUserId;
	}

	public void setPackingTaskUserId(Integer packingTaskUserId) {
		this.packingTaskUserId = packingTaskUserId;
	}

	public String getPackingTaskCreateTimeStart() {
		return packingTaskCreateTimeStart;
	}

	public void setPackingTaskCreateTimeStart(String packingTaskCreateTimeStart) {
		this.packingTaskCreateTimeStart = packingTaskCreateTimeStart;
	}

	public String getPackingTaskCreateTimeEnd() {
		return packingTaskCreateTimeEnd;
	}

	public void setPackingTaskCreateTimeEnd(String packingTaskCreateTimeEnd) {
		this.packingTaskCreateTimeEnd = packingTaskCreateTimeEnd;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public boolean isHasPackingTaskUserId() {
		return isHasPackingTaskUserId;
	}

	public void setHasPackingTaskUserId(boolean isHasPackingTaskUserId) {
		this.isHasPackingTaskUserId = isHasPackingTaskUserId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public boolean isHasNoShowCancel() {
		return hasNoShowCancel;
	}

	public void setHasNoShowCancel(boolean hasNoShowCancel) {
		this.hasNoShowCancel = hasNoShowCancel;
	}

	public String getOrderCreateTimeStart() {
		return orderCreateTimeStart;
	}

	public void setOrderCreateTimeStart(String orderCreateTimeStart) {
		this.orderCreateTimeStart = orderCreateTimeStart;
	}

	public String getOrderCreateTimeEnd() {
		return orderCreateTimeEnd;
	}

	public void setOrderCreateTimeEnd(String orderCreateTimeEnd) {
		this.orderCreateTimeEnd = orderCreateTimeEnd;
	}

	public String getDespatchExpressCode() {
		return despatchExpressCode;
	}

	public void setDespatchExpressCode(String despatchExpressCode) {
		this.despatchExpressCode = despatchExpressCode;
	}

	public Integer getDespatchExpressId() {
		return despatchExpressId;
	}

	public void setDespatchExpressId(Integer despatchExpressId) {
		this.despatchExpressId = despatchExpressId;
	}
	
	
}
