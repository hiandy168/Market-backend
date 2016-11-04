package com.qinyadan.brick.market.account.api.v1;

import java.util.List;

import com.qinyadan.brick.market.account.model.v1.OrganizationModel;
import com.qinyadan.brick.market.account.model.v1.SysOrganization;

public interface OrganizationService {
	
	public List<OrganizationModel> getOrganizationTree(Integer id);
	
	public SysOrganization createOrganization(SysOrganization sysOrganization);
	
	public int delete(int id);
	
	public int updateOrganization(SysOrganization sysOrganization);
	
	public int bindOrganizationUser(int id,Integer[] ids);
	
	public int unBindOrganizationUser(int id,Integer[] ids);
}
