package com.qinyadan.brick.schedule.model.v1;

import java.util.List;

public class MonitorTaskInfoResuit {
	
	public Result result;
	
	public List<MonitorTaskInfo> monitorTaskInfoList;
	/**
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Result result) {
		this.result = result;
	}
	/**
	 * @return the monitorTaskInfoList
	 */
	public List<MonitorTaskInfo> getMonitorTaskInfoList() {
		return monitorTaskInfoList;
	}
	/**
	 * @param monitorTaskInfoList the monitorTaskInfoList to set
	 */
	public void setMonitorTaskInfoList(List<MonitorTaskInfo> monitorTaskInfoList) {
		this.monitorTaskInfoList = monitorTaskInfoList;
	}
	public int getMonitorTaskInfoListSize() {
	    return (this.monitorTaskInfoList == null) ? 0 : this.monitorTaskInfoList.size();
	  }
	
}
