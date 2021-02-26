package com.vinhnguyen.crudapi.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPowerOf2Validator.class)
public @interface CheckPowerOf2 {
	String message() default "{A.invalid}";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
