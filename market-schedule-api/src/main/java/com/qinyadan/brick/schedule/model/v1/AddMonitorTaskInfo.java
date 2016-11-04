package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class AddMonitorTaskInfo implements Serializable{
	
	public String monitorName;
	public int monitorType;
	public String executeSql;
	public int monitorThresholds;
	public int nextInterval;
	/**
	 * @return the monitorName
	 */
	public String getMonitorName() {
		return monitorName;
	}
	/**
	 * @param monitorName the monitorName to set
	 */
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	/**
	 * @return the monitorType
	 */
	public int getMonitorType() {
		return monitorType;
	}
	/**
	 * @param monitorType the monitorType to set
	 */
	public void setMonitorType(int monitorType) {
		this.monitorType = monitorType;
	}
	/**
	 * @return the executeSql
	 */
	public String getExecuteSql() {
		return executeSql;
	}
	/**
	 * @param executeSql the executeSql to set
	 */
	public void setExecuteSql(String executeSql) {
		this.executeSql = executeSql;
	}
	/**
	 * @return the monitorThresholds
	 */
	public int getMonitorThresholds() {
		return monitorThresholds;
	}
	/**
	 * @param monitorThresholds the monitorThresholds to set
	 */
	public void setMonitorThresholds(int monitorThresholds) {
		this.monitorThresholds = monitorThresholds;
	}
	/**
	 * @return the nextInterval
	 */
	public int getNextInterval() {
		return nextInterval;
	}
	/**
	 * @param nextInterval the nextInterval to set
	 */
	public void setNextInterval(int nextInterval) {
		this.nextInterval = nextInterval;
	}
	
}
