package com.le.leseckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.le.leseckill.pojo.Goods;
import com.le.leseckill.vo.GoodsVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author benren
 * @since 2021-10-28
 */
public interface GoodsService extends IService<Goods> {
    /**
     * 获取商品列表
     * @return
     */
    List<GoodsVO> findGoodsVO();
}
