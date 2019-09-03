package com.example.demo.message;

public class SaveSuccessMessage extends JsonMessageTemplete{
	public SaveSuccessMessage(Object user) {
		message.setCode(01);
		message.setData(SAVE_SUCCESS);
	}
}
