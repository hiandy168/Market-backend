package com.qinyadan.brick.account.v1.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.qinyadan.brick.account.v1.dao.PermissionDao;
import com.qinyadan.brick.market.account.api.v1.PermissionService;
import com.qinyadan.brick.market.account.model.v1.SysPermissions;
import com.qinyadan.brick.market.common.base.AbstractService;
import com.qinyadan.brick.market.common.mybatis.Page;

public class PermissionServiceImpl extends AbstractService<SysPermissions> implements PermissionService {
	
	private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	
	@Autowired
	private PermissionDao permissionDao;

	@Override
	@Transactional
	public SysPermissions createPermission(SysPermissions permission) {
		permissionDao.saveByModel(permission);
		return permission;
	}

	@Override
	@Transactional
	public void deletePermission(int permissionId) {
		logger.info("时间:"+new Date()+" 删除了权限;权限ID为"+permissionId);
		permissionDao.deleteByPrimaryKey(permissionId);
	}

	@Override
	public Page<SysPermissions> selectPageByModel(SysPermissions sysPermissions, int limit, int offset) {
		List<SysPermissions> curPageList = permissionDao.selectPageByModel(sysPermissions,limit,offset);
		List<SysPermissions> totalPageList = permissionDao.selectPageByModel(sysPermissions,0,0);
		return getPageResult(curPageList, totalPageList, limit, offset);
	}

	@Override
	public SysPermissions selectByPrimaryKey(int id) {
		return permissionDao.selectByPrimaryKey(id);
	}
}
