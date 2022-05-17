package com.unknown.service.impl;

import javax.inject.Inject;

import com.unknown.dao.IUserDAO;
import com.unknown.model.User;
import com.unknown.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;
	
	@Override
	public User findByUserNameAndPasswordAndStatus(String userName, String passWord, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, passWord, status);
	}

}
