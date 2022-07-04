package com.casestudy.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = ServiceIdValidator.class)
public @interface CheckServiceId {
    String message() default "Đã tồn tại Id khách hàng";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
