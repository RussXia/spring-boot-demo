package com.xzy.demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by RuzzZZ on 2017/3/30.
 */
@ComponentScan(value = {"com.xzy.demo"})
@SpringBootApplication
public class DemoWebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoWebApplication.class, args);
    }
}