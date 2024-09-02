package com.security.jwt.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping("/")
    public String hello(HttpServletRequest request){
        return "Hello"+ request.getSession().getId();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userEnd(HttpServletRequest request){
        return "Hello user";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminEnd(HttpServletRequest request){
        return "Hello admin";
    }
}
