package com.qinyadan.brick.market.account.api.v1;

import com.qinyadan.brick.market.account.model.v1.SysPermissions;
import com.qinyadan.brick.market.common.mybatis.Page;


public interface PermissionService {
    /**
     * 创建权限资源
     * @param permission
     * @return
     */
    public SysPermissions createPermission(SysPermissions permission);

    /**
     * 删除权限资源
     * @param permissionId
     */
    public void deletePermission(int permissionId);
    
    /**
     * 分页查询系统权限
     * @param sysPermissions
     * @param limit
     * @param offset
     * @return
     */
    public Page<SysPermissions> selectPageByModel(SysPermissions sysPermissions,int limit,int offset);
    
    public SysPermissions selectByPrimaryKey(int id);
}
