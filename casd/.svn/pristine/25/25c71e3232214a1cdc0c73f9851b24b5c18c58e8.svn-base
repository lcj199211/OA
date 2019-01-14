package com.casd.serviceimpl.ownCenter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.casd.controller.web.Ref;
import com.casd.dao.activiti.ActivitiDao;
import com.casd.dao.ownCenter.OwnHeadDao;
import com.casd.entity.activiti.DataProcinst;
import com.casd.entity.ownCenter.OwnPurchaseEntry;
import com.casd.entity.ownCenter.OwnPurchaseHead;
import com.casd.entity.uc.User;
import com.casd.service.hr.ActivitiService;
import com.casd.service.ownCenter.OwnHeadService;

@Service
public class OwnHeadServiceImpl implements OwnHeadService {

	@Autowired
	private OwnHeadDao ownHeadDao;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private ActivitiService activitiService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private  ActivitiDao activitiDao;
	@Override
	public List<Map<String, Object>> ownHeadlist(int page, int pageSize,
			Ref<Integer> record, String fields, String where) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("fields", fields);
		param.put("where", where);

		if (record != null) {
			int count = ownHeadDao.getCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));
		return ownHeadDao.ownHeadlist(param);
	}

	@Override
	@Transactional
	public void saveOwnHead(OwnPurchaseHead ownHead, HttpServletRequest request) {

		ownHeadDao.saveOwnHead(ownHead);
		JSONArray jsonArray = JSONArray
				.fromObject(request.getParameter("rows"));
		int purchase_id = ownHead.getOwn_purchase_id();
		List<OwnPurchaseEntry> listDetail = (List) JSONArray.toCollection(
				jsonArray, OwnPurchaseEntry.class);
		for (int i = 0; i < listDetail.size(); i++) {
			OwnPurchaseEntry entry = listDetail.get(i);
			entry.setOwn_purchase_parentId(purchase_id);
			ownHeadDao.saveOwnEntry(entry);
		}
		User user = (User) request.getSession().getAttribute("loginUser");
		String userid = user.getUserid() + "";
		String fields = " ro.role_name ";
		String where = " uc_user uc JOIN uc_role ro ON uc.role_id=ro.role_id";
		where += " where uc.userid=" + userid;
		Map<String, Object> roledata = this.findOwnHead(fields, where);
		String rolename = roledata.get("role_name") + "";

		Map<String, Object> vars = new HashMap<String, Object>();
		String type = ownHead.getOwn_purchase_type() + "";
		if (rolename.indexOf("经理") != -1 || rolename.indexOf("助理") != -1) {
			if (rolename.indexOf("总经理") != -1 || rolename.indexOf("助理") != -1) {
				vars.put("type", "1");// 去采购中心
			} else if (type.equals("1") && rolename.indexOf("经理") != -1) {
				vars.put("type", "2");// 去主管公司总经理
			} else if (type.equals("2") && rolename.indexOf("经理") != -1) {
				vars.put("type", "3");// 去经营部
			}
		} else {

			if (type.equals("1")) {
				vars.put("type", "4");
			} else if (type.equals("2")) {
				vars.put("type", "3");
			}
		}
		vars.put("username",userid);
		String processDefinitioKey = "ownHeadView"; // 定义流程的key,不可修改
		String bizId = processDefinitioKey + "." + purchase_id; // 获取业务id
	ProcessInstance pi=runtimeService.startProcessInstanceByKey(processDefinitioKey, bizId,vars);
	
	   DataProcinst dataProcinst=new  DataProcinst();
		dataProcinst.setProc_inst_id_(pi.getId());
		dataProcinst.setApplicant(user.getUsername());
		dataProcinst.setIllustrate("单据编号/"+ownHead.getOwn_purchase_id());
	    activitiDao.insertDataProcinst(dataProcinst);

	}

	@Override
	public Map<String, Object> findOwnHead(String fields, String where) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fields", fields);
		map.put("where", where);
		return ownHeadDao.findOwnHead(map);
	}

	@Override
	public List<Map<String, Object>> findOwnEntry(String fields, String where) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fields", fields);
		map.put("where", where);

		return ownHeadDao.findOwnEntry(map);
	}

	@Override
	@Transactional
	public Map<String, Object> ownHeadPass(OwnPurchaseHead head,
			HttpServletRequest request) {
		String taskid = request.getParameter("taskid");
		String taskName = request.getParameter("taskName");
		String sign = request.getParameter("sign");
		String options = request.getParameter("options");
		User user = (User) request.getSession().getAttribute("loginUser");// 当前办理人
		String userid = user.getUserid() + ""; // 当前审核人
		String nextUser = request.getParameter("username");// 下一个审核人

		Map<String, Object> vars = new HashMap<String, Object>();// 流程参数

		if (taskName.equals("申请人")) {
			String fields = " ro.role_name ";
			String where = " uc_user uc JOIN uc_role ro ON uc.role_id=ro.role_id";
			where += " where uc.userid=" + user.getUserid();
			Map<String, Object> roledata = this.findOwnHead(fields, where);
			String rolename = roledata.get("role_name") + "";
			String type = head.getOwn_purchase_type() + "";
			if (rolename.indexOf("经理") != -1 || rolename.indexOf("助理") != -1) {
				if (rolename.indexOf("总经理") != -1
						|| rolename.indexOf("助理") != -1) {
					vars.put("type", "1");// 去采购中心
				} else if (type.equals("1") && rolename.indexOf("经理") != -1) {
					vars.put("type", "2");// 去主管公司总经理
				} else if (type.equals("2") && rolename.indexOf("经理") != -1) {
					vars.put("type", "3");// 去经营部
				}
			} else {
				if (type.equals("1")) {
					vars.put("type", "4");
				} else if (type.equals("2")) {
					vars.put("type", "3");
				}
			}

			ownHeadDao.updateOwnHead(head);
			JSONArray jsonArray = JSONArray.fromObject(request
					.getParameter("rows"));
			int purchase_id = head.getOwn_purchase_id();
		
			List<OwnPurchaseEntry> listDetail = (List) JSONArray.toCollection(
					jsonArray, OwnPurchaseEntry.class);
			for (int i = 0; i < listDetail.size(); i++) {
				OwnPurchaseEntry entry = listDetail.get(i);
				entry.setOwn_purchase_parentId(purchase_id);
				int entryId= entry.getOwn_purchase_entryId();
				if(entryId==0){
					ownHeadDao.saveOwnEntry(entry);
				}else {
				    ownHeadDao.updateOwnEntry(entry);
				}
			}
		} else if (taskName.equals("主管公司总经理")) {
			vars.put("cgzx", nextUser);
		}else if(taskName.equals("采购输出")){
			head.setOwn_purchase_status(1);
			ownHeadDao.updateOwnHead(head);
		}
		if (sign.equals("true")) {

			if (!taskName.equals("申请人")) {
				vars.put("type", "5");
			}

		} else {
			head.setOwn_purchase_status(2);
			ownHeadDao.updateOwnHead(head);
			vars.put("type", "6");
		}
	
		   activitiService.comment(taskid,userid,options);
           taskService.complete(taskid,vars);
           //获取回退人员
           String nextuserid= activitiService.getIdentityTask(taskid);
           
   		String content="采购单号："+head.getOwn_purchase_id(); //请假内容
   		       content+="<br>申请人："+head.getOwn_purchase_planMan();
   		       content+="<br>公司名称："+request.getParameter("companyName");
   		       content+="<br>建单时间："+new Date();
		    String theme="普通采购!"; //邮件标题
		   
       try {
		 activitiService.sendEmail(theme, content, nextuserid);
	} catch (Exception e) {
		e.printStackTrace();
	 }
		return null;
	}
    @Transactional
	public void deleteEntry(String where) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("where", where);
		ownHeadDao.deleteEntry(map);

	}
    
	//流程定义类方法
    public  String  ownHeaNextUser(DelegateExecution execution) {
  	  HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
  		String nextUser = request.getParameter("username");// 下一个审核人	
  		return nextUser;		
  	
      }
   
}
