package com.mjjjing.wiki.service;

import com.mjjjing.wiki.domain.Ebook;
import com.mjjjing.wiki.domain.EbookExample;
import com.mjjjing.wiki.mapper.EbookMapper;
import com.mjjjing.wiki.req.EbookReq;
import com.mjjjing.wiki.resp.EbookResp;
import com.mjjjing.wiki.util.CopyUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        //模糊匹配
        if (!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%"+req.getName()+"%");
        }
        //把所有匹配的实例放入ebookList里面
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        //List<EbookResp> respList = new ArrayList<>();
        //遍历ebookList,目的为把Ebook转换成EbookResp
        /*for (Ebook ebook : ebookList) {
            //EbookResp ebookResp = new EbookResp();
            //BeanUtils.copyProperties(ebook,ebookResp);
            //对象复制
            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);

            respList.add(ebookResp);
        }*/
        //列表复制
        List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);

        return  respList;
    }

}
