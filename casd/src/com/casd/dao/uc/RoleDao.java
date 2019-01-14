package com.casd.dao.uc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.casd.entity.tree.Menu;
import com.casd.entity.uc.User;
import com.casd.entity.uc.Role;

public interface RoleDao {

	 List<Map<String, Object>> roleList(Map<String, Object> params)  throws Exception;

	 int getroleCount(Map<String, Object> param);	
	 
	 HashMap<String, Object> findById(Map<String, Object> map);
	 void addRole(Map<String, Object> roleMap);


	void deleRole(Map<String, Object> map);

	void deleRole_Relation(Map<String, Object> map);
	
	String getListForRang(Map<String, Object> param);
	public List<Map<String, Object>> seleroleById(Map<String, Object> params)  throws Exception;

	void saveRole(Role role);

	void saveRoleMenu(Map<String, Object> roleMap);
}
