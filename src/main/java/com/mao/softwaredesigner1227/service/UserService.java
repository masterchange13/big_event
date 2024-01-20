package com.mao.softwaredesigner1227.service;

import com.mao.softwaredesigner1227.entity.User;

public interface UserService {
    // 根据用户名查询用户名是否存在
    User findByUserName(String username);

    //注册
    void register(String username, String password);

    void update(User user);

    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
}
