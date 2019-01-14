package com.casd.service.construct;

import org.activiti.engine.delegate.DelegateExecution;

import com.casd.entity.construct.Drawmoney;


public interface DrawmoneyService {
	
	 public void savaDrawmoney(Drawmoney draw);
	 
     void  updateDrawmoney(Drawmoney draw);
	  public  String drawmoneyUser(DelegateExecution execution);

}
