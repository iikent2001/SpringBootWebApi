package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.convert.UserConvert;
import com.example.demo.entity.User;
import com.example.demo.po.UserRepository;
import com.example.demo.vo.UserVo;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConvert convert;
	
	public List<User> getUserList(){
		return  userRepository.findAll(Sort.by(Direction.ASC, "userid"));
	}
	
	public Object getUserVoList(UserVo vo){
		return  userRepository.findById(vo.getUserid());
	}
	
	
	
	public List<UserVo> getUserVoList() {
		List<User> users = getUserList();
		return this.convertToVoList(users);
	}
	
	
	private List<UserVo> convertToVoList(List<User> users) {
		List<UserVo> userVoList = new ArrayList<UserVo>();
		for(int index=0,num=1;index<users.size();index++,num++) {
			UserVo vo = convert.convertToVo(users.get(index));
			vo.setNumber(num);
			userVoList.add(vo);
		}
		return userVoList;
	}
	
	public User saveUser(UserVo userVo) {
		return userRepository.save(convert.convertToBean(userVo));
	}
	
}
