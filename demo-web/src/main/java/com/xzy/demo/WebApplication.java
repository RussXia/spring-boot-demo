package com.xzy.demo;

import com.xzy.demo.web.controller.ExampleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created by RuzzZZ on 2017/3/30.
 */

@EnableAutoConfiguration
public class WebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleController.class, args);
    }
}