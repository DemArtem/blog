package com.ivl_plus.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/hello")
    public String hello(){
        return "<h2> Hey,everyone <h2>";
    }

    @GetMapping("/user")
    public String user(){
        return "<h2> Hey,user <h2>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h2> Hey,admin <h2>";
    }
}
