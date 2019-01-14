package com.casd.service.sciAndTec;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.casd.entity.sciAndTec.CheckPro;
import com.casd.entity.sciAndTec.CheckRecordEntry;
import com.casd.entity.sciAndTec.CheckRecordHead;

public interface MaintService {

	void saveCheckCon(CheckPro checkPro, JSONArray myJsonArray);

	Map<String, Object> getCheckContentById(Map<String, Object> map);

	void delete_checkCon(Map<String, Object> map);

	void dele_checkPro(Map<String, Object> map);

	void add_record(CheckRecordHead checkRecordHead);

	void dele_checkRecord(String id);

	void update_record(CheckRecordEntry checkRecordEntry);
	
	List<CheckRecordEntry> getEntryList(String fields,String where);



		
	 
}
