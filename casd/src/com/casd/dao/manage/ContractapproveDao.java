package com.casd.dao.manage;

import java.util.List;
import java.util.Map;

import com.casd.entity.manage.AchReview;
import com.casd.entity.manage.Contractapprove;
import com.casd.entity.manage.Reqfunds;
import com.casd.entity.tree.Menu;
import com.casd.entity.uc.User;

public interface ContractapproveDao {
	Integer getCount(Map<String, Object> param);

	List<Map<String, Object>> getList(Map<String, Object> param);

	void saveContractapprove(Contractapprove contractapprove);

	Map<String, Object> getContractapprove(Map<String, Object> map);

	void delete_Contractapprove(Map<String, Object> map);
	void add_Contractapprove(Map<String, Object> map);
	
	
	
	void updatefile(Map<String, Object> uploadVar);
	
	void updateCtp(Contractapprove contractapprove);


	

	

}
