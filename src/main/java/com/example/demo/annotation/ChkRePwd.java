package com.example.demo.annotation;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.demo.validator.ChkRePwdValidator;

@Constraint(validatedBy = ChkRePwdValidator.class)
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChkRePwd {

	String message() default "Fields values don't match!";
	Class<?>[] groups() default {};
	  
	Class<? extends Payload>[] payload() default {};
    String field();
 
    String fieldMatch();
 
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
    	ChkRePwd[] value();
    }
	
}
