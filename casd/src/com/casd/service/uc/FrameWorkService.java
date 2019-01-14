package com.casd.service.uc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateExecution;

import com.casd.controller.web.Ref;
import com.casd.entity.uc.Costapp;
import com.casd.entity.uc.FrameWork;

public interface FrameWorkService {

	List<Map<String, Object>> getData(Map<String, Object> map);

	void save_frameWork(FrameWork frameWork);

	List<Map<String, Object>> frameWorkList(int pageIndex, int pageSize,
			Ref<Integer> record, String string) throws Exception;

	void deleFrameWork(String string);

	
	 
}
