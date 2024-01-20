package com.mao.softwaredesigner1227.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

@Data
public class Category {
    @NotNull(groups = update.class)
    private Integer id;
    @NotEmpty(groups = {add.class, update.class})
    private String categoryName;
    @NotEmpty(groups = {add.class, update.class})
    private String categoryAlias;
    private Integer createUser;
//    private Integer updateUSer;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public interface add extends Default {

    }

    public interface update extends Default {

    }
}
