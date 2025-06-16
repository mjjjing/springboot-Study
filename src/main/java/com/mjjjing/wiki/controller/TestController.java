package com.mjjjing.wiki.controller;

import com.mjjjing.wiki.domain.Test;
import com.mjjjing.wiki.service.TestService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//请求注解
@RestController
public class TestController {

    @Value("${test.hello:Test}")
    private String testHello;
    @Resource
    public TestService testService;
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
        return "hello world!!"+testHello;
    }
    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello world! Post,"+name;
    }
    @GetMapping("/test/list")
    public Object list(){
        List<Test> list = testService.list();
        if (list!=null){
            return testService.list();
        }
        return "空";
    }
}
