package com.casd.serviceimpl.finance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.finance.PaylstDao;
import com.casd.dao.finance.PayrollDao;
import com.casd.entity.finance.Paylist;
import com.casd.entity.finance.Payroll;
import com.casd.service.finance.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	private PayrollDao payrollDao;
	@Autowired
	private PaylstDao paylstDao;
	
	 
	@Override
	public List<Map<String, Object>> payrollList(int page, int pageSize,
			Ref<Integer> record, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			Integer count = payrollDao.getPayrollListCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return payrollDao.payrollList(param);
	}

	@Override
	@Transactional
	public Map<String, Object> addPayroll(JSONArray myJsonArray,Paylist paylist) {
		List<Payroll> list=new ArrayList<Payroll>();
		int paylist_id=paylist.getGad_paylist_id();
		int gad_paylist_id=paylist.getGad_paylist_id();
		if(gad_paylist_id==0){
			paylstDao.insetPaylst(paylist);
			gad_paylist_id=paylist.getGad_paylist_id();
		}else{
			paylstDao.insetPaylst(paylist);
		}
		for (int i = 0; i < myJsonArray.size(); i++) {
			Payroll payroll=new Payroll();
			JSONObject myjObject = myJsonArray.getJSONObject(i);
			
			Iterator<String> sIterator = myjObject.keys();
			Map<String, Object> keyMap=new HashMap<String, Object>();
			while(sIterator.hasNext()){  
			    String key = sIterator.next();  
			    String value = myjObject.getString(key);
			    keyMap.put(key, value);
			}
			
			if(paylist_id!=0 && keyMap.containsKey("wages_id")){
			String wages_id = ((myjObject.getString("wages_id").isEmpty()?"0": myjObject.getString("wages_id")));
			payroll.setWages_id(Integer.parseInt(wages_id));
			
			}else {
			payroll.setWages_id(0);
			}
			if(keyMap.containsKey("user_name")){
			payroll.setUser_name(myjObject.getString("user_name")==null?"":myjObject.getString("user_name"));
			}else {
				payroll.setUser_name("");
			}
			if(keyMap.containsKey("role_name")){
			payroll.setRole_name(myjObject.getString("role_name"));
			}else {
				payroll.setRole_name("");
			}
			if(keyMap.containsKey("attendances")){
			payroll.setAttendances(Double.parseDouble(myjObject.getString("attendances").toString().isEmpty()?"0":myjObject.getString("attendances").toString()));
			}else {
				payroll.setAttendances(0);
			}
			if(keyMap.containsKey("vacation")){
			payroll.setVacation(Double.parseDouble(myjObject.getString("vacation").toString().isEmpty()?"0":myjObject.getString("vacation").toString()));
			}else {
				payroll.setVacation(0);
			}
			if(keyMap.containsKey("go_out")){
			payroll.setGo_out(Double.parseDouble(myjObject.getString("go_out").toString().isEmpty()?"0":myjObject.getString("go_out").toString()));
			}else {
				payroll.setGo_out(0);
			}
			if(keyMap.containsKey("leave_day")){
			payroll.setLeave_day(Double.parseDouble(myjObject.getString("leave_day").toString().isEmpty()?"0":myjObject.getString("leave_day").toString()));
			}else {
				payroll.setLeave_day(0);
			}
			if(keyMap.containsKey("base_pay")){
			payroll.setBase_pay(Double.parseDouble(myjObject.getString("base_pay").toString().isEmpty()?"0":myjObject.getString("base_pay").toString()));
			}else {
				payroll.setBase_pay(0);
			}
			if(keyMap.containsKey("years_wages")){
			payroll.setYears_wages(Double.parseDouble(myjObject.getString("years_wages").toString().isEmpty()?"0":myjObject.getString("years_wages").toString()));
			}else {
				payroll.setYears_wages(0);
			}
			if(keyMap.containsKey("post_wage")){
			payroll.setPost_wage(Double.parseDouble(myjObject.getString("post_wage").toString().isEmpty()?"0":myjObject.getString("post_wage").toString()));
			}else {
				payroll.setPost_wage(0);
			}
			if(keyMap.containsKey("technical_wages")){
			payroll.setTechnical_wages(Double.parseDouble(myjObject.getString("technical_wages").toString().isEmpty()?"0":myjObject.getString("technical_wages").toString()));
			}else {
				payroll.setTechnical_wages(0);
			}
			if(keyMap.containsKey("total_wages")){
			payroll.setTotal_wages(Double.parseDouble(myjObject.getString("total_wages").toString().isEmpty()?"0":myjObject.getString("total_wages").toString()));
			}else {
				payroll.setTotal_wages(0);
			}
			if(keyMap.containsKey("meal_supplement")){
			payroll.setMeal_supplement(Double.parseDouble(myjObject.getString("meal_supplement").toString().isEmpty()?"0":myjObject.getString("meal_supplement").toString()));
			}else {
				payroll.setMeal_supplement(0);
			}
			if(keyMap.containsKey("phone_subsidy")){
			payroll.setPhone_subsidy(Double.parseDouble(myjObject.getString("phone_subsidy").toString().isEmpty()?"0":myjObject.getString("phone_subsidy").toString()));
			}else {
				payroll.setPhone_subsidy(0);
			}
			if(keyMap.containsKey("deduction")){
			payroll.setDeduction(Double.parseDouble(myjObject.getString("deduction").toString().isEmpty()?"0":myjObject.getString("deduction").toString()));
			}else {
				payroll.setDeduction(0);
			}
			if(keyMap.containsKey("should_wages")){
			payroll.setShould_wages(Double.parseDouble(myjObject.getString("should_wages").toString().isEmpty()?"0":myjObject.getString("should_wages").toString()));
			}else {
				payroll.setShould_wages(0);
			}
			if(keyMap.containsKey("social_security")){
			payroll.setSocial_security(Double.parseDouble(myjObject.getString("social_security").toString().isEmpty()?"0":myjObject.getString("social_security").toString()));
			}else {
				payroll.setSocial_security(0);
			}
			if(keyMap.containsKey("any_other")){
			payroll.setAny_other(Double.parseDouble(myjObject.getString("any_other").toString().isEmpty()?"0":myjObject.getString("any_other").toString()));
			}else {
				payroll.setAny_other(0);
			}
			if(keyMap.containsKey("payroll")){
			payroll.setPayroll(Double.parseDouble(myjObject.getString("payroll").toString().isEmpty()?"0":myjObject.getString("payroll").toString()));
			}else {
				payroll.setPayroll(0);
			}
			if(keyMap.containsKey("remarks")){
			payroll.setRemarks(myjObject.getString("remarks"));
			}else {
				payroll.setRemarks("");
			}
			
			payroll.setFinance_paylist_id(gad_paylist_id);
            list.add(payroll);

		}
		//批量插入
		for (int i = 0; i < list.size(); i++) {
			payrollDao.insetPayroll(list.get(i));
			
		}
		return null;
	}

	@Override
	public Map<String, Object> findPaylistByid(String id) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Map<String, Object>> listMaps=new ArrayList<Map<String, Object>>();
		Map<String, Object> data=new HashMap<String, Object>();
		Map<String, Object> paylistMap=new HashMap<String, Object>();
		map.put("what", id);
		paylistMap=payrollDao.getPayList(map);
		listMaps=payrollDao.getPayrolls(map);
		data.put("paylist", paylistMap);
		data.put("listPayrolls", listMaps);
		return data;
	}

	@Override
	@Transactional
	public void delePayRoll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		payrollDao.delePayRollByID(map);
		
	}
	
	@Override
	@Transactional
	public void delePayList(Map<String, Object> map) {
		payrollDao.delePayList(map);
	}
	
	
	
}