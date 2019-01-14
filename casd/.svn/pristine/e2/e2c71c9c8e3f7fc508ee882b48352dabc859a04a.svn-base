package com.casd.serviceimpl.uc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.casd.controller.web.Ref;
import com.casd.dao.uc.CostappDao;
import com.casd.dao.uc.UserDao;
import com.casd.entity.uc.Costapp;
import com.casd.entity.uc.User;
import com.casd.service.hr.ActivitiService;
import com.casd.service.uc.CostappService;


@Service
public class CostappServiceImpl implements CostappService {
	@Autowired
	private CostappDao costappDao;
	
	@Autowired
	private ActivitiService activitiService;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private TaskService  taskService;

	@Override
	public List<Map<String, Object>> costappList(int page, int pageSize,
			Ref<Integer> record, String fields, String where) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fields", fields);
		param.put("where", where);

		if (record != null) {
			Integer count = costappDao.getCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

			param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
					* pageSize, pageSize));
		return costappDao.getList(param);
	}


	
	
     @Transactional
	public void delete_data(Map<String, Object> map) {
	
    	 costappDao.delete_data(map);
	}


	@Override
	public void save_costapp(Costapp costapp)  {
		
		costappDao.save_costapp(costapp);
	    }


	@Override
	public List<Map<String, Object>> getData(Map<String, Object> map) {
		Map<String, Object> daoMap=new HashMap<String, Object>();
		daoMap.put("fields", "*");
		daoMap.put("where", " uc_costapp where costapp_id="+map.get("costapp_id")+"");
		return costappDao.getData(daoMap);
	}




	@Transactional
	public void costappDelegate(DelegateExecution execution, String status) {
	String bizkey= execution.getProcessBusinessKey();
		
		String[] strs=bizkey.split("\\.");
        String bizId=null;
		for(int i=0,len=strs.length;i<len;i++){
			bizId=strs[i].toString();
		}
		Costapp costapp=new Costapp();
		costapp.setCostapp_id(Integer.valueOf(bizId));
		costapp.setCostapp_status(Integer.valueOf(status));
		costappDao.updateCostapp(costapp);
		
	}




	@Override
	public Map<String, Object> findCostapp(String fields, String where) {
		Map<String,Object> param=new  HashMap<String, Object>();
		param.put("fields", fields);
		param.put("where", where);
		return costappDao.findCostapp(param);
	}



     /***
      *  费用申请审核
      *  
      * */
	@Override
	@Transactional
	public void pass_costapp(HttpServletRequest request, Costapp costapp,Map<String, Object> map) {
		String taskid=request.getParameter("taskid");
		String taskName=request.getParameter("taskName");
		
		User user=(User) request.getSession().getAttribute("loginUser");//当前办理人
	    String userid=user.getUserid()+"";  //当前审核人id
		Map<String, Object> vars=new HashMap<String, Object>();
		if (taskName.equals("申请人")){
			vars.put("sign","true");
		
		Map<String, Object> params=new HashMap<String, Object>();	
		String fields="b.role_name";
			StringBuffer sbf=new StringBuffer();
			sbf.append(" uc_user a JOIN uc_role b");
			sbf.append(" ON a.role_id=b.role_id");
			sbf.append(" WHERE a.userid="+userid);
			params.put("fields", fields);
			params.put("where", sbf.toString());
	    Map<String, Object> data =userDao.queryUserById(params);
	    String rolename=data.get("role_name").toString();
	   if (rolename.indexOf("经理") != -1 || rolename.indexOf("助理") != -1) {
		   //总经理级别的职员
		  if ((rolename.indexOf("总经理") != -1) || (rolename.indexOf("助理") != -1)){			   
			   vars.put("place", "1");
		  //经理级别的职员
		   }else {
			   vars.put("place", "2");
	     	}
		  //如果不是经理级别的职员
	    }else {
	    	  vars.put("place","3");
	    	
		}
	     
		}
		//更新 费用申请表
		//costappDao.updateCostapp(costapp);
		if (!taskName.equals("申请人")&&!taskName.equals("管理公司")){
			costappDao.updateAuditor(map);
		}

		//完成任务
		taskService.complete(taskid,vars);	
		
	}

	//流程定义类方法
	  public  String costappNextUser(DelegateExecution execution) {
		  HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String nextUser = request.getParameter("username");// 下一个审核人	
			return nextUser;		
		
	    }


	}


	





     
   


