package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.message.JsonMessage;
import com.example.demo.singleton.GsonSingleton;
import com.google.gson.Gson;

@ControllerAdvice
public class UserExceptionHendler {

	@Autowired
	JsonMessage message;
	
	Gson gson =GsonSingleton.instance();
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String exceptionHendler(HttpServletRequest req, Exception e) {
		message.setCode(9999);
		message.setMessage(e.getMessage());
		message.setUrl(req.getRequestURL().toString());
		return gson.toJson(message);
	}
	
}
