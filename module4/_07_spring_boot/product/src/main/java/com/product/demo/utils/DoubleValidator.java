package com.product.demo.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoubleValidator implements ConstraintValidator<CheckDoubleConstraint, String> {
    @Override
    public void initialize(CheckDoubleConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            double checkDouble = Double.parseDouble(value);
            if (checkDouble < 0){
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
