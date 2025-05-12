package com.example.monitorsensors.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangeValidator.class)
public @interface ValidRange {
    String message() default "From value must be less than to value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 