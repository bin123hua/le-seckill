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
public class Order implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private  long id ;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 收货地址ID
     */
    private Long deliveryAddrId;

    /**
     * 冗余的商品名称，方便查询
     */
    private String goodsName;

    /**
     * 购买的商品数量
     */
    private Integer goodsCount;

    /**
     * 商品单价
     */
    private BigDecimal goodsPrice;

    /**
     * 下单渠道
     */
    private Integer orderChannel;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 支付时间
     */
    private Date payTime;


}
