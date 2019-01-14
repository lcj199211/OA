package com.casd.serviceimpl.flow;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.allinpay.ets.client.StringUtil;
import com.casd.controller.web.Ref;
import com.casd.dao.flow.FlowDao;
import com.casd.dao.uc.UserDao;
import com.casd.entity.construct.Construct;
import com.casd.entity.flow.Flow;
import com.casd.entity.flow.FlowAudit;
import com.casd.entity.flow.FlowNode;
import com.casd.entity.uc.User;
import com.casd.service.flow.FlowService;

@Service
public class FlowServiceImpl implements FlowService {

	@Autowired
	private FlowDao flowDao;
	@Autowired
	private UserDao userDao;
	
	//审核人
	@Override
	public List<Map<String, Object>> initFlow(String userName,String id) {
		Map<String, Object> pamar=new HashMap<String, Object>();
		Map<String, Object> roleMap=new LinkedHashMap<String, Object>();
		List<Map<String, Object>> roles=new ArrayList<Map<String,Object>>();
		String processo="";
		pamar.put("id", id);
		List<Map<String, Object>> nodeList=flowDao.findFlow(pamar);
		pamar.clear();
		pamar.put("fields", "*");
		for(int i=0;i<nodeList.size();i++){
			Map<String, Object> nodeMap = nodeList.get(i);
			if(!nodeMap.get("flow_node_processo").toString().equals("")){
				processo=nodeMap.get("flow_node_processo").toString();
				pamar.put("where", "uc_user where role_id in(select role_id from uc_role where role_name ='"+processo+"' )");
				List<User> userList=userDao.queryUser(pamar);
				List roleNameList=new ArrayList();
				for(User user:userList){
					roleNameList.add(user.getUsername());
				}
				roleMap.put(processo, roleNameList);
			}
		}
		 roles.add(roleMap);
		 return roles;
	}
	
	//第一次提交审核流程
	@Override
	@Transactional
	public void saveFlowAudit(Map<String, Object> map) {
		String flow_bill_id = String.valueOf(map.get("flow_bill_id"));
		String flow_submitter = (String) map.get("flow_submitter");
		String flow_bill_url = (String) map.get("flow_bill_url");
		String flow_bill_type = (String) map.get("flow_bill_type");
		String auditor = (String) map.get("auditor");
		Date currentDate = new Date(System.currentTimeMillis());   

		FlowAudit audit=new FlowAudit();
		audit.setFlow_audit_time(currentDate);
		audit.setFlow_bill_id(flow_bill_id);
		audit.setFlow_submitter(flow_submitter);
		audit.setFlow_bill_url(flow_bill_url);
		audit.setFlow_bill_type(flow_bill_type);
		audit.setFlow_submit_time(currentDate);
		audit.setFlow_audit_option("已提交");
		audit.setFlow_audit_next_auditid(0);
		audit.setFlow_auditer(flow_submitter);//第一次审核人=自己，存档
		audit.setFlow_audit_id(0); 
		audit.setFlow_audit_last_auditid(0);
		audit.setFlow_status(3);//给自己的状态设置成多少
		audit.setFlow_node_order(1);//第一
		flowDao.addFlowAudit(audit);
		
		int last_auditid=audit.getFlow_audit_id();
		audit.setFlow_audit_id(0); 
		audit.setFlow_audit_option(null);
		audit.setFlow_audit_time(null);
		audit.setFlow_auditer(auditor);
		audit.setFlow_submitter(flow_submitter);
		audit.setFlow_status(1);
		audit.setFlow_node_order(2);//第二
		audit.setFlow_audit_last_auditid(last_auditid);
		flowDao.addFlowAudit(audit);
		
		Map<String, Object> nextIDMap=new HashMap<String, Object>();
		nextIDMap.put("id", audit.getFlow_audit_id());
		//nextIDMap.put("flow_audit_time", null);
		nextIDMap.put("where", last_auditid);
		flowDao.addNextAuditID(nextIDMap);
		
	}
	
	
	
	//待办事项列表
	@Override
	@Transactional
	public List<Map<String, Object>> auditList(int page, int pageSize,
			Ref<Integer> record, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			Integer count = flowDao.getAuditCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return flowDao.auditList(param);
		
	}

