package com.casd.dao.hr;

import java.util.List;
import java.util.Map;

import com.casd.entity.hr.Assess;
import com.casd.entity.hr.AssessEntry;
import com.casd.entity.hr.AssessEva;
import com.casd.entity.hr.AssessHead;


public interface AssessDao {

	Boolean isExistEva(String username);

	List<Map<String, Object>> initAssessEntry();

	void saveAssessHead(AssessHead assessHead);

	void saveAssessEntry(List<AssessEntry> entries);

	Integer getAssessCount(Map<String, Object> param);

	List<Map<String, Object>> assessList(Map<String, Object> param);

	List<Map<String, Object>> getAssessEntry(Map<String, Object> map);

	AssessHead getAssessHead(Map<String, Object> map);

	void startAssess();

	void stopAssess();

	List<Map<String, Object>> initEva();

	List<Map<String, Object>> initCont();

	void saveCont(Assess assess);

	void delectCont(Map<String, Object> map);

	void saveEva(AssessEva assessEva);

	void delectEva(Map<String, Object> map);

	void delectData(Map<String, Object> map);
	
}
