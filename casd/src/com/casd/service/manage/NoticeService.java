package com.casd.service.manage;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.casd.controller.web.Ref;
import com.casd.entity.manage.Notice;


public interface NoticeService {
	
	public List<Map<String, Object>> noticeList(int page,int pageSize,Ref<Integer> record,String  where,String fields)  throws Exception;
	
	int savaNotice(HttpServletRequest request) throws Exception;
	
	public  void notice_pass(HttpServletRequest request) throws Exception;
	
	public void updete(Notice notice);

	public void deleteNotice();
}
