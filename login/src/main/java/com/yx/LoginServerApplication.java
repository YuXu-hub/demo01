package com.yx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.yx.mapper")
public class LoginServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginServerApplication.class);
    }
}
