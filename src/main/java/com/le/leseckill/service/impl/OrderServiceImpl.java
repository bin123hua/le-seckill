package com.le.leseckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.le.leseckill.mapper.OrderMapper;
import com.le.leseckill.pojo.Order;
import com.le.leseckill.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author benren
 * @since 2021-10-28
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
