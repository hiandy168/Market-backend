package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;

public class ItemQuery implements Serializable {

	private Integer id;
	private String keyword;
	private Integer sellStatus;
	private Integer companyId;
	private Integer itemType;
	private String[] itemCodes;
	private Integer[] ids;
	private Integer[] excludeIds;
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
	public Integer getSellStatus() {
		return sellStatus;
	}
	public void setSellStatus(Integer sellStatus) {
		this.sellStatus = sellStatus;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getItemType() {
		return itemType;
	}
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	public String[] getItemCodes() {
		return itemCodes;
	}
	public void setItemCodes(String[] itemCodes) {
		this.itemCodes = itemCodes;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public Integer[] getExcludeIds() {
		return excludeIds;
	}
	public void setExcludeIds(Integer[] excludeIds) {
		this.excludeIds = excludeIds;
	}
	

}
