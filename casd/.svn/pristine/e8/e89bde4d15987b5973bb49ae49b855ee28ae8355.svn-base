package com.casd.serviceimpl.construct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.construct.ConstructDepDao;
import com.casd.dao.construct.LaborCostDao;
import com.casd.entity.construct.Construct;
import com.casd.entity.construct.ConstructDep;
import com.casd.entity.construct.PurchaseEntry;
import com.casd.entity.construct.PurchaseHead;
import com.casd.service.construct.ConstructService;
import com.casd.service.construct.LaborCostService;

@Service
public class LaborCostServiceImpl implements LaborCostService {
	
	
	@Autowired
	private LaborCostDao laborCostDao;

	@Override
	public List<Map<String, Object>> getList(int page, int pageSize,
			Ref<Integer> record, String where) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			int count = laborCostDao.getCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return laborCostDao.getList(param);
	}


	
	
	

}
