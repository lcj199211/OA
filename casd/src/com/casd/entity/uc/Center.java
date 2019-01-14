package com.casd.entity.uc;

import java.io.Serializable;

public class Center implements Serializable{

	
	/**
	 * 所属中心
	 * 
	 * */
	private int center_id; // 中心编号
	private String center_name; // 中心名称
	private int center_companyId; // 公司编号
		
	public int getCenter_id() {
		return center_id;
	}
	public void setCenter_id(int center_id) {
		this.center_id = center_id;
	}
	public String getCenter_name() {
		return center_name;
	}
	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}
	public int getCenter_companyId() {
		return center_companyId;
	}
	public void setCenter_companyId(int center_companyId) {
		this.center_companyId = center_companyId;
	}
		


		
	
}
