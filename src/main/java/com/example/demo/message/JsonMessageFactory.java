package com.example.demo.message;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class JsonMessageFactory {
	
	private Gson gson =new GsonBuilder().disableHtmlEscaping().create();
	
	public String getExceptionMessage(String msg,String url) {
		JsonMessage message = new JsonMessage();
		message.setMessage(msg);
		message.setUrl(url);
		return toJson(message);
	}
	
	public String getSuccessMessage(Object obj) {
		JsonMessage message = new JsonMessage();
		message.setSuccess(obj);
		return toJson(message);
	}
	
	//
	public String getEmptyUserIdMessage(Object userId) {
		JsonMessage message = new JsonMessage();
		message.setMessage("userid:"+userId+" is empty");
		return toJson(message);
	}
	
	public String getSaveSuccessMessage(Object user) {
		JsonMessage message = new JsonMessage();
		message.setCode(01);
		message.setData(user);
		return toJson(message);
	}
	
	public String getSaveFailedMessage(List<ObjectError> objectErrors) {
		JsonMessage message = new JsonMessage();
		message.setCode(02);
		message.setMessage(getErrorMessageString(objectErrors));
		return toJson(message);
	}
	
	private String getErrorMessageString(List<ObjectError>  errors) {
		String errorMessage="";
		for(ObjectError error :errors) {
			errorMessage+=error.getDefaultMessage()+",";
		}
		errorMessage = errorMessage.substring(0, errorMessage.length()-1);
		return errorMessage;
	}
		
	
	private String toJson(JsonMessage message) {
		return gson.toJson(message);
	}
	
}
