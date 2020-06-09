package com.springmvc.dao;

import com.springmvc.services.model.User;

import java.util.List;

public interface UserDao {
	 List<User> selectUser();
}
