package com.casd.controller.finance;

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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.finance.Paylist;
import com.casd.service.finance.PayrollService;

@Controller
@RequestMapping("/admin")
public class PayrollController {

	
	
	@Autowired
	private PayrollService payrollService;
	
	/**
	 *  工资列表
	 */
	@RequestMapping(value = "/payrollList", method = RequestMethod.GET)
	public ModelAndView payrollList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/payrollList");
		return mv;
	}
	
	@RequestMapping(value="/payrollList" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> payrollList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		sbf.append(" finance_paylist gp left join uc_center uc on uc.center_id=gp.gad_paylist_centerid where 1=1  ");
		 String gad_paylist_month=  request.getParameter("gad_paylist_month");
	     if (StringUtils.hasText(gad_paylist_month)) {
			sbf.append(" and gad_paylist_month like '%"+gad_paylist_month+"%'");
		}
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		
		List<Map<String, Object>> data = payrollService.payrollList(pageIndex,
				pageSize, record, sbf.toString());
		Map<String, Object> mapsMap=new HashMap<String, Object>();
		
		
		//合计
		Double sum = 0.0 ;
		for (Map<String, Object> sMap:data) {
		 sum += (Double) sMap.get("gad_paylist_payroll");
		}
		
   
		mapsMap.put("gad_paylist_men_num", "合计");
		mapsMap.put("psn", sum);
		mapsMap.put("gad_paylist_payroll", sum);
		
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		list.add(mapsMap);
	
		json.put("rows", data);
		json.put("total", record.getValue());
		json.put("footer", list);
		return json;

	}
	
	
		//查看
		@RequestMapping(value = "/payrollView", method = RequestMethod.GET)
		@ResponseBody
		public ModelAndView payrollView(HttpServletRequest request,Model model)
				throws Exception {
			ModelAndView mv = new ModelAndView();
			String id = request.getParameter("gad_paylist_id");
			JSONObject json = new JSONObject();
			Map<String, Object> map=new HashMap<String, Object>();
			Map<String, Object> data=new HashMap<String, Object>();
		    map.put("what", id);
		    data = payrollService.findPaylistByid(id);
			json.put("rows", data.get("listPayrolls"));
			
		    model.addAttribute("rows",json);
			mv.addObject("PayList", data.get("paylist"));
			mv.setViewName("finance/payrollView");
			return mv;
		}	

	
		//新增/修改界面
		@RequestMapping(value = "/payrollNew", method = RequestMethod.GET)
		@ResponseBody
		public ModelAndView payrollNew(HttpServletRequest request,Model model)
				throws Exception {
			ModelAndView mv = new ModelAndView();
			String id = request.getParameter("id");
			JSONObject json = new JSONObject();

			if (id != "") {
				Map<String, Object> map=new HashMap<String, Object>();
				Map<String, Object> data=new HashMap<String, Object>();
			    map.put("what", id);
			    data = payrollService.findPaylistByid(id);
				json.put("rows", data.get("listPayrolls"));
			    model.addAttribute("rows",json);
				mv.addObject("PayList", data.get("paylist"));
			}
			model.addAttribute("rows",json);
			mv.setViewName("finance/payrollNew");
			return mv;
		}
		//初始化审核基础资料界面
		@RequestMapping(value = "/payrollNew", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> payrollNew(Model model, HttpServletRequest request)
				throws Exception {

			return null;
		}
		
		//提交
		@RequestMapping(value = "/addPayroll", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> addPayroll(Model model, HttpServletRequest request)
				throws Exception {
			Integer paylist_id =Integer.parseInt(request.getParameter("paylist_id").isEmpty()?"0":request.getParameter("paylist_id"));
			Integer	centerid=Integer.parseInt(request.getParameter("centerid").isEmpty()?"0":request.getParameter("centerid"));
			String	month=request.getParameter("month");
			Integer	men_num=Integer.parseInt(request.getParameter("men_num").isEmpty()?"0":request.getParameter("men_num"));
			String	payroll=request.getParameter("payroll");
			String	remarks=request.getParameter("remarks");
			 
			Paylist paylist=new Paylist();
			paylist.setGad_paylist_id(paylist_id);
			paylist.setGad_paylist_centerid(centerid);
			paylist.setGad_paylist_month(month);
			paylist.setGad_paylist_men_num(men_num);
			paylist.setGad_paylist_payroll(Double.parseDouble(payroll));
			paylist.setGad_paylist_remarks(remarks);
			String  rows=request.getParameter("rows");
			if (rows!=null) {
				JSONArray myJsonArray = JSONArray.fromObject(rows);	
				payrollService.addPayroll(myJsonArray,paylist);
			}
			return null;
		}
	
		//删除分录行
		@RequestMapping(value="/delePayRoll" , method = RequestMethod.POST)
		@ResponseBody
		public String delePayRoll(HttpServletRequest request) throws Exception {
			Map<String, Object> map=new HashMap<String, Object>();
			String cid =request.getParameter("cid");
			cid=cid.substring(1);
			String[] ids=cid.split("]");
			map.put("what",ids[0].toString());        
			payrollService.delePayRoll(map);
			return "";
		}
		
		
		//删除全部
		@RequestMapping(value="/delePayList" , method = RequestMethod.POST)
		@ResponseBody
		public String delePayList(HttpServletRequest request) throws Exception {
			Map<String, Object> map=new HashMap<String, Object>();
			String cid =request.getParameter("cid");
			cid=cid.substring(1);
			String[] ids=cid.split("]");
			
			StringBuffer  sbf=new StringBuffer();
			sbf.append(" finance_paylist LEFT JOIN finance_payroll");
			sbf.append(" ON finance_paylist.gad_paylist_id = finance_payroll.finance_paylist_id");
			sbf.append(" WHERE gad_paylist_id = "+ids[0].toString());
			
			map.put("what",sbf.toString());        
			payrollService.delePayList(map);
			return "";
		}
		
		
}
