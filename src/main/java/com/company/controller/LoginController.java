package com.company.controller;

import com.company.annotation.RequiredPermission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yaochunguang
 * @date: 2021-03-04 16:51
 * @description: 登录controller
 **/
@RestController
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login success";
    }

    @GetMapping("/hello")
    @RequiredPermission("perm:err")
    public String hello(String name) {
        return "hello " + name;
    }

    @GetMapping("/testRead")
    @RequiredPermission("perm:read")
    public String testRead() {
        return "test read success";
    }
}
