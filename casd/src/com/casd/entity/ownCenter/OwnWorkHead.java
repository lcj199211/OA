package com.casd.entity.ownCenter;

import java.io.Serializable;
import java.sql.Date;

import org.activiti.engine.task.Task;

/**
 * own_workArrangHead 表格
 * */
public class OwnWorkHead implements Serializable{
	
	private static final long serialVersionUID = 5350443456235244277L;
	
	private int own_workArrangHead_id;             //编号
	private String own_workArrangHead_category;    //分类
	private int own_workArrangHead_centerId;       //中心
	private int own_workArrangHead_companyId;      //公司
	public int getOwn_workArrangHead_id() {
		return own_workArrangHead_id;
	}
	public void setOwn_workArrangHead_id(int own_workArrangHead_id) {
		this.own_workArrangHead_id = own_workArrangHead_id;
	}
	public String getOwn_workArrangHead_category() {
		return own_workArrangHead_category;
	}
	public void setOwn_workArrangHead_category(String own_workArrangHead_category) {
		this.own_workArrangHead_category = own_workArrangHead_category;
	}
	public int getOwn_workArrangHead_centerId() {
		return own_workArrangHead_centerId;
	}
	public void setOwn_workArrangHead_centerId(int own_workArrangHead_centerId) {
		this.own_workArrangHead_centerId = own_workArrangHead_centerId;
	}
	public int getOwn_workArrangHead_companyId() {
		return own_workArrangHead_companyId;
	}
	public void setOwn_workArrangHead_companyId(int own_workArrangHead_companyId) {
		this.own_workArrangHead_companyId = own_workArrangHead_companyId;
	}
	

}
