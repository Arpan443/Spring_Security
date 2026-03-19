package com.pro.Spring_Boot_Security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api") -> comment out this if you are trying to see role based auth
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "its home page";
    }

        @GetMapping("/register")
        public String register(){
            return "register your account";
        }

            @GetMapping("/login")
            public String login(){
                return "login to your account";
            }

}
