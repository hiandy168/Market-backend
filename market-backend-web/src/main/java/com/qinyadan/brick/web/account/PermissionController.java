package com.qinyadan.brick.web.account;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qinyadan.brick.log.Log;
import com.qinyadan.brick.market.account.api.v1.PermissionService;
import com.qinyadan.brick.market.account.api.v1.RoleService;
import com.qinyadan.brick.market.account.api.v1.UserService;
import com.qinyadan.brick.market.account.model.v1.CreatePermissionVo;
import com.qinyadan.brick.market.account.model.v1.SysPermissions;
import com.qinyadan.brick.market.common.mybatis.Page;


@RestController
public class PermissionController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;


    /**
     * 权限权限
     * @return
     */
    @RequestMapping(value = "/user/permissions", method = RequestMethod.GET)
    public Map getPermission(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Set<String> roles = userService.findRoles(username);
        Set<String> permissions = userService.findPermissions(username);
        Map rolesMap = new HashMap();
        rolesMap.put("roles", roles);
        rolesMap.put("permissions", permissions);
        return rolesMap;
    }

    /**
     * 权限列表
     * @param limit
     * @param offset
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    @Log(actionName = "查看权限列表")
    public Page<SysPermissions> getPermissionList(@RequestParam(value = "limit") Integer limit,
                                        @RequestParam(value = "offset") Integer offset,
                                        @RequestParam(value = "keyword", required = false) String keyword){
        SysPermissions sysPermissions = new SysPermissions();
        sysPermissions.setDescription("%" + StringUtils.trimToEmpty(keyword) + "%");
        sysPermissions.setPermission("%" + StringUtils.trimToEmpty(keyword) + "%");
        return permissionService.selectPageByModel(sysPermissions, limit, offset);
    }

    /**
     *  权限资源
     * @param id
     */
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.GET)
    @Log(actionName = "查询单个权限")
    public SysPermissions getPermission(@PathVariable(value = "id") Integer id){
        return permissionService.selectByPrimaryKey(id);
    }

    /**
     * 新增权限
     * @param createPermissionVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/permission", method = RequestMethod.POST)
    @Log(actionName = "新增权限资源")
    public SysPermissions createPermission(@RequestBody  CreatePermissionVo createPermissionVo, BindingResult bindingResult)  {
        
        SysPermissions sysPermissions = new SysPermissions();
        sysPermissions.setDescription(createPermissionVo.getDescription());
        sysPermissions.setPermission(createPermissionVo.getPermissionCode().toUpperCase());
        sysPermissions.setAvailable(createPermissionVo.getAvailable() != null && createPermissionVo.getAvailable() ? 1 : 0);
        return permissionService.createPermission(sysPermissions);
    }

    /**
     *  删除权限
     * @param id
     */
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.DELETE)
    @Log(actionName = "删除权限资源")
    public void deletePermission(@PathVariable(value = "id") Long id){
    	//permissionService.deleteByPrimaryKey(id);
    }

}
