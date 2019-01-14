package com.casd.serviceimpl.manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.manage.AchReviewDao;
import com.casd.dao.manage.AttendPlaceDao;
import com.casd.dao.uc.UserDao;
import com.casd.entity.manage.AchReview;
import com.casd.entity.manage.AttendPlace;
import com.casd.entity.uc.User;
import com.casd.service.hr.ActivitiService;
import com.casd.service.manage.AchReviewService;
import com.casd.service.manage.AttendPlaceService;
import com.casd.service.uc.UserService;

@Service
public class AttendPlaceServiceImpl implements AttendPlaceService {
	
	@Autowired
	private AttendPlaceDao attendPlaceDao;
	
	@Override
	@Transactional
	public void save_place(AttendPlace attendPlace) {
		// TODO Auto-generated method stub
		attendPlaceDao.save_place(attendPlace);
		
	}

	@Override
	@Transactional
	public void dele_place(Map<String, Object> deleMap) {
		// TODO Auto-generated method stub
		attendPlaceDao.dele_place(deleMap);

	}

	
	
	
	
}
