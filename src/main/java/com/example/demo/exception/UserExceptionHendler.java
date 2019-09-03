package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.message.JsonMessageFactory;



@ControllerAdvice
public class UserExceptionHendler {
	
	@Autowired
	JsonMessageFactory factory;

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String exceptionHendler(HttpServletRequest req, Exception e) {
		return factory.getExceptionMessage(e.getMessage(),req.getRequestURL().toString());
	}
	
}
