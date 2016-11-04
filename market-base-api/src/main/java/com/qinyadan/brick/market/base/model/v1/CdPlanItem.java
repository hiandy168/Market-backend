package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdPlanItem implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 计划ID
	 */
	private Integer cdPlanId;

	/**
	 * 搭配的产品
	 */
	private Integer cdItemId;

	/**
	 * 份数
	 */
	private Integer countValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getCdPlanId() {
		return cdPlanId;
	}

	public void setCdPlanId(Integer cdPlanId) {
		this.cdPlanId = cdPlanId;
		if (cdPlanId == null) {
			return;
		}
	}

	public Integer getCdItemId() {
		return cdItemId;
	}

	public void setCdItemId(Integer cdItemId) {
		this.cdItemId = cdItemId;
		if (cdItemId == null) {
			return;
		}
	}

	public Integer getCountValue() {
		return countValue;
	}

	public void setCountValue(Integer countValue) {
		this.countValue = countValue;
		if (countValue == null) {
			return;
		}
	}
}