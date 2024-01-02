package com.ken.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    // <CourseCode annotation, String - type of data to validate against>
    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    } // actual prefix to use to validate data against

    @Override // String code - from HTML form data entered by user
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (code != null) {
            result = code.startsWith(coursePrefix); // does it start with our prefix "LUV"?
        } else {
            result = true; // if nothing entered (null) just return true, course code is not a required field
        }

        return result;
    }
}