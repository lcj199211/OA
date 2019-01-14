package com.casd.controller.personManagem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.casd.controller.web.Ref;
import com.casd.entity.uc.User;
import com.casd.service.construct.PurchaseService;
import com.casd.service.hr.ActivitiService;
import com.casd.service.uc.UserService;

@Controller
@RequestMapping("/admin")
public class ActivitiControllers {

	@Autowired
	private ActivitiService activitiService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private HistoryService historyService;
	 @Autowired
    private  ProcessEngineConfiguration processEngineConfiguration;

	 protected static Map<String, ProcessDefinition> PROCESS_DEFINITION_CACHE = new HashMap<String, ProcessDefinition>();
	/**
	 * 查询任务列表
	 * @throws Exception 
	 * 
	 * 
	 * */
	@RequestMapping(value = "/findTaskList", method = RequestMethod.GET)
	public ModelAndView findTaskList(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		String typeName=billType(request);

		String fields =" DISTINCT RES.*";
		String where ="	ACT_RE_PROCDEF RES GROUP BY RES.KEY_ ";
	List<Map<String, Object>> deflist=userService.queryId(fields, where);

         mv.addObject("deflist", deflist);
		if (typeName.equals("采购申请")) {
			mv.setViewName("ownCenter/taskListMatPur");
		}else {
			mv.setViewName("personManagem/findTaskList");
		}
		return mv;
	}

	
	private String billType(HttpServletRequest request) {
		Enumeration<String> parameterNames = request.getParameterNames();
		String typeName="";
		for(Enumeration e=parameterNames;e.hasMoreElements();){
		      String thisName=e.nextElement().toString();
		      if(thisName.equals("type")){
		    	  typeName=request.getParameter(thisName);
		      }
		}
		
		return typeName;
	}
	
