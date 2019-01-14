package com.casd.entity.manage;

import java.io.Serializable;


/**
 *  manage_notice表
 * 
 * */
public class Notice implements Serializable{
	
	private int notice_id;  //编号
	
	private String user_id;  //用户编号
	
	private String start_time; //创建时间
	
	private int status;  //状态
	
	private String company_id;  //公司编号
	
	private String notice_content; //发文内容
	
	
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	
}
