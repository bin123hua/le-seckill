package com.le.leseckill.exception;

import com.le.leseckill.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NotNull
public class GlobalException extends RuntimeException {
    private RespBeanEnum respBeanEnum;

}
