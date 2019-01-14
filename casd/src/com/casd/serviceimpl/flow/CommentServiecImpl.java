package com.casd.serviceimpl.flow;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casd.dao.flow.CommenDao;
import com.casd.entity.flow.Comment;
import com.casd.entity.uc.User;
import com.casd.service.flow.CommentServiec;
import com.casd.service.hr.ActivitiService;


@Service
public class CommentServiecImpl implements CommentServiec{
	@Autowired
	private ActivitiService  activitiService;
	@Autowired
	private CommenDao  commenDao;

  /****
   *  自定义添加审核记录
   * 
   * 
   * ***/
	@Transactional
	public int updateComment(HttpServletRequest request) {
		  String taskId=request.getParameter("taskid");
		  String bizkey=request.getParameter("bizId");
		  User user=(User) request.getSession().getAttribute("loginUser");//当前办理人
		  String userid=user.getUserid()+"";
	
		String taskName=request.getParameter("taskName");
		String nextUser=request.getParameter("username");//下一个审核人
		String options=request.getParameter("options");//获取审核意见
	
		org.activiti.engine.task.Comment comment=activitiService.comment(taskId, userid, options);
		
	/*	
		Comment comment2=new Comment();
		comment2.setID_(comment.getId());
		
		commenDao.updateComment(comment2);
		*/
		
	/*	// 使用任务id,获取任务对象，获取流程实例id
		Task task=taskService.createTaskQuery().taskId(taskId).singleResult();
		//利用任务对象，获取流程实例id
		String processInstancesId=task.getProcessInstanceId();

		System.out.println(processInstancesId);

		Authentication.setAuthenticatedUserId("cmc"); // 添加批注时候的审核人，通常应该从session获取

		taskService.addComment(taskId,processInstancesId,"尝试添加批注");*/
		
		
		
		
		return 0;
	}
	
  

	
}
