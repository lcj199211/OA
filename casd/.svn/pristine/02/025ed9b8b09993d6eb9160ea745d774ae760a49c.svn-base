package com.casd.controller.uc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.controller.web.common.Authorize;
import com.casd.controller.web.common.Authorize.ResultType;
import com.casd.controller.web.common.Authorize.RoleEnum;
import com.casd.entity.finance.Supplier;
import com.casd.entity.uc.Center;
import com.casd.entity.uc.Company;
import com.casd.entity.uc.Department;
import com.casd.entity.uc.User;
import com.casd.service.uc.OrgService;
import com.casd.service.uc.UserService;

@Controller
@RequestMapping("/admin")
public class OrgController {

	@Autowired
	private UserService userService;
	@Autowired
	private OrgService orgService;
	

	/**
	 * 跳转部门页面
	 * 
	 * */
	@RequestMapping(value = "/departmentList", method = RequestMethod.GET)
	public ModelAndView departmentList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uc/departmentList");
		return mv;

	}

	/**
	 * 部门首页
	 * 
	 * */
	@RequestMapping(value = "/departmentList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> departmentList(HttpServletRequest request)
			throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String department_name = request.getParameter("department_name");

		String center_name = request.getParameter("center_name");
		String company_name = request.getParameter("company_name");
		StringBuilder sBuilder = new StringBuilder();
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		Ref<Integer> record = new Ref<Integer>();
		String fields = "a.department_id,a.department_name,a.department_centerId,a.department_companyId,b.center_name,b.center_id,c.company_name,c.company_id";
		sBuilder.append(" uc_department a");
		sBuilder.append(" LEFT JOIN uc_center b on a.department_centerId=b.center_id");
		sBuilder.append(" LEFT JOIN uc_company c on c.company_id=a.department_companyId");
		sBuilder.append(" where 1=1");
		if (StringUtils.hasText(department_name)) {
			sBuilder.append(" and department_name like'%" + department_name + "%'");
		}

		if (StringUtils.hasText(center_name)) {
			sBuilder.append(" and center_name like'%" + center_name + "%'");
		}
		if (StringUtils.hasText(company_name)) {
			sBuilder.append(" and company_name like '%" + company_name + "%'");
		}

		List<Map<String, Object>> data = userService.companyList(pageIndex,
				pageSize, record, fields, sBuilder.toString());
		jsonMap.put("rows", data);
		jsonMap.put("total", record.getValue());

		return jsonMap;
	}
	
		//部门保存
		@RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> saveDepartment(HttpServletRequest request) throws Exception {
			Department department=new Department();
			department.setDepartment_name(request.getParameter("department_name"));
			department.setDepartment_centerId(Integer.valueOf(request.getParameter("department_centerId").toString()));
			department.setDepartment_companyId(Integer.valueOf(request.getParameter("department_companyId").toString()));
			department.setDepartment_id(Integer.valueOf(request.getParameter("department_id").toString().isEmpty()?"0":request.getParameter("department_id").toString()));
			orgService.saveDepartment(department);
			return null;
		}
		
		//部门删除
		@RequestMapping(value="/deleDepartment" , method = RequestMethod.POST)
		@ResponseBody
		public String deleDepartment(HttpServletRequest request, Model model) {
			Map<String, Object> map=new HashMap<String, Object>();
			String ids =request.getParameter("ids");
			ids=ids.substring(1);
			String[] id=ids.split("]");
			map.put("what",id[0]);        
		    map.put("where", "uc_department");
		    orgService.deleDepartment(map);
			return null;
		}
		
	
	
	
	/**
	 *公司页面
	 * 
	 * */
	@RequestMapping(value = "/companyList", method = RequestMethod.GET)
	public ModelAndView companyList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uc/companyList");
		return mv;

	}

	/**
	 * 公司首页
	 * 
	 * */
	@RequestMapping(value = "/companyList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> companyList(HttpServletRequest request)
			throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String company_name = request.getParameter("companyname");
		StringBuilder sBuilder = new StringBuilder();
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		Ref<Integer> record = new Ref<Integer>();
		String fields = "c.company_name,c.company_id";
		sBuilder.append(" uc_company c");
		sBuilder.append(" where 1=1");
		if (StringUtils.hasText(company_name)) {
			sBuilder.append(" and company_name like '%" + company_name + "%'");
		}

		List<Map<String, Object>> data = userService.companyList(pageIndex,
				pageSize, record, fields, sBuilder.toString());
		jsonMap.put("rows", data);
		jsonMap.put("total", record.getValue());

		return jsonMap;
	}
	
	
	//公司保存
	@RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveCompany(HttpServletRequest request) throws Exception {
		Company company=new Company();
		company.setCompany_name(request.getParameter("company_name"));
		company.setCompany_id(Integer.valueOf(request.getParameter("company_id").toString().isEmpty()?"0":request.getParameter("company_id").toString()));
		orgService.saveCompany(company);
		return null;
	}
	
	//公司删除
	@RequestMapping(value="/deleCompany" , method = RequestMethod.POST)
	@ResponseBody
	public String deleCompany(HttpServletRequest request, Model model) {
		Map<String, Object> map=new HashMap<String, Object>();
		String ids =request.getParameter("ids");
		ids=ids.substring(1);
		String[] id=ids.split("]");
		map.put("what",id[0]);        
	    map.put("where", "uc_company");
	    orgService.deleCompany(map);
		return null;
	}
	
	
	/**
	 * 中心页面
	 * 
	 * */
	@RequestMapping(value = "/centerHome", method = RequestMethod.GET)
	public ModelAndView centerHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uc/centerList");
		return mv;

	}

	/**
	 * 中心首页
	 * 
	 * */
	@RequestMapping(value = "/centerHome", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> centerHome(HttpServletRequest request)
			throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		String center_name = request.getParameter("center_name");
		StringBuilder sBuilder = new StringBuilder();
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		Ref<Integer> record = new Ref<Integer>();
		String fields = "b.center_name,c.company_name ,b.center_id,c.company_id";
		sBuilder.append(" uc_center b");
		sBuilder.append(" LEFT JOIN uc_company c on c.company_id=b.center_companyId");
		sBuilder.append(" where 1=1");

		if (StringUtils.hasText(center_name)) {
			sBuilder.append(" and center_name like'%" + center_name + "%'");
		}

		List<Map<String, Object>> data = userService.companyList(pageIndex,
				pageSize, record, fields, sBuilder.toString());
		jsonMap.put("rows", data);
		jsonMap.put("total", record.getValue());

		return jsonMap;
	}
	
		//中心保存
		@RequestMapping(value = "/saveCenter", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> saveCenter(HttpServletRequest request) throws Exception {
			Center center=new Center();
			center.setCenter_name(request.getParameter("center_name"));
			center.setCenter_id(Integer.valueOf(request.getParameter("center_id").toString().isEmpty()?"0":request.getParameter("center_id").toString()));
			center.setCenter_companyId(Integer.valueOf(request.getParameter("center_companyId").toString()));
			orgService.saveCenter(center);
			return null;
		}
		
		//中心删除
		@RequestMapping(value="/deleCenter" , method = RequestMethod.POST)
		@ResponseBody
		public String deleCenter(HttpServletRequest request, Model model) {
			Map<String, Object> map=new HashMap<String, Object>();
			String ids =request.getParameter("ids");
			ids=ids.substring(1);
			String[] id=ids.split("]");
			map.put("what",id[0]);        
		    map.put("where", "uc_center");
		    orgService.deleCenter(map);
			return null;
		}
}
