package com.casd.service.hr;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.casd.entity.hr.Become;
import com.casd.entity.uc.User;

public interface HregisterService {
	
	public Map<String, Object> getAllContrac(String userid);
	
	public void deleteHregister(Map<String, Object> map);
	
	public void deleteContract(Map<String, Object> map);
	
	public void deleteHrSalary(Map<String, Object> map);
	
	public void deleteHrecord(Map<String, Object> map);

	
	public JSONObject savexistence(User user,JSONArray myJsonArray,JSONArray myJsonArray3,JSONArray myJsonArray4)throws Exception;
	
   public void  insertBecome(Become become,String name) throws Exception;
   
   public void  updateFlow(DelegateExecution execution,String status) throws Exception;
   
   public String  becomenextUser(DelegateExecution execution);
   
   public List<Map<String, Object>>  becomeUser(String taskId) throws Exception;
   
   public List<Map<String, Object>> becomecheck(String taskName)throws Exception;
   
   void becomepass(HttpServletRequest request) throws Exception;
	

	
}
