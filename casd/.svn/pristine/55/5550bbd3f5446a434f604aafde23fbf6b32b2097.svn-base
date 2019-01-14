package com.casd.serviceimpl.construct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.construct.ConstructDepDao;
import com.casd.entity.construct.Construct;
import com.casd.entity.construct.ConstructDep;
import com.casd.entity.construct.ConstructWorkTeam;
import com.casd.service.construct.ConstructService;

@Service
public class ConstructServiceImpl implements ConstructService {
	
	
	@Autowired
	private ConstructDepDao constructDepDao;


	
	@Override
	@Transactional
	public List<Map<String, Object>> constructDepList(int page,
			int pageSize, Ref<Integer> record, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			int count = constructDepDao.getDepCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return constructDepDao.constructDepList(param);
	}

	@Override
	@Transactional
	public List<Map<String, Object>> constructList(int page, int pageSize,
			Ref<Integer> record, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			int count = constructDepDao.getConstructCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return constructDepDao.constructList(param);
	}

	@Override
	public Map<String, Object> getConstructById(Map<String, Object> map) {
		Map<String, Object> data=new HashMap<String, Object>();
		Construct construct= constructDepDao.getConstructById(map);
		int construct_project_id = construct.getConstruct_project_id();
		map.clear();
		map.put("construct_project_id", construct_project_id);
		List<Map<String, Object>> workTeamList= constructDepDao.getConstructWorkTeam(map);
		data.put("construct", construct);
		data.put("workTeamList", workTeamList);
		return data;
	}

	@Override
	public ConstructDep findDepById(String where) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("where", where);

		return constructDepDao.cptDepById(map);
	}

	@Override
	public Map<String, Object> updatectDep(ConstructDep dep) throws Exception {
	
		constructDepDao.updatectDep(dep);
		
		return null;
	}


	@Override
	public Boolean isExist(Map<String, Object>params) {
	
		ConstructDep constructDep=constructDepDao.isExist(params);
		String constuct_project_dep_list = constructDep.getConstuct_project_dep_list();
		
		List list=new ArrayList();
		String[] arrays = constuct_project_dep_list.split("\\s*,\\s*");
		for (String s : arrays) {
			if (s.length() == 0)
				continue;
			Integer i = Integer.parseInt(s);
			if (!list.contains(i))
				list.add(i);
		}
		if(list.contains(Integer.valueOf(params.get("userId").toString()))){
			
			return true;
		}
		return false;
	}
  
	
	@Override
	public void delete_Dep(String where) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("where", where);
		constructDepDao.delete_Dep(map);
	}

	@Override
	@Transactional
	public JSONObject saveConstruct(Construct construct,JSONArray myJsonArray) {
		// TODO Auto-generated method stub
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("erro", "");
		int constructId=construct.getConstruct_project_id();
		if (constructId==0) {
			boolean isExist=constructDepDao.existCon(construct.getConstruct_project_contractId());
			if (!isExist) {
				constructDepDao.saveConstruct(construct);
				constructId=construct.getConstruct_project_id();
			}else {
				jsonObject.put("erro", "项目已存在，不可重复添加");
			}
		}else {
			constructDepDao.saveConstruct(construct);
		}
		if (constructId!=0) {
			for (int i = 0; i < myJsonArray.size(); i++) {
				ConstructWorkTeam constructWorkTeam = new ConstructWorkTeam();
				JSONObject myjObject = myJsonArray.getJSONObject(i);
				int construct_project_workTeam_id=0;
				if (!myjObject.get("construct_project_workTeam_id").toString().equals("")) {
					construct_project_workTeam_id=Integer.valueOf(myjObject.get("construct_project_workTeam_id").toString());
				}
				
				constructWorkTeam.setConstruct_project_workTeam_amount(Double.valueOf(myjObject.get("construct_project_workTeam_amount").toString().equals("")?"0.00":myjObject.get("construct_project_workTeam_amount").toString()));
				constructWorkTeam.setConstruct_project_workTeam_category(Integer.valueOf(myjObject.get("construct_project_workTeam_category").toString()));
				constructWorkTeam.setConstruct_project_workTeam_departmentId(Integer.valueOf(myjObject.get("construct_project_workTeam_departmentId").toString()));
				constructWorkTeam.setConstruct_project_workTeam_id(construct_project_workTeam_id);
				constructWorkTeam.setConstruct_project_workTeam_price(Double.valueOf(myjObject.get("construct_project_workTeam_price").toString().equals("")?"0.00":myjObject.get("construct_project_workTeam_price").toString()));
				constructWorkTeam.setConstruct_project_workTeam_projectId(constructId);
				constructWorkTeam.setConstruct_project_workTeam_userId(Integer.valueOf(myjObject.get("construct_project_workTeam_userId").toString()));
				constructDepDao.saveWorkTeam(constructWorkTeam);
			}
		}
		return jsonObject;
	}

	@Override
	public void delePro(Map<String, Object> map) {
	
		constructDepDao.delePro(map);
	}

	@Override
	public void delete_WorkTeam(String where) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("where", where);
		constructDepDao.delete_WorkTeam(map);
	}

	@Override
	public Map<String, Object> getSupplierMod(String sbf) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("where", sbf);
		return constructDepDao.getSupplierMod(map);
	}

	

}
