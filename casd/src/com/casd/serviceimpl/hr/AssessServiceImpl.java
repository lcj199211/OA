package com.casd.serviceimpl.hr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casd.controller.web.Ref;
import com.casd.dao.hr.AssessDao;
import com.casd.entity.hr.Assess;
import com.casd.entity.hr.AssessEntry;
import com.casd.entity.hr.AssessEva;
import com.casd.entity.hr.AssessHead;
import com.casd.service.hr.AssessService;



@Service
public class AssessServiceImpl implements AssessService{

	
	 @Autowired
	private AssessDao assessDao;
	  

	@Override
	public Boolean isExistEva(String username) {
		// TODO Auto-generated method stub
		return assessDao.isExistEva(username);
	}


	@Override
	public List<Map<String, Object>> initAssessEntry() {
		// TODO Auto-generated method stub
		return assessDao.initAssessEntry();
	}


	@Override
	public void saveAssessHead(AssessHead assessHead) {
		// TODO Auto-generated method stub
		assessDao.saveAssessHead(assessHead);
	}


	@Override
	public void saveAssessEntry(List<AssessEntry> entries) {
		// TODO Auto-generated method stub
		assessDao.saveAssessEntry(entries);
	}


	@Override
	public List<Map<String, Object>> assessList(int page, int pageSize,
			Ref<Integer> record, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			Integer count = assessDao.getAssessCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return assessDao.assessList(param);
	}


	@Override
	public List<Map<String, Object>> getAssessEntry(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return assessDao.getAssessEntry(map);
	}


	@Override
	public AssessHead getAssessHead(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return assessDao.getAssessHead(map);
	}


	@Override
	public void startAssess() {
		// TODO Auto-generated method stub
		assessDao.startAssess();
	}


	@Override
	public void stopAssess() {
		// TODO Auto-generated method stub
		assessDao.stopAssess();
	}


	@Override
	public List<Map<String, Object>> initEva() {
		// TODO Auto-generated method stub
		return assessDao.initEva();
	}


	@Override
	public List<Map<String, Object>> initCont() {
		// TODO Auto-generated method stub
		return assessDao.initCont();
	}


	@Override
	public void saveCont(Assess assess) {
		// TODO Auto-generated method stub
		assessDao.saveCont(assess);
	}


	@Override
	public void delectCont(Map<String, Object> map) {
		// TODO Auto-generated method stub
		assessDao.delectCont(map);
	}


	@Override
	public void saveEva(AssessEva assessEva) {
		// TODO Auto-generated method stub
		assessDao.saveEva(assessEva);
	}


	@Override
	public void delectEva(Map<String, Object> map) {
		// TODO Auto-generated method stub
		assessDao.delectEva(map);
	}


	@Override
	public void delectData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		assessDao.delectData(map);
	}

}
