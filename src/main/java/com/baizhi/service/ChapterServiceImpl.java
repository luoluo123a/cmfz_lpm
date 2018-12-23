package com.baizhi.service;

import com.baizhi.entity.Chapter;
import com.baizhi.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public void insertChapter(Chapter chapter) {
        String id = UUID.randomUUID().toString().replace("-", "");
        chapter.setId(id);
        chapterMapper.insert(chapter);
    }
}
