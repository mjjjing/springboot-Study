package com.mjjjing.wiki.controller;

import com.mjjjing.wiki.req.EbookReq;
import com.mjjjing.wiki.resp.CommonResp;
import com.mjjjing.wiki.resp.EbookResp;
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
    public CommonResp list(EbookReq req){
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        List<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
}
