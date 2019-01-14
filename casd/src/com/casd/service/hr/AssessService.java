package com.casd.service.hr;

import java.util.List;
import java.util.Map;

import com.casd.controller.web.Ref;
import com.casd.entity.hr.Assess;
import com.casd.entity.hr.AssessEntry;
import com.casd.entity.hr.AssessEva;
import com.casd.entity.hr.AssessHead;

public interface AssessService {

	Boolean isExistEva(String username);

	List<Map<String, Object>> initAssessEntry();

	void saveAssessHead(AssessHead assessHead);

	void saveAssessEntry(List<AssessEntry> entries);

	List<Map<String, Object>> assessList(int pageIndex, int pageSize,
			Ref<Integer> record, String string) throws Exception;

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
