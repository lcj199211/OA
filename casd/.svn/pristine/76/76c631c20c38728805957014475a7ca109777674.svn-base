package com.casd.controller.web.common;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.util.StringUtils;

import com.casd.entity.uc.User;

@SuppressWarnings("serial")
public class AuthorityCheck extends TagSupport {

	private AuthorizeProvider authorizeProvider;

	String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	// 权限逻辑处理
	public int doStartTag() {

		if (authorizeProvider == null) {
			authorizeProvider = (AuthorizeProvider) com.casd.controller.web.common.SpringUtil
					.getBean("authorizeProvider");
		}
		boolean flag = authorizeProvider.checkAuthorize(
				pageContext.getSession(), code);

		if (flag) {
			return EVAL_PAGE;
		} else {

			return SKIP_BODY;
		}

	}

	public int doEndTag() {
		return EVAL_PAGE;
	}

	// 释放资源
	public void release() {
		super.release();
	}

}
