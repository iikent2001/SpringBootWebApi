package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.message.JsonMessage;
import com.example.demo.service.UserService;
import com.example.demo.singleton.GsonSingleton;
import com.example.demo.vo.UserVo;
import com.google.gson.Gson;

@RestController
@RequestMapping("/user")
@EnableAspectJAutoProxy
public class UserController {
	
	@Autowired
	UserService service;
	
	Gson gson =GsonSingleton.instance();
	
	@RequestMapping("/details")
	public String selectUsers(UserVo vo) throws Exception {
		JsonMessage message = new JsonMessage();  
		Object detail = vo.getUserid()==null?service.getUserVoList():service.getUserByUserId(vo);
		if(ObjectUtils.isEmpty(detail)) {
			message.setMessage("userid:"+vo.getUserid()+" is empty");
		}else {
			message.setSuccess(detail);
		}
		return gson.toJson(message);
	}
	
	private String getErrorMessageString(List<ObjectError>  errors) {
		String errorMessage="";
		for(ObjectError error :errors) {
			errorMessage+=error.getDefaultMessage()+",";
		}
		errorMessage = errorMessage.substring(0, errorMessage.length()-1);
		return errorMessage;
	}
	
	private JsonMessage getValidMessage(UserVo vo,BeanPropertyBindingResult result) {
		JsonMessage message = new JsonMessage();
		if(result.hasErrors()) {
			message.setCode(02);
			message.setMessage(getErrorMessageString(result.getAllErrors()));
		}else {
			message.setCode(01);
			message.setData(service.saveUser(vo));
		}
		return message;
	}
	
	@PostMapping("/registory")
	public String saveUser(@Valid UserVo vo,BeanPropertyBindingResult result) {
		JsonMessage message = getValidMessage(vo,result);
		return gson.toJson(message);
	}
	
	@PostMapping("/errorTest")
	@SuppressWarnings("unused")
	public String sendError(UserVo vo) throws Exception {
		JsonMessage message = new JsonMessage();
		if(true) {
			throw new Exception("error test");
		}
		return gson.toJson(message);
	}
	

}
