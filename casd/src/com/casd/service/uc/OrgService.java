package com.casd.service.uc;

import java.util.List;
import java.util.Map;

import com.casd.controller.web.Ref;
import com.casd.entity.uc.Center;
import com.casd.entity.uc.Company;
import com.casd.entity.uc.Department;
import com.casd.entity.uc.User;
import com.casd.entity.uc.Role;

public interface OrgService {


	void deleCompany(Map<String, Object> map);

	void saveCompany(Company company);

	void saveCenter(Center center);

	void deleCenter(Map<String, Object> map);

	void saveDepartment(Department department);

	void deleDepartment(Map<String, Object> map);

	List<Map<String, Object>> queryData(Map<String, Object> map);
	
	


	
}
