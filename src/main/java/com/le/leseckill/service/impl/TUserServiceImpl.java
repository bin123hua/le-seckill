package com.le.leseckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.le.leseckill.exception.GlobalException;
import com.le.leseckill.mapper.TUserMapper;
import com.le.leseckill.pojo.User;
import com.le.leseckill.service.ITUserService;
import com.le.leseckill.utils.CookieUtil;
import com.le.leseckill.utils.MD5Util;
import com.le.leseckill.utils.UUIDUtil;
import com.le.leseckill.vo.LoginVo;
import com.le.leseckill.vo.RespBean;
import com.le.leseckill.vo.RespBeanEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author benren
 * @since 2021-10-23
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, User> implements ITUserService {
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
    /*    if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!ValidatorUtil.isMobile(mobile)){

            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }*/
        User user = userMapper.selectById(mobile);
        System.out.println(user);
        if (user ==null){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!MD5Util.fromPassTODBPass(password, user.getSalt()).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        String ticket = UUIDUtil.uuid();
        //讲用户信息存入redis中
        redisTemplate.opsForValue().set("user:"+ticket,user);
        //request.getSession().setAttribute(ticket, user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success();
    }
    
    @Override
    public User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response) {
        if (StringUtils.isEmpty(userTicket)){
            return null;
        }
       User user  = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        if (null!=user){
            CookieUtil.setCookie(request,response,"userTicket",userTicket);
        }
        return user;
    }
}
