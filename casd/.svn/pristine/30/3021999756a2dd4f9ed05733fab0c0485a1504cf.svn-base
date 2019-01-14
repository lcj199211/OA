package com.casd.controller.construct;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.construct.Construct;
import com.casd.entity.construct.PurchaseArrivedHead;
import com.casd.entity.construct.PurchaseEntry;
import com.casd.entity.construct.PurchaseEntryClass;
import com.casd.entity.construct.PurchaseHead;
import com.casd.entity.construct.PurchaseHeadClass;
import com.casd.entity.finance.Settle;
import com.casd.entity.uc.User;
import com.casd.service.construct.ConstructService;
import com.casd.service.construct.FinalPurchaseService;
import com.casd.service.construct.PurchaseService;
import com.casd.service.flow.FlowService;

@Controller
@RequestMapping("/admin")
public class FinalPurchaseController {

	@Autowired
	private FlowService flowService;
	@Autowired
	private FinalPurchaseService finalPurchaseService;
	@Autowired
	private ConstructService constructService;
	@Autowired
	private PurchaseService purchaseService;

	
	private int projectId;
	private String flow_bill_id;
	/**
	 * 列表
	 */
	@RequestMapping(value = "/finalPurchaseList", method = RequestMethod.GET)
	public ModelAndView finalPurchaseList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("construct/finalPurchaseList");
		return mv;
	}

	@RequestMapping(value = "/finalPurchaseList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> finalPurchaseList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		projectId = Integer.valueOf(request.getParameter("construct_project_id"));
		sbf.append(" construct_purchase_head_class pur left join construct_project_table pro on pur.construct_purchase_projectId=pro.construct_project_id where 1=1 and pro.construct_project_id="
				+ projectId + "");

		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = finalPurchaseService
				.finalPurchaseList(pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;
	}

	/**
	 * 查看
	 */
	@RequestMapping(value = "/finalPurchaseView", method = RequestMethod.GET)
	public ModelAndView finalPurchaseView(HttpServletRequest request,
			Model model) throws Exception {
		ModelAndView mv = new ModelAndView();

		StringBuffer sbf = new StringBuffer();
		Construct construct = new Construct();
		String fields = "construct_project_id,construct_project_name,construct_project_addr,construct_project_leader,construct_project_leaderTel";
		sbf.append(" construct_project_table where construct_project_id="
				+ projectId + "");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fields", fields);
		map.put("where", sbf);
		Map<String, Object> data= constructService.getConstructById(map);
		construct =(Construct) data.get("construct");
		mv.addObject("construct", construct);

		Map<String, Object> maps = new HashMap<String, Object>();
		if (!request.getParameter("construct_purchase_id").toString().isEmpty()) {
			maps = finalPurchaseService.initFinalPurchase(request.getParameter(
					"construct_purchase_id").toString());

			List<Map<String, Object>> dsList = (List<Map<String, Object>>) maps.get("rows");
			Double sum = 0.0;
			for (Map<String, Object> list : dsList) {
				sum += Double.valueOf(list.get(
						"construct_purchase_purchaseTotal").toString());
			}
			String purchase_status =request.getParameter("purchase_status");
			
			String codeString="";
			if(Integer.parseInt(purchase_status)>=3){
				codeString="pur";
			}else{
				codeString="purchase_orders";
			
			}
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flow_bill_id", request.getParameter("construct_purchase_id").toString());
			param.put("flow_bill_url", "finalPurchase_process.do");			
			List<Map<String, Object>> listsMaps= flowService.getAuditOption(param);
		
			model.addAttribute("listsMaps", listsMaps);
			Map<String, Object> paramMap=new HashMap<String, Object>();
			paramMap.put("code", codeString);
			paramMap.put("order",1);
			List<Map<String, Object>> auditorList =flowService.getAuditors(paramMap);
			mv.addObject("auditor", auditorList);
			
			mv.addObject("purchaseHead", maps.get("purchaseHeadClass"));
			JSONObject json = new JSONObject();
			json.put("rows", maps.get("rows"));
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> footMap = new HashMap<String, Object>();
			footMap.put("construct_purchase_material", "总计");
			footMap.put("construct_purchase_purchaseTotal", sum);
			list.add(footMap);
			json.put("footer", list);
			model.addAttribute("rows", json);
		}

		mv.setViewName("construct/finalPurchaseView");
		return mv;
	}

	/****
	 *  方法说明:查看采购申请单流程走向
	 * */
	@RequestMapping(value = "/finalPurchase_process", method = RequestMethod.GET)
	public ModelAndView finalPurchase_process(HttpServletRequest request,
			Model model) throws Exception {
		ModelAndView mv = new ModelAndView();

		flow_bill_id= request.getParameter("flow_bill_id");
		String flow_bill_url= request.getParameter("flow_bill_url");
		 String bill_type=request.getParameter("bill_type");
		int auditID = Integer.parseInt(request.getParameter("auditID").toString());
	
		int flow_status = Integer.parseInt(request.getParameter("flow_status").toString());
		int flow_audit_next_auditid = Integer.parseInt(request.getParameter("flow_audit_next_auditid").toString());
		int flow_audit_last_auditid = Integer.parseInt(request.getParameter("flow_audit_last_auditid").toString());
		int flow_node_order = Integer.parseInt(request.getParameter("flow_node_order").toString());
		mv.addObject("auditID", auditID);
		mv.addObject("flow_status", flow_status);
		
		mv.addObject("flow_audit_next_auditid", flow_audit_next_auditid);
		mv.addObject("flow_audit_last_auditid", flow_audit_last_auditid);
		mv.addObject("flow_node_order", flow_node_order);
		
		StringBuffer sbf = new StringBuffer();
		Construct construct = new Construct();
		String fields = "construct_project_id,construct_project_name,construct_project_addr,construct_project_leader,construct_project_leaderTel";
		sbf.append(" construct_project_table where construct_project_id="
				+ projectId + "");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fields", fields);
		map.put("where", sbf);
		Map<String, Object> data= constructService.getConstructById(map);
		construct =(Construct) data.get("construct");
		mv.addObject("construct", construct);
       
		
        mv.addObject("bill_type", bill_type);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("flow_bill_id", flow_bill_id);
		param.put("flow_bill_url", flow_bill_url);
		
		List<Map<String, Object>> listsMaps= flowService.getAuditOption(param);
	
		model.addAttribute("listsMaps", listsMaps);
		
		Map<String, Object> maps = new HashMap<String, Object>();
		if (!flow_bill_id.isEmpty()) {
			maps = finalPurchaseService.initFinalPurchase(flow_bill_id);

			List<Map<String, Object>> dsList = (List<Map<String, Object>>) maps.get("rows");
			Double sum = 0.0;
			for (Map<String, Object> list : dsList) {
				sum += Double.valueOf(list.get(
						"construct_purchase_purchaseTotal").toString());
			}
			
			Map<String, Object> paramMap=new HashMap<String, Object>();
			String codeString="";
          if(bill_type.equals("采购")){
        	  
        		codeString="pur";
			}else{
			   codeString="purchase_orders";
			
		}
			
           paramMap.put("code", codeString);	
			paramMap.put("order",flow_node_order);	
			List<Map<String, Object>> auditorList =flowService.getAuditors(paramMap);
			mv.addObject("size", auditorList.size());
			mv.addObject("auditor", auditorList);
			
			mv.addObject("purchaseHead", maps.get("purchaseHeadClass"));
			JSONObject json = new JSONObject();
			json.put("rows", maps.get("rows"));
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> footMap = new HashMap<String, Object>();
			footMap.put("construct_purchase_material", "总计");
			footMap.put("construct_purchase_purchaseTotal", sum);
			list.add(footMap);
			json.put("footer", list);
			model.addAttribute("rows", json);
		}

		mv.setViewName("construct/finalPurchase_process");
		return mv;
	}
	
	
	// 初始化流程
	@RequestMapping(value = "initFinalPurFlow", method = RequestMethod.POST)
	@ResponseBody
	private JSONObject initPurFlow(HttpServletRequest request, Model model) {
		JSONObject jsonObject = new JSONObject();
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String username = loginUser.getUsername();
		List<Map<String, Object>> flow = flowService.initFlows(1);
		jsonObject.put("flow", flow);
		jsonObject.put("userName", username);
		return jsonObject;
	}

	// 查看页面提交审核
	@RequestMapping(value = "/confirmFlow", method = RequestMethod.POST)
	@ResponseBody
	public String confirmFlow(HttpServletRequest request) throws Exception {
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String username = loginUser.getUsername();
		String selectRole = request.getParameter("selectRole");
		String billId = request.getParameter("construct_purchase_id");
		int status = Integer.valueOf(request.getParameter("status"));
		finalPurchaseService.auditFinalPurchase(username, selectRole, billId,
				status);
		return "";
	}

	/**
	 * 跳转审核界面
	 */
	@RequestMapping(value = "/finalPurchaseAudit", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView finalPurchaseAudit(HttpServletRequest request,
			Model model) {

		ModelAndView mv = new ModelAndView();
		int auditID = Integer.parseInt(request.getParameter("auditID")
				.toString());
		int flow_bill_id = Integer.parseInt(request
				.getParameter("flow_bill_id").toString());
		int flow_status = Integer.parseInt(request.getParameter("flow_status")
				.toString());
		int flow_audit_next_auditid = Integer.parseInt(request.getParameter(
				"flow_audit_next_auditid").toString());

		Map<String, Object> data = new HashMap<String, Object>();
		data = finalPurchaseService.getData(flow_bill_id);
		JSONObject json = new JSONObject();
		json.put("rows", data.get("Entries"));

		model.addAttribute("rows", json);
		mv.addObject("auditID", auditID);
		mv.addObject("flow_status", flow_status);
		mv.addObject("head", data.get("pHead"));
		mv.addObject("flow_audit_next_auditid", flow_audit_next_auditid);
		mv.setViewName("construct/finalPurchaseAudit");
		return mv;
	}

	/**
	 * 审核页面，点击审核
	 */
	@RequestMapping(value = "/auditFinalPurchase", method = RequestMethod.POST)
	@ResponseBody
	public String auditFinalPurchase(HttpServletRequest request, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		String billID = request.getParameter("construct_purchase_id");
		String option = request.getParameter("option");
		int auditID = Integer.valueOf(request.getParameter("auditID"));
		int construct_purchase_status = Integer.valueOf(request
				.getParameter("construct_purchase_status"));
		int flow_audit_next_auditid = Integer.parseInt(request.getParameter(
				"flow_audit_next_auditid").toString());
		Date currentDate = new Date(System.currentTimeMillis());
		map.put("billID", billID);
		map.put("option", option);
		map.put("auditID", auditID);
		map.put("flow_audit_time", currentDate);
		map.put("where", "flow_audit_table");
		//flowService.auditBill(map);
		if (flow_audit_next_auditid == 0) {// 下一个审核节点为0则说明不存在,此节点是最后一个,更新单据状态为已核准
			if (construct_purchase_status == 4) {// 区分采购与审核
				map.put("flow_status", 5);
			} else {
				map.put("flow_status", 3);
			}
			finalPurchaseService.updateStatus(map);
		}
		return null;
	}

	// 保存、修改
	@RequestMapping(value = "/savePurchaseNum", method = RequestMethod.POST)
	@ResponseBody
	public String savePurchaseNum(HttpServletRequest request) throws Exception {
		String rows = request.getParameter("rows");
		int construct_purchase_id = Integer.valueOf(request
				.getParameter("construct_purchase_id"));
		JSONArray myJsonArray = JSONArray.fromObject(rows);
		List<PurchaseEntryClass> entries = new ArrayList<PurchaseEntryClass>();
		Boolean isAllArrive = true;
		for (int i = 0; i < myJsonArray.size(); i++) {
			JSONObject entry = myJsonArray.getJSONObject(i);
			PurchaseEntryClass purchaseEntryClass = new PurchaseEntryClass();
			int id = Integer.valueOf(entry
					.getString("construct_purchase_entryId").toString()
					.isEmpty() ? "0" : entry.getString(
					"construct_purchase_entryId").toString());
			int arriveNum = Integer.valueOf(entry
					.getString("construct_purchase_arriveNum").toString()
					.isEmpty() ? "0" : entry.getString(
					"construct_purchase_arriveNum").toString());
			int planNum = Integer.valueOf(entry
					.getString("construct_purchase_applyNum").toString()
					.isEmpty() ? "0" : entry.getString(
					"construct_purchase_applyNum").toString());
			if (isAllArrive && arriveNum != planNum) {
				isAllArrive = false;
			}
			purchaseEntryClass.setConstruct_purchase_entryId(id);
			purchaseEntryClass.setConstruct_purchase_arriveNum(arriveNum);
			entries.add(purchaseEntryClass);
		}
		finalPurchaseService.savePurchaseNum(entries, isAllArrive,
				construct_purchase_id);
		return "";
	}

	/**
	 * 到货情况
	 */
	@RequestMapping(value = "/arrivePurchaseList.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView arrivePurchaseList(HttpServletRequest request,
			Model model) {
		String construct_purchase_id = request.getParameter("construct_purchase_id").toString();
		ModelAndView mv = new ModelAndView();
		mv.addObject("construct_purchase_id", construct_purchase_id);
		mv.setViewName("construct/arrivePurchaseList");
		return mv;
		
	}
	
	@RequestMapping(value = "/arrivePurchaseList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> arrivePurchaseList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		int construct_purchase_id = Integer.valueOf(request.getParameter("construct_purchase_id").toString());

		sbf.append(" construct_purchase_arrived  where 1=1 and construct_purchase_arrived_parentId="
				+ construct_purchase_id + "");

		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = finalPurchaseService
				.finalPurchaseList(pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;
	}
	
	/**
	 * 新增到货数量
	*/
	@RequestMapping(value = "/arrivePurchaseNum.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView arrivePurchaseNum(HttpServletRequest request,
			Model model) {
		ModelAndView mv = new ModelAndView();
		JSONObject json = new JSONObject();
		Map<String, Object> maps = new HashMap<String, Object>();
		maps = finalPurchaseService.initFinalPurchase(request.getParameter(
				"construct_purchase_id").toString());
		PurchaseArrivedHead head=new PurchaseArrivedHead();
		head.setConstruct_purchase_arrived_parentId(Integer.valueOf(request.getParameter(
				"construct_purchase_id").toString()));
		head.setConstruct_purchase_arrived_id(0);
		head.setConstruct_purchase_arrived_money(0);
		mv.addObject("head", head);
		json.put("rows", maps.get("rows"));
		model.addAttribute("rows", json);
		mv.addObject("construct_purchase_id", request.getParameter(
				"construct_purchase_id").toString());
		mv.setViewName("construct/arrivePurchaseNum");
		return mv;
		
	}
	
	/**
	 * 保存到货单
	*/
	@RequestMapping(value="/saveArrivePur" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveArrivePur(HttpServletRequest request,PurchaseArrivedHead arrive) throws Exception {
		
		String rows = request.getParameter("rows");

		finalPurchaseService.saveArrivePur(rows,arrive);
		
		return null;
	}

	/**
	 * 查看到货单
	*/
	@RequestMapping(value = "/arrivePurchaseView", method = RequestMethod.GET)
	public ModelAndView arrivePurchaseView(HttpServletRequest request,
			Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> maps = new HashMap<String, Object>();
		maps = finalPurchaseService.initArrive(request.getParameter(
				"construct_purchase_arrived_id").toString());
		JSONObject json = new JSONObject();
		json.put("rows", maps.get("rows"));
		model.addAttribute("rows", json);
		mv.addObject("head", maps.get("purchaseArrivedHead"));
		mv.setViewName("construct/arrivePurchaseView");
		return mv;
	}
	
	
	/**
	 * 修改到货单
	*/
	@RequestMapping(value = "/updateArrivePurchaseNum", method = RequestMethod.GET)
	public ModelAndView updateArrivePurchaseNum(HttpServletRequest request,
			Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> maps = new HashMap<String, Object>();
		maps = finalPurchaseService.initArrive(request.getParameter(
				"construct_purchase_arrived_id").toString());
		JSONObject json = new JSONObject();
		json.put("rows", maps.get("rows"));
		model.addAttribute("rows", json);
		mv.addObject("construct_purchase_id", request.getParameter(
				"construct_purchase_id").toString());
		mv.addObject("head", maps.get("purchaseArrivedHead"));
		mv.setViewName("construct/arrivePurchaseNum");
		return mv;
	}
	

	/***
	 *  方法说明：采购申请单提交
	 * 
	 * */
	@RequestMapping(value = "/purchasing_requisition", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> purchasing_requisition(HttpServletRequest request) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			
	
		User user=(User) request.getSession().getAttribute("loginUser");
		String purchase_id=request.getParameter("purchase_id");
		String auditor=request.getParameter("auditor");
		     // 工作流
				Map<String, Object> linkMap = new HashMap<String, Object>();
				linkMap.put("auditor", auditor); // 审批人
				linkMap.put("flow_bill_id", purchase_id); // 单据id
				linkMap.put("flow_submitter", user.getUsername()); // 申请人
				linkMap.put("flow_bill_url", "finalPurchase_process.do");// 审核界面url
				linkMap.put("status", 2);// 审核界面url
				linkMap.put("flow_bill_type", "采购单流程"); // 审核单据类型
				
				finalPurchaseService.purchasing_requisition(linkMap);
		} catch (Exception e) {
		map.put("msg", "提交失败请联系技术员！");
		}
		return map;
		
	}
	/**
	 * 方法说明：采购申请审批，如果审核人为0个时修改单据状态
	 * 
	 * */
	@RequestMapping(value = "/purchasing_submit", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>purchasing_submit(HttpServletRequest request) {
		
		int construct_purchase_id =Integer.parseInt(request.getParameter("purchase_id").toString());
		String auditor =request.getParameter("auditor").toString();
		int flow_node_order =Integer.valueOf(request.getParameter("flow_node_order").toString());
		String option =request.getParameter("option");
		int auditID =Integer.valueOf(request.getParameter("auditID"));
		int size =Integer.valueOf(request.getParameter("size"));
		String bill_type=request.getParameter("bill_type");
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("billID",construct_purchase_id);
		map.put("auditor",auditor);
		map.put("option",option);
		map.put("auditID",auditID);
		map.put("flow_node_order",flow_node_order);
	    map.put("where", "flow_audit_table");
	    map.put("size", size);
	    map.put("bill_type", bill_type);
	    finalPurchaseService.purchasing_submit(map);

		return map;
	}
	
	/**
	 * 方法说明：退回采购申请单程序
	 * */
	@RequestMapping(value = "/return_purchase", method = RequestMethod.POST)
	@ResponseBody
	public String return_purchase(HttpServletRequest request) {
		Map<String, Object> jsonMap=new HashMap<String, Object>();
		Map<String, Object> map=new HashMap<String, Object>();
	try {
		

		String option =request.getParameter("option");
		int auditID =Integer.valueOf(request.getParameter("auditID"));
		int flow_audit_last_auditid =Integer.valueOf(request.getParameter("flow_audit_last_auditid"));
		int flow_node_order = Integer.parseInt(request.getParameter("flow_node_order").toString());

		map.put("flow_audit_last_auditid",flow_audit_last_auditid);

		map.put("option",option);
		map.put("auditID",auditID);
	
	    map.put("where", "flow_audit_table");
	    
	    map.put("billID", flow_bill_id);
	    map.put("node_order", flow_node_order);

	    finalPurchaseService.return_purchase(map);
	
	} catch (Exception e) {
		jsonMap.put("msg", "操作失败,请联系技术员！");
		e.printStackTrace();
	}

		return null;
		
	}
	
	/**
	 * 提交
	*/
	@RequestMapping(value = "/procurement_pur", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  procurement_pur(HttpServletRequest request) {
		
		Map<String, Object> listMap=new  HashMap<String, Object>();
		try {
		User user=(User) request.getSession().getAttribute("loginUser");
		String purchase_id=request.getParameter("purchase_id");
		String auditor=request.getParameter("auditor");
		      // 工作流
				Map<String, Object> linkMap = new HashMap<String, Object>();
				linkMap.put("auditor", auditor); // 审批人
				linkMap.put("flow_bill_id", purchase_id); // 单据id
				linkMap.put("flow_submitter", user.getUsername()); // 申请人
				linkMap.put("flow_bill_url", "finalPurchase_process.do");// 审核界面url
				linkMap.put("flow_bill_type", "采购"); // 审核单据类型
				linkMap.put("status", 4);
				finalPurchaseService.purchasing_requisition(linkMap);
		} catch (Exception e) {
			listMap.put("msg", "采购失败请联系系统管理员！");
		}
		return listMap;
		
	}
	
	
	
	
}
