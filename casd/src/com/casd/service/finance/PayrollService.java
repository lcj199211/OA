package com.casd.service.finance;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.casd.controller.web.Ref;
import com.casd.entity.finance.Paylist;
import com.casd.entity.finance.Payroll;


public interface PayrollService {

	List<Map<String, Object>> payrollList(int pageIndex, int pageSize,
			Ref<Integer> record, String string) throws Exception;
	
	
	public Map<String, Object> addPayroll(JSONArray myJsonArray,Paylist paylst);


	Map<String, Object> findPaylistByid(String id);


	void delePayRoll(Map<String, Object> map);


	void delePayList(Map<String, Object> map);


}
