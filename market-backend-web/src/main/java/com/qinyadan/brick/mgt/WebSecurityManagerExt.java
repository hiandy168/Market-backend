package com.qinyadan.brick.mgt;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.qinyadan.brick.constant.AppConstants;
import com.qinyadan.brick.market.account.api.v1.UserService;
import com.qinyadan.brick.market.account.model.v1.SysUsers;


public class WebSecurityManagerExt extends DefaultWebSecurityManager {

    @Autowired
    private UserService userService;

    protected Subject doCreateSubject(SubjectContext context) {
        Subject subject = this.getSubjectFactory().createSubject(context);
        String username = (String) subject.getPrincipal();
        if(username != null){
            SysUsers sysUsers = userService.findByUsername(username);
            if(sysUsers !=null && sysUsers.getId() != null){
                subject.getSession().setAttribute(AppConstants.SESSION_USER_ID_KEY, sysUsers.getId());
            }
        }
        return subject;
    }
}
