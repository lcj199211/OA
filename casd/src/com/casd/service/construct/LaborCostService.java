package com.casd.service.construct;

import java.util.List;
import java.util.Map;

import com.casd.controller.web.Ref;
import com.casd.entity.construct.ApartyMaterial;
import com.casd.entity.construct.ApartyPur;


public interface LaborCostService {

	List<Map<String, Object>> getList(int pageIndex, int pageSize,
			Ref<Integer> record, String string) throws Exception;


	
}
