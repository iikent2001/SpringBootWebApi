package com.example.demo.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class ExceptionLogPointCut {
	
	Logger log = LogManager.getLogger(this.getClass());
	
	@AfterThrowing(pointcut ="execution(* com.example.demo.controller..*.*(..))",throwing = "ex")
	public void error(JoinPoint point, Throwable ex) {
		log.error("method:"+point.getSignature().getName()+" cause:"+ex.getMessage());
	}

}
