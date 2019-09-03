package com.example.demo.message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class JsonMessageTemplete {

	private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	protected static int SAVE_SUCCESS = 0, SAVE_ERRORR = 1;
	protected JsonMessage message;

	protected JsonMessageTemplete() {
		message = new JsonMessage();
	}

	public String toJson() {
		return gson.toJson(message);
	}

}
