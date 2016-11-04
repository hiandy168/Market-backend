package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable{
	
	public int code;
	public List<FailDesc> failDescList;
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the failDescList
	 */
	public List<FailDesc> getFailDescList() {
		return failDescList;
	}
	/**
	 * @param failDescList the failDescList to set
	 */
	public void setFailDescList(List<FailDesc> failDescList) {
		this.failDescList = failDescList;
	}
	
	
}
