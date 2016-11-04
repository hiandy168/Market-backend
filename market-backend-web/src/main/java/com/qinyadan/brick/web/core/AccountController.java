package com.qinyadan.brick.web.core;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qinyadan.brick.market.account.api.v1.UserService;

@RestController
public class AccountController {

    @Autowired
    private UserService userService;

    /**
     * 用户设置
     * @return
     */
    @RequestMapping(value = "/account/setting", method = RequestMethod.GET)
    public AccountSettingDto accountSetting(){
        AccountSettingDto accountSettingDto = new AccountSettingDto();
        Subject subject = SecurityUtils.getSubject();
        if(subject == null){
            return null;
        }
        String username = subject.getPrincipal().toString();
        accountSettingDto.setUsername(username);
        Set<String> roles = userService.findRoles(username);
        return accountSettingDto;
    }

    /**
     * 用户修改密码
     * @return
     */
    @RequestMapping(value = "/account/resetPassword", method = RequestMethod.POST)
    public void resetPassword(@RequestParam(value = "current_password") String currentPassword,
                              @RequestParam(value = "password") String password){
        Subject subject = SecurityUtils.getSubject();
        String username = subject.getPrincipal().toString();
        userService.changePassword(username, currentPassword, password);
    }


}