	@Override
	public List<Map<String, Object>> flowList(int page, int pageSize,
			Ref<Integer> record, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("where", where);

		if (record != null) {
			Integer count = flowDao.getFlowCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return flowDao.flowList(param);
	}

	@Override
	public Flow findFlowByID(Map<String, Object> map) {
		
		return flowDao.findFlowByID(map);
		
	}

	@Override
	public List<Map<String, Object>> findFlowNode(Map<String, Object> map) {
		
		return flowDao.findFlowNode(map);
		
	}

	@Override
	public List<FlowAudit> findAuditByBillId(Map<String, Object> map) {
		
		
		return flowDao.findAuditByBillId(map);
	}

	@Override
	@Transactional
	public void auditBill(Map<String, Object> map,String auditor) {
		Date currentDate = new Date(System.currentTimeMillis());
	    int flowAuditId=Integer.valueOf(map.get("auditID").toString());
	    
	    if(auditor==""){
	    	Map<String, Object> nextIDMap=new HashMap<String, Object>();
			//nextIDMap.put("id", audit.getFlow_audit_id());
			nextIDMap.put("flow_audit_time", currentDate);
			nextIDMap.put("flow_status", 3);
			nextIDMap.put("flow_audit_option",map.get("option").toString() );
			nextIDMap.put("where", flowAuditId);
			flowDao.addNextAuditID(nextIDMap);
		}else {
			 Map<String, Object> idMap=new HashMap<String, Object>();
			    idMap.put("auditID", flowAuditId);
			    FlowAudit flowAuditMap= flowDao.getFlowAudit(idMap);
			    
				FlowAudit audit=new FlowAudit();
				audit.setFlow_audit_time(null);
				audit.setFlow_bill_id(flowAuditMap.getFlow_bill_id());
				audit.setFlow_submitter(flowAuditMap.getFlow_submitter());
				audit.setFlow_bill_url(flowAuditMap.getFlow_bill_url());
				audit.setFlow_bill_type(flowAuditMap.getFlow_bill_type());
				audit.setFlow_submit_time(flowAuditMap.getFlow_submit_time());
				audit.setFlow_audit_option(null);
				audit.setFlow_audit_next_auditid(0);
				audit.setFlow_auditer(auditor);
				audit.setFlow_audit_id(0);
				audit.setFlow_audit_last_auditid(flowAuditId);
				audit.setFlow_status(1);
				//audit.setFlow_node_order(Integer.valueOf(map.get("flow_node_order").toString())+1);
				audit.setFlow_node_order(flowAuditMap.getFlow_node_order()+1);

				flowDao.addFlowAudit(audit);
				
				Map<String, Object> nextIDMap=new HashMap<String, Object>();
				nextIDMap.put("id", audit.getFlow_audit_id());
				nextIDMap.put("flow_audit_time", currentDate);
				nextIDMap.put("flow_status", 3);
				nextIDMap.put("flow_audit_option",map.get("option").toString() );
				nextIDMap.put("where", flowAuditId);
				flowDao.addNextAuditID(nextIDMap);
		}
	}

	@Override
	public void backBill(Map<String, Object> map) {
		
		Map<String, Object> idMap=new HashMap<String, Object>();
	    int flowAuditId=Integer.valueOf(map.get("flow_audit_last_auditid").toString());
	    idMap.put("auditID", flowAuditId);
	    FlowAudit flowAuditMap= flowDao.getFlowAudit(idMap);
	    
		Date currentDate = new Date(System.currentTimeMillis());   
		FlowAudit audit=new FlowAudit();
		audit.setFlow_audit_time(null);
		audit.setFlow_bill_id(flowAuditMap.getFlow_bill_id());
		audit.setFlow_submitter(flowAuditMap.getFlow_submitter());
		audit.setFlow_bill_url(flowAuditMap.getFlow_bill_url());
		audit.setFlow_bill_type(flowAuditMap.getFlow_bill_type());
		audit.setFlow_submit_time(flowAuditMap.getFlow_submit_time());
		audit.setFlow_audit_option(null);
		audit.setFlow_audit_next_auditid(0);
		audit.setFlow_auditer(flowAuditMap.getFlow_auditer());
		audit.setFlow_audit_id(0);
		audit.setFlow_audit_last_auditid(flowAuditMap.getFlow_audit_last_auditid());
		audit.setFlow_status(1);
		audit.setFlow_node_order(flowAuditMap.getFlow_node_order());
		flowDao.addFlowAudit(audit);
		
		Map<String, Object> nextIDMap=new HashMap<String, Object>();
		nextIDMap.put("id", 0);
		nextIDMap.put("flow_audit_time", currentDate);
		nextIDMap.put("flow_status", 3);
		nextIDMap.put("flow_audit_option",map.get("option").toString());
		nextIDMap.put("where", Integer.valueOf(map.get("auditID").toString()));
		flowDao.addNextAuditID(nextIDMap);
		
	}

	@Override
	@Transactional
	public void submitFlow(FlowNode flowNode) {
		
		flowDao.submitFlow(flowNode);
	}

	@Override
	@Transactional
	public void submitFlowHead(Flow flow) {
		// TODO Auto-generated method stub
		flowDao.submitFlowHead(flow);
	}

	@Override
	@Transactional
	public void delectNode(Map<String, Object> map) {
		// TODO Auto-generated method stub
		flowDao.delectNode(map);
	}

	@Override
	@Transactional
	public void deleFlow(Map<String, Object> map) {
		
		flowDao.deleFlow(map);
		flowDao.deleNodeByParentid(map);
	}

	@Override
	public List<Map<String, Object>> initFlows( int id) {
		Map<String, Object> pamar=new HashMap<String, Object>();
		Map<String, Object> roleMap=new LinkedHashMap<String, Object>();
		List<Map<String, Object>> roles=new ArrayList<Map<String,Object>>();
		int flow_node_role=0;
		String flow_node_name="";
		pamar.put("id", id);
		List<Map<String, Object>> nodeList=flowDao.findFlow(pamar);
		pamar.clear();
		pamar.put("fields", "*");
		for(int i=0;i<nodeList.size();i++){
			Map<String, Object> nodeMap = nodeList.get(i);
			if(!nodeMap.get("flow_node_processo").toString().equals("")){
				flow_node_role=Integer.valueOf(nodeMap.get("flow_node_role").toString());
				flow_node_name=nodeMap.get("flow_node_processo").toString();

				pamar.put("where", "uc_user where role_id in(select role_id from uc_role where role_id ="+flow_node_role+" )");
				List<User> userList=userDao.queryUser(pamar);
				List roleNameList=new ArrayList();
				for(User user:userList){
					roleNameList.add(user.getUsername());
				}
				roleMap.put(flow_node_name, roleNameList);
			}
		}
		 roles.add(roleMap);
		 return roles;
		
	}

	@Override
	public List<Map<String, Object>> getAuditors(Map<String, Object> paramMap) {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		StringBuffer sbf=new StringBuffer();
		String fields = "node.flow_node_auditors";
		sbf.append("  flow_table  flow LEFT JOIN flow_node_table node on  node.flow_node_parentID=flow.flow_id where flow.flow_description='"+paramMap.get("code")+"' ORDER BY node.orders");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fields", fields);
		map.put("where", sbf);
		List<Map<String, Object>> numList=new ArrayList<Map<String,Object>>();
		numList=flowDao.getAuditorId(map);
		Integer order = Integer.valueOf(paramMap.get("order").toString());
		if(order<numList.size()){
			fields="username";
			sbf.setLength(0);
			sbf.append("  uc_user where userid in("+numList.get(order).get("flow_node_auditors")+")");//顺序从1开始
			map.put("fields", fields);
			map.put("where", sbf);
			list=flowDao.getuserNames(map);
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> getAuditOption(Map<String, Object> param) {
		StringBuffer sbf=new StringBuffer();
		String fields = "flow_audit_option,flow_auditer";
		sbf.append(" flow_audit_table where flow_bill_id='"+param.get("flow_bill_id")+"' and flow_bill_url='"+param.get("flow_bill_url")+"'");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fields", fields);
		map.put("where", sbf);
		List<Map<String, Object>> numList=new ArrayList<Map<String,Object>>();
		numList=flowDao.getAuditorId(map);
		return numList;
	}
	
}