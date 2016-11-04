package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPurchase implements Serializable {
	/**
	 * 主键ID
	 */
	private Integer id;

	/**
	 * 采购单编号
	 */
	private String purchaseCode;

	/**
	 * 产品代码
	 */
	private String itemCode;

	/**
	 * 采购总数量
	 */
	private BigDecimal total;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 采购人员ID
	 */
	private Integer buyerId;

	/**
	 * 采购总重量
	 */
	private BigDecimal totalWeight;

	/**
	 * 分配数量
	 */
	private Integer distributeValue;

	/**
	 * 已包装数
	 */
	private Integer packageValue;

	/**
	 * 已装箱数
	 */
	private Integer packingValue;

	/**
	 * 采购状态：0-待采购，1-已采购
	 */
	private Integer purchaseStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
		if (purchaseCode == null) {
			return;
		}
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
		if (itemCode == null) {
			return;
		}
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
		if (total == null) {
			return;
		}
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
		if (createDate == null) {
			return;
		}
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
		if (buyerId == null) {
			return;
		}
	}

	public BigDecimal getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
		if (totalWeight == null) {
			return;
		}
	}

	public Integer getDistributeValue() {
		return distributeValue;
	}

	public void setDistributeValue(Integer distributeValue) {
		this.distributeValue = distributeValue;
		if (distributeValue == null) {
			return;
		}
	}

	public Integer getPackageValue() {
		return packageValue;
	}

	public void setPackageValue(Integer packageValue) {
		this.packageValue = packageValue;
		if (packageValue == null) {
			return;
		}
	}

	public Integer getPackingValue() {
		return packingValue;
	}

	public void setPackingValue(Integer packingValue) {
		this.packingValue = packingValue;
		if (packingValue == null) {
			return;
		}
	}

	public Integer getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(Integer purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
		if (purchaseStatus == null) {
			return;
		}
	}
}