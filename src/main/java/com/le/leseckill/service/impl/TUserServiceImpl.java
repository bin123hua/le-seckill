package com.le.leseckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.le.leseckill.mapper.TUserMapper;
import com.le.leseckill.pojo.TUser;
import com.le.leseckill.service.ITUserService;
import com.le.leseckill.utils.MD5Util;
import com.le.leseckill.utils.ValidatorUtil;
import com.le.leseckill.vo.LoginVo;
import com.le.leseckill.vo.RespBean;
import com.le.leseckill.vo.RespBeanEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author benren
 * @since 2021-10-23
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
    @Autowired
    private TUserMapper userMapper;
    @Override
    public RespBean doLogin(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!ValidatorUtil.isMobile(mobile)){

            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }
        TUser tUser = userMapper.selectById(mobile);
        System.out.println(tUser);
        if (tUser==null){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!MD5Util.fromPassTODBPass(password,tUser.getSalt()).equals(tUser.getPassword())){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        return RespBean.success();
    }
}
