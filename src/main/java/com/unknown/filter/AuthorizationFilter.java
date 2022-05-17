package com.unknown.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unknown.constant.SystemConstant;
import com.unknown.model.User;
import com.unknown.utils.SessionUtil;

public class AuthorizationFilter implements Filter {
	// ServletContext servletContext;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// filterConfig.getServletContext();
		// this.servletContext = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String URI = request.getRequestURI();
		/*if (URI.startsWith(SystemConstant.URI + "/admin")) {
			User userModel = (User) SessionUtil.getInstance().getValue(request, "userModel");
			if (userModel == null) {
				response.sendRedirect(request.getContextPath() + "/login?action=login&alert=danger&message=notLogin");
			} else {
				if (userModel.getRole().getCode().equals(SystemConstant.ADMIN)) {
					chain.doFilter(request, response);
				} else if (userModel.getRole().getCode().equals(SystemConstant.USER)) {
					response.sendRedirect(
							request.getContextPath() + "/login?action=login&alert=danger&message=notPermission");
				}
			}
		} else {
			chain.doFilter(request, response);
		}*/
		User userModel = (User) SessionUtil.getInstance().getValue(request, "userModel");
		if (URI.startsWith(SystemConstant.URI + "/admin")) {
			if (userModel == null) {
				response.sendRedirect(request.getContextPath() + "/home");
			} else {
				if (userModel.getRole().getCode().equals(SystemConstant.ADMIN)) {
					chain.doFilter(request, response);
				} else if (userModel.getRole().getCode().equals(SystemConstant.USER)) {
					response.sendRedirect(request.getContextPath() + "/home");
				}
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
