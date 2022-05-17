package com.unknown.utils;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {

	public static ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	public static void showMessage(HttpServletRequest rq) {
		String message = rq.getParameter("message");
		String alert = rq.getParameter("alert");
		if (alert != null || message != null) {
			if (alert.equals("success")) {
				rq.setAttribute("alert", alert);
				rq.setAttribute("message", resourceBundle.getString(message));
			} else if (alert.equals("danger")) {
				rq.setAttribute("alert", alert);
				rq.setAttribute("message", resourceBundle.getString(message));
			}
		}
	}
}
