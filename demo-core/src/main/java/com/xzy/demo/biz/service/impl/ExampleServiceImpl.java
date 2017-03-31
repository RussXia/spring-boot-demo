package com.xzy.demo.biz.service.impl;

import com.xzy.demo.biz.service.ExampleService;
import org.springframework.stereotype.Service;

/**
 * Created by RuzzZZ on 2017/3/31.
 */
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {


    public String sayHello() {
        return "ExampleService.hello";
    }
}
