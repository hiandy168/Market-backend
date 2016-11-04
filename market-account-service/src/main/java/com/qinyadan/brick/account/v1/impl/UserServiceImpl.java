package com.qinyadan.brick.account.v1.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.qinyadan.brick.account.v1.PasswordHelper;
import com.qinyadan.brick.account.v1.dao.UserDao;
import com.qinyadan.brick.market.account.api.v1.UserService;
import com.qinyadan.brick.market.account.model.v1.CreateUser;
import com.qinyadan.brick.market.account.model.v1.SysPermissions;
import com.qinyadan.brick.market.account.model.v1.SysRoles;
import com.qinyadan.brick.market.account.model.v1.SysUserOrganization;
import com.qinyadan.brick.market.account.model.v1.SysUsers;
import com.qinyadan.brick.market.account.model.v1.SysUsersRoles;
import com.qinyadan.brick.market.account.model.v1.UpdateUserVo;
import com.qinyadan.brick.market.account.model.v1.User;
import com.qinyadan.brick.market.common.base.AbstractService;
import com.qinyadan.brick.market.common.mybatis.Page;

public class UserServiceImpl extends AbstractService<User> implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private PasswordHelper passwordHelper;

	@Autowired
	private UserDao userDao;

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	@Transactional
	@Override
	public SysUsers createUser(CreateUser user) {
		// 加密密码
		String salt = passwordHelper.getSalt();
		String newPassword = passwordHelper.encryptPassword(user.getPassword(), salt);
		SysUsers sysUsers = new SysUsers();
		sysUsers.setSalt(UUID.randomUUID().toString().toUpperCase());
		sysUsers.setUsername(user.getUsername());
		sysUsers.setEmail(user.getEmail());
		sysUsers.setRealname(user.getRealname());
		sysUsers.setAge(user.getAge());
		sysUsers.setOfficeTel(user.getOfficeTel());
		sysUsers.setPhoneNumber(user.getPhoneNumber());
		sysUsers.setQq(user.getQq());
		sysUsers.setSex(user.getSex());
		sysUsers.setSalt(salt);
		sysUsers.setPassword(newPassword);
		sysUsers.setLocked(user.getLocked() ? 1 : 0);
		
		logger.info("时间为："+ new Date() + " 添加了新用户；用户名为:"+user.getUsername());
		
		userDao.saveByModel(sysUsers);
		for (int userGroupId : user.getUserGroupIds()) {
			SysUsersRoles userRoles = new SysUsersRoles();
			userRoles.setRoleId(userGroupId);
			userRoles.setUserId(sysUsers.getId());
			userDao.saveSysUR(userRoles);
		}
		SysUserOrganization userOrganization = new SysUserOrganization();
		userOrganization.setOrganizationId(user.getOrganizationId());
		userOrganization.setUserId(sysUsers.getId());
		userDao.saveSysUO(userOrganization);
		return sysUsers;
	}

	/**
	 * 更新用户
	 *
	 * @param updateUserVo
	 */
	@Transactional
	@Override
	public void updateUser(UpdateUserVo updateUserVo) {
		
		SysUsers sysUsers = new SysUsers();
		sysUsers.setId(updateUserVo.getId());
		sysUsers.setUsername(updateUserVo.getUsername());
		sysUsers.setEmail(updateUserVo.getEmail());
		sysUsers.setLocked(updateUserVo.getLocked() ? 1 : 0);
		sysUsers.setAge(updateUserVo.getAge());
		sysUsers.setOfficeTel(updateUserVo.getOfficeTel());
		sysUsers.setPhoneNumber(updateUserVo.getPhoneNumber());
		sysUsers.setSex(updateUserVo.getSex());
		sysUsers.setQq(updateUserVo.getQq());
		sysUsers.setRealname(updateUserVo.getRealName());
		// 更新权限
		userDao.deleteURBySysUserId(sysUsers.getId());

		for (int userGroupId : updateUserVo.getUserGroupIds()) {
			SysUsersRoles userRoles = new SysUsersRoles();
			userRoles.setRoleId(userGroupId);
			userRoles.setUserId(sysUsers.getId());
			userDao.saveSysUR(userRoles);
		}

		userDao.deleteOrgBySysUserId(sysUsers.getId());
		
		SysUserOrganization userOrganization = new SysUserOrganization();
		userOrganization.setOrganizationId(updateUserVo.getOrganizationId());
		userOrganization.setUserId(sysUsers.getId());
		userDao.saveSysUO(userOrganization);
		
		userDao.saveByModel(sysUsers);
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	@Transactional
	@Override
	public void changePassword(Integer userId, String newPassword) {
		SysUsers user = userDao.selectByPrimaryKey(userId);
		String salt = passwordHelper.getSalt();
		user.setPassword(newPassword);
		user.setSalt(salt);
		passwordHelper.encryptPassword(user.getPassword(), salt);
		userDao.updateByModel(user);
	}

	@Override
	public void changePassword(String username, String currentPassword, String newPassword) {
		SysUsers sysUsers = new SysUsers();
		sysUsers.setUsername(username);
		sysUsers = userDao.selectOneByModel(sysUsers);
		String currentRealPwd = passwordHelper.encryptPassword(currentPassword, sysUsers.getSalt());
		if (sysUsers == null || !sysUsers.getPassword().equals(currentRealPwd)) {
			throw new IllegalArgumentException("当前密码错误");
		}
		String newSalt = passwordHelper.getSalt();
		String newCurrentRealPwd = passwordHelper.encryptPassword(newPassword, newSalt);
		userDao.resetPassword(username, currentRealPwd, newCurrentRealPwd, newSalt);
	}

	/**
	 * 添加用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	@Transactional
	public void correlationRoles(Integer userId, Integer... roleIds) {
		for (int i = 0; i < roleIds.length; i++) {
			Integer roleId = roleIds[i];
			SysUsersRoles sysUsersRoles = new SysUsersRoles();
			sysUsersRoles.setUserId(userId);
			sysUsersRoles.setRoleId(roleId);
			userDao.saveSysUR(sysUsersRoles);
		}
	}

	/**
	 * 移除用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	@Override
	public void uncorrelationRoles(Integer userId, Integer... roleIds) {
		userDao.deleteURByIds(userId,roleIds);
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	@Override
	public SysUsers findByUsername(String username) {
		SysUsers sysUsers = new SysUsers();
		sysUsers.setUsername(username);
		
		//...
		return userDao.selectOneByModel(sysUsers);
	}

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	@Override
	public Set<String> findRoles(String username) {
		List<SysRoles> sysRolesList = userDao.getRoleList(username);
		Set<String> roles = new HashSet<String>();
		for (int i = 0; i < sysRolesList.size(); i++) {
			roles.add(sysRolesList.get(i).getRole());
		}
		return roles;
	}

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	@Override
	public Set<String> findPermissions(String username) {
		List<SysPermissions> sysPermissionsList = userDao.getPermissionList(username);
		Set<String> permissions = new HashSet<String>();
		for (int i = 0; i < sysPermissionsList.size(); i++) {
			permissions.add(sysPermissionsList.get(i).getPermission());
		}
		return permissions;
	}

	public void setPasswordHelper(PasswordHelper passwordHelper) {
		this.passwordHelper = passwordHelper;
	}

	@Override
	public Page<User> getUsers(Map<String, Object> map, int limit, int offset) {
		List<User> result = userDao.getUsers(map, limit, offset);
		List<User> allresult = userDao.getUsers(map, 0, 0);
		return getPageResult(result,allresult,limit,offset);
	}
	
	
}
