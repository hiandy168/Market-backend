package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class QuartzInfo implements Serializable{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = -3927118089200519962L;
	
	public int taskId;
    public String taskName;
    public String taskGroup;
    public String taskExpress;
    public String taskDes;
    public String taskUrl;
    public String taskKey;
    public QuartzStateEnum taskStatus;
    public String createTime;
    public String lastUpdateTime;
	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
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
	/**
	 * @return the taskGroup
	 */
	public String getTaskGroup() {
		return taskGroup;
	}
	/**
	 * @param taskGroup the taskGroup to set
	 */
	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}
	/**
	 * @return the taskExpress
	 */
	public String getTaskExpress() {
		return taskExpress;
	}
	/**
	 * @param taskExpress the taskExpress to set
	 */
	public void setTaskExpress(String taskExpress) {
		this.taskExpress = taskExpress;
	}
	/**
	 * @return the taskDes
	 */
	public String getTaskDes() {
		return taskDes;
	}
	/**
	 * @param taskDes the taskDes to set
	 */
	public void setTaskDes(String taskDes) {
		this.taskDes = taskDes;
	}
	/**
	 * @return the taskUrl
	 */
	public String getTaskUrl() {
		return taskUrl;
	}
	/**
	 * @param taskUrl the taskUrl to set
	 */
	public void setTaskUrl(String taskUrl) {
		this.taskUrl = taskUrl;
	}
	/**
	 * @return the taskKey
	 */
	public String getTaskKey() {
		return taskKey;
	}
	/**
	 * @param taskKey the taskKey to set
	 */
	public void setTaskKey(String taskKey) {
		this.taskKey = taskKey;
	}
	/**
	 * @return the taskStatus
	 */
	public QuartzStateEnum getTaskStatus() {
		return taskStatus;
	}
	/**
	 * @param taskStatus the taskStatus to set
	 */
	public void setTaskStatus(QuartzStateEnum taskStatus) {
		this.taskStatus = taskStatus;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the lastUpdateTime
	 */
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	/**
	 * @param lastUpdateTime the lastUpdateTime to set
	 */
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	  
	  
	  
}
