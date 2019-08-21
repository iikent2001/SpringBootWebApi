package com.example.demo.singleton;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSingleton {

	private GsonSingleton() {}
	
	private static Gson instance;
	
	public static Gson instance() {
		if(instance == null) {
			instance = new GsonBuilder().disableHtmlEscaping().create();
		}
		return instance;
	}
	
}
