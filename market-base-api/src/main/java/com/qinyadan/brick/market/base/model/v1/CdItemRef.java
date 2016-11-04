package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CdItemRef implements Serializable {
	/**
	 * 
	 */
	private Integer cdItemRefId;

	/**
	 * 拓展类型
	 */
	private String refType;

	/**
	 * 拓展描述
	 */
	private String refName;

	/**
	 * 拓展值
	 */
	private String refValue;

	/**
	 * 对应产品
	 */
	private Integer cdItemId;

	/**
	 * 份数
	 */
	private Integer refCount;

	public Integer getCdItemRefId() {
		return cdItemRefId;
	}

	public void setCdItemRefId(Integer cdItemRefId) {
		this.cdItemRefId = cdItemRefId;
		if (cdItemRefId == null) {
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

	public String getRefValue() {
		return refValue;
	}

	public void setRefValue(String refValue) {
		this.refValue = refValue;
		if (refValue == null) {
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