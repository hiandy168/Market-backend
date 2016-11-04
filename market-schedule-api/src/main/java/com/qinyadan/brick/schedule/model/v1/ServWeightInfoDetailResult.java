package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class ServWeightInfoDetailResult implements Serializable{
	public Result result;
	public ServWeightInfoDetail servWeightInfoDetail;
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
	 * @return the servWeightInfoDetail
	 */
	public ServWeightInfoDetail getServWeightInfoDetail() {
		return servWeightInfoDetail;
	}
	/**
	 * @param servWeightInfoDetail the servWeightInfoDetail to set
	 */
	public void setServWeightInfoDetail(ServWeightInfoDetail servWeightInfoDetail) {
		this.servWeightInfoDetail = servWeightInfoDetail;
	}
	
	
}
