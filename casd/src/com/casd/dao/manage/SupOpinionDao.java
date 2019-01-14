package com.casd.dao.manage;

import java.util.List;
import java.util.Map;

import com.casd.entity.manage.AchReview;
import com.casd.entity.manage.SupOpinion;
import com.casd.entity.tree.Menu;
import com.casd.entity.uc.User;

public interface SupOpinionDao {

	Integer getCount(Map<String, Object> param);

	List<Map<String, Object>> getList(Map<String, Object> param);

	void save_supOpinion(SupOpinion supOpinion);

	List<Map<String, Object>> getData(Map<String, Object> daoMap);

	void delete_data(Map<String, Object> map);


}
