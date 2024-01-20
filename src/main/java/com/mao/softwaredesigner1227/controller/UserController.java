package com.mao.softwaredesigner1227.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.mao.softwaredesigner1227.entity.Result;
import com.mao.softwaredesigner1227.entity.User;
import com.mao.softwaredesigner1227.service.UserService;
import com.mao.softwaredesigner1227.utils.JwtUtil;
import com.mao.softwaredesigner1227.utils.Md5Util;
import com.mao.softwaredesigner1227.utils.ThreadLocalUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.ResolutionSyntax;
import javax.validation.constraints.Pattern;
import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {

        // 查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已被占用");
        }
        // 注册
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        User loginUser = userService.findByUserName(username);
        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        // 判断密码是否正确
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUserName());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization")String token*/) {
//        Map<String, Object> claims = JwtUtil.parseToken(token);
//        String username = (String) claims.get("username");

        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params) {
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new-pwd");
        String rePwd = params.get("re_pwd");

        // 参数检验
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if (!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            return Result.error("旧密码错误");
        }
        if (!newPwd.equals(rePwd)) {
            return Result.error("两次输入的新密码不一致");
        }

        // 更新
        userService.updatePwd(newPwd);
        return Result.success();
    }
}