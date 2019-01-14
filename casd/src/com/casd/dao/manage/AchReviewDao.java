package com.casd.dao.manage;

import java.util.List;
import java.util.Map;

import com.casd.entity.manage.AchReview;
import com.casd.entity.tree.Menu;
import com.casd.entity.uc.User;

public interface AchReviewDao {

	Integer getCount(Map<String, Object> param);

	List<Map<String, Object>> getList(Map<String, Object> param);

	void save_achReview(AchReview achReview);

	List<Map<String, Object>> getData(Map<String, Object> daoMap);

	void delete_data(Map<String, Object> map);

}
