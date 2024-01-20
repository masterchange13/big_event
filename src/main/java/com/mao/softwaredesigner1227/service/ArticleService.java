package com.mao.softwaredesigner1227.service;

import com.mao.softwaredesigner1227.entity.Article;
import com.mao.softwaredesigner1227.entity.PageBean;

public interface ArticleService {

    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
