package com.le.leseckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author benren
 * @since 2021-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SeckillGoods implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private  long id ;

    /**
     * 商品ID
     */
    private Long goodId;

    /**
     * 秒杀价格
     */
    private BigDecimal seckillPrice;

    /**
     * 库存数量
     */
    private Integer stockCount;

    /**
     * 秒杀开始时间
     */
    private Date startDate;

    /**
     * 秒杀结束时间
     */
    private Date endDate;


}
