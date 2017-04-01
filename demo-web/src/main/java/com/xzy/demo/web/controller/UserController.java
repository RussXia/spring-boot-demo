package com.xzy.demo.web.controller;

import com.xzy.demo.biz.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by RuzzZZ on 2017/4/1.
 */
@Log4j
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    @ResponseBody
    String addUser() {
        log.info("Todo: add user");
        boolean flag = userService.addUser();
        if (flag) {
            return "success";
        }
        return "failed";
    }

    @RequestMapping(value = "/test.json",method = RequestMethod.GET)
    @ResponseBody
    String test() {
        log.info("Todo: add user");
        boolean flag = userService.addUser();
        if (flag) {
            return "success";
        }
        return "failed";
    }
}
