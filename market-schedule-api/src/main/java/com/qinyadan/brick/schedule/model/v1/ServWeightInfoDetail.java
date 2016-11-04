package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;
import java.util.List;

public class ServWeightInfoDetail implements Serializable{

	public String servName;
	public List<ServWeightInfo> servWeightInfoList;
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
	 * @return the servWeightInfoList
	 */
	public List<ServWeightInfo> getServWeightInfoList() {
		return servWeightInfoList;
	}
	/**
	 * @param servWeightInfoList the servWeightInfoList to set
	 */
	public void setServWeightInfoList(List<ServWeightInfo> servWeightInfoList) {
		this.servWeightInfoList = servWeightInfoList;
	}
	
	
}
