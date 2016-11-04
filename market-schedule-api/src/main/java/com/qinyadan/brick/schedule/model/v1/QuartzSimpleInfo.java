package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class QuartzSimpleInfo implements Serializable{
	
	
	public String servName;
	public String taskName;
	public String taskExpress;
	public String taskDes;
	public String taskParam;
	/**
	 * @return the servName
	 */
	public String getServName() {
		return servName;
	}
	/**
	 * @param servName the servName to set
	 */
	public void setServName(String servName) {
		this.servName = servName;
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
	 * @return the taskParam
	 */
	public String getTaskParam() {
		return taskParam;
	}
	/**
	 * @param taskParam the taskParam to set
	 */
	public void setTaskParam(String taskParam) {
		this.taskParam = taskParam;
	}
	
	
}
