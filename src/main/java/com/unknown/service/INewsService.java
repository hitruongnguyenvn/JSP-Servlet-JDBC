package com.unknown.service;

import java.util.List;

import com.unknown.model.News;
import com.unknown.paging.Pageble;

public interface INewsService {
	public News save(News news);
	public News update(News news);
	public int delete(int[] ids);
	public List<News> findAll(Pageble pageble);
	public int getTotalItem();
	public News findOne(Integer id);
}
