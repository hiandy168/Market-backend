package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class QuartzInfoResult implements Serializable{
	
	
	public Result result;
	public QuartzInfo quartzInfo;
	public int failCode;
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
	 * @return the quartzInfo
	 */
	public QuartzInfo getQuartzInfo() {
		return quartzInfo;
	}
	/**
	 * @param quartzInfo the quartzInfo to set
	 */
	public void setQuartzInfo(QuartzInfo quartzInfo) {
		this.quartzInfo = quartzInfo;
	}
	/**
	 * @return the failCode
	 */
	public int getFailCode() {
		return failCode;
	}
	/**
	 * @param failCode the failCode to set
	 */
	public void setFailCode(int failCode) {
		this.failCode = failCode;
	}
	
	
}
