package com.example.demo.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.vo.UserVo;

@Component
public class UserConvert implements BeanConvert<UserVo, User>{

	@Override
	public User convertToBean(UserVo vo) {
			User user = new User();
			BeanUtils.copyProperties(vo, user);
			return user;
	}

	@Override
	public UserVo convertToVo(User bean) {
		UserVo user = new UserVo();
		BeanUtils.copyProperties(bean, user);
		return user;
	}

}
