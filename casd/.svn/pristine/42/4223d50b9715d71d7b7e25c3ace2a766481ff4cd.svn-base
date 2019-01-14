package com.casd.service.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.web.multipart.MultipartFile;

import com.casd.controller.web.Ref;
import com.casd.entity.manage.Supplierform;
import com.casd.entity.ownCenter.Leave;

public interface SupplierformService {

	List<Map<String, Object>> supplierformList(int pageIndex, int pageSize,
			Ref<Integer> record, String fields, String string) throws Exception;

	void saveSupplierform(Supplierform supplierform);

	Map<String, Object> getData(String supplierform_id);

	void delete_Supplierform(String supplierform_id);
	void add_Supplierform(String supplierform_id);

	public Map<String, Object> uploadFile(MultipartFile file,HttpServletRequest request);
	List<Map<String, Object>> getData(Map<String, Object> map);
	List<Map<String, Object>> add_supplierformList(int pageIndex,
			int pageSize, Ref<Integer> record, String fields, String string);

	List<Map<String, Object>> getCenter(HashMap<String, Object> map);





	
	
		
	 
}

