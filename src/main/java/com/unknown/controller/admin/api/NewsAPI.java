package com.unknown.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unknown.model.News;
import com.unknown.service.INewsService;
import com.unknown.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewsService newsService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		News news = HttpUtil.of(req.getReader()).toModel(News.class);
		news = newsService.save(news);
		objectMapper.writeValue(resp.getOutputStream(), news);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		News news = HttpUtil.of(req.getReader()).toModel(News.class);
		news = newsService.update(news);
		objectMapper.writeValue(resp.getOutputStream(), news);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		News news = HttpUtil.of(req.getReader()).toModel(News.class);
		newsService.delete(news.getIds());
		objectMapper.writeValue(resp.getOutputStream(), "{}");
	}
}
