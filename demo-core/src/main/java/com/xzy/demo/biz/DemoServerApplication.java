package com.xzy.demo.biz;


import com.xzy.demo.dal.DemoDalApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by RuzzZZ on 2017/3/31.
 */
@SpringBootApplication
public class DemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{DemoServerApplication.class, DemoDalApplication.class}, args);
    }
}
