package com.le.leseckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.le.leseckill.pojo.User;
import com.le.leseckill.vo.LoginVo;
import com.le.leseckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author benren
 * @since 2021-10-23
 */
public interface ITUserService extends IService<User> {

    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据cookie获取用户对象
     * @param userTicket
     * @return
     */
    User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response);
}
