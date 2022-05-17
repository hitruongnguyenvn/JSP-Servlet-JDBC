package com.unknown.dao;

import com.unknown.model.User;

public interface IUserDAO {
	public User findByUserNameAndPasswordAndStatus(String userName, String passWord, Integer status);
}
