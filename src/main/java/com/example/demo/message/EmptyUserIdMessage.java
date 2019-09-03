package com.example.demo.message;

public class EmptyUserIdMessage extends JsonMessageTemplete{
	public EmptyUserIdMessage(Long userId){
		message.setMessage("userid:"+userId+" is empty");
	}
}
