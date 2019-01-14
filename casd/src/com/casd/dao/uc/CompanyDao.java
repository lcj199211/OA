package com.casd.dao.uc;

import java.util.List;
import java.util.Map;


public interface CompanyDao {
	
	List<Map<String, Object>> companyList(Map<String, Object> param);
	
	public	int getCompanyCount(Map<String, Object> param);  
}
