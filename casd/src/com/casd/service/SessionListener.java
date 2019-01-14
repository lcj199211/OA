package com.casd.service;

import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.casd.entity.uc.User;


	 
public class SessionListener implements HttpSessionListener{
	  
	
	/** 
	 * seeionId和用户的绑定关系 
	 */  
	public static final Map<String, String> SESSIONID_USER=new HashMap<String, String>();
	

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		 User user = (User)arg0.getSession().getAttribute("loginUser");
		 if(user !=null) {
			 SESSIONID_USER.remove(user.getUserid());
		 }
	}


	}