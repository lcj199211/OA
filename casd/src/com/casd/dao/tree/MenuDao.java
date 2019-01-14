package com.casd.dao.tree;

import java.util.List;
import java.util.Map;

import com.casd.entity.tree.Menu;
import com.casd.entity.uc.User;

public interface MenuDao {

	 List<Menu>  queryMenuList(Map<String, Object> map);
	 
	 List<Map<String, Object>> menuList(Map<String, Object> params)  throws Exception;
	 
	 int getmenuCount(Map<String, Object> param);	
	 
	 void addMenu(Menu menu);
	 
	 void deleMenu(Map<String, Object> map);
	 
	 Menu findById(Map<String, Object> map);
	 
	 void updateMenu(Menu menu);
	 
	 String findMenu(Map<String, Object> map);

	
	List<Map<String, Object>> queryListForRang(Map<String, Object> map);
}
