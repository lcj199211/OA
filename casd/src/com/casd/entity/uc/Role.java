package com.casd.entity.uc;

import java.io.Serializable;
import java.sql.Date;


/**
 * 
 * 角色信息表
 * 
 * */
public class Role implements Serializable {

	private int role_id; // 角色编码
	private String role_name; // 角色名
	private String state; // 权限编码
	
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}


	
}

