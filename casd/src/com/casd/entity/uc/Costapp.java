package com.casd.entity.uc;

import java.io.Serializable;

/**
 * 绩效考核
*/
public class Costapp implements Serializable {

	
	private static final long serialVersionUID = -6107028475165779440L;
	
	private int costapp_id; 				//单据id 
	private String costapp_company;			//公司
	private String costapp_appitem;			//申请事项
	private Double costapp_amount;			//费用金额
	private String costapp_application;		//申请类型
	private String costapp_majoyview;		//主办部门
	private String costapp_managerview;		//总经理意见
	private String costapp_chairmanview;	//董事长意见
	private String costapp_financeview;		//财务经理意见
	private String costapp_assistant;	    //董事助理	
	private String costapp_time;            //建单时间
	private int costapp_status;		        //审核状态
	private int userid;	                    //申请人
	
	public int getCostapp_id() {
		return costapp_id;
	}
	public void setCostapp_id(int costapp_id) {
		this.costapp_id = costapp_id;
	}
	public String getCostapp_company() {
		return costapp_company;
	}
	public void setCostapp_company(String costapp_company) {
		this.costapp_company = costapp_company;
	}
	public String getCostapp_appitem() {
		return costapp_appitem;
	}
	public void setCostapp_appitem(String costapp_appitem) {
		this.costapp_appitem = costapp_appitem;
	}
	public Double getCostapp_amount() {
		return costapp_amount;
	}
	public void setCostapp_amount(Double costapp_amount) {
		this.costapp_amount = costapp_amount;
	}
	public String getCostapp_application() {
		return costapp_application;
	}
	public void setCostapp_application(String costapp_application) {
		this.costapp_application = costapp_application;
	}
	public String getCostapp_majoyview() {
		return costapp_majoyview;
	}
	public void setCostapp_majoyview(String costapp_majoyview) {
		this.costapp_majoyview = costapp_majoyview;
	}
	public String getCostapp_managerview() {
		return costapp_managerview;
	}
	public void setCostapp_managerview(String costapp_managerview) {
		this.costapp_managerview = costapp_managerview;
	}

	public String getCostapp_chairmanview() {
		return costapp_chairmanview;
	}
	public void setCostapp_chairmanview(String costapp_chairmanview) {
		this.costapp_chairmanview = costapp_chairmanview;
	}
	public String getCostapp_financeview() {
		return costapp_financeview;
	}
	public void setCostapp_financeview(String costapp_financeview) {
		this.costapp_financeview = costapp_financeview;
	}
	public int getCostapp_status() {
		return costapp_status;
	}
	public void setCostapp_status(int costapp_status) {
		this.costapp_status = costapp_status;
	}
	public String getCostapp_assistant() {
		return costapp_assistant;
	}
	public void setCostapp_assistant(String costapp_assistant) {
		this.costapp_assistant = costapp_assistant;
	}
	public String getCostapp_time() {
		return costapp_time;
	}
	public void setCostapp_time(String costapp_time) {
		this.costapp_time = costapp_time;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

}
