package com.xzy.demo.web;

import com.xzy.demo.biz.DemoServerApplication;
import org.springframework.boot.Banner;
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
        SpringApplication app = new SpringApplication(DemoWebApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}