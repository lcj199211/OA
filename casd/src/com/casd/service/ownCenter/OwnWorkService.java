package com.casd.service.ownCenter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.activiti.engine.delegate.DelegateExecution;

import com.casd.controller.web.Ref;
import com.casd.entity.ownCenter.OwnPurchaseHead;
import com.casd.entity.ownCenter.OwnWorkEntry;
import com.casd.entity.ownCenter.OwnWorkHead;

public interface OwnWorkService {

	void save_workArrang(OwnWorkHead ownWorkHead, JSONArray myJsonArray, HttpServletRequest request);

	List<Map<String, Object>> ownWorkList(int pageIndex, int pageSize,
			Ref<Integer> record, String string) throws Exception;

	Map<String, Object> getOwnWorkById(int own_workArranged_categoryId);

	void update_work(OwnWorkEntry ownWorkEntry);

	void delete_workerEntry(Map<String, Object> map);

	void delete_workerHead(Map<String, Object> map);

	Map<String, Object> selectArrCount(HttpServletRequest request);
	
	
}
