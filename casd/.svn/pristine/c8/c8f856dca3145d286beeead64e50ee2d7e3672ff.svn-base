package com.casd.serviceimpl.hr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.hr.TemplateModelDao;
import com.casd.entity.hr.TemplateModel;
import com.casd.service.hr.TemplateService;

@Service
public class TemplateServiceImpl implements TemplateService{
	
	@Autowired
	private TemplateModelDao templateModelDao;

	@Override
	public List<Map<String, Object>> templateData(int pageIndex, int pageSize,
			Ref<Integer> record, String fields, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fields", fields);
		param.put("where", where);
		
		if (record != null) {
			Integer count = templateModelDao.countemplate(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");
		param.put("limit", String.format("limit %1$s,%2$s", pageIndex < 0 ? 0 : pageIndex
				* pageSize, pageSize));
		return templateModelDao.listTemplate(param);
	}

	@Override
	public Map<String, Object> findTemplateById(String fields, String where) {
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("fields", fields);
		param.put("where", where);
		
		return templateModelDao.findTemplate(param);
	}

	
	@Transactional
	public void updateTemplate(TemplateModel templateModel) {
		
		
		//添加模板
		if (templateModel.getHr_templatel_id()==0) {
		
			templateModelDao.insertTemplate(templateModel);
	    //修改模板
		}else {
			templateModelDao.updateTemplate(templateModel);
		}	
	}

	@Transactional
	public void deleteTemplate(String where) {
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("where", where);
		templateModelDao.deleteTemplate(map);
	}
	
	

}
