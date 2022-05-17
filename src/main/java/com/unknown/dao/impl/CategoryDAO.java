package com.unknown.dao.impl;

import java.util.List;

import com.unknown.dao.ICategoryDAO;
import com.unknown.mapper.CategoryMapper;
import com.unknown.model.Category;

public class CategoryDAO implements ICategoryDAO {

	@Override
	public List<Category> findAll() {
		String query = "SELECT * FROM dbo.Category";
		return DataProvider.getInstance().executeQuery(query, new CategoryMapper(), null);
	}

}
