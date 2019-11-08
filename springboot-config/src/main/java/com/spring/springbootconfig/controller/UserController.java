package com.spring.springbootconfig.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    public String sayHello(){
        System.out.println("哈哈");
        return "Hello world!";
    }

}
