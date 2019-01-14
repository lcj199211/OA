package com.casd.service.ownCenter;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.casd.controller.web.Ref;
import com.casd.entity.ownCenter.OwnGoal;



public interface OwnGoalService {

	List<Map<String, Object>> ownGoalList(int pageIndex, int pageSize,
			Ref<Integer> record, String string) throws Exception;

	void saveConstruct(OwnGoal ownGoad);

	void finishOwnGoal(Map<String, Object> map);


		
	 
}