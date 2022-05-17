package com.unknown.dao.impl;

import java.util.List;

import com.unknown.dao.IUserDAO;
import com.unknown.mapper.UserMapper;
import com.unknown.model.User;

public class UserDAO implements IUserDAO {

	@Override
	public User findByUserNameAndPasswordAndStatus(String userName, String passWord, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM Userr");
		sql.append(" JOIN Rolee ON Userr.idRole = Rolee.id");
		sql.append(" WHERE Userr.userName = ? AND Userr.passWord = ? AND Userr.status = ?");
		List<User> users = DataProvider.getInstance().executeQuery(sql.toString(), new UserMapper(), new Object[] {userName, passWord, status});
		return users.isEmpty() ? null : users.get(0);
	}

}
