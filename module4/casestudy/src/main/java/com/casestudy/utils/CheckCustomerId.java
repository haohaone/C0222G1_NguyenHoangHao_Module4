package com.casestudy.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = CustomerIdValidator.class)
public @interface CheckCustomerId {
    String message() default "Đã tồn tại Id khách hàng";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
