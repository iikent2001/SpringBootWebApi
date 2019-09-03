package com.example.demo.message;

public class SuccessMessage extends JsonMessageTemplete{
	public SuccessMessage(Object successMsg) {
		message.setSuccess(successMsg);
	}
}
