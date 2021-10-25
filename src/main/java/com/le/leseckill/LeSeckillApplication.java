package com.le.leseckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.le.leseckill.mapper")
public class LeSeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeSeckillApplication.class, args);
    }

}
