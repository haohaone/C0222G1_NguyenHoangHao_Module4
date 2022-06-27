package com.casestudy.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = Age18Validator.class)
public @interface CheckAge18Constraint {
    String message() default "Khách hàng chưa đủ 18 tuổi";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
