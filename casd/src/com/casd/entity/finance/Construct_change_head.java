package com.casd.entity.finance;

import java.io.Serializable;


//表格construct_change_head 
public class Construct_change_head implements  Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7378827000157076954L;
	
	private int id;					//id
	private String change_price_name;	//变更名称
	private String status;			//状态
	private String describe;			//描述
	private int material_supplierId;	//供应商id
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChange_price_name() {
		return change_price_name;
	}
	public void setChange_price_name(String change_price_name) {
		this.change_price_name = change_price_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getMaterial_supplierId() {
		return material_supplierId;
	}
	public void setMaterial_supplierId(int material_supplierId) {
		this.material_supplierId = material_supplierId;
	}
	

}
