package com.qinyadan.brick.account.v1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qinyadan.brick.market.account.model.v1.SysPermissions;
import com.qinyadan.brick.market.account.model.v1.SysRoles;
import com.qinyadan.brick.market.account.model.v1.SysUserOrganization;
import com.qinyadan.brick.market.account.model.v1.SysUsers;
import com.qinyadan.brick.market.account.model.v1.SysUsersRoles;
import com.qinyadan.brick.market.account.model.v1.User;
import com.qinyadan.brick.market.common.mybatis.BaseDao;
import com.qinyadan.brick.market.common.mybatis.Page;

@Repository
public interface UserDao extends BaseDao<SysUsers>{
	
	/**
	 * 保存用户角色
	 * @param sysUsersRoles
	 * @return
	 */
	public int saveSysUR(SysUsersRoles sysUsersRoles);
	/**
	 * 保存用户组织
	 * @param sysUserOrganization
	 * @return
	 */
	public int saveSysUO(SysUserOrganization sysUserOrganization);
	
	public int deleteURBySysUserId(int id);
	
	public int deleteOrgBySysUserId(int id);
	
	public int resetPassword(@Param(value = "username") String username,
            @Param(value = "currentPassword") String currentPassword,
            @Param(value = "password") String password,
            @Param(value = "salt") String salt);
	
	public List<SysRoles> getRoleList(String username);
	 
	public List<SysPermissions> getPermissionList(String username);
	
	public int deleteURByIds(Integer userId, Integer[] roleIds);
	
	public List<User> getUsers(@Param(value = "map")Map<String, Object> map,@Param(value = "limit")int limit,@Param(value = "offset")int offset);
}
