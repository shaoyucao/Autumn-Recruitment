package com.syc.service.impl;

import com.syc.dao.UserDao;
import com.syc.domain.User;
import com.syc.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void register(User user) {
		this.userDao.save(user);
	}

}
