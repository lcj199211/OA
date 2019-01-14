package com.casd.entity.construct;

import java.io.Serializable;

/**
 *    项目 purChangeTab
 * */
public class PurChange implements Serializable {
	
	private int purChangeTab_id;				//编号
	private String purChangeTab_proName;		//项目名
	private String purChangeTab_matter;			//事宜
	private String purChangeTab_dep;			//部门
	private double purChangeTab_total;			//总金额
	private int purChangeTab_proId;				//部门id
	private String purChangeTab_reason;			//原因
	private int purChangeTab_status;			//状态
	
	public int getPurChangeTab_id() {
		return purChangeTab_id;
	}
	public void setPurChangeTab_id(int purChangeTab_id) {
		this.purChangeTab_id = purChangeTab_id;
	}
	public String getPurChangeTab_proName() {
		return purChangeTab_proName;
	}
	public void setPurChangeTab_proName(String purChangeTab_proName) {
		this.purChangeTab_proName = purChangeTab_proName;
	}
	public String getPurChangeTab_matter() {
		return purChangeTab_matter;
	}
	public void setPurChangeTab_matter(String purChangeTab_matter) {
		this.purChangeTab_matter = purChangeTab_matter;
	}
	public String getPurChangeTab_dep() {
		return purChangeTab_dep;
	}
	public void setPurChangeTab_dep(String purChangeTab_dep) {
		this.purChangeTab_dep = purChangeTab_dep;
	}
	public double getPurChangeTab_total() {
		return purChangeTab_total;
	}
	public void setPurChangeTab_total(double purChangeTab_total) {
		this.purChangeTab_total = purChangeTab_total;
	}
	public String getPurChangeTab_reason() {
		return purChangeTab_reason;
	}
	public void setPurChangeTab_reason(String purChangeTab_reason) {
		this.purChangeTab_reason = purChangeTab_reason;
	}
	public int getPurChangeTab_proId() {
		return purChangeTab_proId;
	}
	public void setPurChangeTab_proId(int purChangeTab_proId) {
		this.purChangeTab_proId = purChangeTab_proId;
	}
	public int getPurChangeTab_status() {
		return purChangeTab_status;
	}
	public void setPurChangeTab_status(int purChangeTab_status) {
		this.purChangeTab_status = purChangeTab_status;
	}

}
