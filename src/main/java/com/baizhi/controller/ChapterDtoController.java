package com.baizhi.controller;

import com.baizhi.service.ChapterDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("detail")
public class ChapterDtoController {
    @Autowired
    ChapterDtoService chapterDtoService;

    public Object queryTwo(Integer id, Integer uid) {
        Object o = chapterDtoService.queryTwo(id, uid);
        return o;
    }
}
