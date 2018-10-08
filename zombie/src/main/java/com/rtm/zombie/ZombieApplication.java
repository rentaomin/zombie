package com.rtm.zombie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZombieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZombieApplication.class, args);
    }
}
