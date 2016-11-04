package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;
import java.util.List;

public class ServEndpointInfo implements Serializable{
	
	public String servName;
	public List<String> endPointList;
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
	 * @return the endPointList
	 */
	public List<String> getEndPointList() {
		return endPointList;
	}
	/**
	 * @param endPointList the endPointList to set
	 */
	public void setEndPointList(List<String> endPointList) {
		this.endPointList = endPointList;
	}
	
	
}
