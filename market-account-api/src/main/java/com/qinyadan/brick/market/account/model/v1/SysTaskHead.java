package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class SysTaskHead implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1318715784061280184L;

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 任务名称
	 */
	private String taskName;

	/**
	 * 任务描述
	 */
	private String taskDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
		if (taskName == null) {
			return;
		}
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
		if (taskDesc == null) {
			return;
		}
	}
}