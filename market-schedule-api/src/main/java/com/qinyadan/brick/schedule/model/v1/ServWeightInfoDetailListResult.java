package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;
import java.util.List;

public class ServWeightInfoDetailListResult implements Serializable{
	
	public Result result;
	public int total;
	public List<ServWeightInfoDetail> servWeightInfoDetailList;
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
	 * @return the servWeightInfoDetailList
	 */
	public List<ServWeightInfoDetail> getServWeightInfoDetailList() {
		return servWeightInfoDetailList;
	}
	/**
	 * @param servWeightInfoDetailList the servWeightInfoDetailList to set
	 */
	public void setServWeightInfoDetailList(List<ServWeightInfoDetail> servWeightInfoDetailList) {
		this.servWeightInfoDetailList = servWeightInfoDetailList;
	}
	
	
}
