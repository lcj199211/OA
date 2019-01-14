package com.casd.entity.construct;

import java.io.Serializable;


/**
 *    项目计划 construct_prosch_table
 * */
public class ProSch implements Serializable {
	
	private static final long serialVersionUID = 5255411984322554500L;
	private int construct_prosch_id;				//id
	private String construct_prosch_system;			//系统
	private String construct_prosch_teamplan;		//班主计划
	private String construct_prosch_makespan;		//完工时间
	private String construct_prosch_debugcom;		//调试完成
	private String construct_prosch_detectioncom;	//检测完成
	private String construct_prosch_accepcom;		//验收完成
	private String construct_prosch_busyowner;		//交证业主
	private String construct_prosch_fulfil;			//竣备完成
	private String construct_prosch_checkupon;		//业主验收
	private String construct_prosch_turnover;		//移交物业
	private String construct_prosch_startbusiness;	//交楼/开业
	private String construct_prosch_settlement;		//结算
	private String construct_prosch_updatetime;		//更新时间
	private String construct_prosch_remark;			//备注
	private int construct_prosch_projectid;			//项目id
	public int getConstruct_prosch_id() {
		return construct_prosch_id;
	}
	public void setConstruct_prosch_id(int construct_prosch_id) {
		this.construct_prosch_id = construct_prosch_id;
	}
	public String getConstruct_prosch_system() {
		return construct_prosch_system;
	}
	public void setConstruct_prosch_system(String construct_prosch_system) {
		this.construct_prosch_system = construct_prosch_system;
	}
	public String getConstruct_prosch_teamplan() {
		return construct_prosch_teamplan;
	}
	public void setConstruct_prosch_teamplan(String construct_prosch_teamplan) {
		this.construct_prosch_teamplan = construct_prosch_teamplan;
	}
	public String getConstruct_prosch_makespan() {
		return construct_prosch_makespan;
	}
	public void setConstruct_prosch_makespan(String construct_prosch_makespan) {
		this.construct_prosch_makespan = construct_prosch_makespan;
	}
	public String getConstruct_prosch_debugcom() {
		return construct_prosch_debugcom;
	}
	public void setConstruct_prosch_debugcom(String construct_prosch_debugcom) {
		this.construct_prosch_debugcom = construct_prosch_debugcom;
	}
	public String getConstruct_prosch_detectioncom() {
		return construct_prosch_detectioncom;
	}
	public void setConstruct_prosch_detectioncom(
			String construct_prosch_detectioncom) {
		this.construct_prosch_detectioncom = construct_prosch_detectioncom;
	}
	public String getConstruct_prosch_accepcom() {
		return construct_prosch_accepcom;
	}
	public void setConstruct_prosch_accepcom(String construct_prosch_accepcom) {
		this.construct_prosch_accepcom = construct_prosch_accepcom;
	}
	public String getConstruct_prosch_busyowner() {
		return construct_prosch_busyowner;
	}
	public void setConstruct_prosch_busyowner(String construct_prosch_busyowner) {
		this.construct_prosch_busyowner = construct_prosch_busyowner;
	}
	public String getConstruct_prosch_fulfil() {
		return construct_prosch_fulfil;
	}
	public void setConstruct_prosch_fulfil(String construct_prosch_fulfil) {
		this.construct_prosch_fulfil = construct_prosch_fulfil;
	}
	public String getConstruct_prosch_checkupon() {
		return construct_prosch_checkupon;
	}
	public void setConstruct_prosch_checkupon(String construct_prosch_checkupon) {
		this.construct_prosch_checkupon = construct_prosch_checkupon;
	}
	public String getConstruct_prosch_turnover() {
		return construct_prosch_turnover;
	}
	public void setConstruct_prosch_turnover(String construct_prosch_turnover) {
		this.construct_prosch_turnover = construct_prosch_turnover;
	}
	public String getConstruct_prosch_startbusiness() {
		return construct_prosch_startbusiness;
	}
	public void setConstruct_prosch_startbusiness(
			String construct_prosch_startbusiness) {
		this.construct_prosch_startbusiness = construct_prosch_startbusiness;
	}
	public String getConstruct_prosch_settlement() {
		return construct_prosch_settlement;
	}
	public void setConstruct_prosch_settlement(String construct_prosch_settlement) {
		this.construct_prosch_settlement = construct_prosch_settlement;
	}
	public String getConstruct_prosch_updatetime() {
		return construct_prosch_updatetime;
	}
	public void setConstruct_prosch_updatetime(String construct_prosch_updatetime) {
		this.construct_prosch_updatetime = construct_prosch_updatetime;
	}
	public String getConstruct_prosch_remark() {
		return construct_prosch_remark;
	}
	public void setConstruct_prosch_remark(String construct_prosch_remark) {
		this.construct_prosch_remark = construct_prosch_remark;
	}
	public int getConstruct_prosch_projectid() {
		return construct_prosch_projectid;
	}
	public void setConstruct_prosch_projectid(int construct_prosch_projectid) {
		this.construct_prosch_projectid = construct_prosch_projectid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
