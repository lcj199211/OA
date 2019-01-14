package com.casd.serviceimpl.uc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.casd.controller.web.Ref;
import com.casd.dao.uc.CostappDao;
import com.casd.dao.uc.FrameWorkDao;
import com.casd.dao.uc.UserDao;
import com.casd.entity.uc.Costapp;
import com.casd.entity.uc.FrameWork;
import com.casd.entity.uc.User;
import com.casd.service.hr.ActivitiService;
import com.casd.service.uc.CostappService;
import com.casd.service.uc.FrameWorkService;


@Service
public class FrameWorkServiceImpl implements FrameWorkService {
	@Autowired
	private FrameWorkDao frameWorkDao;

	@Override
	public List<Map<String, Object>> getData(Map<String, Object> map) {
		
		return frameWorkDao.getData(map);
		
	}

	@Override
	public void save_frameWork(FrameWork frameWork) {
		// TODO Auto-generated method stub
		
		frameWorkDao.save_frameWork(frameWork);
	}

	@Override
	public List<Map<String, Object>> frameWorkList(int pageIndex, int pageSize,
			Ref<Integer> record, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			int count = frameWorkDao.getFrameWorkCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", pageIndex < 0 ? 0 : pageIndex
				* pageSize, pageSize));

		return frameWorkDao.frameWorkList(param);
	}

	@Override
	public void deleFrameWork(String id) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		frameWorkDao.deleFrameWork(map);
	}
	
	


	}
