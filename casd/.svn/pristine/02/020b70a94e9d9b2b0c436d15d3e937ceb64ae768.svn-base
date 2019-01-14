package com.casd.serviceimpl.flow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casd.service.flow.FlowServices;

@Service
public class FlowServicesImpl implements FlowServices{
	


	 @Autowired
	private ProcessEngine processEngine; //获取引擎
	
	@Override
	public void deploymentProcessDefinition_zip() throws FileNotFoundException {
		
		File file = new File(
				"E:/chenganshidai/mydemo/WebRoot/res/activiti/leave_flow.zip");
		InputStream in = new FileInputStream(file);

		ZipInputStream zipInputStream = new ZipInputStream(in);
		Deployment deployment = processEngine.getRepositoryService()// 与流程定义和部署对象相关的Service
				.createDeployment()// 创建一个部署对象
				.name("请假流程")// 添加部署的名称
				.addZipInputStream(zipInputStream)// 指定zip格式的文件完成部署
				.deploy();// 完成部署
	}
    
	
	public Map<String, Object> findMyProsonalTask(HttpServletRequest request) {
		return null;
		
		
	}


	/**
	 * 根据任务id 获取from key值
	 *//*
	@Override
	public String findfromKey(String taskId) {
		
		TaskFormData formData = formService.getTaskFormData(taskId);;
		String formKey = formData.getFormKey();
		return null;
	}*/
	
}
