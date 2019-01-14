package com.casd.controller.finance;

import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.finance.Base_wages;
import com.casd.entity.finance.Paylist;
import com.casd.entity.uc.User;
import com.casd.service.construct.LaborCostService;
import com.casd.service.finance.PayrollService;
import com.casd.service.finance.WagesService;

@Controller
@RequestMapping("/admin")
public class WagesController {

	@Autowired
	private LaborCostService  laborCostService;
	@Autowired
	private WagesService  wagesService;
	/**
	 *  工资列表
	 */
	@RequestMapping(value = "/userWagesList", method = RequestMethod.GET)
	public ModelAndView userWagesList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/userWagesList");
		return mv;
	}
	
	@RequestMapping(value="/userWagesList" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userWagesList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH );
		String yearMon="";
		if (month>0&&month<10) {
			yearMon=year+"-0"+month;
		}else if(month==0) {
			yearMon=year-1+"-12";
		}else {
			yearMon=year+"-"+month;
		}
		sbf.append(" (  ");
		sbf.append("  select  SUM(att.hr_attend_WTLength) finance_wages_attCount,us.username finance_wages_name,us.userid,us.status,us.incorporation_date, ");
		sbf.append("  com.company_name finance_wages_company, wage.uc_wage_base finance_wages_base, wage.uc_wage_post  finance_wages_post, wage.uc_wage_achieve finance_wages_achieve, wage.uc_wage_subsidy finance_wages_subsidy, wage.uc_wage_socSec finance_wages_socSec, wage.uc_wage_accFund finance_wages_accFund,center.center_name finance_wages_center  ");
		sbf.append("  ,(select  SUM(lea.day_count) from own_leave_table lea where lea.createdate  like '%"+yearMon+"%' and lea.applicant=us.username and lea.`status`=3) finance_wages_leaveCount ");
		sbf.append("  ,(select  count(1) from finance_wages_table fina where fina.finance_wages_yearMon  like '%"+yearMon+"%' and fina.finance_wages_name=us.username ) isWages ");
		sbf.append("  ,(select  fina.finance_wages_id from finance_wages_table fina where fina.finance_wages_yearMon  like '%"+yearMon+"%' and fina.finance_wages_name=us.username ) finance_wages_id ");

		sbf.append("  from hr_attend att ");
		sbf.append("  LEFT JOIN uc_user us on us.userid=att.hr_attend_userId ");
		sbf.append("  LEFT JOIN uc_wage wage on us.userid=wage.uc_wage_userId ");
		sbf.append("  LEFT JOIN uc_center center on center.center_id=us.center_id ");
		sbf.append("  LEFT JOIN uc_company com on com.company_id=center.center_companyId ");
		sbf.append("  where att.hr_attend_date like '%"+yearMon+"%' ");
		sbf.append("  GROUP BY us.userid  ");
		sbf.append("  ORDER BY center.center_id ");
		sbf.append("  ) tableAll where 1=1 and finance_wages_company!='分供方' ");
		
		String finance_wages_company=  request.getParameter("finance_wages_company");
	    if (StringUtils.hasText(finance_wages_company)) {
			sbf.append(" and tableAll.finance_wages_company like '%"+finance_wages_company+"%'");
		}
	    String finance_wages_name=  request.getParameter("finance_wages_name");
	    if (StringUtils.hasText(finance_wages_name)) {
			sbf.append(" and tableAll.finance_wages_name like '%"+finance_wages_name+"%'");
		}
	     
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		
		List<Map<String, Object>> data = laborCostService.getList(pageIndex, pageSize, record, sbf.toString());
	
		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}
	
	
	/**
	 *  工资历史记录
	 */
	@RequestMapping(value = "/userWagesLib", method = RequestMethod.GET)
	public ModelAndView userWagesLib(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		Calendar now = Calendar.getInstance();
		int yearNum = now.get(Calendar.YEAR)-2018;
		for (int j = 0; j < yearNum+1; j++) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("year", 2018+j);
			list.add(map);
		}
		
		mv.addObject("year", list);
		mv.setViewName("finance/userWagesLib");
		return mv;
	}
	
	@RequestMapping(value="/userWagesLib" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userWagesLib(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		String yearMon="";
		yearMon=request.getParameter("year").toString()+"-"+request.getParameter("month").toString();
		
		if (yearMon.equals("-")) {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH );
			if (month<10) {
				yearMon=year+"-0"+month;
			}else {
				yearMon=year+"-"+month;
			}
		}
		sbf.append(" finance_wages_table where finance_wages_yearMon like '%"+yearMon+"%' ");
		
		 String finance_wages_company=  request.getParameter("finance_wages_company");
	     if (StringUtils.hasText(finance_wages_company)) {
			sbf.append(" and finance_wages_company like '%"+finance_wages_company+"%'");
		}
	     String finance_wages_name=  request.getParameter("finance_wages_name");
	     if (StringUtils.hasText(finance_wages_name)) {
			sbf.append(" and finance_wages_name like '%"+finance_wages_name+"%'");
		}
	    
	     
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		
		List<Map<String, Object>> data = laborCostService.getList(pageIndex, pageSize, record, sbf.toString());
	
		
		Double finance_wages_wages=0.00;
		Double finance_wages_tax=0.00;
	    for (Map<String, Object> m : data){
	    	finance_wages_wages =finance_wages_wages + Double.valueOf(m.get("finance_wages_wages").toString()==null?"0.00":m.get("finance_wages_wages").toString());
	    	finance_wages_tax =finance_wages_tax + Double.valueOf((m.get("finance_wages_tax")==null?"0.00":m.get("finance_wages_tax")).toString());
	    }
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> footMap = new HashMap<String, Object>();
		footMap.put("finance_wages_wages", finance_wages_wages);
		footMap.put("finance_wages_tax", finance_wages_tax);
		footMap.put("deduTotal", "合计");

		
		list.add(footMap);
		json.put("footer", list);
		
		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}
	
	
	
	/**
	 * 保存工资
	*/
	@RequestMapping(value = "save_userWages", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject save_userWages(HttpServletRequest request)
			throws Exception {
		JSONObject jsonObject=new JSONObject();
		try {
			
			Double finance_wages_vacaCount=Double.valueOf(request.getParameter("finance_wages_vacaCount"));
			Double finance_wages_dedu=Double.valueOf(request.getParameter("finance_wages_dedu"));
			Double finance_wages_wages=Double.valueOf(request.getParameter("finance_wages_wages"));
			Double finance_wages_tax=Double.valueOf(request.getParameter("finance_wages_tax"));
			Double finance_wages_baseTotal=Double.valueOf(request.getParameter("finance_wages_baseTotal"));
			
			JSONArray myJsonArray = JSONArray.fromObject(request
					.getParameter("data"));
			wagesService.save_userWages(myJsonArray,finance_wages_vacaCount,finance_wages_dedu,finance_wages_wages,finance_wages_tax,finance_wages_baseTotal);
			jsonObject.put("success", true);
			jsonObject.put("msg", "保存成功");
		} catch (Exception e) {
			jsonObject.put("success", false);
			jsonObject.put("msg", "保存失败"+e);
		}
		return jsonObject;
	}
	
	
	/**
	 * 删除工资存档
	*/
	@RequestMapping(value = "dele_userWages", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject dele_userWages(HttpServletRequest request)
			throws Exception {
		JSONObject jsonObject=new JSONObject();
		try {
			
			int finance_wages_id = Integer.valueOf(request.getParameter("finance_wages_id").toString());
			wagesService.dele_userWages(finance_wages_id);
			jsonObject.put("success", true);
			jsonObject.put("msg", "删除成功");
		} catch (Exception e) {
			jsonObject.put("success", true);
			jsonObject.put("msg", "删除失败"+e);
		}
		return jsonObject;
	}
	/**
	 * 保存基本工资
	*/
	@RequestMapping(value = "submitWages", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject submitWages(HttpServletRequest request,Base_wages base_wages)
			throws Exception {
		JSONObject jsonObject=new JSONObject();
		try {
			wagesService.submitWages(base_wages);
			jsonObject.put("success", true);
		} catch (Exception e) {
			jsonObject.put("success", true);
			jsonObject.put("msg", "保存失败"+e);
		}
		
		
		return jsonObject;
	}
	
	
	/**
	 * 获取基本工资
	*/
	@RequestMapping(value = "base_Wages", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject base_Wages(HttpServletRequest request)
			throws Exception {
		JSONObject jsonObject=new JSONObject();
		int userid=Integer.valueOf(request.getParameter("userid").toString());
		Map<String, Object> data=wagesService.base_Wages(userid);
		jsonObject.put("data", data);
		return jsonObject;
	}
}
