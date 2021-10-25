package com.le.leseckill.controller;

import com.le.leseckill.service.ITUserService;
import com.le.leseckill.vo.LoginVo;
import com.le.leseckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ldap.PagedResultsControl;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private ITUserService userService;
    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping("/tologin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo loginVo){

        return userService.doLogin(loginVo);
    }
}
