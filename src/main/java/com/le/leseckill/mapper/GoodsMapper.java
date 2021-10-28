package com.le.leseckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.le.leseckill.pojo.Goods;
import com.le.leseckill.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author benren
 * @since 2021-10-28
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    
    List<GoodsVO> findGoodsVO();
}
