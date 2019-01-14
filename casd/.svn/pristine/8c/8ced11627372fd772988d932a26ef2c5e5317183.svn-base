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
import com.casd.dao.construct.FinalPurchaseDao;
import com.casd.dao.construct.PurchaseDao;
import com.casd.dao.flow.FlowDao;
import com.casd.entity.construct.Construct;
import com.casd.entity.construct.PurchaseArriveEntry;
import com.casd.entity.construct.PurchaseArrivedHead;
import com.casd.entity.construct.PurchaseEntry;
import com.casd.entity.construct.PurchaseEntryClass;
import com.casd.entity.construct.PurchaseHead;
import com.casd.entity.construct.PurchaseHeadClass;
import com.casd.entity.finance.SettlePay;
import com.casd.entity.finance.SettlePur;
import com.casd.entity.hr.AssessEntry;
import com.casd.entity.uc.User;
import com.casd.service.construct.ConstructService;
import com.casd.service.construct.FinalPurchaseService;
import com.casd.service.construct.PurchaseService;
import com.casd.service.flow.FlowService;

@Service
public class FinalPurchaseServiceImpl implements FinalPurchaseService {
	
	
	@Autowired
	private FinalPurchaseDao finalPurchaseDao;
	@Autowired
	private FlowService flowService;
	
	
	@Override
	@Transactional
	public List<Map<String, Object>> finalPurchaseList(int page,
			int pageSize, Ref<Integer> record, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			int count = finalPurchaseDao.getFinalPurchaseCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return finalPurchaseDao.finalPurchaseList(param);
	}

	@Override
	public Map<String, Object> initFinalPurchase(String construct_purchase_id) {
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> data=new HashMap<String, Object>();
		map.put("id", construct_purchase_id);
		PurchaseHeadClass head=new PurchaseHeadClass();
		List<Map<String, Object>> entries=new ArrayList<Map<String,Object>>();
		head=finalPurchaseDao.getHead(map);
		entries=finalPurchaseDao.getEntry(map);
		data.put("purchaseHeadClass", head);
		data.put("rows", entries);
		return data;
	}

	@Override
	@Transactional
	public void auditFinalPurchase(String username, String selectRole,String billId,int status) {
		// 工作流
		Map<String, Object> linkMap = new HashMap<String, Object>();
		linkMap.put("selectRole", selectRole); // 审批人
		linkMap.put("flow_bill_id", billId); // 单据id
		linkMap.put("flow_submitter", username); // 申请人
		linkMap.put("flow_bill_url", "finalPurchaseAudit.do");// 审核界面url
		linkMap.put("flow_bill_type", "采购申请"); // 审核单据类型
		
		//设置单据状态为审批中/采购中
		
		PurchaseHeadClass purchaseHeadClass=new PurchaseHeadClass();
		purchaseHeadClass.setConstruct_purchase_status(status);
		purchaseHeadClass.setConstruct_purchase_id(Integer.valueOf(billId));
		finalPurchaseDao.updatePurchaseStatus(purchaseHeadClass);
		
		flowService.saveFlowAudit(linkMap);
		
	}

