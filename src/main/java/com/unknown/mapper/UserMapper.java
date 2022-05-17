package com.unknown.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.unknown.model.Role;
import com.unknown.model.User;

public class UserMapper implements IRowMapper<User> {

	@Override
	public User mapRow(ResultSet rs) {
		User user = new User();
		try {
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("userName"));
			user.setPassWord(rs.getString("passWord"));
			user.setFullName(rs.getString("fullName"));
			user.setStatus(rs.getInt("status"));
			user.setIdRole(rs.getInt("idRole"));
			try {
				Role role = new Role();
				role.setName(rs.getString("name"));
				role.setCode(rs.getString("code"));
				user.setRole(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
