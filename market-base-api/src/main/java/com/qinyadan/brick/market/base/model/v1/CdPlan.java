package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CdPlan implements Serializable {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 计划名称
	 */
	private String planName;

	/**
	 * 计划创建人
	 */
	private String createUser;

	/**
	 * 计划创建时间
	 */
	private Date createTime;

	/**
	 * 配送频率（1-一天,2-一周，3-一月）
	 */
	private Integer deliveryType;

	/**
	 * 配送时间(一周的星期几，一月的几号等）
	 */
	private String deliveryTime;

	/**
	 * 配送的次数
	 */
	private Integer deliverCount;

	/**
	 * 价格
	 */
	private BigDecimal price;

	/**
	 * 是否随机
	 */
	private Integer isRandom;

	/**
	 * 产品归属的类别
	 */
	private Integer cdCategoryId;

	/**
	 * 随机数
	 */
	private Integer randomNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
		if (planName == null) {
			return;
		}
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
		if (createUser == null) {
			return;
		}
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		if (createTime == null) {
			return;
		}
	}

	public Integer getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
		if (deliveryType == null) {
			return;
		}
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
		if (deliveryTime == null) {
			return;
		}
	}

	public Integer getDeliverCount() {
		return deliverCount;
	}

	public void setDeliverCount(Integer deliverCount) {
		this.deliverCount = deliverCount;
		if (deliverCount == null) {
			return;
		}
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
		if (price == null) {
			return;
		}
	}

	public Integer getIsRandom() {
		return isRandom;
	}

	public void setIsRandom(Integer isRandom) {
		this.isRandom = isRandom;
		if (isRandom == null) {
			return;
		}
	}

	public Integer getCdCategoryId() {
		return cdCategoryId;
	}

	public void setCdCategoryId(Integer cdCategoryId) {
		this.cdCategoryId = cdCategoryId;
		if (cdCategoryId == null) {
			return;
		}
	}

	public Integer getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(Integer randomNum) {
		this.randomNum = randomNum;
		if (randomNum == null) {
			return;
		}
	}
}