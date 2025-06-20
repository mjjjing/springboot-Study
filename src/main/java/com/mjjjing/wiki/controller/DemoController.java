package com.mjjjing.wiki.controller;

import com.mjjjing.wiki.domain.Demo;
import com.mjjjing.wiki.service.DemoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//请求注解
@RestController
@RequestMapping("/demo")
public class DemoController {


    @Resource
    public DemoService demoService;

    @GetMapping("/list")
    public Object list(){
        List<Demo> list = demoService.list();
        if (list!=null){
            return demoService.list();
        }
        return "空";
    }
}
