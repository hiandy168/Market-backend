package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;
import java.util.List;

public class QuartzInfoListResult implements Serializable{

	public Result result;
	public int total;
	public List<QuartzInfo> quartzInfo;
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
	 * @return the quartzInfo
	 */
	public List<QuartzInfo> getQuartzInfo() {
		return quartzInfo;
	}
	/**
	 * @param quartzInfo the quartzInfo to set
	 */
	public void setQuartzInfo(List<QuartzInfo> quartzInfo) {
		this.quartzInfo = quartzInfo;
	}
	
	
}
