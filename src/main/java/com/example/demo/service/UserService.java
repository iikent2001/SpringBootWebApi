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
	
	public List<User> getUserList(){
		return  userRepository.findAll(Sort.by(Direction.ASC, "userid"));
	}
	
	public Object getUserVoList(Long userId){
		return  userRepository.findById(userId);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
}
