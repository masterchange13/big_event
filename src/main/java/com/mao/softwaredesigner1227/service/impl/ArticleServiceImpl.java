package com.mao.softwaredesigner1227.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mao.softwaredesigner1227.entity.Article;
import com.mao.softwaredesigner1227.entity.PageBean;
import com.mao.softwaredesigner1227.mapper.ArticleMapper;
import com.mao.softwaredesigner1227.service.ArticleService;
import com.mao.softwaredesigner1227.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        // 补充属性值
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        article.setCreateUser(id);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        // 创建bean
        PageBean<Article> pageBean = new PageBean<>();
        // 开启分页查询 PageHelper
        PageHelper.startPage(pageNum, pageSize);
        // 调用mapper
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        List<Article> as = articleMapper.list(id, categoryId, state);
        Page<Article> p = (Page<Article>) as;

        //  把数据填充到PageBean对象中
        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());
        return pageBean;
    }
}
