package com.casestudy.utils;

import com.casestudy.model.login.User;
import com.casestudy.service.furama_interface.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameValidator implements ConstraintValidator<CheckUserNameConstraint, String> {
    @Autowired
    private UserService userService;

    @Override
    public void initialize(CheckUserNameConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User user = userService.findById(value);
        if (user != null){
            return false;
        }else {
            return true;
        }
    }
}
