package com.xzy.demo.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RuzzZZ
 * @since 2019-09-10
 */
@Slf4j
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/nullPointerException")
    public String nullPointer() {
        log.info("start NullPointerException");
        Object object = null;
        return object.toString();
    }

    @RequestMapping("/arithmeticException")
    public String arithmeticException() {
        log.info("start ArithmeticException");
        int a = 10 / 0;
        return "success";
    }
}
