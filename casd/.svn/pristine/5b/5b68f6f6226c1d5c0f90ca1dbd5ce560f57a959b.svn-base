package com.casd.controller.uc;

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
import com.casd.entity.uc.FrameWork;
import com.casd.service.uc.FrameWorkService;

@Controller
@RequestMapping("/admin")
public class FrameworkController<costapp> {

	@Autowired
	private FrameWorkService frameWorkService;

	@RequestMapping(value = "/framework", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView framework(HttpServletRequest request) {
		int company=Integer.valueOf(request.getParameter("company").toString());
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map=new HashMap<String, Object>();
		String fields =" uc_framework_id  'key',uc_framework_name 'name',uc_framework_parentId parent,uc_framework_describe 'desc' ";
		StringBuffer sbf = new StringBuffer();
		sbf.append(" uc_framework where 1=1 and uc_framework_company='"+company+"' ");
		map.put("fields", fields);
		map.put("where", sbf.toString());
		List<Map<String, Object>> data=frameWorkService.getData(map);
		JSONArray jsonArray=JSONArray.fromObject(data);
		mv.addObject("data", jsonArray);
		mv.setViewName("uc/frameWorkBuild");
		return mv;

	}

	/**
	 *  行动列表
	 */
	@RequestMapping(value = "/frameWorkList", method = RequestMethod.GET)
	public ModelAndView frameWorkList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uc/frameWorkList");
		return mv;
	}

	@RequestMapping(value = "/frameWorkList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> frameWorkList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		
		sbf.append(" (select frame.*,com.*,(select framework.uc_framework_name from uc_framework framework where framework.uc_framework_id=frame.uc_framework_parentId ) lastLev  from  ");
		sbf.append(" uc_framework frame left join uc_company com on frame.uc_framework_company=com.company_id ) tableNew where 1=1 ");
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		String company=request.getParameter("company");
		if (StringUtils.hasText(company)) {
			sbf.append(" and company_name like  '%"+company+"%' ");
		}
		String framework_name=request.getParameter("framework_name");
		if (StringUtils.hasText(framework_name)) {
			sbf.append(" and uc_framework_name like  '%"+framework_name+"%' ");
		}
		sbf.append(" order by uc_framework_company ");
		
		List<Map<String, Object>> data = frameWorkService.frameWorkList(
				pageIndex, pageSize, record, sbf.toString());
		json.put("rows", data);
		json.put("total", record.getValue());
		return json;
	}
	
	
	
	@RequestMapping(value = "/deleFrameWork", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleFrameWork(HttpServletRequest request)
			throws Exception {

			Map<String, Object> json=new HashMap<String, Object>();
			try {
				frameWorkService.deleFrameWork(request.getParameter("ids").toString());
				json.put("Success", true);
				json.put("Msg", "已删除!");
			} catch (Exception e) {
				e.printStackTrace();
				json.put("Success", false);
				json.put("Msg", "程序出错,请联系技术员");
			}
			return json;
	}
	
	
	
	@RequestMapping(value = "/save_frameWork", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject save_frameWork(HttpServletRequest request,FrameWork frameWork) throws Exception {
		JSONObject json=new JSONObject();
		try {
			frameWorkService.save_frameWork(frameWork);
			json.put("erro", "");
		} catch (Exception e) {
			json.put("erro", e.getMessage());
		}
		return json;
	}

}
