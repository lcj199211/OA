package com.casd.dao.finance;

import java.util.List;
import java.util.Map;

import com.casd.entity.finance.Paylist;
import com.casd.entity.finance.Payroll;


public interface  PayrollDao {


	Integer getPayrollListCount(Map<String, Object> param);

	List<Map<String, Object>> payrollList(Map<String, Object> param);
	
	public void insetPayroll(Payroll payroll);

	Map<String, Object> getPayList(Map<String, Object> map);

	List<Map<String, Object>> getPayrolls(Map<String, Object> map);


	void delePayRollByID(Map<String, Object> map);

	void delePayList(Map<String, Object> map);


}
