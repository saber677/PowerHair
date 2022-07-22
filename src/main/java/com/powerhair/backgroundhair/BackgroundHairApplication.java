package com.powerhair.backgroundhair;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan(basePackages = "com.powerhair.backgroundhair.**.mapper")
public class BackgroundHairApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackgroundHairApplication.class, args);
    }

}
