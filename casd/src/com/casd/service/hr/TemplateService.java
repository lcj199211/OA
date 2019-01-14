package com.casd.service.hr;

import java.util.List;
import java.util.Map;

import com.casd.controller.web.Ref;
import com.casd.entity.hr.TemplateModel;

public interface TemplateService {
	
	
	List<Map<String, Object>> templateData(int pageIndex, int pageSize,
			Ref<Integer> record, String fields, String where) throws Exception;
	
	 Map<String, Object> findTemplateById(String fields, String where);
	 
	 public void updateTemplate(TemplateModel templateModel);
	 
	 public void deleteTemplate(String where);

	

}
