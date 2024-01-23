package com.mao.softwaredesigner1227.utils;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/utils")
public class VerifyCode {
    // public void createCode(HttpResponse response, HttpRequest request) {
    //     @GetMapping("/verifyCode")
    //     // 生成验证码并发送到用户手机
    //     LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
    //     // 图形验证码浏览器显示
    //     lineCaptcha.write(response.getOutputStream());
    //     // 关闭流
    //     response.getOutputStream().close();
    //
    // }

    @Autowired
    HttpServletResponse response;
    @Autowired
    HttpSession session;

    @GetMapping("VerifyCode")
    public void getCode() throws IOException {
        // 利用 hutool 工具，生成验证码图片资源
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 5);
        // 获得生成的验证码字符
        String code = captcha.getCode();
        // 利用 session 来存储验证码
        session.setAttribute("code",code);
        // 将验证码图片的二进制数据写入【响应体 response 】
        captcha.write(response.getOutputStream());

        // response.getOutputStream().close();
    }
}
