package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CdActivity implements Serializable {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 活动名称
	 */
	private String activityName;

	/**
	 * 活动开始时间
	 */
	private Date activityBeginTime;

	/**
	 * 活动结束时间
	 */
	private Date activityEndTime;

	/**
	 * 活动介绍
	 */
	private String activityDescribe;

	/**
	 * 参与活动的卡类型
	 */
	private Integer activityType;

	/**
	 * 是否启用（0-不启用，1-启用）
	 */
	private Integer available;

	/**
	 * 最低配送金额
	 */
	private BigDecimal lowestPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
		if (activityName == null) {
			return;
		}
	}

	public Date getActivityBeginTime() {
		return activityBeginTime;
	}

	public void setActivityBeginTime(Date activityBeginTime) {
		this.activityBeginTime = activityBeginTime;
		if (activityBeginTime == null) {
			return;
		}
	}

	public Date getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
		if (activityEndTime == null) {
			return;
		}
	}

	public String getActivityDescribe() {
		return activityDescribe;
	}

	public void setActivityDescribe(String activityDescribe) {
		this.activityDescribe = activityDescribe;
		if (activityDescribe == null) {
			return;
		}
	}

	public Integer getActivityType() {
		return activityType;
	}

	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
		if (activityType == null) {
			return;
		}
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
		if (available == null) {
			return;
		}
	}

	public BigDecimal getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(BigDecimal lowestPrice) {
		this.lowestPrice = lowestPrice;
		if (lowestPrice == null) {
			return;
		}
	}
}