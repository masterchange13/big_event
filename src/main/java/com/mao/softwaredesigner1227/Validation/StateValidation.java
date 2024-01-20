package com.mao.softwaredesigner1227.Validation;

import com.mao.softwaredesigner1227.anno.State;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;

public class StateValidation implements ConstraintValidator<State, String> {


    @Override
    public void initialize(State constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s== null){
            return false;
        }
        if (s.equals("已发布") || s.equals("草稿")){
            return true;
        }
        return false;
    }
}
