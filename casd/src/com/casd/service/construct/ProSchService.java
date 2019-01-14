package com.casd.service.construct;

import java.util.List;
import java.util.Map;

import com.casd.entity.construct.ProSch;


public interface ProSchService {

	List<Map<String, Object>> getRows(String construct_project_id);

	void save_proSch(ProSch proSch);

	void delete_ProSch(String construct_prosch_id);
	
}
