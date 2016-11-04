package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class ServWeightInfo implements Serializable{
	
	public String ip;
	public String isEnable;
	public String weight;
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the isEnable
	 */
	public String getIsEnable() {
		return isEnable;
	}
	/**
	 * @param isEnable the isEnable to set
	 */
	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}
	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	
}
