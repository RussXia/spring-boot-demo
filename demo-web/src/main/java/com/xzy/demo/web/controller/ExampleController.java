package com.xzy.demo.web.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by RuzzZZ on 2017/3/30.
 */
//@RestController == @Controller + @ResponseBody
@RestController
@EnableAutoConfiguration
public class ExampleController {

    @RequestMapping("/home")
    String home() {
        return "Hello World! string";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String index() {
        // TODO: 2017/3/29 视图的怎么设置。。。
        return "welcome";
    }
}