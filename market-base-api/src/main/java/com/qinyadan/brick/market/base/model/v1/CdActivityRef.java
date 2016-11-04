package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdActivityRef implements Serializable {
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 活动ID
	 */
	private Integer cdActivityId;

	/**
	 * 拓展值
	 */
	private String refValue;

	/**
	 * 拓展类型
	 */
	private String refType;

	/**
	 * 拓展描述
	 */
	private String refName;

	/**
	 * 份数
	 */
	private Integer refCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getCdActivityId() {
		return cdActivityId;
	}

	public void setCdActivityId(Integer cdActivityId) {
		this.cdActivityId = cdActivityId;
		if (cdActivityId == null) {
			return;
		}
	}

	public String getRefValue() {
		return refValue;
	}

	public void setRefValue(String refValue) {
		this.refValue = refValue;
		if (refValue == null) {
			return;
		}
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
		if (refType == null) {
			return;
		}
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
		if (refName == null) {
			return;
		}
	}

	public Integer getRefCount() {
		return refCount;
	}

	public void setRefCount(Integer refCount) {
		this.refCount = refCount;
		if (refCount == null) {
			return;
		}
	}
}