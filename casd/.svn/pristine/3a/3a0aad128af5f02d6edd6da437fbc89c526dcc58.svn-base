package com.casd.serviceimpl.uc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.dao.uc.OrgDao;
import com.casd.entity.uc.Center;
import com.casd.entity.uc.Company;
import com.casd.entity.uc.Department;
import com.casd.service.uc.OrgService;

@Service
public class OrgServiceImpl implements OrgService {

	@Autowired
	private OrgDao OrgDao;

	@Override
	public void saveCompany(Company company) {
		// TODO Auto-generated method stub
		OrgDao.saveCompany(company);
		
	}

	@Override
	public void deleCompany(Map<String, Object> map) {
		// TODO Auto-generated method stub
		OrgDao.deleCompany(map);
	}
	
	@Override
	public void saveCenter(Center center) {
		// TODO Auto-generated method stub
		OrgDao.saveCenter(center);
		
	}

	@Override
	public void deleCenter(Map<String, Object> map) {
		// TODO Auto-generated method stub
		OrgDao.deleCenter(map);
	}
	
	
	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		OrgDao.saveDepartment(department);
		
	}

	@Override
	public void deleDepartment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		OrgDao.deleDepartment(map);
	}

	@Override
	@Transactional
	public List<Map<String, Object>> queryData(Map<String, Object> map) {
		
		return OrgDao.queryData(map);
		
	}
	
	
	
	
}
