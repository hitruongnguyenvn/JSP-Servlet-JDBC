package com.unknown.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.unknown.dao.INewsDAO;
import com.unknown.model.News;
import com.unknown.paging.Pageble;
import com.unknown.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewsDAO newsDAO;
	@Override
	public News save(News news) {
		int newsId = newsDAO.save(news);
		return newsDAO.findOne(newsId);
	}
	@Override
	public News update(News news) {
		News newsOld = newsDAO.findOne(news.getId());
		news.setCreatedBy(newsOld.getCreatedBy());
		news.setCreatedDate(newsOld.getCreatedDate());
		newsDAO.update(news);
		return newsDAO.findOne(news.getId());
	}
	@Override
	public int delete(int[] ids) {
		for(int item : ids) {
			newsDAO.delete(item);
		}
		return 0;
	}
	@Override
	public List<News> findAll(Pageble pageble) {
		return newsDAO.findAll(pageble);
	}
	@Override
	public int getTotalItem() {
		return newsDAO.getTotalItem();
	}
	@Override
	public News findOne(Integer id) {
		return newsDAO.findOne(id);
	}

}
