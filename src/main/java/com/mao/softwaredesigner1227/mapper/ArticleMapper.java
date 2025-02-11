package com.mao.softwaredesigner1227.mapper;

import com.mao.softwaredesigner1227.entity.Article;
import com.mao.softwaredesigner1227.entity.Result;
import org.apache.ibatis.annotations.*;

import javax.validation.constraints.Max;
import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO article (title, content, cover_img, state, category_id, create_user, create_time, update_time)" +
            " VALUES (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Article article);

    List<Article> list(Integer id, Integer categoryId, String state);

    @Update("UPDATE article SET title = #{title}, content = #{content}, cover_img = #{coverImg}, state = #{state}, " +
            "category_id = #{categoryId}, create_user = #{createUser}, update_time = #{updateTime}" +
            " where id = #{id}")
    void update(Article article);

    @Select("SELECT * FROM article WHERE id = #{id}")
    List<Article> findById(Integer id);

    @Delete("delete from article where id = #{id}")
    void deleteById(Integer id);
}