	private Map<String, Object> billData(String typeName,String billId) {
		Map<String, Object> data=new HashMap<String, Object>();
		if (typeName.equals("采购申请")) {
			String bizkey = activitiService.getBusinessBizId(billId);// 获取业务编号
			String[] strs = bizkey.split("\\.");
			String bizId = null; // 业务编号
			for (int i = 0, len = strs.length; i < len; i++) {
				bizId = strs[i].toString();
			}
			data = purchaseService.headData_Audit(Integer.valueOf(bizId));
			
		}
		
		return data;
	}
	
	
	/***
	 * 查询任务列表
	 * 
	 * @param 获选人查询
	 *            taskCandidateUser
	 * @param
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/findTaskLists", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findTaskList(HttpServletRequest request)
			throws Exception {
		User user = (User) request.getSession().getAttribute("loginUser");
	
		List<Map<String, Object>> taskList = new ArrayList<Map<String, Object>>();
		Map<String, Object> json = new HashMap<String, Object>();
	     	String userid = user.getUserid() + "";
	     	String type=request.getParameter("pdkey");//类型
	        String fields=" DISTINCT RES.*, datas.illustrate,datas.applicant,d.name_  pdname";
	        StringBuffer sbf=new StringBuffer();
	        sbf.append(" ACT_RU_TASK RES LEFT JOIN ACT_RU_IDENTITYLINK I ON I.TASK_ID_ = RES.ID_");
	        sbf.append(" INNER JOIN ACT_RE_PROCDEF D ON RES.PROC_DEF_ID_ = D.ID_");
	        sbf.append(" LEFT JOIN act_data_procinst datas ON datas.proc_inst_id_ = RES.PROC_INST_ID_");
	        sbf.append(" WHERE RES.SUSPENSION_STATE_ = 1 AND (RES.ASSIGNEE_ = "+userid+" OR (RES.ASSIGNEE_ IS NULL");
	        sbf.append(" AND (I.USER_ID_ = "+userid+" OR I.GROUP_ID_ IN (SELECT g.GROUP_ID_ FROM");
	        sbf.append(" ACT_ID_MEMBERSHIP g WHERE g.USER_ID_ ="+userid+"))))");
	        if (org.apache.commons.lang3.StringUtils.isNotEmpty(type)){
	        sbf.append(" and d.KEY_='"+type+"'");	
			}
	        sbf.append(" ORDER BY RES.ID_ DESC");
	      List<Map<String, Object>>listMaps= userService.queryId(fields, sbf.toString());
			 JSONArray jsonArray=JSONArray.fromObject(listMaps);
			 json.put("code", 0);
			 json.put("msg", "");
			 json.put("count",taskList.size());
			 json.put("data", jsonArray);
		   return json;

	}
	

	/***
	 * 查询历史记录
	 * 
	 * */
	@RequestMapping(value = "/historyTaskList", method = RequestMethod.GET)
	public ModelAndView historyTaskList() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("personManagem/historyTaskList");
		return mv;
	}

	// 查询历史记录
	@RequestMapping(value = "/historyTaskList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> historyTaskList(HttpServletRequest request)
			throws Exception {

		Ref<Integer> record = new Ref<Integer>();

		StringBuilder sbf = new StringBuilder();// 拼接sql
		User user = (User) request.getSession().getAttribute("loginUser");
		String processInstanceId = request.getParameter("processInstanceId");
		String userid = user.getUserid() + "";
		String username = user.getUsername() + "";
		StringBuilder fields = new StringBuilder();// 需要显示字段
		fields.append(" htt.PROC_INST_ID_,htt.NAME_,rdt.NAME_ rdtName,hpt.BUSINESS_KEY_,htt.START_TIME_,htt.END_TIME_");
		fields.append(",hpt.DELETE_REASON_");
		Map<String, Object> json = new HashMap<String, Object>();
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int pageIndex = Integer.parseInt(request.getParameter("page")) - 1;

		sbf.append("act_hi_taskinst htt");
		sbf.append(" LEFT JOIN  ACT_HI_PROCINST hpt ON htt.PROC_INST_ID_ = hpt.PROC_INST_ID_");
		sbf.append(" LEFT JOIN act_re_procdef rpf ON hpt.PROC_DEF_ID_=rpf.ID_");
		sbf.append(" LEFT JOIN act_re_deployment rdt on rpf.DEPLOYMENT_ID_=rdt.ID_");

		sbf.append(" WHERE htt.ASSIGNEE_ =" + userid );
		if (StringUtils.isNoneBlank(processInstanceId)) {
			sbf.append(" and htt.PROC_INST_ID_=" + processInstanceId);
		}

		List<Map<String, Object>> data = userService.userList(pageIndex,
				pageSize, record, sbf.toString(), fields.toString());

		json.put("rows", data);
		json.put("total", record.getValue());
		return json;

	}

	/**
	 * @author mr liao 签收任务
	 * 
	 * */
	
	 @RequestMapping(value = "/taskclaim", method = RequestMethod.POST)
	 @ResponseBody 
	 public Object taskclaim(String taskid,HttpSession session) {  
		 Map<String, Object> json= new HashMap<String,Object>();
		 
	  try { 
		User user =(User)session.getAttribute("loginUser");
	    String userid=user.getUserid()+"";
	     taskService.claim(taskid,userid);
		  	json.put("Success", true); 
		  	json.put("Msg", "已签收"); 
      	} catch (Exception e){ 
	  		json.put("Msg", "签收失败"); 
	  		json.put("Success", false);
             }
	 
	  return json;
	 }
	 
	/***
	 * 部署流程
	 * 
	 * */
	@RequestMapping(value = "/deploymentProcessDefinition_zip", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deploymentProcessDefinition_zip(
			MultipartFile file, String fileName) throws IOException {
		Map<String, Object> json = new HashMap<String, Object>();
		InputStream fis = null;
		ZipInputStream zipInputStream = null;
		try {
			fileName = file.getOriginalFilename(); // 文件名
			String newfileName = fileName.substring(0,
					fileName.lastIndexOf('.')); // 截取名 newfileName
			MultipartFile cf = (MultipartFile) file;
			fis = cf.getInputStream();
			
			zipInputStream = new ZipInputStream(fis);
			Deployment deployment = processEngine.getRepositoryService()// 与流程定义和部署对象相关的Service
					.createDeployment()// 创建一个部署对象
					.name(newfileName)// 添加部署的名称
					.addZipInputStream(zipInputStream)// 指定zip格式的文件完成部署
					.deploy();// 完成部署
			json.put("Success", true);
			json.put("Msg", "部署成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "部署失败");
		} finally {
			// 关闭流
			zipInputStream.close();
			fis.close();
		}

		return json;
	}

	/***
	 * 删除流程实例
	 * 
	 * */
	@RequestMapping(value = "/deleteProcessInstance", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteProcessInstance(String processInstanceId) {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			runtimeService.deleteProcessInstance(processInstanceId, "删除原因");
			json.put("Success", true);
			json.put("Msg", "删除成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("Success", false);
			json.put("Msg", "程序出错");
		}
		return json;
	   }

	
	@RequestMapping(value = "/delversion", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  delversion(String deploymentId) {
		repositoryService.deleteDeployment(deploymentId, true);
		return null;
	}
	
	
	/*   *//**
     * 读取带跟踪的图片
     *//*
    @RequestMapping(value = "/personManagem_s")
    public void readResource( String processInstanceId, HttpServletResponse response)
            throws Exception {
     processInstanceId="627501";
        //获取历史流程实例
        HistoricProcessInstance processInstance =  historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
        processEngineConfiguration = processEngine.getProcessEngineConfiguration();
        Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);

        ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
        ProcessDefinitionEntity definitionEntity = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processInstance.getProcessDefinitionId());

        List<HistoricActivityInstance> highLightedActivitList =  historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).list();
        //高亮环节id集合
        List<String> highLightedActivitis = new ArrayList<String>();
        //高亮线路id集合
        List<String> highLightedFlows = getHighLightedFlows(definitionEntity,highLightedActivitList);

        for(HistoricActivityInstance tempActivity : highLightedActivitList){
            String activityId = tempActivity.getActivityId();
            highLightedActivitis.add(activityId);
        }

        //中文显示的是口口口，设置字体就好了
        InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis,highLightedFlows,"宋体","宋体",null,1.0);
        //单独返回流程图，不高亮显示
//        InputStream imageStream = diagramGenerator.generatePngDiagram(bpmnModel);
        // 输出资源内容到相应对象
        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }

  
        }
    
    
    private List<String> getHighLightedFlows(
            ProcessDefinitionEntity processDefinitionEntity,
            List<HistoricActivityInstance> historicActivityInstances) {
        List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {// 对历史流程节点进行遍历
            ActivityImpl activityImpl = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i)
                            .getActivityId());// 得到节点定义的详细信息
            List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
            ActivityImpl sameActivityImpl1 = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i + 1)
                            .getActivityId());
            // 将后面第一个节点放在时间相同节点的集合里
            sameStartTimeNodes.add(sameActivityImpl1);
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                HistoricActivityInstance activityImpl1 = historicActivityInstances
                        .get(j);// 后续第一个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances
                        .get(j + 1);// 后续第二个节点
                if (activityImpl1.getStartTime().equals(
                        activityImpl2.getStartTime())) {
                    // 如果第一个节点和第二个节点开始时间相同保存
                    ActivityImpl sameActivityImpl2 = processDefinitionEntity
                            .findActivity(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                } else {
                    // 有不相同跳出循环
                    break;
                }
            }
            List<PvmTransition> pvmTransitions = activityImpl
                    .getOutgoingTransitions();// 取出节点的所有出去的线
            for (PvmTransition pvmTransition : pvmTransitions) {
                // 对所有的线进行遍历
                ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition
                        .getDestination();
                // 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }
        }
        return highFlows;
    }*/

    
}