package com.le.leseckill.controller;

import com.le.leseckill.service.ITUserService;
import com.le.leseckill.vo.LoginVo;
import com.le.leseckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){

        return userService.doLogin(loginVo,request,response);
    }
}
