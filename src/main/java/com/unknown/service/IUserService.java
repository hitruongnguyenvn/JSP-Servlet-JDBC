package com.unknown.service;

import com.unknown.model.User;

public interface IUserService {
	public User findByUserNameAndPasswordAndStatus(String userName, String passWord, Integer status);
}
