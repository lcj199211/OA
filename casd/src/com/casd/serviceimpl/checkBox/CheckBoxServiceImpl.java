package com.casd.serviceimpl.checkBox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casd.controller.web.Ref;
import com.casd.dao.checkBox.CheckBoxDao;
import com.casd.dao.uc.CenterDao;
import com.casd.service.checkBox.CheckBoxService;

@Service
public class CheckBoxServiceImpl implements CheckBoxService {

	
	@Autowired
	private CheckBoxDao checkBoxDao;
	
	@Override
	public List<Map<String, Object>> getList(int page, int pageSize,
			Ref<Integer> record, String where, String fields) throws Exception {
		Map<String, Object> param=new HashMap<String, Object>();

		 param.put("fields", fields);
        param.put("where", where);

		   if (record != null) {
				Integer count=checkBoxDao.getCount(param);
				record.setValue(count);
			}
		 //分页
		   
		   if (pageSize <= 0)
				throw new Exception("pageSize 必须 > 0");

		          param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
					* pageSize, pageSize));

		return checkBoxDao.getList(param);
	}
	
	
	
}
