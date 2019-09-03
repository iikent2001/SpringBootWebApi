package com.example.demo.message;

public class ExceptionMessage extends JsonMessageTemplete{
	public ExceptionMessage(String msg,String url) {
		message.setMessage(msg);
		message.setUrl(url);
	}
}
