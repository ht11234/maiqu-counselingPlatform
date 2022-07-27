package com.maiqu.counsel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.maiqu"})
public class CounselApplication {
    public static void main(String[] args) {
        SpringApplication.run(CounselApplication.class,args);
    }
}
