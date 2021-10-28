package com.le.leseckill.controller;

import com.le.leseckill.pojo.User;
import com.le.leseckill.service.GoodsService;
import com.le.leseckill.service.ITUserService;
import com.le.leseckill.vo.RespBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    
    @Autowired
    private ITUserService userService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 跳转到商品列表页
     * @param
     * @param model
     * @param
     * @return
     */
    @RequestMapping("/toList")
    public String toList(Model model, User user){
    /*   if (StringUtils.isEmpty(ticket)){
           return "login";
       }
       //User user =(User) session.getAttribute(ticket);
        User user = userService.getUserByCookie(ticket, request, response);
        if (null==user){
           return "login";
       }*/
       model.addAttribute("user",user);
       model.addAttribute("goodsList",goodsService.findGoodsVO());
       return "goodsList";
    }
}
