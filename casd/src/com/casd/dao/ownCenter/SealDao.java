package com.casd.dao.ownCenter;

import java.util.List;
import java.util.Map;

import com.casd.entity.ownCenter.Seal;

public interface SealDao {

	Integer getCount(Map<String, Object> param);

	List<Map<String, Object>> getList(Map<String, Object> param);

	void save_seal(Seal seal);

	List<Map<String, Object>> getData(Map<String, Object> daoMap);

	void delete_data(Map<String, Object> map);
	
	void updateSeal(Seal seal);
	
	 Seal findSealById(Map<String, Object> map);
	

}
