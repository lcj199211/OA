package com.casd.serviceimpl.manage;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.controller.web.Ref;
import com.casd.dao.activiti.ActivitiDao;
import com.casd.dao.flow.FlowDao;
import com.casd.dao.manage.SupOpinionDao;
import com.casd.dao.uc.UserDao;
import com.casd.entity.activiti.DataProcinst;
import com.casd.entity.manage.SupOpinion;
import com.casd.entity.uc.User;
import com.casd.service.hr.ActivitiService;
import com.casd.service.manage.SupOpinionService;

@Service
public class SupOpinionServiceImpl implements SupOpinionService {
	@Autowired
	private SupOpinionDao supOpinionDao;
	
	@Autowired
	private FlowDao  flowDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ActivitiService activitiService;
	
	@Autowired
	private TaskService  taskService;
	@Autowired
	private  ActivitiDao activitiDao;

	@Override
	public List<Map<String, Object>> supOpinionList(int page,
			int pageSize, Ref<Integer> record, String fields, String where) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fields", fields);
		param.put("where", where);

		if (record != null) {
			Integer count = supOpinionDao.getCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return supOpinionDao.getList(param);
	}

	@Override
	@Transactional
	public void save_supOpinion(SupOpinion supOpinion,String userid,String username) throws Exception {
		
		supOpinionDao.save_supOpinion(supOpinion);
		String processDefinitioKey = "supOpinionView"; // 定义流程的key,不可修改
		String bizId = processDefinitioKey + "."
				+ supOpinion.getSupOpinion_id(); // 获取业务id
	ProcessInstance	pi=activitiService.startProcesses(bizId, userid, processDefinitioKey,null);
	    DataProcinst dataProcinst=new  DataProcinst();
		dataProcinst.setProc_inst_id_(pi.getId());
		dataProcinst.setApplicant(username);
		dataProcinst.setIllustrate(supOpinion.getSupOpinion_company());
	    activitiDao.insertDataProcinst(dataProcinst);
	     }

	@Override
	public List<Map<String, Object>> getData(Map<String, Object> map) {
	
		Map<String, Object> daoMap=new HashMap<String, Object>();
		daoMap.put("fields", "*");
		daoMap.put("where", " manage_supopinion where supOpinion_id="+map.get("supOpinion_id")+"");
		return supOpinionDao.getData(daoMap);
	}

	@Override
	public void delete_data(Map<String, Object> map) {
		
		supOpinionDao.delete_data(map);
	}

public List<Map<String, Object>> supOpinionUser(String taskName,String description){
	
	Map<String, Object> map = new HashMap<String, Object>();
	StringBuffer sbf = new StringBuffer();
	String fields = "c.flow_node_auditors";
	sbf.append("flow_table b JOIN flow_node_table c on b.flow_id=c.flow_node_parentID");
	sbf.append(" WHERE  b.flow_description='"+description
			+ "' AND c.flow_node_name='" + taskName + "'");
	map.put("fields", fields);
	map.put("where", sbf);
	String name = flowDao.newlis(map);
	map.clear();
	sbf.delete(0, sbf.length());
	String nameString = " a.userid,a.username";
	sbf.append("uc_user a WHERE a.userid in(" + name + ")");
	map.put("fields", nameString);
	map.put("where", sbf.toString());
	return userDao.queryId(map);
	
}
	@Transactional
    public void sava_opinionAut(HttpServletRequest request) throws IOException {
		
		Map<String, Object> vars=new HashMap<String, Object>();
		SupOpinion supOpinion=new SupOpinion();
		 String taskid=request.getParameter("taskid");
		 String taskName=request.getParameter("taskName");
		
		
		int supOpinion_id=Integer.parseInt(request.getParameter("supOpinion_id"));
		supOpinion.setSupOpinion_id(supOpinion_id);
		supOpinion.setSupOpinion_company(request.getParameter("supOpinion_company"));
		supOpinion.setSupOpinion_supProblem(request.getParameter("supOpinion_supProblem"));
		supOpinion.setSupOpinion_supPropose(request.getParameter("supOpinion_supPropose"));
		supOpinion.setSupOpinion_praiOrPun(request.getParameter("supOpinion_praiOrPun"));
		supOpinion.setSupOpinion_selfEva(request.getParameter("supOpinion_selfEva"));
		supOpinion.setSupOpinion_result(request.getParameter("supOpinion_result"));
		supOpinion.setSupOpinion_title(request.getParameter("supOpinion_title"));
	
         String date2= request.getParameter("supOpinion_creatDate");
         String str = date2;  
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
         java.util.Date d = null;  
       
             try {
				d = format.parse(str);
			} catch (ParseException e) {
			
				e.printStackTrace();
			}  
    
         java.sql.Date date = new java.sql.Date(d.getTime()); 
      
		supOpinion.setSupOpinion_creatDate(date);

	

    if (taskName.equals("提交申请")) {
   	 Map<String, Object> map=new HashMap<String, Object>();
    	String  fields="a.username"; 
    	String  where="uc_user a JOIN uc_role b on a.role_id=b.role_id WHERE b.role_name='监察中心经理'"; 
    	map.put("fields", fields);
    	map.put("where", where);
        Map<String, Object> userlist=userDao.queryUserById(map);
        String nextUser=userlist.get("username").toString();
			vars.put("department", nextUser);		
			supOpinionDao.save_supOpinion(supOpinion);
			taskService.complete(taskid,vars);
	}else{
			supOpinionDao.save_supOpinion(supOpinion); 	
			taskService.complete(taskid,vars);
		
	}
    
	
}

}
