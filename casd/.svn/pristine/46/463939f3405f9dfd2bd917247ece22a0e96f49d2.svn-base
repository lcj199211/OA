package com.casd.serviceimpl.construct;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import com.casd.dao.construct.CoQuantitiesDao;
import com.casd.entity.construct.CoQuantities;
import com.casd.service.construct.CoQuantitieService;

@Service
public class CoQuantitieServiceImpl implements  CoQuantitieService{

	@Autowired
	private CoQuantitiesDao cQuantitiesDao;
  

	@Transactional
	@Override
	public Map<String, Object> addquantities(CoQuantities cq)  throws Exception {
		cQuantitiesDao.insert(cq);
		return null;
	}


	@Override
	public void deleteCoQuantitie(String where) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("where", where);
		cQuantitiesDao.deleteQuantities(map);
	}


	@Override
	@Transactional
	public void insert(List<Map<String, Object>> list) {
		      CoQuantities cq=new CoQuantities();
		      
		      
		for (Map<String, Object> params : list) {
			cq.setConstruct_project_quantities_id(0);
			cq.setConstruct_project_quantities_name(params.get("quantities_name").toString());
			cq.setConstruct_project_quantities_model(params.get("quantities_model").toString());
			cq.setConstruct_project_quantities_num(BigDecimal.valueOf(Double.valueOf(params.get("quantities_num").toString())));
			cq.setConstruct_project_quantities_unit(params.get("quantities_unit").toString());
			cq.setConstruct_project_quantities_price(BigDecimal.valueOf(Double.valueOf(params.get("quantities_price").toString())));
			cq.setConstruct_project_quantities_conId(Integer.parseInt(params.get("quantities_conId").toString()));
			cQuantitiesDao.insert(cq);
		
		}
		
		
	}


	@Override
	public int isExistPur(String cid) {
		// TODO Auto-generated method stub
		return cQuantitiesDao.isExistPur(cid);
	}


	@Override
	public int existQuan(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return  cQuantitiesDao.existQuan(map);
	}


	@Override
	public void sum_quantities(Map<String, Object> map) {
		// TODO Auto-generated method stub
		cQuantitiesDao.sum_quantities(map);
	}
   
	 
}
