package com.casd.service.construct;

import java.util.List;
import java.util.Map;

import com.casd.controller.web.Ref;
import com.casd.entity.construct.PurChange;
import com.casd.entity.construct.PurchaseHead;
import com.casd.entity.construct.PurchaseHeadClass;

public interface PurChangeService {

	List<Map<String, Object>> purchaseList(String filds, int pageIndex,
			int pageSize, Ref<Integer> record, String string) throws Exception;

	void submitPurChange(PurChange purChange, String rows, String username,
			String auditor);

	int savePurChange(PurChange purChange, String rows);

	Map<String, List<Map<String, Object>>> getPurChangeData(
			Map<String, Object> map);

	String delete_purChange(Map<String, Object> map);

	String delete_purChangeEntry(Map<String, Object> map);

	String audit_purChange(Map<String, Object> map);

}
