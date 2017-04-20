package com.xzy.demo.biz.service.impl;

import com.xzy.demo.biz.redis.RedisService;
import com.xzy.demo.biz.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RuzzZZ on 2017/3/31.
 */
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private RedisService redisService;

    public String sayHello() {
        return "ExampleService.hello";
    }

    @Override
    public String addCache() {
        redisService.putJson("test-" + System.currentTimeMillis(), "HelloWorld" + System.currentTimeMillis());
        return "ok";
    }
}
