package com.qinyadan.brick.web.core;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qinyadan.brick.market.account.api.v1.UserService;
import com.qinyadan.brick.market.account.model.v1.CreateUser;
import com.qinyadan.brick.market.account.model.v1.SysUsers;


@Controller
public class CoreController {

    private static Logger logger = LoggerFactory.getLogger(CoreController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/")
    public String index(){
        return "redirect:/index.html";
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, Model model){
        if(SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:/";
        }
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }

    

    @RequestMapping(value = "/register")
    public String register(@ModelAttribute  RegisterDto registerDto,
                           BindingResult bindingResult,
                           HttpServletRequest request,
                           Model model) {
        if (!WebUtils.toHttp(request).getMethod().equalsIgnoreCase("POST")){
            return "register";
        }
        if(!bindingResult.hasErrors()){
            CreateUser user = new CreateUser();
            user.setUsername(registerDto.getUsername());
            user.setPassword(registerDto.getPassword());
            SysUsers sysUsers = userService.createUser(user);
            if(sysUsers.getId() != null && sysUsers.getId() > 0 ){
                return "login";
            }else{
                logger.error("注册成功后返回的主键为空（或主键等于或小于0）");
                model.addAttribute("error", "注册用户失败");
                return "register";
            }
        }else{
            model.addAttribute("error", bindingResult.getFieldError().getDefaultMessage());
            return "register";
        }
    }

}
