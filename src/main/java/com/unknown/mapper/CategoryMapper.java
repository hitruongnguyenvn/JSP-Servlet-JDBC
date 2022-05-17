package com.unknown.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.unknown.model.Category;

public class CategoryMapper implements IRowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs) {
		Category category = new Category();
		try {
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			category.setCode(rs.getString("code"));
			return category;
		} catch (SQLException e) {
			return null;
		}
	}
}
