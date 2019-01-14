package com.casd.service.manage;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateExecution;

import com.casd.controller.web.Ref;
import com.casd.entity.manage.AchReview;
import com.casd.entity.manage.AttendPlace;
import com.casd.entity.ownCenter.Leave;

public interface AttendPlaceService {

	void save_place(AttendPlace attendPlace);

	void dele_place(Map<String, Object> deleMap);



		
	 
}
