package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.message.ExceptionMessage;



@ControllerAdvice
public class UserExceptionHendler {
	

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String exceptionHendler(HttpServletRequest req, Exception e) {
		return new ExceptionMessage(e.getMessage(),req.getRequestURL().toString()).toJson();
	}
	
}
