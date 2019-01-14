package com.casd.serviceimpl.hr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.casd.dao.hr.ResignDao;
import com.casd.entity.hr.Resign;
import com.casd.entity.uc.User;
import com.casd.service.hr.ActivitiService;
import com.casd.service.hr.ResignService;

@Service
public class ResignServiceImpl implements ResignService {
	@Autowired
	private ResignDao resignDao;
	
	@Autowired
	private ActivitiService activitiService;
	@Autowired
	private TaskService taskService;
	

	@Override
	@Transactional
	public void addResign(Resign ressign) {
		// TODO Auto-generated method stub
		resignDao.addResign(ressign);
	}

	@Override
	public List<Resign> getData(String fields, String where) {
		// TODO Auto-generated method stub
		Map<String , Object>param=new HashMap<String, Object>();
		param.put("fields",fields );
		param.put("where", where);
		return resignDao.getData(param);
		
	}

	@Override
	public void addAutoPath(String path,String resignId) {
		
		Map<String , Object>param=new HashMap<String, Object>();
		param.put("where", "hr_resign_autoPath = '"+path+"'  WHERE hr_resign_id = "+resignId+"");
		resignDao.addAutoPath(param);
		
	}

	@Override
	public Resign findResign(String fields, String where) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("fields", fields);
		map.put("where", where);
		
		return resignDao.findResign(map);
	}
    
	
	
	
	@Override
	@Transactional
	public void passResign(HttpServletRequest request, Resign ressign) throws Exception {
		Map<String, Object> vars=new HashMap<String, Object>();
		
	
		String taskid=request.getParameter("taskid");
		String taskName=request.getParameter("taskName");
		String options=request.getParameter("options");//获取审核意见
		
		String nextUser=request.getParameter("username"); //下一个人审核人
		 User user=(User) request.getSession().getAttribute("loginUser");//当前办理人
		  String userid=user.getUserid()+"";  //当前审核人id
		  
		 if (StringUtils.isNotBlank(options)) {
			 
		  activitiService.comment(taskid,userid,options);

		 } 
		 if (taskName.equals("申请人")) {
			  vars.put("bmjl", nextUser);

		   }
		 
		vars.put("sign","true");
		taskService.complete(taskid,vars);	
		resignDao.updateResign(ressign);
		String theme ="离职申请";
		String content="你有一张离职申请单需要审核";
		//activitiService.sendEmail(theme, content, nextUser);
	}
	//流程定义类方法
	  public  String resignNextUser(DelegateExecution execution) {
		  HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String nextUser = request.getParameter("username");// 下一个审核人	
			return nextUser;		
		
	    }
}
