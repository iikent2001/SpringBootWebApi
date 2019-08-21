package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.example.demo.annotation.ChkRePwd;

public class ChkRePwdValidator implements ConstraintValidator<ChkRePwd, Object>{

	private String field;
	private String fieldMatch;
	@Override
	public void initialize(ChkRePwd constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		this.field = constraintAnnotation.field();
		this.fieldMatch = constraintAnnotation.fieldMatch();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		BeanWrapper bean = new BeanWrapperImpl(value);
		String field = String.valueOf(bean.getPropertyValue(this.field));
		String fieldMatch = String.valueOf(bean.getPropertyValue(this.fieldMatch));
		if(StringUtils.equals(field, fieldMatch)) {
			return true;
		}
		return false;
	}

}
