package com.le.leseckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author benren
 * @since 2021-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String nickname;

    /**
     * 两次MD5加密
     */
    private String password;

    private String salt;

    private String head;

    private Date registerDate;

    private Date lastLoginDate;

    private Integer loginCount;


}
