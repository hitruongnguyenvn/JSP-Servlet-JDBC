package com.unknown.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	private static SessionUtil instance;

	public static SessionUtil getInstance() {
		if (SessionUtil.instance == null) {
			SessionUtil.instance = new SessionUtil();
		}
		return instance;
	}

	public void putValue(HttpServletRequest rq, String key, Object value) {
		rq.getSession().setAttribute(key, value);
	}

	public Object getValue(HttpServletRequest rq, String key) {
		return rq.getSession().getAttribute(key);
	}

	public void removeValue(HttpServletRequest rq, String key) {
		rq.getSession().removeAttribute(key);
	}
}
