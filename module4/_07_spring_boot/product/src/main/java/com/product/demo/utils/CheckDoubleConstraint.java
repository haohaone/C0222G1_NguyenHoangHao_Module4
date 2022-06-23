package com.product.demo.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = DoubleValidator.class)
public @interface CheckDoubleConstraint {
    String message() default "Không được nhập chữ hoặc bé hơn 0";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
