package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class StringResult implements Serializable{

	public Result result;
	public String value;
	public String extend;
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the extend
	 */
	public String getExtend() {
		return extend;
	}
	/**
	 * @param extend the extend to set
	 */
	public void setExtend(String extend) {
		this.extend = extend;
	}
	
	

}
