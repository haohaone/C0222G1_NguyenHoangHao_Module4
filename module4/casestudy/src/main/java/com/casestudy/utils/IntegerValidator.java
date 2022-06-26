package com.casestudy.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntegerValidator implements ConstraintValidator<CheckIntegerConstraint, String> {

    @Override
    public void initialize(CheckIntegerConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            int checkInteger = Integer.parseInt(value);
            if (checkInteger < 0){
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
