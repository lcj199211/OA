package com.casd.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.casd.controller.web.common.Authorize;
import com.casd.controller.web.common.AuthorizeProvider;
import com.casd.entity.uc.User;
import com.casd.service.SessionListener;

/**
 * 拦截器 2017-10-28
 * 
 * @author Mr Liao
 * 
 * 
 * */

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private AuthorizeProvider authorizeProvider;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {

			Authorize authPassport = ((HandlerMethod) handler)
					.getMethodAnnotation(Authorize.class);

			User loginUser = (User) request.getSession().getAttribute(
					"loginUser");

			if (loginUser == null) {
				response.sendRedirect(request.getContextPath() + "/login.do");
				return false;
			}
			
			
			//设置同一个账号不能同时在两个地方登陆
			String userId = loginUser.getUserid()+"";
			String oldSessionId = SessionListener.SESSIONID_USER.get(userId);
			if(!request.getSession().getId().equals(oldSessionId)) {
			
				request.getSession().invalidate();
				response.sendRedirect(request.getContextPath() + "/login.do");
				return false;
			}

			// 没有声明需要权限,或者声明不验证权限
			if (authPassport == null)
				return true;
			boolean flag = true;

			// User loginUser =(User)
			// request.getSession().getAttribute("loginUser");

			if (flag
					&& (null == authPassport.code() || authPassport.code()
							.length() > 0)) {
				if (authorizeProvider == null)
					throw new java.lang.NullPointerException();

				flag = authorizeProvider.checkAuthorize(
						request.getSession(true), authPassport.code());
				return flag;
			}
			
	
			/*
			 * if (loginUser==null) {
			 * response.sendRedirect(request.getContextPath()+"/login.do");
			 * return false; }else { return true; }
			 */

		}
		return true;
	}
}
