package com.qinyadan.brick.market.account.api.v1;

import java.util.List;

import com.qinyadan.brick.market.account.model.v1.SysRoles;
import com.qinyadan.brick.market.common.mybatis.Page;



public interface RoleService {

    /**
     * 根据角色ID查询用户
     * @param roleId
     * @param pageSize
     * @param pageNum
     * @return
     */
    public Page findUsersByRoles(String roleId, boolean chose, Integer pageSize, Integer pageNum);

    /**
     * 查询用户角色
     * @param keyValue
     * @param pageSize
     * @param pageNum
     * @return
     */
    public Page findRoles(String keyValue, Integer pageSize, Integer pageNum);

    /**
     * 获取角色
     * @param roleId
     */
    public SysRoles getRole(Integer roleId);

    /**
     * 获取角色
     * @param sysRoles
     */
    public void updateRole(SysRoles sysRoles);

    /**
     * 更新用户组信息并添加用户
     * @param sysRoles
     * @param userIdList
     */
    public void updateRole(SysRoles sysRoles, List<Integer> userIdList);

    /**
     * 创建角色
     * @param role
     * @return
     */
    public SysRoles createRole(SysRoles role);

    /**
     * 删除角色
     * @param roleId
     */
    public void deleteRole(Integer roleId);

    /**
     * 根据角色查询权限
     * @param roleId
     * @param chose
     * @param pageSize
     * @param pageNum
     * @return
     */
    public Page findPermissionByRoles(String roleId, boolean chose, Integer pageSize, Integer pageNum);

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Integer roleId, Integer... permissionIds);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void unCorrelationPermissions(Integer roleId, Integer... permissionIds);

}
