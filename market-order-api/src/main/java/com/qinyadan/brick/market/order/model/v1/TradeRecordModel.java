package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public  class TradeRecordModel implements Serializable{
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
    
    private String recordUserName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getRecordUser() {
		return recordUser;
	}

	public void setRecordUser(Integer recordUser) {
		this.recordUser = recordUser;
	}

	public String getRecordUserName() {
		return recordUserName;
	}

	public void setRecordUserName(String recordUserName) {
		this.recordUserName = recordUserName;
	}
    
    
}
