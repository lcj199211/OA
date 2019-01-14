package com.casd.service.construct;

import java.util.List;
import java.util.Map;

import com.casd.entity.construct.CoQuantities;

public interface CoQuantitieService {
	  
	Map<String, Object> addquantities(CoQuantities cq) throws Exception;
	
	
	void deleteCoQuantitie(String where) throws Exception;
	
	void insert(List<Map<String, Object>> list);


	int isExistPur(String cid);


	int existQuan(Map<String, Object> map);


	void sum_quantities(Map<String, Object> map);
      
}