	@Override
	public Map<String, Object> getData(int flow_bill_id) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> data=new HashMap<String, Object>();
		map.put("id", flow_bill_id);
		String filds="*";
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append(" construct_purchase_head_class head left join construct_project_table pro on head.construct_purchase_projectId=pro.construct_project_id ");
		sBuffer.append(" where head.construct_purchase_id = "+flow_bill_id+"");
		map.put("where", sBuffer);
		map.put("filds", filds);
		Map<String, Object> pHead=new HashMap<String, Object>();
		List<Map<String, Object>> Entries=new ArrayList<Map<String,Object>>();
		pHead=finalPurchaseDao.getPHead(map);
		Entries=finalPurchaseDao.getPEntry(map);
		data.put("Entries", Entries);
		data.put("pHead", pHead);
		return data;
	}

	@Override
	@Transactional
	public void savePurchaseNum(List<PurchaseEntryClass> entries,
			Boolean isAllArrive, int construct_purchase_id) {
		PurchaseHeadClass purchaseHeadClass=new PurchaseHeadClass();
		if(isAllArrive){
			purchaseHeadClass.setConstruct_purchase_status(7);
		}else {
			purchaseHeadClass.setConstruct_purchase_status(6);
		}
		purchaseHeadClass.setConstruct_purchase_id(construct_purchase_id);
		finalPurchaseDao.updatePurchaseStatus(purchaseHeadClass);
		finalPurchaseDao.savePurchaseNum(entries);
	}

	@Override
	public void updateStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		//设置单据状态为审批中
		int flow_status =Integer.valueOf(map.get("flow_status").toString());
		String billID = map.get("billID").toString();
		PurchaseHeadClass purchaseHeadClass=new PurchaseHeadClass();
		
		purchaseHeadClass.setConstruct_purchase_status(flow_status);
		purchaseHeadClass.setConstruct_purchase_id(Integer.valueOf(billID));
		finalPurchaseDao.updatePurchaseStatus(purchaseHeadClass);
	}

	@Override
	@Transactional
	public void saveArrivePur(String rows, PurchaseArrivedHead arrive) {
		JSONArray  rowsArray= JSONArray.fromObject(rows);
		List<PurchaseArriveEntry> entryList=new ArrayList<PurchaseArriveEntry>();
		List<PurchaseEntryClass> purchaseEntryClassList=new ArrayList<PurchaseEntryClass>();

		int headId = arrive.getConstruct_purchase_arrived_id();
		if(headId==0){
			finalPurchaseDao.saveArriveHead(arrive);
			headId = arrive.getConstruct_purchase_arrived_id();
		}else {
			finalPurchaseDao.saveArriveHead(arrive);
		}
		
		for (int i = 0; i < rowsArray.size(); i++) {
			JSONObject entry = rowsArray.getJSONObject(i);
			int construct_purchase_arrived_entry_id=0;
			if(entry.containsKey("construct_purchase_arrived_entry_id")){
				construct_purchase_arrived_entry_id=Integer.valueOf(entry.get("construct_purchase_arrived_entry_id").toString().isEmpty()?"0":entry.get("construct_purchase_arrived_entry_id").toString());
			}
			Double construct_purchase_arrived_entry_money=0.0;
			if(entry.containsKey("construct_purchase_arrived_entry_money")){
				construct_purchase_arrived_entry_money=Double.valueOf(entry.get("construct_purchase_arrived_entry_money").toString().isEmpty()?"0":entry.get("construct_purchase_arrived_entry_money").toString());
			}
			int construct_purchase_arrived_entry_num=0;
			if(entry.containsKey("construct_purchase_arrived_entry_num")){
				construct_purchase_arrived_entry_num=Integer.valueOf(entry.get("construct_purchase_arrived_entry_num").toString().isEmpty()?"0":entry.get("construct_purchase_arrived_entry_num").toString());
			}
			int construct_purchase_arrived_entry_parentId=headId;
			int construct_purchase_arrived_entry_chassId=Integer.valueOf(entry.get("construct_purchase_entryId").toString().isEmpty()?"0":entry.get("construct_purchase_entryId").toString());

			PurchaseArriveEntry arriveEntry = new PurchaseArriveEntry();
			arriveEntry.setConstruct_purchase_arrived_entry_chassId(construct_purchase_arrived_entry_chassId);
			arriveEntry.setConstruct_purchase_arrived_entry_id(construct_purchase_arrived_entry_id);
			arriveEntry.setConstruct_purchase_arrived_entry_parentId(construct_purchase_arrived_entry_parentId);
			arriveEntry.setConstruct_purchase_arrived_entry_money(construct_purchase_arrived_entry_money);
			arriveEntry.setConstruct_purchase_arrived_entry_num(construct_purchase_arrived_entry_num);
			
			entryList.add(arriveEntry);
			
			
			PurchaseEntryClass purchaseEntryClass = (PurchaseEntryClass) JSONObject.toBean(entry,  
					PurchaseEntryClass.class);
			purchaseEntryClassList.add(purchaseEntryClass);
		}
		
		for(int i = 0; i < entryList.size(); i++){
			finalPurchaseDao.saveArriveEntry(entryList.get(i));
		}
		
		finalPurchaseDao.updatePurEntryClass(purchaseEntryClassList);
		
	}

	@Override
	public Map<String, Object> initArrive(String construct_purchase_arrived_id) {
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> data=new HashMap<String, Object>();
		map.put("id", construct_purchase_arrived_id);
		PurchaseArrivedHead head=new PurchaseArrivedHead();
		List<Map<String, Object>> entries=new ArrayList<Map<String,Object>>();
		head=finalPurchaseDao.getArriveHead(map);
		entries=finalPurchaseDao.getArriveEntry(map);
		data.put("purchaseArrivedHead", head);
		data.put("rows", entries);
		return data;
	}
	
	/**
	 * 方法说明：采购单申单请提交
	 * 
	 * */
   @Transactional
  public Map<String, Object> purchasing_requisition(Map<String, Object> linkMap) {
	  
	  
	  flowService.saveFlowAudit(linkMap);
	  Integer status= Integer.parseInt(linkMap.get("status").toString());
	  PurchaseHeadClass phc=new PurchaseHeadClass();
	  phc.setConstruct_purchase_id(Integer.parseInt(linkMap.get("flow_bill_id").toString()));  
	  phc.setConstruct_purchase_status(status);
	  finalPurchaseDao.updatePurchaseStatus(phc);
	  
	return null;
	
}
   /**
	 * 方法说明：采购申请审批，如果审核人为0个时修改单据状态
	 * 
	 * */
   @Transactional
   public Map<String, Object>purchasing_submit(Map<String, Object> map){
	   String auditor=map.get("auditor").toString();
	   
	   flowService.auditBill(map,auditor);

	   if (map.get("size").toString().equals("0")) {
		   if (map.get("bill_type").equals("采购")) {
			
	
		      PurchaseHeadClass phc=new PurchaseHeadClass();
			  phc.setConstruct_purchase_id(Integer.parseInt(map.get("billID").toString()));  
			  phc.setConstruct_purchase_status(5);
			  finalPurchaseDao.updatePurchaseStatus(phc);	
			  }else {

			      PurchaseHeadClass phc=new PurchaseHeadClass();
				  phc.setConstruct_purchase_id(Integer.parseInt(map.get("billID").toString()));  
				  phc.setConstruct_purchase_status(3);
				  finalPurchaseDao.updatePurchaseStatus(phc);	
			}
	     }
	   
	return null;
	   
   }

   /**
    * 采购申请单驳回
    * */
@Override
@Transactional
public Map<String, Object> return_purchase(Map<String, Object> map) {
	
	int flow_node_order=Integer.parseInt(map.get("node_order").toString());
	  flowService.backBill(map);
	  if (flow_node_order-1==1) {
		  Integer purchase_id=Integer.parseInt(map.get("billID").toString());
		  PurchaseHeadClass headClass=new PurchaseHeadClass();
		 
			  headClass.setConstruct_purchase_status(1);

	          headClass.setConstruct_purchase_id(purchase_id);
		   
		  finalPurchaseDao.updatePurchaseStatus(headClass);
	   }
	return null;
}
  
}
