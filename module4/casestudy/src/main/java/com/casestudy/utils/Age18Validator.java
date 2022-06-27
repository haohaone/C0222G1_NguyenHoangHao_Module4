package com.casestudy.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class Age18Validator implements ConstraintValidator<CheckAge18Constraint, String> {
    @Override
    public void initialize(CheckAge18Constraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(value);
        } catch (Exception e) {
            return true;
        }
        LocalDate localDateNow = LocalDate.now();
        int year = Period.between(localDate, localDateNow).getYears();
        if (year < 18){
            return false;
        }else {
            return true;
        }
    }
}
