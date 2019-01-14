package com.casd.entity.hr;

import java.io.Serializable;


/**
 * 
 * 薪资调整记录
 * */
public class HrSalary implements Serializable{
	
	
	private int salary_id;     //
	private String adjustment_time;//调整时间
	private String original_salary;//原薪资
	private String adjusted_salary;//调整后薪资
	private String  reason;//调整原因
	private String note_taker;//记录人
	private int user_id;//用户编号
	
	public int getSalary_id() {
		return salary_id;
	}
	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}

	public String getAdjustment_time() {
		return adjustment_time;
	}
	public void setAdjustment_time(String adjustment_time) {
		this.adjustment_time = adjustment_time;
	}
	public String getOriginal_salary() {
		return original_salary;
	}
	public void setOriginal_salary(String original_salary) {
		this.original_salary = original_salary;
	}
	public String getAdjusted_salary() {
		return adjusted_salary;
	}
	public void setAdjusted_salary(String adjusted_salary) {
		this.adjusted_salary = adjusted_salary;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getNote_taker() {
		return note_taker;
	}
	public void setNote_taker(String note_taker) {
		this.note_taker = note_taker;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
