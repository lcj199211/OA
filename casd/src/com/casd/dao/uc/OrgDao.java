package com.casd.dao.uc;

import java.util.List;
import java.util.Map;

import com.casd.entity.uc.Center;
import com.casd.entity.uc.Company;
import com.casd.entity.uc.Department;


public interface OrgDao {

	void saveCompany(Company company);

	void deleCompany(Map<String, Object> map);

	void saveCenter(Center center);

	void deleCenter(Map<String, Object> map);

	void saveDepartment(Department department);

	void deleDepartment(Map<String, Object> map);

	List<Map<String, Object>> queryData(Map<String, Object> map);

	
}
