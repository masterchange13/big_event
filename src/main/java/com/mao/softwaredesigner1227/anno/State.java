package com.mao.softwaredesigner1227.anno;

import com.mao.softwaredesigner1227.Validation.StateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.lang.reflect.Field;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {StateValidation.class})

public @interface State {


    // 提供校验失败的提示信息
    String message() default "{javax.validation.constraints.NotEmpty.message}";
    // 指定分组
    Class<?>[] groups() default {};
    // 负载 获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
