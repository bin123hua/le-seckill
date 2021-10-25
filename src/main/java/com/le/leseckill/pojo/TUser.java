package com.le.leseckill.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class TUser  {

    private static final long serialVersionUID = 1L;

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
