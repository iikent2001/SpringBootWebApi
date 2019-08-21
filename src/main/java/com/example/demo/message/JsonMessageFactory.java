package com.example.demo.message;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.example.demo.message.JsonMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class JsonMessageFactory<T> {
	
	private Gson gson =new GsonBuilder().create();
	private JsonMessage message;
	Logger log = LogManager.getLogger(this.getClass());	
	public JsonMessageFactory() {
		message = new JsonMessage();
	}
	
	@SuppressWarnings("unchecked")
	public void setAttribute(String fieldName,Object obj) throws Exception {
		try {
			@SuppressWarnings("rawtypes")
			Class clz = message.getClass();
			Method m = clz.getMethod(getSetterName(fieldName), Object.class);
			m.invoke(message, obj);
		}catch(Exception e) {
			log.debug(e.getMessage());
			throw new Exception("JsonMessageFactory.setAttribute error");
		}
	}
	
	private String getSetterName(String fieldName) {
		return "set"+StringUtils.substring(fieldName, 0,1).toUpperCase()+
		StringUtils.substring(fieldName,1);
		
	}
	
	public String toJson() {
		return gson.toJson(message);
	}
}
