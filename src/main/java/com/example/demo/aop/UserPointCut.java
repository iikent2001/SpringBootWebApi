package com.example.demo.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//@Configuration
//@Aspect
public class UserPointCut {
	
//	Gson gson =new GsonBuilder().create();
//	
//	@AfterReturning(pointcut ="execution(* com.example.demo.controller..*.*(..))",returning="val")
//	public Object returnJson(Object val) {
//		System.out.println(val);
//		return val+"aa";
//	}
}
