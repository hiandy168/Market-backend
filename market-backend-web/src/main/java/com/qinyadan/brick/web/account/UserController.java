package com.qinyadan.brick.web.account;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qinyadan.brick.log.Log;
import com.qinyadan.brick.market.account.api.v1.UserService;
import com.qinyadan.brick.market.account.model.v1.CreateUser;
import com.qinyadan.brick.market.account.model.v1.CreateUserVo;
import com.qinyadan.brick.market.account.model.v1.SysUsers;
import com.qinyadan.brick.market.account.model.v1.UpdateUserVo;
import com.qinyadan.brick.market.account.model.v1.User;
import com.qinyadan.brick.market.common.mybatis.Page;


@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     *  用户列表
     * @param id
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @Log(actionName = "查询用户列表")
    public Page<User> getUserList(@RequestParam(value = "limit") Integer limit,
                                  @RequestParam(value = "offset") Integer offset,
                                  @RequestParam(value = "id", required = false) Integer id,
                                  @RequestParam(value = "keyword", required = false) String keyword,
                                  @RequestParam(value = "organizationId",required = false) Integer organizationId){
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("id", id);
        map.put("keyword", keyword);
        map.put("organizationId", organizationId);
        
        Page<User> pageUserList = userService.getUsers(map,limit,offset);
        
        return pageUserList;
        
    }

    /**
     *  用户列表
     * @param id
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @Log(actionName = "查询用户")
    public SysUsers getUserList(@PathVariable(value = "id") Integer id){
        return null;//userService.selectByPrimaryKey(id);
    }

    /**
     * 新增用户
     * @param createUser
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @Log(actionName = "新增用户")
    public SysUsers createUser(@RequestBody  CreateUserVo createUser, BindingResult bindingResult) {
        
        CreateUser user = new CreateUser();
        user.setAge(createUser.getAge());
        user.setOfficeTel(createUser.getOfficeTel());
        user.setPhoneNumber(createUser.getPhoneNumber());
        user.setQq(createUser.getQq());
        user.setRealname(createUser.getRealName());
        user.setSex(createUser.getSex());
        user.setUsername(createUser.getUsername());
        user.setPassword(createUser.getPassword());
        user.setEmail(createUser.getEmail());
        user.setLocked(createUser.getLocked() != null && createUser.getLocked() == true ? true : false);
        user.setOrganizationId(createUser.getOrganizationId());
        user.setUserGroupIds(createUser.getUserGroupIds());
        return userService.createUser(user);
    }

    /**
     * 更新用户
     * @param id
     * @param updateUserVo
     * @param bindingResult
     * @throws ArgumentValidException
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @Log(actionName = "更新用户")
    public void updateUser(@PathVariable(value = "id") Integer id,
                           @RequestBody  UpdateUserVo updateUserVo, BindingResult bindingResult)  {
        userService.updateUser(updateUserVo);
    }

    /**
     *  删除用户
     * @param id
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @Log(actionName = "删除用户")
    public void deleteUser(@PathVariable(value = "id") Long id){
        //userService.deleteByPrimaryKey(id);
    }

    /**
     *  锁定用户
     * @param id
     */
    @RequestMapping(value = "/user/{id}/locked", method = RequestMethod.PUT)
    @Log(actionName = "修改用户信息")
    public void lockedUser(@PathVariable(value = "id") Integer id,
                           @RequestParam(value = "locked") Boolean locked){
        SysUsers sysUsers = new SysUsers();
        sysUsers.setLocked(locked ? 1 : 0);
        sysUsers.setId(id);
       /// userService.updateUser(sysUsers);
    }
    
    /**
     *  重置密码
     * @param id
     */
    @RequestMapping(value = "/user/{id}/resetPassword", method = RequestMethod.PUT)
    @Log(actionName = "重置密码")
    public void resetPassword(@PathVariable(value = "id") Integer id){
        userService.changePassword(id, "123456");
    }

}
