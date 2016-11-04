package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbTradeRecord implements Serializable {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 交易金额
	 */
	private BigDecimal amount;

	/**
	 * 交易单号
	 */
	private String tradeNo;

	/**
	 * 交易时间
	 */
	private Date createTime;

	/**
	 * 交易类型：cash-现金，card-卡券,recharge-充值，adjustment-卡余额调整
	 */
	private String tradeType;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 记录人
	 */
	private Integer recordUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
		if (amount == null) {
			return;
		}
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
		if (tradeNo == null) {
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

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
		if (tradeType == null) {
			return;
		}
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
		if (remark == null) {
			return;
		}
	}

	public Integer getRecordUser() {
		return recordUser;
	}

	public void setRecordUser(Integer recordUser) {
		this.recordUser = recordUser;
		if (recordUser == null) {
			return;
		}
	}
}