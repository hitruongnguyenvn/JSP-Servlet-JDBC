package com.unknown.dao;

import java.util.List;

import com.unknown.model.News;
import com.unknown.paging.Pageble;

public interface INewsDAO {
	public int save(News news);
	public News findOne(int id);
	public int update(News news);
	public int delete(int id);
	public List<News> findAll(Pageble pageble);
	public int getTotalItem();
}
