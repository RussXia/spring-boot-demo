package com.xzy.demo.web;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by RuzzZZ on 2017/3/30.
 */
@SpringBootApplication(scanBasePackages = {"com.xzy.demo"})
public class DemoWebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(DemoWebApplication.class);
        app.setBannerMode(Banner.Mode.LOG);
        app.run(args);
    }
}