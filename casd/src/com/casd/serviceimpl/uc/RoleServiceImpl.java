package com.casd.serviceimpl.uc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.uc.RoleDao;
import com.casd.entity.uc.Role;
import com.casd.service.uc.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Map<String, Object>> roleList(int page, int pageSize,
			Ref<Integer> record, String where) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			Integer count = roleDao.getroleCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return roleDao.roleList(param);
	}

	@Override
	public HashMap<String, Object> findById(Map<String, Object> map) {
	
		return roleDao.findById(map);
	}


	@Transactional
	@Override
	public void addRole(Map<String, Object> map) {
			Map<String, Object> roleMap=new HashMap<String, Object>();
			String ids=map.get("ids").toString();
			String menuId=map.get("menuId").toString().isEmpty()?"0":map.get("menuId").toString();
			Role role=(Role)map.get("role");
			roleDao.saveRole(role);
			int role_id = role.getRole_id();
			roleMap.put("id",menuId );
			roleMap.put("role_id", role_id);
			roleMap.put("menu_id", ids);
			roleDao.saveRoleMenu(roleMap);
	}

	

	@Transactional
	@Override
	public void deleRole(Map<String, Object> map) {
		try {
			roleDao.deleRole(map);
			roleDao.deleRole_Relation(map);
		}catch(Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public List<Integer> getUserProgramIds(int userid) {
		List<Integer> list = new ArrayList<Integer>();

		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		sbf.append(" uc_role_menu rm " 
				+ " LEFT JOIN uc_role r ON rm.role_id=r.role_id " 
				+ " LEFT JOIN uc_user u ON r.role_id= u.role_id" 
				+ " where u.userid="+userid);

		String fields="menu_id";
		param.put("where", sbf.toString());
		param.put("fields", fields);
		String menu_id = roleDao.getListForRang(param);

			String[] arrays = menu_id.split("\\s*,\\s*");
			for (String s : arrays) {
				if (s.length() == 0)
					continue;
				Integer i = Integer.parseInt(s);
				if (!list.contains(i))
					list.add(i);
			}

		return list;

	}

	@Override
	public 	List<Map<String, Object>> seleroleById(String fields, String where) throws Exception {
		Map<String , Object>param=new HashMap<String, Object>();
		param.put("fields",fields );
		param.put("where", where);
		return roleDao.seleroleById(param);
	}

}
