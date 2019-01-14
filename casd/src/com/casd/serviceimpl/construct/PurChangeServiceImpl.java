package com.casd.serviceimpl.construct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.construct.ConstructDepDao;
import com.casd.dao.construct.PurChangeDao;
import com.casd.dao.construct.PurchaseDao;
import com.casd.dao.flow.FlowDao;
import com.casd.entity.construct.Construct;
import com.casd.entity.construct.PurChange;
import com.casd.entity.construct.PurChangeEmtry;
import com.casd.entity.construct.PurchaseEntry;
import com.casd.entity.construct.PurchaseEntryClass;
import com.casd.entity.construct.PurchaseHead;
import com.casd.entity.construct.PurchaseHeadClass;
import com.casd.entity.hr.AssessEntry;
import com.casd.entity.uc.User;
import com.casd.service.construct.ConstructService;
import com.casd.service.construct.PurChangeService;
import com.casd.service.construct.PurchaseService;
import com.casd.service.flow.FlowService;

@Service
public class PurChangeServiceImpl implements PurChangeService {
	
	
	@Autowired
	private PurChangeDao  purChangeDao;
	@Autowired
	private FlowService flowService;
	
	@Override
	public List<Map<String, Object>> purchaseList(String filds, int page,
			int pageSize, Ref<Integer> record, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("where", where);
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		List<Map<String, Object>> list= purChangeDao.purchaseList(param);
		if (record != null) {
			record.setValue(list.size());
		}
		return list;
	}

	@Override
	@Transactional
	public void submitPurChange(PurChange purChange, String rows,
			String username, String auditor) {
		if(!auditor.equals("")){
		purChange.setPurChangeTab_status(2);
		int billId= savePurChange(purChange, rows);
		// 工作流
		Map<String, Object> linkMap = new HashMap<String, Object>();
		linkMap.put("auditor", auditor); // 审批人
		linkMap.put("flow_bill_id", billId); // 单据id
		linkMap.put("flow_submitter", username); // 申请人
		linkMap.put("flow_bill_url", "purChangeAudit.do");// 审核界面url
		linkMap.put("flow_bill_type", "申购变更申请"); // 审核单据类型
		flowService.saveFlowAudit(linkMap);
		}else{
			purChange.setPurChangeTab_status(0);
			savePurChange(purChange, rows);
		}
	}
	

	@Override
	@Transactional
	public int savePurChange(PurChange purChange, String rows) {
		// TODO Auto-generated method stub
		int purChangeTab_id = purChange.getPurChangeTab_id();
		if(purChangeTab_id==0){
			purChangeDao.savePurChange(purChange);
			purChangeTab_id = purChange.getPurChangeTab_id();
		}else {
			purChangeDao.savePurChange(purChange);
		}
		JSONArray myJsonArray = JSONArray.fromObject(rows);
		for (int i=0;i<myJsonArray.size();i++) {
			JSONObject jsonObject = myJsonArray.getJSONObject(i);
			PurChangeEmtry purChangeEmtry = (PurChangeEmtry) JSONObject.toBean(jsonObject,  
					PurChangeEmtry.class);
			purChangeEmtry.setPurChangeEntryTab_parentId(purChangeTab_id);
			purChangeDao.savePurchangeEntries(purChangeEmtry);
		}
		
		return purChangeTab_id;
	}

	@Override
	public Map<String, List<Map<String, Object>>> getPurChangeData(
			Map<String, Object> map) {
		Map<String, List<Map<String, Object>>> data=new HashMap<String, List<Map<String,Object>>>();
		StringBuffer sbf=new StringBuffer();
		String fields = "*";
		sbf.append(" purChangeTab where purChangeTab_id="+map.get("purChangeTab_id")+"");
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("fields", fields);
		paramMap.put("where", sbf);
		List<Map<String, Object>> head =purChangeDao.getData(paramMap);
		data.put("head", head);
		sbf.setLength(0);
		sbf.append(" purChangeEntryTab where purChangeEntryTab_parentId="+map.get("purChangeTab_id")+"");
		paramMap.put("where", sbf);
		List<Map<String, Object>> entries =purChangeDao.getData(paramMap);
		data.put("entries", entries);
		return data;
	}

	@Override
	public String delete_purChange(Map<String, Object> map) {
		StringBuffer  sbf=new StringBuffer();
		sbf.append(" purChangeTab  LEFT JOIN purChangeEntryTab ");
		sbf.append(" ON purChangeTab.purChangeTab_id = purChangeEntryTab.purChangeEntryTab_parentId");
		sbf.append(" WHERE purChangeTab_id = "+map.get("purChangeTab_id"));
		map.put("where",sbf.toString()); 
		purChangeDao.delete_purChange(map);
		return null;
	}

	@Override
	public String delete_purChangeEntry(Map<String, Object> map) {
		StringBuffer  sbf=new StringBuffer();
		sbf.append("  purChangeEntryTab  WHERE purChangeEntryTab_id = "+map.get("purChangeEntryTab_id"));
		map.put("where",sbf.toString()); 
		purChangeDao.delete_purChangeEntry(map);
		return null;
	}

	@Override
	public String audit_purChange(Map<String, Object> map) {
		String auditor=map.get("auditor").toString();
		flowService.auditBill(map,auditor);
		return null;
	}
	
}
