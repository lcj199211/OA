package com.casd.dao.finance;

import java.util.List;
import java.util.Map;



import com.casd.entity.finance.Construct_change_head;
import com.casd.entity.finance.Supplier;


public interface SupplierDao {

	void saveSupplier(Supplier supplier);

	void deleSupplier(Map<String, Object> map);
	
	int add_change_head(Construct_change_head construct_change_head);
	
	void updateStatus(Map<String, Object> map);
	
	List<Map<String, Object>>findPriceratio(Map<String, Object> map);
	
	
	void new_update_price(Map<String, Object> map);
	
	void add_changeHead();
	


}
