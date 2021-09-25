package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/hellow1")
    public String hellow(){
        return "hellow";
    }
    @GetMapping(value = {"/login"})
    public String login(){
        System.out.println("login===========");
        return "login";
    }
}
