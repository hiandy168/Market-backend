package com.qinyadan.brick.account.v1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qinyadan.brick.market.account.model.v1.SysPermissions;
import com.qinyadan.brick.market.common.mybatis.BaseDao;

@Repository
public interface PermissionDao extends BaseDao<SysPermissions> {

	public List<SysPermissions> selectPageByModel(@Param("sysPermissions") SysPermissions sysPermissions,
			@Param("limit") int limit, @Param("offset") int offset);

}
