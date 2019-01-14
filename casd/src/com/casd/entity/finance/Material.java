package com.casd.entity.finance;

import java.io.Serializable;



/**
 *    材料 construct_material_table
 * */
public class Material implements Serializable{
	
	private int construct_material_id;					//id
	private String construct_material_name;				//材料名
	private String construct_material_remarks;			//备注
	private int construct_material_seriesId;			//系列id
	private int construct_material_num;					//材料编码
	public int getConstruct_material_id() {
		return construct_material_id;
	}
	public void setConstruct_material_id(int construct_material_id) {
		this.construct_material_id = construct_material_id;
	}
	public String getConstruct_material_name() {
		return construct_material_name;
	}
	public void setConstruct_material_name(String construct_material_name) {
		this.construct_material_name = construct_material_name;
	}
	public String getConstruct_material_remarks() {
		return construct_material_remarks;
	}
	public void setConstruct_material_remarks(String construct_material_remarks) {
		this.construct_material_remarks = construct_material_remarks;
	}
	public int getConstruct_material_seriesId() {
		return construct_material_seriesId;
	}
	public void setConstruct_material_seriesId(int construct_material_seriesId) {
		this.construct_material_seriesId = construct_material_seriesId;
	}
	public int getConstruct_material_num() {
		return construct_material_num;
	}
	public void setConstruct_material_num(int construct_material_num) {
		this.construct_material_num = construct_material_num;
	}

	
	

}
