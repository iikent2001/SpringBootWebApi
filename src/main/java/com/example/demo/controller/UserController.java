package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.convert.UserConvert;
import com.example.demo.message.SuccessMessage;
import com.example.demo.message.factory.JsonMessageFactory;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVo;

@RestController
@RequestMapping("/user")
@EnableAspectJAutoProxy
public class UserController {

	@Autowired
	UserService service;

	@Autowired
	UserConvert convert;

	@Autowired
	JsonMessageFactory factory;

	@RequestMapping("/details")
	public String selectUsers() throws Exception {
		Object detail = convert.convertToVoList(service.getUserList());
		return new SuccessMessage(detail).toJson();
	}

	@RequestMapping("/detail")
	public String selectUser(UserVo vo) throws Exception {
		Object detail = service.getUserVoList(vo.getUserid());
		if (ObjectUtils.isEmpty(detail)) {
			return factory.getEmptyUserIdMessage(vo.getUserid());
		} else {
			return factory.getSuccessMessage(detail);
		}
	}

	@PostMapping("/registory")
	public String saveUser(@Valid UserVo vo, BeanPropertyBindingResult result) {
		if (result.hasErrors()) {
			return factory.getSaveFailedMessage(result.getAllErrors());
		} else {
			return factory.getSaveSuccessMessage(service.saveUser(convert.convertToBean(vo)));
		}
	}

	@PostMapping("/errorTest")
	@SuppressWarnings("unused")
	public String sendError(UserVo vo) throws Exception {
		if (true) {
			throw new Exception("error test");
		}
		return new SuccessMessage("success").toJson();
	}

}
