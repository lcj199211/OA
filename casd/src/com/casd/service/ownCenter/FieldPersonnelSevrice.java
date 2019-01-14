package com.casd.service.ownCenter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.casd.controller.web.Ref;
import com.casd.entity.ownCenter.FieldPersonnel;

public interface FieldPersonnelSevrice {

	List<Map<String, Object>> findFieldpList(int page, int pageSize,
			Ref<Integer> record,String fields, String where) throws Exception;
	
	 void  addFieldPersonne(FieldPersonnel fieldPersonnel,String username) throws Exception;  
	 
	 void  deleteFieldPsl(String where); 
	
	public void updateFieldPslExt(DelegateExecution execution, String status);
	
	public Map<String, Object>	fieldPersonnelPass(HttpServletRequest request);
	
	public void updateFieldPsl(FieldPersonnel fieldPersonnel);
	
	//流程定义类方法
	  public  String fieldPslNextUser(DelegateExecution execution);

}
