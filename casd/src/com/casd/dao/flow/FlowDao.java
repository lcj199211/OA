package com.casd.dao.flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.casd.entity.flow.Flow;
import com.casd.entity.flow.FlowAudit;
import com.casd.entity.flow.FlowLink;
import com.casd.entity.flow.FlowNode;

public interface  FlowDao {

	List<Map<String, Object>> findFlow(Map<String, Object> flowMap);


	int addFlowAudit(FlowAudit audit);

	Integer getAuditCount(Map<String, Object> param);

	List<Map<String, Object>> auditList(Map<String, Object> param);

	void addNextAuditID(Map<String, Object> nextIDMap);


	Integer getFlowCount(Map<String, Object> param);


	List<Map<String, Object>> flowList(Map<String, Object> param);


	List<Map<String, Object>> findFlowNode(Map<String, Object> map);


	Flow findFlowByID(Map<String, Object> map);


	List<FlowAudit> findAuditByBillId(Map<String, Object> map);


	void auditBill(Map<String, Object> map);


	void updateFlowStatus(Map<String, Object> map);


	int getBillID(Map<String, Object> map);


	void backBill(Map<String, Object> map);


	int findNextNode(Map<String, Object> map);


	void submitFlow(FlowNode flowNode);


	void submitFlowHead(Flow flow);


	void delectNode(Map<String, Object> map);


	void deleFlow(Map<String, Object> map);


	void deleNodeByParentid(Map<String, Object> map);


	List<Map<String, Object>> getAuditorId(Map<String, Object> map);


	List<Map<String, Object>> getuserNames(Map<String, Object> map);


	FlowAudit getFlowAudit(Map<String, Object> idMap);
	
	String newlis(Map<String, Object> map);
	
}
