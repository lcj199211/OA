package com.casd.entity.uc;

import java.io.Serializable;

public class FrameWork implements Serializable{
	/**
	 * 行动
	 * */
	private static final long serialVersionUID = 3233733474854852305L;
	
	private int uc_framework_id; 			// 行动id
	private String uc_framework_name; 		// 名字
	private int uc_framework_parentId; 		// 父id
	private String uc_framework_describe; 	// 描述
	private int uc_framework_company; 		// 公司
	
	public int getUc_framework_id() {
		return uc_framework_id;
	}
	public void setUc_framework_id(int uc_framework_id) {
		this.uc_framework_id = uc_framework_id;
	}
	public String getUc_framework_name() {
		return uc_framework_name;
	}
	public void setUc_framework_name(String uc_framework_name) {
		this.uc_framework_name = uc_framework_name;
	}
	public int getUc_framework_parentId() {
		return uc_framework_parentId;
	}
	public void setUc_framework_parentId(int uc_framework_parentId) {
		this.uc_framework_parentId = uc_framework_parentId;
	}
	public String getUc_framework_describe() {
		return uc_framework_describe;
	}
	public void setUc_framework_describe(String uc_framework_describe) {
		this.uc_framework_describe = uc_framework_describe;
	}
	public int getUc_framework_company() {
		return uc_framework_company;
	}
	public void setUc_framework_company(int uc_framework_company) {
		this.uc_framework_company = uc_framework_company;
	}
	
		
	
}
