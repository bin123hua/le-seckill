package com.le.leseckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class Goods implements Serializable {

   @TableId(value = "id",type = IdType.AUTO)
    private  long id ;
    

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品标题
     */
    private String goodsTitle;

    /**
     * 商品图片
     */
    private String goodsImg;

    /**
     * 商品详情
     */
    private String goodsDetail;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 如果为-1表示没有限制，可以无限抢
     */
    private Integer goodsStock;


}
