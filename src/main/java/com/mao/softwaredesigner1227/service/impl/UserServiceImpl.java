package com.mao.softwaredesigner1227.service.impl;

import com.mao.softwaredesigner1227.entity.User;
import com.mao.softwaredesigner1227.mapper.UserMapper;
import com.mao.softwaredesigner1227.service.UserService;
import com.mao.softwaredesigner1227.utils.Md5Util;
import com.mao.softwaredesigner1227.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User user = userMapper.findByUserName(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        // 加密
        String md5Password = Md5Util.getMD5String(password);

        // 添加
        userMapper.add(username, md5Password);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(id, Md5Util.getMD5String(newPwd));
    }

}
