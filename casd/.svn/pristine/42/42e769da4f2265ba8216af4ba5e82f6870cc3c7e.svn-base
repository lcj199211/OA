package com.casd.controller.web.common;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	public static WebApplicationContext getWebApplicationContext() {
		return (WebApplicationContext) applicationContext;
	}

	public static String getMessage(String key, Object[] args, Locale locale) {
		return applicationContext.getMessage(key, args, locale);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<?> cla) {
		return (T) applicationContext.getBean(cla);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {

		SpringUtil.applicationContext = applicationContext;
	}
}