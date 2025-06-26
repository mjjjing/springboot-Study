package com.mjjjing.wiki.service;

import com.mjjjing.wiki.domain.Ebook;
import com.mjjjing.wiki.mapper.EbookMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list(){
        return ebookMapper.selectByExample(null);
    }

}
