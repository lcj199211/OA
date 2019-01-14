package com.casd.dao.construct;

import java.util.List;
import java.util.Map;

import com.casd.entity.construct.Construct;
import com.casd.entity.construct.ConstructDep;
import com.casd.entity.construct.ProSch;

public interface  ProSchDao {

	List<Map<String, Object>> getRows(Map<String, Object> map);

	void save_proSch(ProSch proSch);

	void delete_ProSch(Map<String, Object> map);

}


