package com.xzy.demo.web.controller;

import com.xzy.demo.biz.service.ExampleService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by RuzzZZ on 2017/3/30.
 */
@Log4j
@RestController
@Configuration
public class ExampleController {


    @Value("${demo.env}")
    private String env;

    @Autowired
    private ExampleService exampleService;

    @RequestMapping("/sayHello")
    String sayHello() {
        log.info("env:" + env);
        return exampleService.sayHello();
    }

    @RequestMapping("/home")
    String home() {
        return "Hello World! string";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    String index() {
        // TODO: 2017/3/29 视图的怎么设置。。。
        return "welcome";
    }
}