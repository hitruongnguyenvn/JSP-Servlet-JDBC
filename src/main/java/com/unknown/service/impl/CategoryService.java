package com.unknown.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.unknown.dao.ICategoryDAO;
import com.unknown.model.Category;
import com.unknown.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
}
