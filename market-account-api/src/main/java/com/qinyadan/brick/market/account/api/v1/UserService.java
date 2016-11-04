package com.qinyadan.brick.market.account.api.v1;

import java.util.Map;
import java.util.Set;

import com.qinyadan.brick.market.account.model.v1.CreateUser;
import com.qinyadan.brick.market.account.model.v1.SysUsers;
import com.qinyadan.brick.market.account.model.v1.UpdateUserVo;
import com.qinyadan.brick.market.common.mybatis.Page;



public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    public SysUsers createUser(CreateUser user);

    /**
     * 更新用户
     * @param updateUserVo
     */
    public void updateUser(UpdateUserVo updateUserVo);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Integer userId, String newPassword);

    /**
     * 修改密码
     * @param currentPassword
     * @param newPassword
     */
    public void changePassword(String username, String currentPassword, String newPassword);

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(Integer userId, Integer... roleIds);


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(Integer userId, Integer... roleIds);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public SysUsers findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);
    /**
     * 分页查询用户
     * 
     * @param map
     * @param limit
     * @param offset
     * @return
     */
    public Page getUsers(Map<String, Object> map,int limit,int offset);

}
