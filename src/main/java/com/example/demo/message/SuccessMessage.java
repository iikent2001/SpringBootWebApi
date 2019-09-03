package com.example.demo.message;

public class SuccessMessage extends JsonMessageTemplate{
	public SuccessMessage(Object successMsg) {
		message.setSuccess(successMsg);
	}
}
