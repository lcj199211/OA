package com.casd.controller.personManagem;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
import com.casd.entity.hr.Assess;
import com.casd.entity.hr.AssessEntry;
import com.casd.entity.hr.AssessEva;
import com.casd.entity.hr.AssessHead;
import com.casd.entity.uc.User;
import com.casd.service.hr.AssessService;

@Controller
@RequestMapping("/admin")
public class AssessController {

	
	
	@Autowired
	private AssessService assessService;
	
	/**
	 *  人事评估页面列表跳转
	 */
	@RequestMapping(value = "/assessList", method = RequestMethod.GET)
	public ModelAndView assessList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("personManagem/assessList");
		return mv;
	}
	
	@RequestMapping(value = "/assessList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> assessList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		sbf.append(" assess_head_table where 1=1");

		 String start_time=request.getParameter("start_time"); 
		 String end_time=request.getParameter("end_time");

	     SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");  
		 if(StringUtils.hasText(start_time)) {
			 java.util.Date start_timeDate = format.parse(start_time);
		     Date startDate=new Date(start_timeDate.getTime());
			 sbf.append(" and assess_head_creatdate >='"+startDate+"'"); 
		} 
		if(StringUtils.hasText(end_time)) {
			 java.util.Date end_timeDate = format.parse(end_time);
		     Date endDate=new Date(end_timeDate.getTime());
			 sbf.append(" and assess_head_creatdate <= '"+endDate+"'"); 
		}
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		/*int pageSize =20;
		int pageIndex =0;*/
		List<Map<String, Object>> data = assessService.assessList(pageIndex,
				pageSize, record, sbf.toString());
		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}
	
	
	
	/**
	 *  个人中心评估提交页面跳转
	 */
	@RequestMapping(value = "/assess", method = RequestMethod.GET)
	public ModelAndView assess(HttpServletRequest request,Model model) {
		ModelAndView mv = new ModelAndView();
		User loginUser = (User) request.getSession().getAttribute(
				"loginUser");
		String username = loginUser.getUsername();
		Boolean isExist=assessService.isExistEva(username);
		if(isExist){
			AssessHead head = new AssessHead();
			head.setAssess_head_evaluator(username);
			List<Map<String, Object>> maps=new ArrayList<Map<String,Object>>();
			JSONObject json = new JSONObject();
			maps=assessService.initAssessEntry();
			json.put("rows", maps);
			model.addAttribute("rows", json);
			mv.addObject("head", head);
			mv.setViewName("ownCenter/assess");
			return mv;
		}
		mv.setViewName("common/noAuthority");
		return mv;
	}
	
	//评估信息查看按钮
	@RequestMapping(value = "/assessView", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView assessView(HttpServletRequest request,Model model) {
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("id");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		List<Map<String, Object>> Entrymaps=new ArrayList<Map<String,Object>>();
		JSONObject json = new JSONObject();
		Entrymaps=assessService.getAssessEntry(map);
		AssessHead head=assessService.getAssessHead(map);
		json.put("rows", Entrymaps);
		model.addAttribute("rows", json);
		model.addAttribute("head", head);
		mv.setViewName("personManagem/assessview");
		return mv;
	}
	
	
	
	
	
	/**
	 * 审核基础资料新增修改界面保存按钮
	*/
	@RequestMapping(value="/saveAssess" , method = RequestMethod.POST)
	public String saveAssess(HttpServletRequest request) throws Exception {
		AssessHead assessHead=new AssessHead();
		Date currentDate = new Date(System.currentTimeMillis());   
		assessHead.setAssess_head_company(request.getParameter("assess_head_company"));
		assessHead.setAssess_head_creatdate(currentDate);
		assessHead.setAssess_head_department(request.getParameter("assess_head_department"));
		assessHead.setAssess_head_evaluator(request.getParameter("assess_head_evaluator"));
		assessHead.setAssess_head_name(request.getParameter("assess_head_name"));
		assessHead.setAssess_head_position(request.getParameter("assess_head_position"));
		assessHead.setAssess_head_totalscore(Integer.valueOf(request.getParameter("assess_head_totalscore")));
		assessService.saveAssessHead(assessHead);
		int assess_head_id=assessHead.getAssess_head_id();
		String rows = request.getParameter("rows");
		JSONArray myJsonArray = JSONArray.fromObject(rows);
		List<AssessEntry> entries=new ArrayList<AssessEntry>();
		for (int i = 0; i < myJsonArray.size(); i++) {
			AssessEntry assessEntry=new AssessEntry();
			JSONObject entry = myJsonArray.getJSONObject(i);
			assessEntry.setAssess_parent_id(assess_head_id);
			assessEntry.setAssess_entry_content(entry.getString("assess_content"));
			assessEntry.setAssess_entry_score(Integer.valueOf(entry.getString("assess_score")));
			entries.add(assessEntry);
		}
		assessService.saveAssessEntry(entries);
		return "";
	}
	
	//一键启动评估
	@RequestMapping(value = "/startAssess", method = RequestMethod.POST)
	public String startAssess(HttpServletRequest request,Model model) {
		
		assessService.startAssess();
		return "";
	}
	//一键停止评估
	@RequestMapping(value = "/stopAssess", method = RequestMethod.POST)
	@ResponseBody
	public String stopAssess(HttpServletRequest request,Model model) {
		assessService.stopAssess();
		return "";
	}
	
	/*//修改评估人按钮
	@RequestMapping(value = "/updateEva", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView updateEva(HttpServletRequest request,Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("personManagem/test");
		return mv;
	}*/
	
	//初始化修改评估人页面
	@RequestMapping(value = "/initEva", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject initEva(HttpServletRequest request,Model model) {
		List<Map<String, Object>> Evamaps=new ArrayList<Map<String,Object>>();
		JSONObject json = new JSONObject();
		Evamaps=assessService.initEva();
		json.put("rows", Evamaps);
		return json;
	}
	//修改评估内容页面
	@RequestMapping(value = "/assessContEdit", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView assessContEdit(HttpServletRequest request,Model model) {
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> Contmaps=new ArrayList<Map<String,Object>>();
		JSONObject json = new JSONObject();
		Contmaps=assessService.initCont();
		json.put("rows", Contmaps);
		mv.addObject("rows", json);
		mv.setViewName("personManagem/assessContEdit");
		return mv;
	}
	
	
	/**
	 * 评估内容保存
	*/
	@RequestMapping(value="/saveCont" , method = RequestMethod.POST)
	@ResponseBody
	public String saveCont(HttpServletRequest request) throws Exception {
		String rows = request.getParameter("rows");
		JSONArray myJsonArray = JSONArray.fromObject(rows);
		for (int i = 0; i < myJsonArray.size(); i++) {
			Assess assess=new Assess();
			JSONObject assessJson = myJsonArray.getJSONObject(i);
			assess.setAssess_category(assessJson.getString("assess_category"));
			assess.setAssess_content(assessJson.getString("assess_content"));
			assess.setAssess_deduct(assessJson.getString("assess_deduct"));
			assess.setAssess_grade(Integer.valueOf(assessJson.getString("assess_grade").isEmpty()?"0":assessJson.getString("assess_grade")));
			assess.setAssess_id(Integer.valueOf(assessJson.getString("assess_id").isEmpty()?"0":assessJson.getString("assess_id")));
			assess.setAssess_score(0);
			assessService.saveCont(assess);
		}
		return "";
	}
	//评估内容删除
	@RequestMapping(value="/delectCont" , method = RequestMethod.POST)
	@ResponseBody
	public String delectCont(HttpServletRequest request) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		String cid =request.getParameter("cid");
		cid=cid.substring(1);
		String[] ids=cid.split("]");
		map.put("what",ids[0].toString());        
		assessService.delectCont(map);
		return "";
	}
	
	
	/**
	 * 评估人保存
	*/
	@RequestMapping(value="/saveEva" , method = RequestMethod.POST)
	@ResponseBody
	public String saveEva(HttpServletRequest request) throws Exception {
		String rows = request.getParameter("rows");
		JSONArray myJsonArray = JSONArray.fromObject(rows);
		for (int i = 0; i < myJsonArray.size(); i++) {
			AssessEva assessEva=new AssessEva();
			JSONObject assessJson = myJsonArray.getJSONObject(i);
			assessEva.setEvaluator_id(Integer.valueOf(assessJson.getString("evaluator_id").isEmpty()?"0":assessJson.getString("evaluator_id")));
			assessEva.setEvaluator(assessJson.getString("evaluator"));
			assessEva.setStatus(Integer.valueOf(assessJson.getString("status")));
			assessService.saveEva(assessEva);
			
		}
		return "";
	}
	//评估人删除
	@RequestMapping(value="/delectEva" , method = RequestMethod.POST)
	@ResponseBody
	public String delectEva(HttpServletRequest request) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		String cid =request.getParameter("cid");
		cid=cid.substring(1);
		String[] ids=cid.split("]");
		map.put("what",ids[0].toString());        
		assessService.delectEva(map);
		return "";
	}
	
	@RequestMapping(value="/delectData" , method = RequestMethod.POST)
	@ResponseBody
	public String delectData(HttpServletRequest request) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		String cid =request.getParameter("cid");
		cid=cid.substring(1);
		String[] ids=cid.split("]");
		map.put("what",ids[0].toString());        
		assessService.delectData(map);
		return "";
	}
}
