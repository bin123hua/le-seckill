package com.le.leseckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.le.leseckill.pojo.TUser;
import com.le.leseckill.vo.LoginVo;
import com.le.leseckill.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author benren
 * @since 2021-10-23
 */
public interface ITUserService extends IService<TUser> {

    RespBean doLogin(LoginVo loginVo);
}
