package com.ken.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    // define parameters - default course code
    public String value() default "LUV";

    public String message() default "must start with LUV";

    // define default groups and default payloads
    public Class<?>[] groups() default {}; // can group related constraints
    public Class<? extends Payload>[] payload() default {}; // provide custom details about validation failure (severity level, error code etc)

}