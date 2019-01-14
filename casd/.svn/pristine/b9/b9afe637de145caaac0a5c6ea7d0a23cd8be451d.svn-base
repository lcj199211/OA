package com.casd.controller.web.common;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.impl.task.TaskDefinition;

import com.casd.controller.web.utils.ActivitUtil;

public class JumpActivityCmd implements Command<Object>{
	

    private static ActivitUtil activitUtil; 
	private String activityId;
	private String processInstanceId;
	private String jumpOrigin;
	


	public JumpActivityCmd(String activityId, String processInstanceId,
			String jumpOrigin) {
		this.activityId = activityId;
		this.processInstanceId = processInstanceId;
		this.jumpOrigin = jumpOrigin;
	}

	public JumpActivityCmd(String activityId, String processInstanceId) {
		this(activityId, processInstanceId, "jump");
	}

	public Object execute(CommandContext commandContext) {
		ExecutionEntity executionEntity = commandContext
				.getExecutionEntityManager().findExecutionById(
						processInstanceId);
		executionEntity.destroyScope(jumpOrigin);
		ProcessDefinitionImpl processDefinition = executionEntity
				.getProcessDefinition();
		ActivityImpl activity = processDefinition.findActivity(activityId);
		executionEntity.executeActivity(activity);
		return executionEntity;
	}

	
	
	/***
	 * 获取版本编号  @param processDefinitionId
	 * 节点ID     @param  activitiId
	 * 
	 * */
	public static List<TaskDefinition> taskDefinitionList(String processDefinitionId,String activitiId) {
		ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl)activitUtil.getRepositoryService()).getDeployedProcessDefinition(processDefinitionId);
	
		// 获得当前任务的所有节点
				List<ActivityImpl> activitiList = def.getActivities(); //
				
				ActivityImpl activityImpl = null;
				List<TaskDefinition> taskDefinitionList = new ArrayList<TaskDefinition>();
				for (int i = 0; i < activitiList.size(); i++) {
					String flag = activitiList.get(i).getId();
					if (flag.equals(activitiId)) {
						activityImpl = activitiList.get(i);				
					 taskDefinitionList = nextTaskDefinition(activityImpl, activityImpl.getId());
					}
				}
		
		return taskDefinitionList;

	}
	
	
	/**
	 * 
	 * @author: Longjun
	 * @Description: 获取所有下一节点
	 * @date:2016年3月18日 下午4:33:24
	 */
	@SuppressWarnings("unused")
	private static List<TaskDefinition> nextTaskDefinition(ActivityImpl activityImpl, String activityId){
		List<TaskDefinition> taskDefinitionList = new ArrayList<TaskDefinition>();//所有的任务实例
		List<TaskDefinition> nextTaskDefinition = new ArrayList<TaskDefinition>();//逐个获取的任务实例
		TaskDefinition taskDefinition = null;
		if("userTask".equals(activityImpl.getProperty("type")) && !activityId.equals(activityImpl.getId())){
			taskDefinition = ((UserTaskActivityBehavior)activityImpl.getActivityBehavior()).getTaskDefinition();
			taskDefinitionList.add(taskDefinition);
		}else{
			List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();
			List<PvmTransition> outTransitionsTemp = null;
			for(PvmTransition tr:outTransitions){  
				PvmActivity ac = tr.getDestination(); //获取线路的终点节点  
				//如果是互斥网关或者是并行网关
				if("exclusiveGateway".equals(ac.getProperty("type"))||"parallelGateway".equals(ac.getProperty("type"))){
					outTransitionsTemp = ac.getOutgoingTransitions();
					if(outTransitionsTemp.size() == 1){							
						nextTaskDefinition = nextTaskDefinition((ActivityImpl)outTransitionsTemp.get(0).getDestination(), activityId);
						taskDefinitionList.addAll(nextTaskDefinition);
					}else if(outTransitionsTemp.size() > 1){
						for(PvmTransition tr1 : outTransitionsTemp){
							nextTaskDefinition = nextTaskDefinition((ActivityImpl)tr1.getDestination(), activityId);
							taskDefinitionList.addAll(nextTaskDefinition);
						}							
					}
				}else if("userTask".equals(ac.getProperty("type"))){
					taskDefinition = ((UserTaskActivityBehavior)((ActivityImpl)ac).getActivityBehavior()).getTaskDefinition();
					taskDefinitionList.add(taskDefinition);
				}else{
					System.out.println((String) ac.getProperty("type"));
				}
			} 		
		}
		return taskDefinitionList;
	}


}
