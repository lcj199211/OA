package com.casd.controller.web.utils;


import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

public class ActivitUtil {
	
		private static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();  
		private static  IdentityService  identityService = processEngine.getIdentityService();  
		private static RuntimeService runtimeService = processEngine.getRuntimeService();  
        private static TaskService taskService = processEngine.getTaskService();  
        private static RepositoryService repositoryService = processEngine.getRepositoryService();  
        private static HistoryService historyService = processEngine.getHistoryService();  
        private static ManagementService managementService=processEngine.getManagementService();
        private static FormService formService=processEngine.getFormService();
        
		public static ProcessEngine getProcessEngine() {
			return processEngine;
		}
		public static IdentityService getIdentityService() {
			return identityService;
		}
		public static RuntimeService getRuntimeService() {
			return runtimeService;
		}
		public static TaskService getTaskService() {
			return taskService;
		}
		public static RepositoryService getRepositoryService() {
			return repositoryService;
		}
		public static HistoryService getHistoryService() {
			return historyService;
		}
		public static ManagementService getManagementService() {
			return managementService;
		}
		public static FormService getFormService() {
			return formService;
		}
		public static void setProcessEngine(ProcessEngine processEngine) {
			ActivitUtil.processEngine = processEngine;
		}
		public static void setIdentityService(IdentityService identityService) {
			ActivitUtil.identityService = identityService;
		}
		public static void setRuntimeService(RuntimeService runtimeService) {
			ActivitUtil.runtimeService = runtimeService;
		}
		public static void setTaskService(TaskService taskService) {
			ActivitUtil.taskService = taskService;
		}
		public static void setRepositoryService(RepositoryService repositoryService) {
			ActivitUtil.repositoryService = repositoryService;
		}
		public static void setHistoryService(HistoryService historyService) {
			ActivitUtil.historyService = historyService;
		}
		public static void setManagementService(ManagementService managementService) {
			ActivitUtil.managementService = managementService;
		}
		public static void setFormService(FormService formService) {
			ActivitUtil.formService = formService;
		}
    
	
}
