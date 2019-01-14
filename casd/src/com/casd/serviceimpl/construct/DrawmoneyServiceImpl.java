package com.casd.serviceimpl.construct;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.casd.dao.construct.DrawmoneyDao;
import com.casd.entity.construct.Drawmoney;
import com.casd.service.construct.DrawmoneyService;

@Service
public class DrawmoneyServiceImpl implements DrawmoneyService{
	
	@Autowired
	private DrawmoneyDao drawmoneyDao;
	
	
	@Override
	public void savaDrawmoney(Drawmoney draw) {
		
		drawmoneyDao.savaDrawmoney(draw);
		  
	}

	
	@Override
	@Transactional
	public void updateDrawmoney(Drawmoney draw) {
		drawmoneyDao.updateDrawmoney(draw);
  
	}
	 //流程定义类方法
    public  String drawmoneyUser(DelegateExecution execution) {
  	  HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
  		String nextUser = request.getParameter("username");// 下一个审核人	
  		return nextUser;		
  	
      }
}
