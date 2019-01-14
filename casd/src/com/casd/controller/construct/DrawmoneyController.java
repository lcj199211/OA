package com.casd.controller.construct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.construct.Drawmoney;
import com.casd.entity.uc.User;
import com.casd.service.construct.DrawmoneyService;
import com.casd.service.hr.ActivitiService;
import com.casd.service.manage.SupOpinionService;
import com.casd.service.uc.UserService;

@Controller
@RequestMapping("/admin")
public class DrawmoneyController {
	
	@Autowired
	private DrawmoneyService  drawmoneyService;
	
	@Autowired
	private  UserService userService;
	
	@Autowired
	private SupOpinionService supOpinionService;
	
	@Autowired
	private  RuntimeService runtimeService;
	
	@Autowired
	private ActivitiService activitiService;
	
	@Autowired
	private TaskService taskService;
	
	
	@RequestMapping(value = "/drawmoneyList", method = RequestMethod.GET)
	public  String drawmoneyList() {
		
		return "drawmoney/drawmoneyList";

	}

	@RequestMapping(value = "/drawmoneyList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> drawmoneyList(HttpServletRequest request) throws Exception {
		Ref<Integer> record = new Ref<Integer>();

		StringBuilder sbf = new StringBuilder();// 拼接sql
         String bizid=request.getParameter("bizid");
		StringBuilder fields = new StringBuilder();// 需要显示字段
		fields.append(" a.*,b.construct_project_name");

		Map<String, Object> json = new HashMap<String, Object>();
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		sbf.append(" construct_drawmoney a");
		sbf.append(" JOIN construct_project_table b on a.construct_project_id=b.construct_project_id");
	    sbf.append(" WHERE a.construct_project_id="+bizid);
	
		List<Map<String, Object>> data = userService.userList(pageIndex,
				pageSize, record, sbf.toString(), fields.toString());
		json.put("rows", data);
		json.put("total", record.getValue());
		return json;
		
	

	}
	
	
	@RequestMapping(value = "/drawmoneyView", method = RequestMethod.GET)
	public ModelAndView drawmoneyView(HttpServletRequest request) throws Exception {
		ModelAndView mv=new ModelAndView();
		Map<String, Object> dataMap=new HashMap<String, Object>();
		String type=request.getParameter("type");
		String where = "";
		String  bizid;
		String fields2;
		if (type.equals("save")) {
		     bizid=request.getParameter("bizid");
			User loginUser = (User) request.getSession().getAttribute("loginUser");
			String fields = "b.role_name";
			StringBuffer sbf = new StringBuffer();
			sbf.append("uc_user a JOIN uc_role b ON a.role_id=b.role_id");
			sbf.append(" where a.userid=" + loginUser.getUserid());
			Map<String, Object> userMap= userService.queryUserById(fields,
					sbf.toString());
			String rolename= userMap.get("role_name")+"";
			List<Map<String, Object>>  userList=null;
			if (rolename.indexOf("总经理")!=-1 ||rolename.indexOf("董事长助理")!=-1) {
				userList = supOpinionService.supOpinionUser(
						"总经理级别", "drawmoneyView"); //查询审核人
			}else {
				userList = supOpinionService.supOpinionUser("普通职员", "drawmoneyView"); //查询审核人
			}
			 fields2 = "project.construct_project_id,project.construct_project_name";
			 where="construct_project_table project WHERE project.construct_project_id="+bizid;
			 dataMap=userService.queryUserById(fields2,where) ;
			mv.addObject("userList", userList);
		}else {
			fields2 ="draw.*,project.construct_project_name";
			bizid=request.getParameter("bizid");
			where+=" construct_drawmoney draw";
			where+=" JOIN construct_project_table project on draw.construct_project_id=project.construct_project_id";
			where+=" WHERE draw.construct_draw_id="+bizid;
			dataMap=userService.queryUserById(fields2,where) ;
		}
	    mv.addAllObjects(dataMap);
		mv.setViewName("drawmoney/drawmoneyView");
		return mv;
		
	}
	@RequestMapping(value = "/savedrawmoney", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> savedrawmoney(Drawmoney draw,HttpServletRequest request) throws Exception {
		
		Map<String, Object> json=new HashMap<String, Object>();
		try {

		 draw.setConstruct_draw_status(0);
	     drawmoneyService.savaDrawmoney(draw);
		Map<String, Object> vars=new HashMap<String, Object>();
		vars.put("title", "领款申请"); // 任务类型
		String processDefinitioKey = "drawmoneyView"; // 定义流程的key,不可修改
		String bizId = processDefinitioKey + "."
				+ draw.getConstruct_draw_id(); //获取业务id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String fields = "b.role_name";
		StringBuffer sbf = new StringBuffer();
		String userid=loginUser.getUserid()+"";
		sbf.append("uc_user a JOIN uc_role b ON a.role_id=b.role_id");
		sbf.append(" where a.userid=" + userid);
		Map<String, Object> userMap= userService.queryUserById(fields,
				sbf.toString());
		String rolename= userMap.get("role_name")+"";
		
		if ((rolename.indexOf("总经理")!=-1) ||(rolename.indexOf("董事长助理")!=-1)) {
		     vars.put("sign", true);
		}else {
			vars.put("sign", false);
		}
          vars.put("username",userid);
           runtimeService.startProcessInstanceByKey(
			processDefinitioKey, bizId, vars);
          
			json.put("Success", true);
			json.put("Msg", "保存成功！");
		} catch (Exception e) {
			json.put("Msg", "保存失败,请联系技术员！");
			json.put("Success", false);
				
		}
			return json;
	 
	}
	
	@RequestMapping(value = "/drawmoneyAudit", method = RequestMethod.GET)
	public ModelAndView  drawmoneyAudit(String taskid,String taskName,HttpServletRequest request) throws Exception {
		ModelAndView mv=new ModelAndView();
		
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String bizkey = activitiService.getBusinessBizId(taskid);// 获取业务编号
		String[] strs = bizkey.split("\\.");
		String bizId = null; // 业务编号
		for (int i = 0, len = strs.length; i < len; i++) {
			bizId = strs[i].toString();
		}
		List<Map<String, Object>>  userList=null;
		if (taskName.equals("重新调整")) {
			String fields = "b.role_name";
			StringBuffer sbf = new StringBuffer();
			sbf.append("uc_user a JOIN uc_role b ON a.role_id=b.role_id");
			sbf.append(" where a.userid=" + loginUser.getUserid());
			Map<String, Object> userMap= userService.queryUserById(fields,
					sbf.toString());
			String rolename= userMap.get("role_name")+"";
		
			if (rolename.indexOf("总经理")!=-1 ||rolename.indexOf("董事长助理")!=-1) {
				userList = supOpinionService.supOpinionUser("总经理级别", "drawmoneyView"); //查询审核人
			}else {
				userList = supOpinionService.supOpinionUser("普通职员","drawmoneyView"); //查询审核人
			}
		}else{
			userList = supOpinionService.supOpinionUser(taskName, "drawmoneyView"); //查询审核人
		} 
		String fields ="draw.*,project.construct_project_name";
		String where=" construct_drawmoney draw JOIN construct_project_table project";
		       where+="  on draw.construct_project_id=project.construct_project_id where draw.construct_draw_id="+bizId;
		Map<String, Object> drawData= userService.queryUserById(fields,where);
		mv.addAllObjects(drawData);
        mv.addObject("userList", userList);
        mv.addObject("taskid", taskid);
        mv.addObject("taskName", taskName);

	    mv.setViewName("drawmoney/drawmoneyAudit");
		return mv;	
	  }
	
	@RequestMapping(value = "/drawmoneyPass", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> drawmoneyPass(Drawmoney draw,HttpServletRequest request) throws Exception{
		  Map<String, Object> json=new HashMap<String, Object>();
		try {
			
		
		String taskid=request.getParameter("taskid");
		String taskName=request.getParameter("taskName");
		int bizId=Integer.parseInt(request.getParameter("bizId"));
		
		User user=(User) request.getSession().getAttribute("loginUser");//当前办理人
	    String userid=user.getUserid()+"";  //当前审核人id
	    Map<String, Object> vars=new HashMap<String, Object>();
	    
	    String sign=request.getParameter("sign");
	     Drawmoney draw2=new Drawmoney();
	   
	    if (sign.equals("true")) {
			if (taskName.equals("重新调整")) {
				User loginUser = (User) request.getSession().getAttribute("loginUser");
		    	String fields = "b.role_name";
				StringBuffer sbf = new StringBuffer();
				sbf.append("uc_user a JOIN uc_role b ON a.role_id=b.role_id");
				sbf.append(" where a.userid=" + loginUser.getUserid());
				Map<String, Object> userMap= userService.queryUserById(fields,
						sbf.toString());
				String rolename= userMap.get("role_name")+"";
				
				if ((rolename.indexOf("总经理")!=-1) ||(rolename.indexOf("董事长助理")!=-1)) {
				     vars.put("sign", true);
				}else {
					vars.put("sign", false);
				}
				draw.setConstruct_draw_id(bizId);	
				drawmoneyService.updateDrawmoney(draw);
			}else if (taskName.equals("科技公司意见")) {
				  vars.put("sign", true);
				draw2.setConstruct_draw_id(bizId);
				draw2.setConstruct_draw_fopinion(draw.getConstruct_draw_fopinion());
				drawmoneyService.updateDrawmoney(draw2);
			}else if (taskName.equals("财务中心意见")) {
				  vars.put("sign", true);
				draw2.setConstruct_draw_id(bizId);
				draw2.setConstruct_draw_copinion(draw.getConstruct_draw_copinion());
				drawmoneyService.updateDrawmoney(draw2);
			}else if (taskName.equals("董事长意见")) {
				  vars.put("sign", true);
				draw2.setConstruct_draw_id(bizId);
				draw2.setConstruct_draw_zopinion(draw.getConstruct_draw_zopinion());
				draw2.setConstruct_draw_status(2);
				drawmoneyService.updateDrawmoney(draw2);
			}
	    	
		}else {
			
			if (taskName.equals("科技公司意见")) {
				 
				draw2.setConstruct_draw_id(bizId);
				draw2.setConstruct_draw_fopinion(draw.getConstruct_draw_fopinion());
				drawmoneyService.updateDrawmoney(draw2);
			}else if (taskName.equals("财务中心意见")) {
				
				draw2.setConstruct_draw_id(bizId);
				draw2.setConstruct_draw_fopinion(draw.getConstruct_draw_copinion());
				drawmoneyService.updateDrawmoney(draw2);
			}else if (taskName.equals("董事长意见")) {
				
				draw2.setConstruct_draw_id(bizId);
				draw2.setConstruct_draw_zopinion(draw.getConstruct_draw_zopinion());
				draw2.setConstruct_draw_status(2);
				drawmoneyService.updateDrawmoney(draw2);
			}
			 vars.put("sign", false);
		}
		
		taskService.complete(taskid,vars);
		  
		json.put("Success", true);
		json.put("Msg", "已审核！");
	  } catch (Exception e) {
		json.put("Msg", "操作失败,请联系技术员！");
		json.put("Success", false);			
	 }
		return json;
		
	}
	
	/**
	 *  删除领款单
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/deleteDrawmoney", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteDrawmoney(String bizid) throws Exception {
		Map<String, Object> json=new HashMap<String, Object>();
		try {
			
	
		String fields=" from construct_drawmoney";
		String where=" where construct_draw_id="+bizid;
		
		userService.deleteUser(fields, where);
		
		String beyId ="drawmoneyView";
		activitiService.deleteRecord(bizid, beyId);
		  
			json.put("Success", true);
			json.put("Msg", "已删除！");
		  } catch (Exception e) {
			json.put("Msg", "操作失败,请联系技术员！");
			json.put("Success", false);			
		 }
			return json;
		
	}

}
