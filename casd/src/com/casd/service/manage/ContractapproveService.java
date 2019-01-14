package com.casd.service.manage;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.casd.controller.web.Ref;
import com.casd.entity.manage.AchReview;
import com.casd.entity.manage.Contract;
import com.casd.entity.manage.Contractapprove;
import com.casd.entity.ownCenter.Leave;

public interface ContractapproveService {

	List<Map<String, Object>> contractapproveList(int pageIndex, int pageSize,
			Ref<Integer> record, String fields, String string) throws Exception;

	void saveContractapprove(Contractapprove contractapprove,String userid,String username) throws Exception;

	Map<String, Object> getData(String manage_contractapprove_id);

	void delete_Contractapprove(String manage_contractapprove_id);
	void add_Contractapprove(String manage_contractapprove_id);

	public Map<String, Object> uploadFile(MultipartFile file,HttpServletRequest request);

	 Map<String, Object> findContractapprove(String fields, String string);

    public void updateCttp(DelegateExecution execution, String status);
    
    public void contractapprovePass(HttpServletRequest request) throws Exception;


  //流程定义类方法
    public  String contractUser(DelegateExecution execution);
	
		
	 
}

