package com.casd.serviceimpl.ownCenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.casd.dao.ownCenter.FieldPersonnelDao;
import com.casd.dao.uc.UserDao;
import com.casd.entity.activiti.DataProcinst;
import com.casd.entity.ownCenter.FieldPersonnel;
import com.casd.entity.uc.User;
import com.casd.service.hr.ActivitiService;
import com.casd.service.ownCenter.FieldPersonnelSevrice;

@Service
public class FieldPersonnelImpl implements FieldPersonnelSevrice {
	
	@Autowired
	private FieldPersonnelDao fpldDao;
	@Autowired
	private ActivitiService activitiService;
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private  UserDao userDao;
	@Autowired
	private  RuntimeService runtimeService;
	@Autowired
	private  ActivitiDao activitiDao;
	
	
	@Override
	public List<Map<String, Object>> findFieldpList(int page, int pageSize,
			Ref<Integer> record, String fields, String where) throws Exception {
	
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("fields", fields);
		param.put("where", where);

		if (record != null) {
			int count = fpldDao.getFPCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");

		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return fpldDao.findFieldpList(param);
	
	}


	@Override
	@Transactional
	public void addFieldPersonne(FieldPersonnel fieldPersonnel,String username) throws Exception {
		
		int biz=fieldPersonnel.getField_personnel_id();
		//添加
		if (biz==0) {
			
			fpldDao.addFieldPersonne(fieldPersonnel);		
		String processDefinitioKey = "findFieldpView"; // 定义流程的key,不可修改
		String userid=fieldPersonnel.getField_personnel_userid()+"";
		
		Map<String, Object> params=new HashMap<String, Object>();	
		String fields="b.role_name";
		StringBuffer sbf=new StringBuffer();
		sbf.append(" uc_user a JOIN uc_role b");
		sbf.append(" ON a.role_id=b.role_id");
		sbf.append(" WHERE a.userid="+userid);
		params.put("fields", fields);
		params.put("where", sbf.toString());
          Map<String, Object> data = userDao.queryUserById(params) ;
          
         String rolename=data.get("role_name")+"";  
         //流程参数map
			String bizId = processDefinitioKey + "."
					+ fieldPersonnel.getField_personnel_id(); //获取业务id
		  ProcessInstance pi= runtimeService.startProcessInstanceByKey(processDefinitioKey,bizId);
		  
		  DataProcinst dataProcinst=new  DataProcinst();
			dataProcinst.setProc_inst_id_(pi.getId());
			dataProcinst.setApplicant(username);
			dataProcinst.setIllustrate(fieldPersonnel.getField_personnel_place());
		    activitiDao.insertDataProcinst(dataProcinst);
		//编辑
		}else {
			fpldDao.updateFieldPsl(fieldPersonnel);	
		}
		
	}

     /**
      * 删除单据
      * */
	@Transactional
	public void deleteFieldPsl(String where) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("where", where);
		fpldDao.deleteFieldPsl(map);
	}

	

	@Override
	@Transactional
	public void updateFieldPslExt(DelegateExecution execution, String status) {
		String bizkey = execution.getProcessBusinessKey();
		String[] strs = bizkey.split("\\.");
		String bizId = null;
		for (int i = 0, len = strs.length; i < len; i++) {
			bizId = strs[i].toString();
		}
		FieldPersonnel fpl=new  FieldPersonnel();
		fpl.setField_personnel_status(Integer.parseInt(status));
		fpl.setField_personnel_id(Integer.parseInt(bizId));
		fpldDao.updateFieldPsl(fpl);
	}


	@Transactional
	public Map<String, Object> fieldPersonnelPass(HttpServletRequest request) {
		  String taskid=request.getParameter("taskid");
			taskService.complete(taskid);
		return null;
	}

	@Override
	@Transactional
	public void updateFieldPsl(FieldPersonnel fieldPersonnel) {
		fpldDao.updateFieldPsl(fieldPersonnel);
	}
	
	//流程定义类方法
	  public  String fieldPslNextUser(DelegateExecution execution) {
		  HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String nextUser = request.getParameter("userid");// 下一个审核人	
			return nextUser;		
		
	    }


}
