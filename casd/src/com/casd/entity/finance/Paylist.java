package com.casd.entity.finance;

import java.io.Serializable;
import java.sql.Date;

public class Paylist implements Serializable{
	private int gad_paylist_id;
	private int gad_paylist_centerid;
	private String gad_paylist_month;
	private int gad_paylist_men_num;
	private double gad_paylist_payroll;
	private String gad_paylist_remarks;
	public int getGad_paylist_id() {
		return gad_paylist_id;
	}
	public void setGad_paylist_id(int gad_paylist_id) {
		this.gad_paylist_id = gad_paylist_id;
	}
	public int getGad_paylist_centerid() {
		return gad_paylist_centerid;
	}
	public void setGad_paylist_centerid(int gad_paylist_centerid) {
		this.gad_paylist_centerid = gad_paylist_centerid;
	}
	public String getGad_paylist_month() {
		return gad_paylist_month;
	}
	public void setGad_paylist_month(String gad_paylist_month) {
		this.gad_paylist_month = gad_paylist_month;
	}
	public int getGad_paylist_men_num() {
		return gad_paylist_men_num;
	}
	public void setGad_paylist_men_num(int gad_paylist_men_num) {
		this.gad_paylist_men_num = gad_paylist_men_num;
	}
	public double getGad_paylist_payroll() {
		return gad_paylist_payroll;
	}
	public void setGad_paylist_payroll(double gad_paylist_payroll) {
		this.gad_paylist_payroll = gad_paylist_payroll;
	}
	public String getGad_paylist_remarks() {
		return gad_paylist_remarks;
	}
	public void setGad_paylist_remarks(String gad_paylist_remarks) {
		this.gad_paylist_remarks = gad_paylist_remarks;
	}
	


}
