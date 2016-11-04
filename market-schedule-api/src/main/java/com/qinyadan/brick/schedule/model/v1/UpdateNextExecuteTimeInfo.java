package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class UpdateNextExecuteTimeInfo implements Serializable{
	
	
	public String monitorId;
	public int reduceTime;
	public String nextExecuteTime;
	/**
	 * @return the monitorId
	 */
	public String getMonitorId() {
		return monitorId;
	}
	/**
	 * @param monitorId the monitorId to set
	 */
	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}
	/**
	 * @return the reduceTime
	 */
	public int getReduceTime() {
		return reduceTime;
	}
	/**
	 * @param reduceTime the reduceTime to set
	 */
	public void setReduceTime(int reduceTime) {
		this.reduceTime = reduceTime;
	}
	/**
	 * @return the nextExecuteTime
	 */
	public String getNextExecuteTime() {
		return nextExecuteTime;
	}
	/**
	 * @param nextExecuteTime the nextExecuteTime to set
	 */
	public void setNextExecuteTime(String nextExecuteTime) {
		this.nextExecuteTime = nextExecuteTime;
	}
	
	
}
