package com.casd.serviceimpl.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.casd.controller.web.Ref;
import com.casd.dao.activiti.ActivitiDao;
import com.casd.dao.manage.ContractDao;
import com.casd.entity.activiti.DataProcinst;
import com.casd.entity.manage.Contract;
import com.casd.entity.manage.Reqfunds;
import com.casd.entity.uc.User;
import com.casd.service.hr.ActivitiService;
import com.casd.service.manage.ContractService;

@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	private ContractDao contractDao;
	@Autowired
	private TaskService taskService;
	@Autowired
	private  ActivitiService activitiService;
	
	@Autowired
	private  ActivitiDao activitiDao;
	@Override
	@Transactional
	public List<Map<String, Object>> contractList(int page, int pageSize,
			Ref<Integer> record, String fields, String where) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fields", fields);
		param.put("where", where);

		if (record != null) {
			Integer count = contractDao.getCount(param);
			record.setValue(count);
		}
		// 分页
		if (pageSize <= 0)
			throw new Exception("pageSize 必须 > 0");
		param.put("limit", String.format("limit %1$s,%2$s", page < 0 ? 0 : page
				* pageSize, pageSize));

		return contractDao.getList(param);
		
	}

	@Override
	@Transactional
	public void saveContract(Contract contract,JSONArray reqfundsJson) {
		int manage_contract_id = contract.getManage_contract_id();
		/*int manage_contract_company = contract.getManage_contract_company();
		Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        String numsString="";
        String num="";
        Map<String, Object> map=new HashMap<String, Object>();*/
		if (manage_contract_id==0) {
			/*switch (manage_contract_company) {
				case 1:
					numsString="JS"+year;
					break;
				case 2:
					numsString="KJ"+year;
					break;
				case 3:
					numsString="JM"+year;
					break;	
				default:
					break;
			}
			String fields ="MAX(manage_contract_num) manage_contract_num";
			StringBuffer sBuffer=new StringBuffer();
			sBuffer.append(" manage_contract  where manage_contract_num LIKE '%"+numsString+"%' ");
			map.put("fields", fields);
			map.put("where", sBuffer);
			Map<String, Object> manage_contract_num = contractDao.getContract(map);
			if(manage_contract_num==null){
				num=numsString+"001";
			}else {
				int lastnum = Integer.valueOf(manage_contract_num.get("manage_contract_num").toString().substring(6))+1;
				if (lastnum<10) {
					num=numsString+"00"+lastnum;
				}else if(9<lastnum&&lastnum<100) {
					num=numsString+"0"+lastnum;
				}else {
					num=numsString+lastnum;
				}
			}
			contract.setManage_contract_num(num);*/
			contractDao.saveContract(contract);
			manage_contract_id=contract.getManage_contract_id();
		}else {
			contractDao.saveContract(contract);
		}
		 List<Reqfunds> listDetail=(List)JSONArray.toCollection(reqfundsJson, Reqfunds.class);
	   for (int i = 0; i < listDetail.size(); i++) {
		
		   Reqfunds reqfunds= listDetail.get(i);		
		   reqfunds.setManage_reqfunds_contractId(manage_contract_id);
			contractDao.saveReqfunds(reqfunds);
	   }
	}
	

	@Override
	@Transactional
	public List<Map<String, Object>> contractData(String fields,String where) {
		// TODO Auto-generated method stub
		/*Map<String, Object> map=new HashMap<String, Object>();
		Map<String, List<Map<String, Object>>> dataMap=new HashMap<String, List<Map<String,Object>>>();
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		String fieds ="*";
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append(" manage_contract  where manage_contract_id="+manage_contract_id+" ");
		map.put("fields", fieds);
		map.put("where", sBuffer);
		list.add(contractDao.getContract(map));
		dataMap.put("contract", list);
		sBuffer.delete(0, sBuffer.length()-1);
		sBuffer.append(" manage_reqfunds where manage_reqfunds_contractId="+manage_contract_id+" ");
		map.put("where", sBuffer);
		dataMap.put("rows", contractDao.getReqfunds(map));*/
		Map<String, Object> map=new HashMap<String, Object>();
		 map.put("fields", fields);
		 map.put("where", where);
		return contractDao.getReqfunds(map);
	}

	@Override
	@Transactional
	public void delete_Contract(String manage_contract_id) {
		Map<String, Object> map=new HashMap<String, Object>();
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append(" manage_contract LEFT JOIN manage_reqfunds");
		sBuffer.append(" ON manage_contract.manage_contract_id = manage_reqfunds.manage_reqfunds_contractId");
		sBuffer.append(" WHERE manage_contract_id = "+manage_contract_id);
		map.put("what",sBuffer.toString()); 
		contractDao.delete_Contract(map);
		
	}

	@Override
	public void delete_Reqfunds(String manage_reqfunds_id) {
		Map<String, Object> map=new HashMap<String, Object>();
		int id = Integer.valueOf(manage_reqfunds_id);
		map.put("id", id);
		contractDao.delete_Reqfunds(map);
	}


	@Override
	public Map<String, Object> findContract(String fields, String where) {
		 Map<String, Object> map=new HashMap<String, Object>();
		 map.put("fields", fields);
		 map.put("where", where);
		return contractDao.getContract(map);
	}

	@Override
	@Transactional
	public void updateReqfunds(Reqfunds reqfunds,User user) {
	contractDao.updateReqfunds(reqfunds);

	String userid = user.getUserid() + "";// 获取申请人
	String processDefinitioKey = "reqfundsView"; // 定义流程的key,不可修改

	String bizId = processDefinitioKey + "."
			+ reqfunds.getManage_reqfunds_id(); // 获取业务id
	try {
		ProcessInstance pi=activitiService.startProcesses(bizId, userid, processDefinitioKey,
				null);
		DataProcinst dataProcinst=new DataProcinst();
	
		dataProcinst.setProc_inst_id_(pi.getId());
		dataProcinst.setApplicant(user.getUsername());
		dataProcinst.setIllustrate("开票内容："+reqfunds.getManage_ticket_content());
		activitiDao.insertDataProcinst(dataProcinst);
		
	} catch (Exception e) {
	
		e.printStackTrace();
	}

		 
	}
	
	

	@Override
	@Transactional
	public void updateRfdStatus(DelegateExecution execution, String status) {
		
		String bizkey= execution.getProcessBusinessKey();

			String[] strs=bizkey.split("\\.");
	        String bizId=null;
			for(int i=0,len=strs.length;i<len;i++){
				bizId=strs[i].toString();
			}
			Reqfunds rfs=new Reqfunds();
			rfs.setManage_reqfunds_id(Integer.valueOf(bizId));
			rfs.setManage_status(Integer.valueOf(status));
			contractDao.updateReqfunds(rfs);
	}

	public String getSum(String manage_contract_company) {
		Map<String, Object> map=new HashMap<String, Object>();
		String fieds ="sum(manage_contract_visaAmount+manage_contract_amount) sum";
		StringBuffer sBuffer=new StringBuffer();
		if (StringUtils.hasText(manage_contract_company)) {
			sBuffer.append(" manage_contract where   manage_contract_company = "+manage_contract_company+" ");
		}else {
			sBuffer.append(" manage_contract  ");
		}
		map.put("fields", fieds);
		map.put("where", sBuffer);
		return contractDao.getSum(map);
	}

	@Override
	@Transactional
	public void reqfundspass(HttpServletRequest request,Reqfunds reqfunds) {
		 String taskid=request.getParameter("taskid");
		 String taskName=request.getParameter("taskName");
		 String sign=request.getParameter("sign");
		 String options=request.getParameter("options");
		 Map<String, Object> vars=new HashMap<String, Object>();
		    User user=(User) request.getSession().getAttribute("loginUser");//当前办理人
	        String userid=user.getUserid()+"";
		 if (taskName.equals("申请人")) {
				contractDao.updateReqfunds(reqfunds);
		 }
		    vars.put("sign", sign);	
		    activitiService.comment(taskid,userid,options);
			taskService.complete(taskid,vars);
	     }
	@Override
	@Transactional
	public void saveReqfunds(Reqfunds reqfunds) {
	 contractDao.saveReqfunds(reqfunds);
	}
	
	
  	     //流程定义类方法
	  public  String reqfundsNextUser(DelegateExecution execution) {
		  HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String nextUser = request.getParameter("username");// 下一个审核人	
			return nextUser;		
	    }


     }
