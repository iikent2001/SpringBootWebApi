package com.example.demo.message;

import java.util.List;

import org.springframework.validation.ObjectError;

public class SaveFailedMessage extends JsonMessageTemplate{
	public SaveFailedMessage(List<ObjectError> objectErrors) {
		message.setCode(02);
		message.setMessage(getErrorMessageString(objectErrors));
	}
	
	private String getErrorMessageString(List<ObjectError> errors) {
		String errorMessage = "";
		for (ObjectError error : errors) {
			errorMessage += error.getDefaultMessage() + ",";
		}
		errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
		return errorMessage;
	}
}
