package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class SuccessedResult implements Serializable{
	
	private boolean success;
	private Object result;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
