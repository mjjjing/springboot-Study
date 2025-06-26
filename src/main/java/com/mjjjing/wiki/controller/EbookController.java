package com.mjjjing.wiki.controller;

import com.mjjjing.wiki.domain.Ebook;
import com.mjjjing.wiki.service.EbookService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//请求注解
@RestController
@RequestMapping("/ebook")
public class EbookController {


    @Resource
    public EbookService ebookService;

    @GetMapping("/list")
    public Object list(){
        List<Ebook> list = ebookService.list();
        if (list!=null){
            return ebookService.list();
        }
        return "空";
    }
}
