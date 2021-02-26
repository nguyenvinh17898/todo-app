package com.vinhnguyen.crudapi.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPowerOf2Validator implements ConstraintValidator<CheckPowerOf2, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		int temp = Integer.parseInt(value);
		if(Math.sqrt(temp) == (int)Math.sqrt(temp)) {
			return true;
		}
		return false;
	}

}
