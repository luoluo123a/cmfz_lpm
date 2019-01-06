package com.baizhi.controller;

import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("detail")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping("queryOne")
    public Object queryOne(Integer id, Integer uidc) {
        Object o = articleService.queryOne(id, uidc);
        return o;
    }
}
