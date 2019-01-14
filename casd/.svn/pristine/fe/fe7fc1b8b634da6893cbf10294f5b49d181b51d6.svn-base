package com.casd.controller.manage;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.construct.ProSch;
import com.casd.service.construct.ConstructService;
import com.casd.service.construct.ProSchService;

@Controller
@RequestMapping("/admin")
public class ProSchController {

	@Autowired
	private ConstructService constructService;
	@Autowired
	private ProSchService proSchService;
	
	private int project_id=0;
	
	/**
	 *  合同管理列表
	 * 
	 * */
	@RequestMapping(value = "/proSchConList", method = RequestMethod.GET)
	public ModelAndView contractList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("construct/proSchConList");
		return mv;

	}
	
	@RequestMapping(value = "/proSchConList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> proSchConList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		sbf.append(" construct_project_table pro left join construct_project_dep dep on dep.constuct_project_dep_id=pro.construct_project_dep where dep.constuct_project_dep_company=1  ");
		String construct_project_name = request.getParameter("construct_project_name");
		if (StringUtils.hasText(construct_project_name)) {
			sbf.append(" and pro.construct_project_name like '%" + construct_project_name
					+ "%'");
		}
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		List<Map<String, Object>> data = constructService.constructList(
				pageIndex, pageSize, record, sbf.toString());
		json.put("rows", data);
		json.put("total", record.getValue());
		return json;
	}
	
	
	/**
	 *  项目进度
	 * 
	 * */
	@RequestMapping(value = "/proSch", method = RequestMethod.GET)
	public ModelAndView proSch(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		JSONObject jsonObject=new JSONObject();
		String construct_project_name = request.getParameter("construct_project_name");
		String construct_project_id = request.getParameter("construct_project_id");
		project_id=Integer.valueOf(construct_project_id);
		List<Map<String, Object>> rows=proSchService.getRows(construct_project_id);
		jsonObject.put("rows", rows);
		mv.addObject("rows", jsonObject);
		mv.addObject("construct_project_name", construct_project_name);
		mv.setViewName("construct/proSch");
		return mv;
	}
	
	
	/**
	 *  项目进度保存
	 * 
	 * */
	@RequestMapping(value = "/save_proSch", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject save_proSch(HttpServletRequest request) {
		JSONObject data=new JSONObject();
		String proSchStr = request.getParameter("proSch").toString();
		JSONArray jsonProSch = JSONArray.fromObject(proSchStr);
		JSONObject myjObject = jsonProSch.getJSONObject(0);
		ProSch proSch = (ProSch) JSONObject.toBean(myjObject,  
				ProSch.class);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		proSch.setConstruct_prosch_updatetime(df.format(new Date()).toString());
		proSch.setConstruct_prosch_projectid(project_id);
		proSchService.save_proSch(proSch);
		data.put("success", true);
		return data;
	}
	
	/**
	 *  项目进度删除
	 * 
	 * */
	@RequestMapping(value = "/delete_ProSch", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete_ProSch(HttpServletRequest request)
			throws Exception {
		
		String construct_prosch_id = request.getParameter("id");
		
		proSchService.delete_ProSch(construct_prosch_id);
		
		return null;
	}
	
	
	
}
