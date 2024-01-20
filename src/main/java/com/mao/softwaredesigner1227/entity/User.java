package com.mao.softwaredesigner1227.entity;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class User {
    @NotNull
    private Integer id;
    private String userName;
    @JsonIgnore // 转换成json字符串的时候可自动忽略该字段，就可以不显示
    private String password;

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;

    @NotEmpty
    @Email
    private String email;
    private String user_pic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    // 省略getter和setter方法
}
