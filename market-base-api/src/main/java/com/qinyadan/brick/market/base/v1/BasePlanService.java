package com.qinyadan.brick.market.base.v1;

import com.qinyadan.brick.market.base.model.v1.CdPlan;
import com.qinyadan.brick.market.base.model.v1.CreatePlan;
import com.qinyadan.brick.market.base.model.v1.PlanModel;
import com.qinyadan.brick.market.base.model.v1.UpdatePlan;
import com.qinyadan.brick.market.common.mybatis.Page;

public interface BasePlanService {

	public Page<PlanModel> getPlanList(String keyword, Integer limit, Integer offset);

	public CdPlan getPlan(Integer id);

	public CdPlan createPlan(CreatePlan createPlan);

	public CdPlan updatePlan(Integer id, UpdatePlan updatePlan);

	public void delete(Integer id);
}
