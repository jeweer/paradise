package com.springmvc.services.service.impl;

import com.springmvc.services.dao.UserDao;
import com.springmvc.services.model.User;
import com.springmvc.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public List<User> select() {
		List<User> users = userDao.selectUser();
		return users;
	}
	

}
