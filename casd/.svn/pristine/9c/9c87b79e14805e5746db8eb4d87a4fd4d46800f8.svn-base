package com.casd.controller.ownCenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.ownCenter.OwnGoal;
import com.casd.entity.uc.User;
import com.casd.service.ownCenter.OwnGoalService;


@Controller
@RequestMapping("/admin")
public class OwnGoalController {
	
	@Autowired
	private OwnGoalService ownGoalService;
	
	/**
	 * 个人目标list
	*/
	@RequestMapping(value="/ownGoalList", method = RequestMethod.GET)
	public ModelAndView ownWorkList(HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("ownCenter/ownGoalList");
		return mv;
	}
	@RequestMapping(value = "/ownGoalList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ownGoalList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		
		String userId=request.getParameter("userId");
		if(!StringUtils.hasText(userId)){
			User loginUser = (User) request.getSession().getAttribute("loginUser");
			userId = String.valueOf(loginUser.getUserid());
		}
		
		sbf.append(" own_goal where 1=1 and own_goal_userId="+userId+" ");
		
		String goal_year = request.getParameter("goal_year");
		if (StringUtils.hasText(goal_year)) {
			sbf.append(" and own_goal_year like '%"+ goal_year + "%' ");
		}
		sbf.append(" order BY 	own_goal_type ");
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = ownGoalService.ownGoalList(
				pageIndex, pageSize, record, sbf.toString());
		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}
	
	
	
	/**
	 * 目标report
	*/
	@RequestMapping(value="/ownGoalReport", method = RequestMethod.GET)
	public ModelAndView ownGoalReport(HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ownCenter/ownGoalReport");
		return mv;
	}
	@RequestMapping(value = "/ownGoalReport", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ownGoalReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		String yearNum =request.getParameter("goal_year");
		
		sbf.append(" (  ");
		sbf.append(" SELECT  com.company_name,cen.center_name, goal.*,COUNT(own_goal_userId) goalTotal,   ");
		sbf.append(" (select COUNT(own_goal_id) from  own_goal  where own_goal_isFinish=0 and own_goal_type=1 and own_goal_userId=goal.own_goal_userId and own_goal_year like '"+yearNum+"' ) workGoalUnfinish ,  ");
		sbf.append(" (select COUNT(own_goal_id) from  own_goal  where own_goal_isFinish=1 and own_goal_type=1 and own_goal_userId=goal.own_goal_userId and own_goal_year like '"+yearNum+"' ) workGoalFinish,  ");
		sbf.append(" (select COUNT(own_goal_id) from  own_goal  where own_goal_isFinish=1 and own_goal_type=2 and own_goal_userId=goal.own_goal_userId and own_goal_year like '"+yearNum+"' ) lifeGoalFinish,  ");
		sbf.append(" (select COUNT(own_goal_id) from  own_goal  where own_goal_isFinish=0 and own_goal_type=2 and own_goal_userId=goal.own_goal_userId  and own_goal_year like '"+yearNum+"') lifeGoalUnfinish ");
		sbf.append(" from own_goal goal LEFT JOIN  ");
		sbf.append(" uc_user us on goal.own_goal_userId=us.userid LEFT JOIN  ");
		sbf.append(" uc_center cen on cen.center_id=us.center_id LEFT JOIN   ");
		sbf.append(" uc_company com on com.company_id=cen.center_companyId  ");
		sbf.append(" where goal.own_goal_year like '"+yearNum+"' ");
		
		String company_name = request.getParameter("company");
		if (StringUtils.hasText(company_name)) {
			sbf.append(" and com.company_name like '%"+ company_name + "%' ");
		}
		String center_name = request.getParameter("center");
		if (StringUtils.hasText(center_name)) {
			sbf.append(" and cen.center_name like '%"+ center_name + "%' ");
		}
		
		sbf.append(" GROUP BY own_goal_userId  ORDER BY com.company_id  ");
		sbf.append(" ) tableAll  ");
		
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = ownGoalService.ownGoalList(
				pageIndex, pageSize, record, sbf.toString());
		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}
	
	@RequestMapping(value = "/save_ownGoal", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject save_ownGoal(HttpServletRequest request,
			OwnGoal ownGoal) throws Exception {
		JSONObject jsonObject=new JSONObject();
		try {
			
			User loginUser = (User) request.getSession().getAttribute("loginUser");
			int userId = Integer.valueOf(loginUser.getUserid());
			String userName = String.valueOf(loginUser.getUsername());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			ownGoal.setOwn_goal_creatTime(df.format(new Date()));
			ownGoal.setOwn_goal_userId(userId);
			ownGoal.setOwn_goal_userName(userName);
			ownGoalService.saveConstruct(ownGoal);
			jsonObject.put("erro", "");
			jsonObject.put("success", true);
		} catch (Exception e) {
			// TODO: handle exception
			jsonObject.put("erro", e.getMessage());
			jsonObject.put("success", false);
		}
		return jsonObject;
		
	}
	
	@RequestMapping(value = "/finishOwnGoal", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject finishOwnGoal(HttpServletRequest request) throws Exception {
		JSONObject jsonObject=new JSONObject();
		try {
			String id=request.getParameter("id").toString();
			Map<String, Object> map=new HashMap<String, Object>();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			map.put("id", id);
			map.put("own_goal_finishTime", df.format(new Date()));
			ownGoalService.finishOwnGoal(map);
			jsonObject.put("erro", "");
			jsonObject.put("success", true);
		} catch (Exception e) {
			// TODO: handle exception
			jsonObject.put("erro", e.getMessage());
			jsonObject.put("success", false);
		}
		return jsonObject;
		
	}
	
}
