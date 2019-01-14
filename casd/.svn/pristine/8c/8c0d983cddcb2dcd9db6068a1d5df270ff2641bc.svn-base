package com.casd.service.hr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateExecution;

import com.casd.entity.hr.Resign;

public interface ResignService {

	void addResign(Resign ressign);

	List<Resign> getData(String fields, String string);

	void addAutoPath(String path, String resignId);

	Resign findResign(String fields, String where);
	
	void passResign(HttpServletRequest request,Resign ressign) throws Exception;
	 public  String resignNextUser(DelegateExecution execution) ;
	 
}
