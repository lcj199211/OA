package com.casd.service.construct;

import java.util.List;
import java.util.Map;

import com.casd.controller.web.Ref;
import com.casd.entity.construct.PurchaseArrivedHead;
import com.casd.entity.construct.PurchaseEntryClass;
import com.casd.entity.construct.PurchaseHead;
import com.casd.entity.construct.PurchaseHeadClass;

public interface FinalPurchaseService {

	List<Map<String, Object>> finalPurchaseList(int pageIndex, int pageSize,
			Ref<Integer> record, String string) throws Exception;


	Map<String, Object> initFinalPurchase(String string);


	void auditFinalPurchase(String username, String selectRole, String billId, int status);


	Map<String, Object> getData(int flow_bill_id);


	void savePurchaseNum(List<PurchaseEntryClass> entries, Boolean isAllArrive, int construct_purchase_id);


	void updateStatus(Map<String, Object> map);


	void saveArrivePur(String rows, PurchaseArrivedHead arrive);


	Map<String, Object> initArrive(String string);


  public Map<String, Object> purchasing_requisition(Map<String, Object> linkMap);
  
  public Map<String, Object> purchasing_submit(Map<String, Object> map);
  Map<String, Object> return_purchase(Map<String, Object> map);

}
