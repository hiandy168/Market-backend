package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CreatePlan implements Serializable {
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
	 * 配送频率
	 */
	private Integer deliveryType;

	/**
	 * 配送时间(一周的星期几）
	 */
	private String deliveryTime;

	/**
	 * 配送的次数
	 */
	private Integer deliverCount;

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

	private List<PlanItemModel> planItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getDeliverCount() {
		return deliverCount;
	}

	public void setDeliverCount(Integer deliverCount) {
		this.deliverCount = deliverCount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getIsRandom() {
		return isRandom;
	}

	public void setIsRandom(Integer isRandom) {
		this.isRandom = isRandom;
	}

	public Integer getCdCategoryId() {
		return cdCategoryId;
	}

	public void setCdCategoryId(Integer cdCategoryId) {
		this.cdCategoryId = cdCategoryId;
	}

	public Integer getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(Integer randomNum) {
		this.randomNum = randomNum;
	}

	public List<PlanItemModel> getPlanItems() {
		return planItems;
	}

	public void setPlanItems(List<PlanItemModel> planItems) {
		this.planItems = planItems;
	}
	

}
