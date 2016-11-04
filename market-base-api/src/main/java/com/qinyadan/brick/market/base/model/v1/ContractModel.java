package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ContractModel implements Serializable {
	private Integer id;
	/**
	 * 合同名称
	 */
	private String contractName;
	/**
	 * 合同编号
	 */
	private String contractCode;
	/**
	 * 合同价的客户
	 */
	private Integer cdMemberId;
	/**
	 * 单位名称
	 */
	private String companyName;
	/**
	 * 合同价的单位
	 */
	private Integer cdCompanyId;

	/**
	 * 1-部分产品，2-全部产品
	 */
	private Integer scope;

	/**
	 * 仅当适用范围为全部产品时适用
	 */
	private BigDecimal contractPrice;

	/**
	 * 合同开始时间
	 */
	private Date beginTime;

	/**
	 * 合同开始时间
	 */
	private Date endTime;

	/**
	 * 是否作废
	 */
	private int isDel;

	private List<ContractItemModel> contractItemList;
}
