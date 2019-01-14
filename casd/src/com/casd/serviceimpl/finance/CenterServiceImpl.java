package com.casd.serviceimpl.finance;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casd.controller.web.Ref;
import com.casd.dao.uc.CenterDao;
import com.casd.service.finance.CenterService;

@Service
public class CenterServiceImpl implements CenterService {

	@Autowired
	private CenterDao centerDao;
	
	@Override
	public List<Map<String, Object>> centerList(int page, int pageSize,
			Ref<Integer> record, String fields, String where) throws Exception {
		 Map<String, Object> param=new HashMap<String, Object>();

		 param.put("fields", fields);
         param.put("where", where);

		   if (record != null) {
				Integer count=centerDao.getCenterCount(param);
				record.setValue(count);
			}
		 //分页
		   
		   if (pageSize <= 0)
				throw new Exception("pageSize 必须 > 0");

		          param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
					* pageSize, pageSize));

		return centerDao.centerList(param);
	}

	@Override
	public List<Map<String, Object>> finance(String fields, String where) {
		Map<String, Object> param=new HashMap<String, Object>();

		 param.put("fields", fields);
        param.put("where", where);

		return centerDao.finance(param);
	}

	
	
}