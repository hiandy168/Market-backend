package com.qinyadan.brick.account.v1.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.qinyadan.brick.account.v1.dao.RoleDao;
import com.qinyadan.brick.market.account.api.v1.RoleService;
import com.qinyadan.brick.market.account.api.v1.UserService;
import com.qinyadan.brick.market.account.model.v1.GroupPermissionRelation;
import com.qinyadan.brick.market.account.model.v1.SysRoles;
import com.qinyadan.brick.market.account.model.v1.SysRolesPermissions;
import com.qinyadan.brick.market.account.model.v1.UserGroupRelation;
import com.qinyadan.brick.market.common.base.AbstractService;
import com.qinyadan.brick.market.common.mybatis.Page;

public class RoleServiceImpl extends  AbstractService<SysRoles> implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	UserService userService;

	/**
	 * 根据角色ID查询用户
	 *
	 * @param roleId
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	@Override
	public Page<UserGroupRelation> findUsersByRoles(String roleId, boolean chose, Integer pageSize, Integer pageNum) {
		Map map = new HashMap();
		map.put("id", roleId);
		map.put("chose", chose);

		Page<UserGroupRelation> result = new Page<UserGroupRelation>();
		result = roleDao.findUsersByRolesId(map, pageSize, pageNum);

		return result;
	}

	@Override
	public Page<SysRoles> findRoles(String keyValue, Integer pageSize, Integer pageNum) {
		SysRoles sysRoles = new SysRoles();

		sysRoles.setRole(keyValue);
		sysRoles.setDescription(keyValue);
		
		List<SysRoles> curPageList = roleDao.selectPageByModel(sysRoles, pageSize, pageNum);
		List<SysRoles> totalPageList = roleDao.selectPageByModel(sysRoles, 0, 0);
		
		return getPageResult(curPageList, totalPageList,pageSize, pageNum);
	}

	/**
	 * 获取角色
	 *
	 * @param roleId
	 */
	@Override
	public SysRoles getRole(Integer roleId) {
		return roleDao.selectByPrimaryKey(roleId);
	}

	/**
	 * 更新角色
	 *
	 * @param sysRoles
	 */
	@Override
	public void updateRole(SysRoles sysRoles) {
		roleDao.updateByModel(sysRoles);
	}

	/**
	 * 更新用户组信息并添加用户
	 *
	 * @param sysRoles
	 * @param userIdList
	 */
	@Override
	@Transactional
	public void updateRole(SysRoles sysRoles, List<Integer> userIdList) {
		roleDao.updateByModel(sysRoles);
		for (Integer userId : userIdList) {
			userService.correlationRoles(userId, sysRoles.getId());
		}
	}

	public SysRoles createRole(SysRoles role) {
		roleDao.saveByModel(role);
		return role;
	}

	public void deleteRole(Integer roleId) {
		roleDao.deleteByPrimaryKey(roleId);
	}

	@Override
	public Page<GroupPermissionRelation> findPermissionByRoles(String roleId, boolean chose, Integer pageSize,
			Integer pageNum) {
		Map map = new HashMap();
		map.put("id", roleId);
		map.put("chose", chose);
		return null ; //(Page<GroupPermissionRelation>) mybatisDao
				//.selectPage(UserMapper.UserMapperNameSpace + "findPermissionByRole", map, pageSize, pageNum);
	}

	/**
	 * 添加角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	@Override
	public void correlationPermissions(Integer roleId, Integer... permissionIds) {
		for (Integer permissionId : permissionIds) {
			SysRolesPermissions sysRolesPermissionsKey = new SysRolesPermissions();
			sysRolesPermissionsKey.setPermissionId(permissionId);
			sysRolesPermissionsKey.setRoleId(roleId);
			roleDao.saveSysRP(sysRolesPermissionsKey);
		}
	}

	/**
	 * 移除角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void unCorrelationPermissions(Integer roleId, Integer... permissionIds) {
		/*SysRolesPermissionsExample sysRolesPermissionsExample = new SysRolesPermissionsExample();
		sysRolesPermissionsExample.createCriteria().andRoleIdEqualTo(roleId)
				.andPermissionIdIn(Arrays.asList(permissionIds));
		mybatisDao.deleteByExample(sysRolesPermissionsExample);*/
	}

}
