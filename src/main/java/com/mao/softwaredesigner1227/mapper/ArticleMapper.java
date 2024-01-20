package com.mao.softwaredesigner1227.mapper;

import com.mao.softwaredesigner1227.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO article (title, content, cover_img, state, category_id, category_user, category_time, update_time)" +
            " VALUES (#{title}, #{content}), #{coverImg}, #{state}, #{categoryId}, #{categoryUser}, #{categoryTime}, #{updateTime})")
    void add(Article article);


    List<Article> list(Integer id, Integer categoryId, String state);
}
