package com.mao.softwaredesigner1227.controller;

import com.mao.softwaredesigner1227.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        // 保证文件名字唯一
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        String path = "D:\\jetbrains\\IntelliJ IDEA 2023.2.4\\javaCode\\big_event\\src\\main\\resources\\image\\" + filename;
        file.transferTo(new File(path));
        return Result.success("文件上传成功");
    }
}
