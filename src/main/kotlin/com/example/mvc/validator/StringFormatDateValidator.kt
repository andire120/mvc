package com.example.mvc.validator

import com.example.mvc.annotaion.StringFormatDateTime
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class StringFormatDateValidator : ConstraintValidator<StringFormatDateTime, String> {

    private var pattern : String?=null

    override fun initialize(constraintAnnotation: StringFormatDateTime?) {
        this.pattern = constraintAnnotation?.pattern
    }

    //정상이면 true, 비정상이면 false
    override fun isValid(value : String?, context : ConstraintValidatorContext?): Boolean {
        return try {
            LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern))
            true
        }catch (e:Exception) {
            false
        }
    }
}