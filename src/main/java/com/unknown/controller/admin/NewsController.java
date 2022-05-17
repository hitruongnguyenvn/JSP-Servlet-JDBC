package com.unknown.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unknown.constant.SystemConstant;
import com.unknown.model.News;
import com.unknown.paging.PageRequest;
import com.unknown.paging.Pageble;
import com.unknown.service.ICategoryService;
import com.unknown.service.INewsService;
import com.unknown.sort.Sort;
import com.unknown.utils.FormUtil;
import com.unknown.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-news" })
public class NewsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private INewsService newsService;
	
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		News model = FormUtil.toModel(News.class, req);
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sort(model.getSortName(), model.getSortBy()));
		int totalItem = newsService.getTotalItem();
		int maxPageItem = model.getMaxPageItem();
		int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
		model.setTotalPage(totalPage);
		model.setModels(newsService.findAll(pageble));
		req.setAttribute(SystemConstant.MODEL, model);
		MessageUtil.showMessage(req);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/news/list.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		News model = FormUtil.toModel(News.class, req);
		if(model.getId() != null) {
			model = newsService.findOne(model.getId());
		}
		req.setAttribute("categories", categoryService.findAll());
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/news/edit.jsp");
		requestDispatcher.forward(req, resp);
	}

}
