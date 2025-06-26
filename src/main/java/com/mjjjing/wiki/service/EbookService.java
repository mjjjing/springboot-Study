package com.mjjjing.wiki.service;

import com.mjjjing.wiki.domain.Ebook;
import com.mjjjing.wiki.domain.EbookExample;
import com.mjjjing.wiki.mapper.EbookMapper;
import com.mjjjing.wiki.req.EbookReq;
import com.mjjjing.wiki.resp.EbookResp;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        //模糊匹配
        criteria.andNameLike("%"+req.getName()+"%");
        //把所有匹配的实例放入ebookList里面
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> respList = new ArrayList<>();
        //遍历ebookList,目的为把Ebook转换成EbookResp
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook,ebookResp);
            respList.add(ebookResp);
        }

        return  respList;
    }

}
