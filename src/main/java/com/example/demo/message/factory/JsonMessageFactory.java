package com.example.demo.message.factory;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import com.example.demo.message.EmptyUserIdMessage;
import com.example.demo.message.ExceptionMessage;
import com.example.demo.message.SaveFailedMessage;
import com.example.demo.message.SaveSuccessMessage;
import com.example.demo.message.SuccessMessage;

@Component
public class JsonMessageFactory {

	public String getExceptionMessage(String msg, String url) {
		return new ExceptionMessage(msg, url).toJson();
	}

	public String getSuccessMessage(Object obj) {
		return new SuccessMessage(obj).toJson();
	}

	public String getEmptyUserIdMessage(Long userId) {
		return new EmptyUserIdMessage(userId).toJson();
	}

	public String getSaveSuccessMessage(Object user) {
		return new SaveSuccessMessage(user).toJson();
	}

	public String getSaveFailedMessage(List<ObjectError> objectErrors) {
		return new SaveFailedMessage(objectErrors).toJson();
	}

}
