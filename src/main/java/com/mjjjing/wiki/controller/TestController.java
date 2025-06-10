package com.mjjjing.wiki.controller;

import org.springframework.web.bind.annotation.*;
//请求注解
@RestController
public class TestController {

    //GET,POST,PUT,DELETE
    /*@GetMapping
    @PostMapping
    @PutMapping
    @DeleteMapping
    @RequestMapping支持所有形式的请求
    @RequestMapping(value = "/user/1",method = RequestMethod.GET)
    @RequestMapping(value = "/user/1",method = RequestMethod.DELETE)*/;
    @GetMapping("/hello")
    public String hello(){
        return "hello world!!";
    }
    @PostMapping("hello/post")
    public String helloPost(String name){
        return "hello world! Post,"+name;
    }
}
