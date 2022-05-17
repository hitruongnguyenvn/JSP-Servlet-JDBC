package com.unknown.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unknown.constant.SystemConstant;
import com.unknown.model.User;
import com.unknown.service.ICategoryService;
import com.unknown.service.IUserService;
import com.unknown.utils.FormUtil;
import com.unknown.utils.SessionUtil;

@WebServlet(urlPatterns = { "/home", "/login", "/logout" })
public class HomeController extends HttpServlet {
	@Inject
	public ICategoryService categoryService;
	@Inject
	public IUserService userService;
	private static final long serialVersionUID = -4824681992465884920L;

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String URI = req.getRequestURI();
		if (URI.startsWith(SystemConstant.URI + "/login") || URI.startsWith(SystemConstant.URI + "/logout")) {
			String alert = req.getParameter("alert");
			String message = req.getParameter("message");
			if (alert != null && message != null) {
				req.setAttribute("alert", alert);
				req.setAttribute("message", resourceBundle.getString(message));
			}
			if (action != null && action.equals("login")) {
				RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
				rd.forward(req, resp);
			} else if (action != null && action.equals("logout")) {
				SessionUtil.getInstance().removeValue(req, "userModel");
				resp.sendRedirect(req.getContextPath() + "/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			req.setAttribute("model", categoryService.findAll().get(1));
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			User model = FormUtil.toModel(User.class, req);
			model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassWord(), 1);
			if (model != null) {
				SessionUtil.getInstance().putValue(req, "userModel", model);
				if (model.getRole().getCode().equals("admin")) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				} else if (model.getRole().getCode().equals("user")) {
					resp.sendRedirect(req.getContextPath() + "/home");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login&alert=danger&message=userOrPassInvalid");
			}
		} else {

		}
	}
	
	public static boolean checkURL(HttpServletRequest req, HttpServletResponse resp) {
		String url = req.getRequestURI();
		if(url.startsWith(SystemConstant.URI + "/admin")) {
			
		}
		return true;
	}
}
