package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;
import java.util.List;

public class QuartzInfoPaginate implements Serializable{

	public int total;
	public int pageCount;
	public int page;
	public int perPage;
	public List<QuartzInfo> quartzInfo;
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}
	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * @return the perPage
	 */
	public int getPerPage() {
		return perPage;
	}
	/**
	 * @param perPage the perPage to set
	 */
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	/**
	 * @return the quartzInfo
	 */
	public List<QuartzInfo> getQuartzInfo() {
		return quartzInfo;
	}
	/**
	 * @param quartzInfo the quartzInfo to set
	 */
	public void setQuartzInfo(List<QuartzInfo> quartzInfo) {
		this.quartzInfo = quartzInfo;
	}
	
	
}
