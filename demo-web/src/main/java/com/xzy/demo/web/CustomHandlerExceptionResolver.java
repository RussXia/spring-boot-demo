package com.xzy.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiazhengyue
 * @since 2019-09-11
 */
@Slf4j
@Order(value = -1)
@Component
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof NullPointerException
                || (ex.getCause() != null && ex.getCause() instanceof NullPointerException)) {
            try {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "null_pointer_exception occurred just now!");
                return new ModelAndView();
            } catch (IOException e) {
                log.error("some error occurred!", e);
            }
        }
        return null;
    }
}
