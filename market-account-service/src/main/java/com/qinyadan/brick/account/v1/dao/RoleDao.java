package com.qinyadan.brick.account.v1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qinyadan.brick.market.account.model.v1.SysRoles;
import com.qinyadan.brick.market.account.model.v1.SysRolesPermissions;
import com.qinyadan.brick.market.account.model.v1.UserGroupRelation;
import com.qinyadan.brick.market.common.mybatis.BaseDao;
import com.qinyadan.brick.market.common.mybatis.Page;


@Repository
public interface RoleDao extends BaseDao<SysRoles>{
	
	public Page<UserGroupRelation> findUsersByRolesId(@Param(value = "map")Map map,@Param(value = "pageSize")int pageSize,@Param(value = "pageNum")int pageNum);
	
	public int saveSysRP(SysRolesPermissions sysRolesPermissions);
	
	public List<SysRoles> selectPageByModel(@Param(value = "sysRoles")SysRoles sysRoles,@Param(value = "limit")int pageSize,@Param(value = "offset")int pageNum);
}
