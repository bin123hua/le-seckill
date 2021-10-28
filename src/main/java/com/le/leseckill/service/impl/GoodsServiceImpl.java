package com.le.leseckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.le.leseckill.mapper.GoodsMapper;
import com.le.leseckill.pojo.Goods;
import com.le.leseckill.service.GoodsService;
import com.le.leseckill.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author benren
 * @since 2021-10-28
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<GoodsVO> findGoodsVO() {
        return goodsMapper.findGoodsVO();
    }
}
