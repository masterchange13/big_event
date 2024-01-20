package com.mao.softwaredesigner1227.controller;

import com.mao.softwaredesigner1227.entity.Article;
import com.mao.softwaredesigner1227.entity.PageBean;
import com.mao.softwaredesigner1227.entity.Result;
import com.mao.softwaredesigner1227.service.ArticleService;
import com.sun.xml.bind.v2.schemagen.xmlschema.Particle;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mao.softwaredesigner1227.utils.JwtUtil;

import javax.naming.InsufficientResourcesException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping()
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }

    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        return Result.success(articleService.list(pageNum, pageSize, categoryId, state));
    }

    @PostMapping("/update")
    public Result update(@RequestBody @Validated Article article) {
        articleService.update(article);
        return Result.success();
    }

    @GetMapping("/detail")
    public Result<List<Article>> detail(Integer id) {
        List<Article> rs = articleService.findById(id);
        System.out.println(rs.toString());
        return Result.success(rs);
    }

    @PostMapping("/delete")
    public Result delete(Integer id) {
        articleService.deleteById(id);
        return Result.success();
    }
}
