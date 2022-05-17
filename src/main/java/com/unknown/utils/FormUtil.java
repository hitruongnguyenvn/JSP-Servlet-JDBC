package com.unknown.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> tclass, HttpServletRequest req) {
		T object = null;
		try {
			object = tclass.newInstance();
			BeanUtils.populate(object, req.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return object;
	}
}
