package com.casd.controller.web.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.casd.controller.web.common.AuthorizeProvider;
import com.casd.entity.uc.User;
import com.casd.service.tree.MenuService;
import com.casd.service.uc.RoleService;

public class AuthorizeProviderImpl implements AuthorizeProvider {

	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleService roleService;

	protected static final Log log = LogFactory
			.getLog(AuthorizeProviderImpl.class);

	/**
	 * 权限验证处理
	 * 
	 * @author 作者 Mr 廖 E-mail:
	 * 
	 * 
	 * */
	@Override
	public boolean checkAuthorize(HttpSession session, String code) {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			if (session == null)
				return false;
			User user = (User) session.getAttribute("loginUser");

			StringBuffer sbf = new StringBuffer();
			sbf.append("`uc_menu` WHERE program_code IN ('" + code
					+ "') ORDER BY id");
			param.put("where", sbf.toString());
			List<Map<String, Object>> datas = menuService
					.queryListForRang(param);

			if (datas == null || datas.size() == 0)
				return false;

			@SuppressWarnings("unchecked")
			List<Integer> list = (List<Integer>) session
					.getAttribute("__USER_RIGHTS");
			if (list == null) {

				list = roleService.getUserProgramIds(user.getUserid());
				// session.setAttribute("__USER_RIGHTS", list);
			}
			//
			for (Map<String, Object> map : datas) {
				if (list.contains((Integer) map.get("id")))
					return true;
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
		}
		return false;
	}

}
