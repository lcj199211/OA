package com.casd.controller.supplierMod;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.construct.ApartyPur;
import com.casd.entity.supplierMod.Worker;
import com.casd.entity.supplierMod.WorkerApply;
import com.casd.entity.uc.User;
import com.casd.service.checkBox.CheckBoxService;
import com.casd.service.construct.ConstructService;
import com.casd.service.hr.ActivitiService;
import com.casd.service.supplierMod.WorkerService;
import com.casd.service.uc.OrgService;
import com.casd.service.uc.RoleService;
import com.casd.service.uc.UserService;

@Controller
@RequestMapping("/admin")
public class WorkerController {

	@Autowired
	private ConstructService constructService;
	@Autowired
	private CheckBoxService checkBoxService;

	@Autowired
	private WorkerService workerService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrgService orgService;

	@Autowired
	private ActivitiService activitiService;

	/**
	 * 班组list
	 */
	@RequestMapping(value = "/workerConList", method = RequestMethod.GET)
	public ModelAndView aPartyConList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("supplierMod/workerConList");
		return mv;
	}

	@RequestMapping(value = "/workerConList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> workerConList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();

		sbf.append(" construct_project_table pro left join construct_project_dep dep on dep.constuct_project_dep_id=pro.construct_project_dep   ");
		sbf.append(" LEFT JOIN construct_project_workteam team  on  pro.construct_project_id =team.construct_project_workTeam_projectId  ");
		sbf.append(" left join uc_user us on us.userid = team.construct_project_workTeam_userId  ");
		sbf.append(" where  1=1 ");
		//sbf.append(" and  dep.constuct_project_dep_company=1  ");
		sbf.append(" and  pro.construct_project_leader='"
				+ loginUser.getUsername() + "' ");
		String construct_project_name = request
				.getParameter("construct_project_name");
		if (StringUtils.hasText(construct_project_name)) {
			sbf.append(" and pro.construct_project_name like '%"
					+ construct_project_name + "%'");
		}

		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = constructService.constructList(
				pageIndex, pageSize, record, sbf.toString());

		if (data.size() == 0) {
			
			StringBuffer sbf2 = new StringBuffer();

			sbf2.append(" construct_project_workteam team LEFT  JOIN 	construct_project_table pro ON pro.construct_project_id = team.construct_project_workTeam_projectId   ");
			sbf2.append(" LEFT JOIN construct_project_dep dep ON dep.constuct_project_dep_id = pro.construct_project_dep  ");
			sbf2.append(" left join uc_user us on us.userid = team.construct_project_workTeam_userId  ");
			sbf2.append(" where  1=1 and  us.username is not null ");
			//sbf2.append(" where  dep.constuct_project_dep_company=1 ");
			sbf2.append(" and  us.username='" + loginUser.getUsername() + "' ");
			if (StringUtils.hasText(construct_project_name)) {
				sbf.append(" and pro.construct_project_name like '%"
						+ construct_project_name + "%'");
			}

			data = constructService.constructList(pageIndex, pageSize, record,
					sbf2.toString());

		}

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}

	/**
	 * 工人list
	 */
	@RequestMapping(value = "/workerList", method = RequestMethod.GET)
	public ModelAndView workerList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String construct_project_workTeam_id = request
				.getParameter("construct_project_workTeam_id");
		String construct_project_workTeam_departmentId = request
				.getParameter("construct_project_workTeam_departmentId");
		String construct_project_id = request
				.getParameter("construct_project_id");
		String construct_project_leader = request
				.getParameter("construct_project_leader");

		int userId = workerService.getUserByName(construct_project_leader);

		mv.addObject("userId", userId);

		mv.addObject("construct_project_workTeam_id",
				construct_project_workTeam_id);
		mv.addObject("construct_project_workTeam_departmentId",
				construct_project_workTeam_departmentId);
		mv.addObject("construct_project_id", construct_project_id);

		mv.setViewName("supplierMod/workerList");
		return mv;
	}

	@RequestMapping(value = "/workerList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> workerList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String construct_project_id = request
				.getParameter("construct_project_id");
		String construct_project_workTeam_id = request
				.getParameter("construct_project_workTeam_id");

		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();

		sbf.append(" ( ");
		sbf.append(" SELECT ");
		sbf.append(" worker.*,us.*,(select COUNT(1) from suppliermod_worker_apply apply where apply.suppliermod_worker_apply_userId =worker.supplierMod_worker_userId and apply.suppliermod_worker_apply_status=0) isOnApply ");
		sbf.append(" FROM ");
		sbf.append(" suppliermod_worker_table worker ");
		sbf.append(" LEFT JOIN uc_user us ON worker.supplierMod_worker_userId = us.userid ");
		sbf.append(" where  worker.supplierMod_worker_projectId="
				+ construct_project_id
				+ " and worker.supplierMod_worker_workTeamId="
				+ construct_project_workTeam_id + " ");
		sbf.append(" ) tableAll ");

		String username = request.getParameter("username");
		if (StringUtils.hasText(username)) {
			sbf.append(" and us.username like '%" + username + "%'");
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
	 * 工人选择
	 */
	@RequestMapping(value = "/workerCheck", method = RequestMethod.GET)
	public ModelAndView workerCheck(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("checkBox/workerCheck");
		return mv;

	}

	@RequestMapping(value = "/workerCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> workerCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String departmentId = request.getParameter("departmentId");

		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();
		StringBuffer fields = new StringBuffer();
		fields.append("us.userid,us.username,us.phone_number,us.sex, role.role_name,dep.department_name,cen.center_name,com.company_name,dep.department_id");
		sbf.append("  uc_user us ");
		sbf.append("LEFT JOIN uc_role role on us.role_id=role.role_id ");
		sbf.append("LEFT JOIN uc_department dep on us.department=dep.department_id ");
		sbf.append("LEFT JOIN uc_center cen on dep.department_centerId=cen.center_id ");
		sbf.append("LEFT JOIN uc_company com on com.company_id=dep.department_companyId ");
		sbf.append(" where 1=1 and us.department=" + departmentId + " ");

		if (StringUtils.hasText(username)) {
			sbf.append(" and username like '%" + username + "%'");
		}
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		List<Map<String, Object>> data = checkBoxService.getList(pageIndex,
				pageSize, record, sbf.toString(), fields.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}

	/**
	 * 保存
	 * 
	 * */
	@RequestMapping(value = "/save_Worker", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save_Worker(HttpServletRequest request,
			ApartyPur apartyPur) throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			String construct_project_id = request
					.getParameter("construct_project_id");
			String construct_project_workTeam_id = request
					.getParameter("construct_project_workTeam_id");
			String supplierMod_worker_userId = request
					.getParameter("supplierMod_worker_userId");

			Boolean checkWorker = workerService
					.checkWorkerExist(supplierMod_worker_userId);
			if (!checkWorker) {
				Worker worker = new Worker();
				worker.setSupplierMod_worker_id(0);
				worker.setSupplierMod_worker_projectId(Integer
						.valueOf(construct_project_id));
				worker.setSupplierMod_worker_userId(Integer
						.valueOf(supplierMod_worker_userId));
				worker.setSupplierMod_worker_workTeamId(Integer
						.valueOf(construct_project_workTeam_id));
				workerService.save_Worker(worker);
				json.put("Success", true);
				json.put("Msg", "保存成功");
			} else {
				json.put("Success", true);
				json.put("Msg", "此人已被分配在项目中，如需调动请走工人项目调动流程！");

			}
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "保存失败");
		}
		return json;
	}
	
	/**
	 *  补卡
	 */
	@RequestMapping(value = "/saveWorkerAtt", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveWorkerAtt(HttpServletRequest request) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			Map<String, Object> data=new HashMap<String, Object>();
			data.put("hr_attend_id", 0);
			data.put("hr_attend_date", request.getParameter("hr_attend_date").toString());
			data.put("hr_attend_WTLength", request.getParameter("hr_attend_WTLength").toString());
			data.put("hr_attend_userId", request.getParameter("hr_attend_userId").toString());
			data.put("hr_attend_projectId", request.getParameter("hr_attend_projectId").toString());
			data.put("hr_attend_workTeamId", request.getParameter("hr_attend_workTeamId").toString());
			workerService.saveWorkerAtt(data);
			
			map.put("ero", "");
		} catch (Exception e) {
			// TODO: handle exception
			map.put("ero", e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 打卡记录list
	 * @throws Exception 
	 */
	@RequestMapping(value = "/workerAttendList", method = RequestMethod.GET)
	public ModelAndView workerAttendList(HttpServletRequest request, Model model)  {
		ModelAndView mv = new ModelAndView();
		
		
		StringBuffer sbf = new StringBuffer();
		sbf.append(" uc_company a");
		String fields="a.company_id,a.company_name ";
		List<Map<String, Object>> companyList=userService.queryId(fields, sbf.toString());
		System.err.println(companyList.size());
      /*Calendar c1 = Calendar.getInstance();
		// 获得年份
		int year = c1.get(Calendar.YEAR);
		// 获得月份
		int month = c1.get(Calendar.MONTH)+1;
		String monString = String.valueOf(month);
		if (month < 10) {
			monString = "0" + month;
		}
		
		JSONObject jsonObject = new JSONObject();
		String supplierMod_worker_userId = request
				.getParameter("supplierMod_worker_userId");
		StringBuffer sbf2 = new StringBuffer();
		sbf2.append(" suppliermod_worker_table supp left join uc_user user on supp.supplierMod_worker_userId=user.userid");
		sbf2.append(" where supp.supplierMod_worker_userId="
				+ supplierMod_worker_userId + "  ");
		Map<String, Object> map = constructService.getSupplierMod(sbf2
				.toString());
		jsonObject.put("data", map);
		mv.addObject("data", jsonObject);
		mv.addObject("yearMon", year + "-" + monString);*/
		mv.addObject("companyList", companyList);
		mv.setViewName("supplierMod/workerAttendList");
		return mv;
	}

	@RequestMapping(value = "/workerAttendLists", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> workerAttendList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Ref<Integer> record = new Ref<Integer>();
		
		String company_id =request.getParameter("company_id");
		String start_time =request.getParameter("start_time");
		String end_time =request.getParameter("end_time");
		String username =request.getParameter("username");
		
		StringBuffer sbf = new StringBuffer();
		sbf.append(" hr_attend attend");
		sbf.append(" LEFT JOIN hr_attend_apply apply ON attend.hr_attend_applyId = apply.hr_attend_apply_id");
		sbf.append(" LEFT JOIN uc_user us ON us.userid = attend.hr_attend_userId");
		sbf.append(" LEFT JOIN uc_center center on  center.center_id=us.center_id");
		sbf.append(" LEFT JOIN uc_company company on  company.company_id=center.center_companyId");
		sbf.append(" where 1=1");
		
		if (StringUtils.hasText(company_id)) {
			sbf.append(" and company.company_id =" + company_id);
		}
		if (StringUtils.hasText(start_time)) {
			sbf.append(" and attend.hr_attend_date >='" + start_time+"'");
		}
		if (StringUtils.hasText(end_time)) {
			sbf.append(" and attend.hr_attend_date <='" + end_time+"'");
		}
		if (StringUtils.hasText(username)) {
			sbf.append(" and us.username ='" + username+"'");
		}


		sbf.append(" ORDER BY attend.hr_attend_date desc");
		
		Integer page=Integer.parseInt(request.getParameter("page"));
		page = page==null ? 1: page;
	       page=page-1;
		int pageSize = Integer.parseInt(request.getParameter("limit"));
	

		List<Map<String, Object>> data = constructService.constructList(
				page, pageSize, record, sbf.toString());
		 JSONArray jsonArray=JSONArray.fromObject(data);
		  Map<String, Object> result = new HashMap<String, Object>();
		    result.put("code", 0);
		    result.put("msg", "");
		    result.put("count", record.getValue());
		    result.put("data", jsonArray);
		
		return result;

	}

	/**
	 * 项目调动申请
	 */
	@RequestMapping(value = "/workerApply", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> workerApply(HttpServletRequest request,
			WorkerApply workerApply) {

		Map<String, Object> json = new HashMap<String, Object>();
		try {
			// 日期格式化
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			workerApply.setSuppliermod_worker_apply_creatTime(df
					.format(new Date()));
			String nextUserid = request.getParameter("username");

			workerService.workerApply(workerApply);

			String processDefinitioKey = "workerApplyViwe"; // 定义流程的key,不可修改
			String title = "工人项目调动"; // 请注意
			String bizId = processDefinitioKey + "."
					+ workerApply.getSuppliermod_worker_apply_id(); // 获取业务id

			activitiService.startProcesses(bizId, nextUserid,
					processDefinitioKey, title);

			/*
			 * String content="你有一张工人项目调动申请单需要审批！";
			 * json=activitiService.sendEmail(title, content, nextUserid);
			 */

			json.put("Success", true);
			json.put("Msg", "保存成功，流程已启动");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "保存失败，流程未启动");
		}
		return json;

	}

	/**
	 * 调动记录
	 * 
	 */
	@RequestMapping(value = "/workerApplyList", method = RequestMethod.GET)
	public ModelAndView workerApplyList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("supplierMod/workerApplyList");
		return mv;
	}

	@RequestMapping(value = "/workerApplyList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> workerApplyList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String supplierMod_worker_userId = request
				.getParameter("supplierMod_worker_userId");

		Ref<Integer> record = new Ref<Integer>();
		Map<String, Object> json = new HashMap<String, Object>();
		StringBuffer sbf = new StringBuffer();

		sbf.append(" ( ");
		sbf.append(" select (select con.construct_project_name  from	construct_project_table con where con.construct_project_id= apply.suppliermod_worker_apply_oldProId ) projectName, ");
		sbf.append(" pro.construct_project_name,us.username,apply.* from suppliermod_worker_apply apply ");
		sbf.append(" LEFT JOIN construct_project_table pro ON pro.construct_project_id = apply.suppliermod_worker_apply_proId ");
		sbf.append(" LEFT JOIN uc_user us ON us.userid = apply.suppliermod_worker_apply_userId ");
		sbf.append(" where  apply.suppliermod_worker_apply_userId="
				+ supplierMod_worker_userId + "  ");
		sbf.append(" ) tab ");

		String suppliermod_worker_apply_creatTime = request
				.getParameter("suppliermod_worker_apply_creatTime");
		if (StringUtils.hasText(suppliermod_worker_apply_creatTime)) {
			sbf.append(" and apply.suppliermod_worker_apply_creatTime like '%"
					+ suppliermod_worker_apply_creatTime + "%'");
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
	 * 项目调动 审批
	 * 
	 * @throws Exception
	 * 
	 * */
	@RequestMapping(value = "/workerApplyAut", method = RequestMethod.GET)
	public ModelAndView workerApplyAut(HttpServletRequest request)
			throws Exception {
		ModelAndView mv = new ModelAndView();

		String taskid = request.getParameter("taskid");// 获取任务id
		String taskName = request.getParameter("taskName");
		String bizkey = activitiService.getBusinessBizId(taskid);// 获取业务编号

		String[] strs = bizkey.split("\\.");
		String bizId = null; // 业务编号
		for (int i = 0, len = strs.length; i < len; i++) {
			bizId = strs[i].toString();
		}
		List<Map<String, Object>> userList = null;
		if (taskName.equals("项目经理")) {
			String fields = " a.userid,a.username";
			String where = " uc_user a join uc_role b";
			where += " on a.role_id=b.role_id";
			where += " WHERE b.role_name like '%总经理'";
			userList = userService.queryId(fields, where);
		}

		// 查询旧项目信息
		String wobkString = "uu.username,uu.userid,swa.suppliermod_worker_apply_creatTime,";
		wobkString += " cpt.construct_project_name,swa.suppliermod_worker_apply_reason,";
		wobkString += " swa.suppliermod_worker_apply_oldProId";
		StringBuffer sbf = new StringBuffer();
		sbf.append(" suppliermod_worker_apply swa");
		sbf.append(" JOIN construct_project_table cpt ON");
		sbf.append(" swa.suppliermod_worker_apply_proId=cpt.construct_project_id");
		sbf.append(" LEFT JOIN uc_user uu on uu.userid = swa.suppliermod_worker_apply_userId");
		sbf.append(" WHERE swa.suppliermod_worker_apply_id=" + bizId);
		// 查询旧项目信息
		Map<String, Object> findwoMap = workerService.findWorker(wobkString,
				sbf.toString());
		// 查询新项目信息
		String findname = "cpt.construct_project_name as newProjectName";
		sbf.delete(0, sbf.length());
		sbf.append("suppliermod_worker_apply swa");
		sbf.append(" LEFT JOIN  construct_project_table cpt ON swa.suppliermod_worker_apply_oldProId = cpt.construct_project_id");
		sbf.append(" where swa.suppliermod_worker_apply_id =" + bizId);
		// 查询新项目信息
		Map<String, Object> findmork = workerService.findWorker(findname,
				sbf.toString());

		List<Map<String, Object>> historyList = activitiService
				.getProcessComments(taskid);// 查询审批记录

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("history", historyList);
		mv.addObject("history", jsonObject);

		mv.addObject("userList", userList);
		mv.addAllObjects(findwoMap);
		mv.addAllObjects(findmork);
		mv.addObject("taskid", taskid);
		mv.addObject("taskName", taskName);
		mv.addObject("userList", userList);
		mv.setViewName("supplierMod/workerApplyAut");
		return mv;
	}

	// 审核
	@RequestMapping(value = "/workerApplyPass", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> workerApplyPass(HttpServletRequest request) {
		Map<String, Object> json = new HashMap<String, Object>();
		try {

			workerService.workerApplyPass(request);
			json.put("Success", true);
			json.put("Msg", "已审核!");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "程序出错,请联系技术员");
		}
		return json;
	}

	@RequestMapping(value = "/multiplayerApply", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> multiplayerApply(HttpServletRequest request) {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			Map<String, Object> map = new HashMap<String, Object>();

			String suppliermod_worker_apply_proId = request
					.getParameter("suppliermod_worker_apply_proId");
			String suppliermod_worker_apply_teamId = request
					.getParameter("suppliermod_worker_apply_teamId");
			String ids = request.getParameter("cid");
			ids = ids.substring(1);
			String[] id = ids.split("]");
			map.put("what", id[0]);
			map.put("suppliermod_worker_apply_proId",
					suppliermod_worker_apply_proId);
			map.put("suppliermod_worker_apply_teamId",
					suppliermod_worker_apply_teamId);
			workerService.multiplayerApply(map);
			json.put("Success", true);
			json.put("Msg", "已转移!");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "程序出错,请联系技术员");
		}
		return json;
	}

	/**
	 * 生成树
	 */
	@RequestMapping(value = "/workerUserTreeList", method = RequestMethod.GET)
	@ResponseBody
	public void workerUserTreeList(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String center_name = request.getParameter("center_name");

			Map<String, Object> map = new HashMap<String, Object>();
			// 公司
			map.put("where", "uc_company WHERE company_id=17 ");
			map.put("what", "company_id,company_name");
			List<Map<String, Object>> companies = orgService.queryData(map);
			// 中心
			map.put("where", "uc_center where center_name='" + center_name
					+ "' ");
			map.put("what", "center_id,center_name,center_companyId");
			List<Map<String, Object>> centers = orgService.queryData(map);

			// 部门
			map.put("where",
					"uc_department dep left join uc_center cen on cen.center_id=dep.department_centerId  where center_name='"
							+ center_name + "' ");
			map.put("what",
					"dep.department_id,dep.department_name,dep.department_centerId");
			List<Map<String, Object>> departments = orgService.queryData(map);

			JSONArray arr = new JSONArray();
			// 一级菜单
			for (int i = 0; i < companies.size(); i++) {
				JSONObject node = new JSONObject();
				int company_id = Integer.valueOf(companies.get(i)
						.get("company_id").toString());
				node.put("id", company_id);
				node.put("name", companies.get(i).get("company_name"));
				JSONArray childrenArr = new JSONArray();
				// 二级菜单
				for (int j = 0; j < centers.size(); j++) {
					if (company_id == Integer.valueOf(centers.get(j)
							.get("center_companyId").toString())) {
						int center_id = Integer.valueOf(centers.get(j)
								.get("center_id").toString());
						JSONObject children = new JSONObject();
						children.put("id", center_id);
						children.put("name", centers.get(j).get("center_name"));
						// 三级
						JSONArray threeArr = new JSONArray();
						for (int k = 0; k < departments.size(); k++) {
							if (center_id == Integer.valueOf(departments.get(k)
									.get("department_centerId").toString())) {
								JSONObject threeChildren = new JSONObject();
								threeChildren
										.put("id",
												departments.get(k).get(
														"department_id"));
								threeChildren.put("name", departments.get(k)
										.get("department_name"));
								threeArr.add(threeChildren);
							}
						}
						children.put("children", threeArr);
						childrenArr.add(children);
					}
				}

				node.put("children", childrenArr);
				arr.add(node);
			}
			response.setCharacterEncoding("UTF-8");

			response.getWriter().write(arr.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 工人列表信息
	 * 
	 * */
	@RequestMapping(value = "/workerUserList", method = RequestMethod.GET)
	public ModelAndView workerUserList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String center_name = request.getParameter("center_name");
		mv.addObject("center_name", "'" + center_name + "'");
		mv.setViewName("supplierMod/workerUserList");
		return mv;

	}

	@RequestMapping(value = "/workerUserList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> workerUserList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Ref<Integer> record = new Ref<Integer>();
		StringBuilder sbf = new StringBuilder();
		StringBuilder fields = new StringBuilder();

		// 显示字段
		fields.append(" * ");

		Map<String, Object> json = new HashMap<String, Object>();
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;
		String username = request.getParameter("username");
		// String userid = request.getParameter("userid");
		String department_name = request.getParameter("department_name");
		String center_name = request.getParameter("center_name");
		String company_name = request.getParameter("company_name");
		// int status = Integer.valueOf(request.getParameter("status"));

		sbf.append(" ( ");
		sbf.append(" SELECT ");
		sbf.append(" newtable.* ,(select dep.department_name FROM uc_department dep where dep.department_id=newtable.department )   as  department_name from ");
		sbf.append(" ( ");
		sbf.append(" select  a.user_num,a.userid,a.username,a.phone_number,a.sex,a.email,a.user_card,a.card_address,a.status,a.department,c.center_name,d.company_name,a.center_id ");
		sbf.append(" from uc_user a ");
		sbf.append(" LEFT JOIN uc_center c ON a.center_id = c.center_id ");
		sbf.append(" LEFT JOIN uc_department b ON c.center_id = b.department_centerId ");
		sbf.append(" LEFT JOIN uc_company d ON d.company_id = c.center_companyId ");
		sbf.append(" GROUP BY a.userid ORDER BY a.user_num asc  ");
		sbf.append(" ) newtable ) secedtable ");
		sbf.append(" where 1=1 ");

		// if(!company_name.equals("诚安时代（1）")){
		/*
		 * if (status != 0) { sbf.append(" and `status`="+status+""); }
		 */
		/*
		 * if (StringUtils.hasText(company_name)) {
		 * sbf.append(" and company_name like '%" + company_name + "%'"); }
		 */
		if (StringUtils.hasText(center_name)) {
			sbf.append(" and center_name like '%" + center_name + "%'");
		}
		if (StringUtils.hasText(department_name)) {
			sbf.append(" and department_name like '%" + department_name + "%'");
		}

		if (StringUtils.hasText(username)) {
			sbf.append(" and username like '%" + username + "%'");
		}
		/*
		 * if (StringUtils.hasText(userid)) { sbf.append(" and userid like '%" +
		 * userid + "%'"); }
		 */
		// }
		List<Map<String, Object>> data = userService.userList(pageIndex,
				pageSize, record, sbf.toString(), fields.toString());
		json.put("rows", data);
		json.put("total", record.getValue());

		return json;

	}

	/**
	 * 新增职员
	 */
	@RequestMapping(value = "workerUserNew", method = RequestMethod.GET)
	public ModelAndView workerUserNew(Model model, HttpServletRequest request)
			throws Exception {
		String cid = request.getParameter("cid");
		String department = request.getParameter("department");
		ModelAndView mv = new ModelAndView();

		// 查看角色
		StringBuffer sbf = new StringBuffer();
		String fields = "b.role_id,b.role_name";
		sbf.append(" uc_role b");
		List<Map<String, Object>> roles = roleService.seleroleById(fields,
				sbf.toString());
		mv.addObject("roles", roles);

		if (cid != null) {
			// 表头
			String field = " *";
			sbf.delete(0, sbf.length());
			sbf.append("  uc_user us ");
			sbf.append("LEFT JOIN uc_center cen on us.center_id=cen.center_id ");
			sbf.append("LEFT JOIN uc_department dep on cen.center_id=dep.department_centerId ");
			sbf.append("LEFT JOIN uc_company com on com.company_id=cen.center_companyId ");
			sbf.append(" where 1=1 ");
			sbf.append(" and userid=" + cid + "");
			if (department != "") {
				sbf.append("  and dep.department_id=" + department);
			}

			Map<String, Object> data = userService.queryUserById(field,
					sbf.toString());
			mv.addObject("pro", data);
		} else {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("userid", 0);
			data.put("sex", 0);
			data.put("age", 0);
			data.put("marital_status", 0);
			data.put("education", 0);
			data.put("level", 0);
			data.put("blood", 0);
			data.put("weight", 0);
			data.put("user_num", 0);
			data.put("status", "0");
			mv.addObject("pro", data);
		}
		mv.addObject("center_name", "'" + request.getParameter("center_name")
				+ "'");
		mv.setViewName("supplierMod/workerUserNew");
		return mv;

	}
	
	@RequestMapping(value = "getworkerUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getworkerUser(String userid) {
				StringBuffer sbf2 = new StringBuffer();
				sbf2.append(" suppliermod_worker_table supp left join uc_user user on supp.supplierMod_worker_userId=user.userid");
				sbf2.append(" where supp.supplierMod_worker_userId="+ userid);
				Map<String, Object> map = constructService.getSupplierMod(sbf2
						.toString());
				return map;
	            }
	
	public HSSFCell creatRow(HSSFSheet sheet,int i,HSSFWorkbook wb,HSSFFont font, HSSFRow row,HSSFCellStyle style,HSSFCell cell,Map<String, Object> map) {
		try {
			
		Object reason = map.get("hr_attend_apply_reason");
		String replace = null;
		String hr_attend_overtime = map.get("hr_attend_overtime") + "";
		String overtime = "";
		String Lagtime="";
		if (reason != null) {
			replace = "是";
		} else {
			replace = "否";
		}
		// 是否加班
		if (hr_attend_overtime.equals("0")) {
			overtime = "否";
		} else {
			overtime = "是";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
		Date date1= new Date(sdf.parse((map.get("hr_attend_startWork").toString())).toString());//上班打卡时间
		Date date2= new Date(sdf.parse("08:30:00 ").toString()); //上班时间 
		int fenzhong=(int) ((date1.getTime() - date2.getTime()) / (1000 * 60));//计算迟到分钟数
		if(fenzhong>0&&fenzhong<=30){
			Lagtime=String.valueOf(fenzhong);
	    }else if (fenzhong>30&&fenzhong<210) {
	    	Lagtime=String.valueOf("是否旷工,打卡时间超过9点");
		}else if (fenzhong>210) {
	    	Lagtime=String.valueOf("是否请假，打卡时间超过12点");
		}
		map.put("replace", replace);
		map.put("overtime", overtime);
		map.put("Lagtime", Lagtime);
		
		/*int num = row.getRowNum();
		System.out.println(row.getRowNum());*/
		row = sheet.createRow(i + 2);
		cell=getCell(sheet, row, style, cell, map);
		/*if ((i+1) % 2 != 0) {
			
			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
			style1.setFont(font);
			style1.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
			style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
			style1.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
			style1.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边
			
			cell=getCell(sheet, row, style1, cell, map);
		}else {
			style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE
					.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

			cell=getCell(sheet, row, style, cell, map);
		}*/
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cell;
	}
	
	
	public HSSFCell getCell(HSSFSheet sheet, HSSFRow row,HSSFCellStyle style,HSSFCell cell,Map<String, Object> map){
		
		cell = row.createCell(0);
		cell.setCellValue(map.get("center_name") + "");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue(map.get("username") + "");
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue(map.get("hr_attend_date") + "");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue(map.get("hr_attend_startWork") + "");
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue(map.get("hr_attend_workAddress") + "");
		cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue(map.get("hr_attend_workingState") + "");
		cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue(map.get("hr_attend_knockOff") == null ? ""
				: map.get("hr_attend_knockOff") + "");
		cell.setCellStyle(style);
		cell = row.createCell(7);
		cell.setCellValue(map.get("hr_attend_offWorkAddress") == null ? ""
				: map.get("hr_attend_offWorkAddress") + "");
		cell.setCellStyle(style);
		cell = row.createCell(8);
		cell.setCellValue(map.get("hr_attend_restState") == null ? ""
				: map.get("hr_attend_restState") + "");
		cell.setCellStyle(style);
		cell = row.createCell(9);
		cell.setCellValue(map.get("overtime")+ "");
		cell.setCellStyle(style);
		cell = row.createCell(10);
		cell.setCellValue(map.get("hr_attend_overtimeDate") + "");
		cell.setCellStyle(style);
		cell = row.createCell(11);
		cell.setCellValue(map.get("hr_attend_WTLength") + "");
		cell.setCellStyle(style);
		cell = row.createCell(12);
		cell.setCellValue(map.get("replace")+ "");
		cell.setCellStyle(style);
		cell = row.createCell(13);
		cell.setCellValue(map.get("hr_attend_apply_reason") == null ? ""
				: map.get("hr_attend_apply_reason") + "");
		cell.setCellStyle(style);
		cell = row.createCell(14);
		cell.setCellValue(map.get("Lagtime")+ "");   
		cell.setCellStyle(style);
		return cell;
		
	}
	
	public HSSFCell total(HSSFSheet sheet,int i, HSSFRow row,HSSFCellStyle style,HSSFCell cell,Map<String, Object> map, String start_time, String end_time){
		
		String fields = " SUM(hr_attend_WTLength) workTime, SUM(hr_attend_overtimeDate) overTime, (SELECT SUM(day_count) from own_leave_table where start_time >= '"+start_time+"' and end_time<'"+end_time+"' and applicant='"+map.get("username")+"' ) leaveTime";
		StringBuffer sbf = new StringBuffer();
		sbf.append(" hr_attend where hr_attend_date >= '"+start_time+"' and hr_attend_date <= '"+end_time+"'  and hr_attend_userId='"+map.get("userid")+"' ");
		Map<String, Object> getDataMap=new HashMap<String, Object>();
		getDataMap.put("fields", fields);
		getDataMap.put("where", sbf);
		
		Map<String, Object> data = userService.attendTotal(getDataMap);
		
		row = sheet.createRow(i + 2);
		cell = row.createCell(0);
		cell.setCellValue("上班时长");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue(String.valueOf(data.get("workTime")== null ? "0"
				: data.get("workTime"))+"天");
		cell.setCellStyle(style);
		
		cell = row.createCell(2);
		cell.setCellValue("加班时长");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue(String.valueOf(data.get("overTime")== null ? "0"
				: data.get("overTime"))+"分钟");
		cell.setCellStyle(style);
		
		cell = row.createCell(4);
		cell.setCellValue("请假天数");
		cell.setCellStyle(style);
		
		cell = row.createCell(5);
		cell.setCellValue(String.valueOf(data.get("leaveTime")== null ? "0"
				: data.get("leaveTime"))+"天");
		cell.setCellStyle(style);
		return cell;
		
	}
	
	/**
	 * 导出单据信息 修改人：Jerry_木子 修改时间：2018年11月15日 方法描述：@param response 方法描述：@param
	 * request 方法描述：@throws Exception
	 */
	@RequestMapping(value = "/hrattendExcel", method = RequestMethod.GET)
	@ResponseBody
	public void hrattendExcel(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		
		String company_id =request.getParameter("company_id");
		String start_time =request.getParameter("start_time");
		String end_time =request.getParameter("end_time");
		String username =request.getParameter("username");
		
		OutputStream ous = null;
		try {
			String fields = "center.center_name,us.username,us.userid,attend.hr_attend_date,attend.hr_attend_startWork,";
			fields += "attend.hr_attend_workAddress,attend.hr_attend_workingState,attend.hr_attend_knockOff,";
			fields += "attend.hr_attend_offWorkAddress,attend.hr_attend_restState,attend.hr_attend_overtime,";
			fields += "attend.hr_attend_overtimeDate,attend.hr_attend_WTLength,apply.hr_attend_apply_reason";
			StringBuffer sbf = new StringBuffer();
			
			sbf.append("hr_attend attend");
			sbf.append(" LEFT JOIN hr_attend_apply apply ON attend.hr_attend_applyId = apply.hr_attend_apply_id");
			sbf.append(" LEFT JOIN uc_user us ON us.userid = attend.hr_attend_userId");
			sbf.append(" LEFT JOIN uc_center center on  center.center_id=us.center_id");
			sbf.append(" LEFT JOIN uc_company company on company.company_id=center.center_companyId");
			sbf.append(" where 1=1");
			
			if (StringUtils.hasText(company_id)) {
				sbf.append(" and company.company_id =" + company_id);
			}
			if (StringUtils.hasText(start_time)) {
				sbf.append(" and attend.hr_attend_date >='" + start_time+"'");
			}
			if (StringUtils.hasText(end_time)) {
				sbf.append(" and attend.hr_attend_date <='" + end_time+"'");
			}
			if (StringUtils.hasText(username)) {
				sbf.append(" and us.username ='" + username+"'");
			}
			sbf.append(" order by us.center_id,us.userid,hr_attend_date");
			
			List<Map<String, Object>> data = userService.queryId(fields,
					sbf.toString());
		
			
			HSSFWorkbook wb = new HSSFWorkbook(); // 定义一个新的工作簿
			HSSFSheet sheet = wb.createSheet("打卡记录"); // 创建第一个Sheet页
			HSSFCellStyle stylehead = wb.createCellStyle();
			HSSFFont font = wb.createFont();
			HSSFRow row = null; // 创建一个行
			HSSFCell cell = null;// 创建列
			font.setFontHeightInPoints((short) 12);// 字号
			font.setFontName("宋体");
			stylehead.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
			stylehead.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
			stylehead.setFont(font);
			stylehead.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
			stylehead.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
			stylehead.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
			stylehead.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边
			row = sheet.createRow(0);
			
			
			for (int i = 0; i < 14; i++) {

				if (i == 0) {
					cell = row.createCell(0);
					cell.setCellValue("打卡记录");
					cell.setCellStyle(stylehead);
				} else {
					cell = row.createCell(i);
					cell.setCellStyle(stylehead);
				}
			}
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 14)); // 单元格合并
			row = sheet.createRow(1);
			cell = row.createCell(0);
			cell.setCellValue("中心名称");
			cell.setCellStyle(stylehead);
			cell = row.createCell(1);
			cell.setCellValue("姓名");
			cell.setCellStyle(stylehead);
			cell = row.createCell(2);
			cell.setCellValue("打卡日期");
			cell.setCellStyle(stylehead);
			cell = row.createCell(3);
			cell.setCellValue("上班打卡时间");
			cell.setCellStyle(stylehead);
			cell = row.createCell(4);
			cell.setCellValue("上班打卡地址");
			cell.setCellStyle(stylehead);
			cell = row.createCell(5);
			cell.setCellValue("上班打卡状态");
			cell.setCellStyle(stylehead);
			cell = row.createCell(6);
			cell.setCellValue("下班打卡时间");
			cell.setCellStyle(stylehead);
			cell = row.createCell(7);
			cell.setCellValue("下班打卡地址");
			cell.setCellStyle(stylehead);
			cell = row.createCell(8);
			cell.setCellValue("下班打卡状态");
			cell.setCellStyle(stylehead);
			cell = row.createCell(9);
			cell.setCellValue("是否加班 ");
			cell.setCellStyle(stylehead);
			cell = row.createCell(10);
			cell.setCellValue("加班时长(分钟)");
			cell.setCellStyle(stylehead);
			cell = row.createCell(11);
			cell.setCellValue("工作时长(天)");
			cell.setCellStyle(stylehead);
			cell = row.createCell(12);
			cell.setCellValue("是否补卡");
			cell.setCellStyle(stylehead);
			cell = row.createCell(13);
			cell.setCellValue("补卡原因");
			cell.setCellStyle(stylehead);	
			cell = row.createCell(14);
			cell.setCellValue("迟到分钟");
			cell.setCellStyle(stylehead);
			// 从第三行开始循环
			int i = 0;
			
			boolean isColor=false;
			HSSFCellStyle style = wb.createCellStyle();
			//for (Map<String, Object> map : data) {
			for (int j =0;j<data.size();j++) {
				
				if (!isColor) {
					
					HSSFCellStyle style1 = wb.createCellStyle();
					style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
					style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
					style1.setFont(font);
					style1.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
					style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
					style1.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
					style1.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边
					style1.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE
							.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					
					style=style1;
					
				}else {
					HSSFCellStyle style2 = wb.createCellStyle();
					style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
					style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
					style2.setFont(font);
					style2.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
					style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
					style2.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
					style2.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边
					style=style2;
				}
				
				Map<String, Object> map = data.get(j);
				if(j!=data.size()-1){
					Map<String, Object> map2 = data.get(j+1);
					
					if (map.get("username").toString().trim().equals(map2.get("username").toString().trim())) {
						
						cell=creatRow(sheet, i, wb, font, row, style, cell, map);
					}else {
						cell=creatRow(sheet, i, wb, font, row, style, cell, map);
						i++;
						cell=total(sheet, i, row, style, cell, map,start_time,end_time);
						isColor=!isColor;
					}
				}else {
					cell=creatRow(sheet, i, wb, font, row, style, cell, map);
					i++;
					cell=total(sheet, i, row, style, cell, map, start_time, end_time);
					
					
				}
				i++;
			}
			sheet.setColumnWidth(0, 20 * 256);
			sheet.setColumnWidth(1, 20 * 256);
			sheet.setColumnWidth(2, 20 * 256);
			sheet.setColumnWidth(3, 20 * 256);
			sheet.setColumnWidth(4, 20 * 256);
			sheet.setColumnWidth(5, 20 * 256);
			sheet.setColumnWidth(6, 20 * 256);
			sheet.setColumnWidth(7, 20 * 256);
			sheet.setColumnWidth(8, 20 * 256);
			sheet.setColumnWidth(9, 20 * 256);
			sheet.setColumnWidth(10, 20 * 256);
			sheet.setColumnWidth(11, 20 * 256);
			sheet.setColumnWidth(12, 20 * 256);
			sheet.setColumnWidth(13, 20 * 256);
			sheet.setColumnWidth(14, 20 * 256);
			
			String filename = "打卡记录.xls";// 设置下载时客户端Excel的名称
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment;filename="
					+ java.net.URLEncoder.encode(filename, "UTF-8"));
			ous = new BufferedOutputStream(response.getOutputStream());

			wb.write(ous);
			ous.flush();
			System.gc();
		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常
			response.sendError(500, e.getMessage());
		} finally {
			if (ous != null) {
				ous.close();
			}

		}
	}
	
}
