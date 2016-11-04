package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class CreateItemCategory implements Serializable {

	private String name;
	private Integer parentId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
