package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;
import java.util.List;

public class ServEndpointInfoListResult implements Serializable{
	
	
	  public Result result;
	  public int total;
	  public List<ServEndpointInfo> servEndpointInfoList;
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
	 * @return the servEndpointInfoList
	 */
	public List<ServEndpointInfo> getServEndpointInfoList() {
		return servEndpointInfoList;
	}
	/**
	 * @param servEndpointInfoList the servEndpointInfoList to set
	 */
	public void setServEndpointInfoList(List<ServEndpointInfo> servEndpointInfoList) {
		this.servEndpointInfoList = servEndpointInfoList;
	}
	  
	  
}
