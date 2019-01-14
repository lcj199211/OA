package com.casd.dao.construct;

import java.util.List;
import java.util.Map;

import com.casd.entity.construct.Construct;
import com.casd.entity.construct.PurchaseArriveEntry;
import com.casd.entity.construct.PurchaseArrivedHead;
import com.casd.entity.construct.PurchaseEntry;
import com.casd.entity.construct.PurchaseEntryClass;
import com.casd.entity.construct.PurchaseHead;
import com.casd.entity.construct.PurchaseHeadClass;

public interface  FinalPurchaseDao {


	int getFinalPurchaseCount(Map<String, Object> param);

	List<Map<String, Object>> finalPurchaseList(Map<String, Object> param);

	PurchaseHeadClass getHead(Map<String, Object> map);

	List<Map<String, Object>> getEntry(Map<String, Object> map);

	Map<String, Object> getPHead(Map<String, Object> map);

	List<Map<String, Object>> getPEntry(Map<String, Object> map);

	void updatePurchaseStatus(PurchaseHeadClass purchaseHeadClass);

	void savePurchaseNum(List<PurchaseEntryClass> entries);

	void saveArriveHead(PurchaseArrivedHead arrive);

	void saveArriveEntry(PurchaseArriveEntry purchaseArriveEntry);

	PurchaseArrivedHead getArriveHead(Map<String, Object> map);

	List<Map<String, Object>> getArriveEntry(Map<String, Object> map);

	void updatePurEntryClass(List<PurchaseEntryClass> purchaseEntryClassList);


}
