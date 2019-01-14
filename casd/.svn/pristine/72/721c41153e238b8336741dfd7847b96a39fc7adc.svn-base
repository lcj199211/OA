package com.casd.controller.manage;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.manage.Contract;
import com.casd.entity.manage.Reqfunds;
import com.casd.entity.uc.User;
import com.casd.service.hr.ActivitiService;
import com.casd.service.manage.ContractService;
import com.casd.service.manage.SupOpinionService;

@Controller
@RequestMapping("/admin")
public class ContractPayController {

	@Autowired
	private ContractService contractService;
	@Autowired
	private SupOpinionService supOpinionService;
	@Autowired
	private ActivitiService activitiService;

	/**
	 * 合同管理列表
	 * 
	 * */
	@RequestMapping(value = "/contractPayList", method = RequestMethod.GET)
	public ModelAndView contractPayList(HttpServletRequest request,Model model) {
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Calendar now = Calendar.getInstance();
		int yearNum = now.get(Calendar.YEAR) - 2016;
		for (int j = 0; j < yearNum + 1; j++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("yearMon", 2016 + j);
			list.add(map);
		}

		mv.addObject("yearMon", list);
		mv.setViewName("manage/contractPayList");
		return mv;

	}

	@RequestMapping(value = "/contractPayList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> contractPayList(HttpServletRequest request)
			throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		StringBuilder sBuilder = new StringBuilder();
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		Ref<Integer> record = new Ref<Integer>();
		String fields = " * ";
		sBuilder.append(" (select con.*,com.* from ");
		sBuilder.append(" manage_contract con ");
		sBuilder.append(" LEFT JOIN uc_company com on con.manage_contract_payCompany=com.company_id ");

		/*sBuilder.append(" LEFT JOIN construct_project_table pro on con.manage_contract_id=pro.construct_project_contractId ");
		sBuilder.append(" LEFT JOIN construct_purchase_head head on head.construct_purchase_projectId = pro.construct_project_id ");
		sBuilder.append(" LEFT JOIN construct_purchase_entry entry on entry.construct_purchase_parentId=head.construct_purchase_id ");*/
		sBuilder.append(" where con.manage_contract_company=0 ");

		String company_name = request
				.getParameter("company_name");
		if (StringUtils.hasText(company_name)) {
			sBuilder.append(" and com.company_name like '%"
					+ company_name + "%'");
		}
		String manage_contract_name = request
				.getParameter("manage_contract_name");
		if (StringUtils.hasText(manage_contract_name)) {
			sBuilder.append(" and con.manage_contract_name like '%"
					+ manage_contract_name + "%'");
		}


		String yearMon = request.getParameter("yearMon");
		if (StringUtils.hasText(yearMon) && !yearMon.equals("0")) {
			sBuilder.append(" and con.manage_contract_startTime like '%" + yearMon
					+ "%'");
		}

		sBuilder.append(" GROUP BY con.manage_contract_id  ) tableAll");
		List<Map<String, Object>> data = contractService.contractList(
				pageIndex, pageSize, record, fields, sBuilder.toString());

		BigDecimal manage_contract_amount = BigDecimal.ZERO;
		BigDecimal manage_contract_visaAmount = BigDecimal.ZERO;

		for (Map<String, Object> m : data) {
			manage_contract_amount = manage_contract_amount.add((BigDecimal
					.valueOf(Double.valueOf(m.get("manage_contract_amount")
							.toString() == "" ? "0.00" : m.get(
							"manage_contract_amount").toString()))));
			manage_contract_visaAmount = manage_contract_visaAmount
					.add((BigDecimal.valueOf(Double
							.valueOf(m.get("manage_contract_visaAmount")
									.toString() == "" ? "0.00" : m.get(
									"manage_contract_visaAmount").toString()))));
		}
		
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> footMap = new HashMap<String, Object>();
		footMap.put("manage_contract_endTime", "单页总计");
		
		footMap.put("manage_contract_amount", manage_contract_amount);
		footMap.put("manage_contract_visaAmount", manage_contract_visaAmount);

		
		footMap.put("psn", "foot");

		list.add(footMap);

		jsonMap.put("footer", list);
		jsonMap.put("rows", data);
		jsonMap.put("total", record.getValue());
		return jsonMap;

	}

	
	/**
	 * 新增，修改合同
	 * 
	 * */
	@RequestMapping(value = "/contractPayNew", method = RequestMethod.GET)
	public ModelAndView contractPayNew(HttpServletRequest request)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		String manage_contract_id = request.getParameter("manage_contract_id");
		Map<String, Object> contract = new HashMap<String, Object>();
		JSONObject jsonObject = new JSONObject();
		String type = "";
		String fields = "*";
		if (manage_contract_id.equals("")) {
			contract.put("manage_contract_id", 0);
			contract.put("manage_contract_amount", 0);
			contract.put("manage_contract_visaAmount", 0);
			jsonObject.put("rows", "");
			type = "'new'";
		} else {
			String where = "manage_reqfunds where manage_reqfunds_contractId="
					+ manage_contract_id;
			List<Map<String, Object>> data = contractService.contractData(
					fields, where);
			String str = "manage_contract con left join uc_company com on con.manage_contract_payCompany=com.company_id where manage_contract_id="
					+ manage_contract_id;
			jsonObject.put("rows", data);
			contract = contractService.findContract(fields, str);
			type = request.getParameter("type");
		}
		mv.addObject("type", type);
		mv.addObject("rows", jsonObject);
		mv.addAllObjects(contract);
		mv.setViewName("manage/contractPayNew");
		return mv;

	}

}
