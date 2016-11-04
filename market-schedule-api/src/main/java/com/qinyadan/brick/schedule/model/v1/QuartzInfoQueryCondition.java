package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class QuartzInfoQueryCondition implements Serializable{
	
	
	public int page;
	public int perPage;
	public String taskName;
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
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	
}
