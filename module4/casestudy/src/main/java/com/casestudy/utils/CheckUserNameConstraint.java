package com.casestudy.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = UserNameValidator.class)
public @interface CheckUserNameConstraint {
    String message() default "Tên tài khoản đã có người sử dụng";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
