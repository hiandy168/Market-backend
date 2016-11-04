package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class FailDesc implements Serializable{

	public String name;
	public String failCode;
	public String desc;
	
	public FailDesc(){
		
	}
	public FailDesc(String name,String failCode,String desc){
		this.name = name;
		this.failCode = failCode;
		this.desc = desc;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the failCode
	 */
	public String getFailCode() {
		return failCode;
	}
	/**
	 * @param failCode the failCode to set
	 */
	public void setFailCode(String failCode) {
		this.failCode = failCode;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
