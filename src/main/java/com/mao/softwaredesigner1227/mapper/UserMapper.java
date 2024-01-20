package com.mao.softwaredesigner1227.mapper;

import com.mao.softwaredesigner1227.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    // 根据用户名查询用户
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUserName(String username);

    // 添加用户
    @Insert("INSERT INTO user (username, password, create_time, update_time)" +
            " VALUES (#{username}, #{md5Password}, now(), now())")
    void add(String username, String md5Password);

    @Update("update user set nickname=#{nickname}, email=#{email}, update_time=now() where id=#{id}")
    void update(User user);

    @Update("update user set avatar_url=#{avatarUrl}, update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);

    @Update("update user set password=#{M5dPwd}, update_time=now() where id=#{id}")
    void updatePwd(Integer id, String M5dPwd);
}
