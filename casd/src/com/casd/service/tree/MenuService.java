package com.casd.service.tree;

import java.util.List;
import java.util.Map;

import com.casd.controller.web.Ref;
import com.casd.entity.tree.Menu;
import com.casd.entity.uc.User;

public interface MenuService {

	List<Menu> queryMenuList(Map<String, Object> map);

	List<Map<String, Object>> menuList(int page, int pageSize,
			Ref<Integer> record, String where, String searchId,
			String searchName) throws Exception;

	void addMenu(Menu menu);

	void deleMenu(Map<String, Object> map);

	Menu findById(Map<String, Object> map);

	void updateMenu(Menu menu);

	String findMenu(Map<String, Object> map);

	public List<Map<String, Object>> queryListForRang(Map<String, Object> map);

}
