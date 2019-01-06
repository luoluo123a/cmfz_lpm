package com.baizhi.service;

import com.baizhi.entity.Article;
import com.baizhi.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Object queryOne(Integer id, Integer uidc) {
        if (uidc == null) {
            return "未登录";
        } else if (id == null) {
            return "参数错误";
        } else {
            Article article = articleMapper.selectByPrimaryKey(id);
            if (article == null) {
                return "该文章不存在";
            } else {
                return article;
            }
        }
    }
}
