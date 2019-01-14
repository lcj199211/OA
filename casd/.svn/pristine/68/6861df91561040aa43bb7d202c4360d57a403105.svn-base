package com.casd.serviceimpl.construct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.construct.ConstructDepDao;
import com.casd.dao.construct.ProSchDao;
import com.casd.entity.construct.Construct;
import com.casd.entity.construct.ConstructDep;
import com.casd.entity.construct.ProSch;
import com.casd.entity.construct.PurchaseEntry;
import com.casd.entity.construct.PurchaseHead;
import com.casd.service.construct.ConstructService;
import com.casd.service.construct.ProSchService;

@Service
public class ProSchServiceImpl implements ProSchService {
	
	
	@Autowired
	private ProSchDao proSchDao;

	@Override
	@Transactional
	public List<Map<String, Object>> getRows(
			String construct_project_id) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("where", construct_project_id);
		return proSchDao.getRows(map);
	}

	@Override
	@Transactional
	public void save_proSch(ProSch proSch) {
		// TODO Auto-generated method stub
		proSchDao.save_proSch(proSch);
	}

	@Override
	public void delete_ProSch(String construct_prosch_id) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("construct_prosch_id", construct_prosch_id);
		proSchDao.delete_ProSch(map);
	}



}
