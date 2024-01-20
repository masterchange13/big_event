package com.mao.softwaredesigner1227.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.mao.softwaredesigner1227.entity.Category;
import com.mao.softwaredesigner1227.entity.Result;
import com.mao.softwaredesigner1227.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public Result add( @RequestBody @Validated({Category.add.class}) Category category){
        categoryService.add(category);
        return Result.success();
    }

    @GetMapping()
    public Result<List<Category>> getAll(){
        List<Category> cs = categoryService.list();
        return Result.success(cs);
    }

    @GetMapping("/detail")
    public Result detail(Integer id){
        Category c = categoryService.findById(id);
        return Result.success(c);
    }

    @PutMapping("/update")
    public Result update( @RequestBody @Validated(Category.update.class) Category category){
        categoryService.update(category);
        return  Result.success();
    }

    @PutMapping("/delete")
    public Result delete(Integer id){
        categoryService.deleteById(id);
        return Result.success();
    }
}
