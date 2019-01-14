package com.casd.controller.construct;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.service.construct.ConstructService;
import com.casd.service.construct.LaborCostService;

@Controller
@RequestMapping("/admin")
public class LaborCostController {

	@Autowired
	private LaborCostService  laborCostService;

	/**
	 * 劳动力费用月份报表
	 */
	@RequestMapping(value = "/laborCostMon", method = RequestMethod.GET)
	public ModelAndView aPartyConList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Calendar c1 = Calendar.getInstance();
		// 获得年份
		int year = c1.get(Calendar.YEAR);
		mv.addObject("yearNum", year);
		mv.setViewName("construct/laborCostMon");
		return mv;
	}

	@RequestMapping(value = "/laborCostMon", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> laborCostMon(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		String yearNum = request.getParameter("yearNum");
		StringBuffer sbf = new StringBuffer();
		sbf.append(" ( select tableAll.construct_project_name,tableAll.construct_project_workTeam_category,tableAll.username,tableAll.construct_project_workTeam_amount, tableAll.construct_project_workTeam_price,tableAll.hr_attend_workTeamId, tableAll.manage_contract_num,");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"01' THEN num ELSE 0 END) AS 'jan', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"02' THEN num ELSE 0 END) AS 'feb', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"03' THEN num ELSE 0 END) AS 'mar', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"04' THEN num ELSE 0 END) AS 'apr', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"05' THEN num ELSE 0 END) AS 'may', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"06' THEN num ELSE 0 END) AS 'jun', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"07' THEN num ELSE 0 END) AS 'jul', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"08' THEN num ELSE 0 END) AS 'aug', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"09' THEN num ELSE 0 END) AS 'sep', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"10' THEN num ELSE 0 END) AS 'oct', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"11' THEN num ELSE 0 END) AS 'nov', ");
		sbf.append(" MAX(CASE attend_date WHEN '"+yearNum+"12' THEN num ELSE 0 END) AS 'dec' ");

		
		sbf.append(" from  ( select attend.hr_attend_workTeamId,attend.hr_attend_WTLength,users.username,team.construct_project_workTeam_category,pro.construct_project_name, team.construct_project_workTeam_price,");
		sbf.append("  team.construct_project_workTeam_amount,sum(hr_attend_WTLength) num,contract.manage_contract_num,DATE_FORMAT(attend.hr_attend_date, '%Y%m') as 'attend_date' ");
		sbf.append("  from hr_attend  attend ");
		sbf.append("  LEFT JOIN construct_project_workteam team on attend.hr_attend_workTeamId=team.construct_project_workTeam_id ");
		sbf.append("  LEFT JOIN uc_user users on users.userid=team.construct_project_workTeam_userId ");
		sbf.append("  LEFT JOIN construct_project_table pro on attend.hr_attend_projectId =pro.construct_project_id  ");
		sbf.append("  LEFT JOIN manage_contract contract on contract.manage_contract_id =pro.construct_project_contractId  ");
		sbf.append("  where attend.hr_attend_workTeamId !=0 and attend.hr_attend_date like '%"+yearNum+"%' ");
		sbf.append("  group by  attend.hr_attend_workTeamId ,attend_date ");
		sbf.append("  ) tableAll group by  hr_attend_workTeamId   ) tab where 1=1 ");

		String construct_project_name = request
				.getParameter("construct_project_name");
		if (StringUtils.hasText(construct_project_name)) {
			sbf.append(" and tab.construct_project_name like '%"
					+ construct_project_name + "%'");
		}
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = laborCostService.getList(pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;
	}

	
	/**
	 * 劳动力费用日报表
	 */
	@RequestMapping(value = "/laborCostDate", method = RequestMethod.GET)
	public ModelAndView laborCostDate(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("construct/laborCostDate");
		return mv;
	}
	
	
	@RequestMapping(value = "/laborCostDate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> laborCostDate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		String yearNum = request.getParameter("yearNum");
		Calendar c1 = Calendar.getInstance();
		yearNum = String.valueOf(c1.get(Calendar.YEAR));
		String field = request.getParameter("field");
		String	month="";
		
		if (field.equals("jan")) {
			month=yearNum+"-01";
		} else if (field.equals("feb")) {
			month=yearNum+"-02";
		} else if (field.equals("mar")) {
			month=yearNum+"-03";
		} else if (field.equals("apr")) {
			month=yearNum+"-04";
		} else if (field.equals("may")) {
			month=yearNum+"-05";
		} else if (field.equals("jun")) {
			month=yearNum+"-06";
		} else if (field.equals("jul")) {
			month=yearNum+"-07";
		} else if (field.equals("aug")) {
			month=yearNum+"-08";
		} else if (field.equals("sep")) {
			month=yearNum+"-09";
		} else if (field.equals("oct")) {
			month=yearNum+"-10";
		} else if (field.equals("nov")) {
			month=yearNum+"-11";
		} else if (field.equals("dec")) {
			month=yearNum+"-12";
		} 
		
		String hr_attend_workTeamId = request.getParameter("hr_attend_workTeamId");
		
		StringBuffer sbf = new StringBuffer();

		sbf.append("  ( select attend.hr_attend_workTeamId,attend.hr_attend_WTLength,users.username,team.construct_project_workTeam_category,pro.construct_project_name, team.construct_project_workTeam_price,");
		sbf.append("  team.construct_project_workTeam_amount,contract.manage_contract_num,sum(hr_attend_WTLength) num,attend.hr_attend_date ");
		sbf.append("  from hr_attend  attend ");
		sbf.append("  LEFT JOIN construct_project_workteam team on attend.hr_attend_workTeamId=team.construct_project_workTeam_id ");
		sbf.append("  LEFT JOIN uc_user users on users.userid=team.construct_project_workTeam_userId ");
		sbf.append("  LEFT JOIN construct_project_table pro on attend.hr_attend_projectId =pro.construct_project_id  ");
		sbf.append("  LEFT JOIN manage_contract contract on contract.manage_contract_id =pro.construct_project_contractId  ");
		sbf.append("  where attend.hr_attend_workTeamId ="+hr_attend_workTeamId+" and attend.hr_attend_date like '%"+month+"%'  ");
		sbf.append("  group by  attend.hr_attend_date ");
		sbf.append("  ) tableAll where 1=1 ");

		String hr_attend_date = request
				.getParameter("hr_attend_date");
		if (StringUtils.hasText(hr_attend_date)) {
			sbf.append(" and tableAll.hr_attend_date like '%"
					+ hr_attend_date + "%'");
		}
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = laborCostService.getList(pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;
	}
	
	
	/**
	 * 劳动力打卡详细
	 */
	@RequestMapping(value = "/laborCostAttend", method = RequestMethod.GET)
	public ModelAndView laborCostAttend(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("construct/laborCostAttend");
		return mv;
	}
	@RequestMapping(value = "/laborCostAttend", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> laborCostAttend(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		String hr_attend_date = request.getParameter("hr_attend_date");
		String hr_attend_workTeamId = request.getParameter("hr_attend_workTeamId");
		
		StringBuffer sbf = new StringBuffer();

		sbf.append("  ( select attend.hr_attend_workTeamId,attend.hr_attend_WTLength,team.construct_project_workTeam_category,pro.construct_project_name, ");
		sbf.append("  contract.manage_contract_num,attend.hr_attend_date,attend.hr_attend_startWork,attend.hr_attend_knockOff,attend.hr_attend_workAddress,attend.hr_attend_offWorkAddress,attendUser.username labor ");
		sbf.append("  from hr_attend  attend ");
		sbf.append("  LEFT JOIN uc_user attendUser on attendUser.userid=attend.hr_attend_userId ");
		sbf.append("  LEFT JOIN construct_project_workteam team on attend.hr_attend_workTeamId=team.construct_project_workTeam_id ");
		//sbf.append("  LEFT JOIN uc_user users on users.userid=team.construct_project_workTeam_userId ");
		sbf.append("  LEFT JOIN construct_project_table pro on attend.hr_attend_projectId =pro.construct_project_id  ");
		sbf.append("  LEFT JOIN manage_contract contract on contract.manage_contract_id =pro.construct_project_contractId  ");
		sbf.append("  where attend.hr_attend_workTeamId ="+hr_attend_workTeamId+" and attend.hr_attend_date= '"+hr_attend_date+"' ) tableAll where 1=1 ");

		String labor = request
				.getParameter("labor");
		if (StringUtils.hasText(labor)) {
			sbf.append(" and tableAll.labor like '%"
					+ labor + "%'");
		}
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = laborCostService.getList(pageIndex, pageSize, record, sbf.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;
	}
	
	
	
}
