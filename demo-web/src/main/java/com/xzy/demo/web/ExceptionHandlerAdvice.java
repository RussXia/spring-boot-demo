package com.xzy.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiazhengyue
 * @since 2019-09-10
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({NullPointerException.class, ArithmeticException.class})
//    @ResponseStatus(value= HttpStatus.NETWORK_AUTHENTICATION_REQUIRED, reason="hello123")
    @ResponseBody
    public String handlerNullPointer(RuntimeException ex) {
        log.error("error happened:", ex);
        return this.getClass().getSimpleName() + ":" + ex.getMessage();
    }
}
