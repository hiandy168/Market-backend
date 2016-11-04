package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class QuartzInfoPaginateResult implements Serializable{

	public Result result;
	public QuartzInfoPaginate quartzInfoPaginate;
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
	 * @return the quartzInfoPaginate
	 */
	public QuartzInfoPaginate getQuartzInfoPaginate() {
		return quartzInfoPaginate;
	}
	/**
	 * @param quartzInfoPaginate the quartzInfoPaginate to set
	 */
	public void setQuartzInfoPaginate(QuartzInfoPaginate quartzInfoPaginate) {
		this.quartzInfoPaginate = quartzInfoPaginate;
	}
	
	
}
