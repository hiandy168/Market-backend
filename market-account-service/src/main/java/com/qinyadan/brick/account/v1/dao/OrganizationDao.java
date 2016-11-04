package com.qinyadan.brick.account.v1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qinyadan.brick.market.account.model.v1.OrganizationModel;
import com.qinyadan.brick.market.account.model.v1.SysOrganization;
import com.qinyadan.brick.market.common.mybatis.BaseDao;


@Repository
public interface OrganizationDao extends BaseDao<SysOrganization>{
	
	public List<SysOrganization> selectByModel(SysOrganization sysOrganization);
	
	public List<OrganizationModel> getOrganizationTree(@Param(value = "id") Integer id);
	
}
