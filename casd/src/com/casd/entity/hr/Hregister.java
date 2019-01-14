package com.casd.entity.hr;

import java.io.Serializable;
import java.sql.Date;


/**
 * 公司职位变更记录表hr_register
 * 
 **/
public class Hregister implements Serializable{
	
	private int job_id;

	private String begin_date; //开始时间
	private String end_date;//结束时间
	private String corporate_name;//公司名称
	private String job_name;//职位
	private String reason;//变更原因
	private int user_id;//变更人编号
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getCorporate_name() {
		return corporate_name;
	}
	public void setCorporate_name(String corporate_name) {
		this.corporate_name = corporate_name;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}