package com.yuhang.novel.pirate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuhang.novel.pirate.mapper")
public class PirateWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PirateWebApplication.class, args);
    }

}
