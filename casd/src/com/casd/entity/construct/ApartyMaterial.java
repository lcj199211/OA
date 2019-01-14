package com.casd.entity.construct;

import java.io.Serializable;


/**
 *     甲供材料工程量 construct_aparty_material
 * */
public class ApartyMaterial implements Serializable {
	
	private static final long serialVersionUID = 5255411984322554500L;
	private int construct_Aparty_material_id;						//id
	private String construct_Aparty_material_name;					//材料名
	private String construct_Aparty_material_unit;					//单位
	private String construct_Aparty_material_category;				//类别
	private Double construct_Aparty_material_num;					//合同量
	private String construct_Aparty_material_remark;				//备注
	private int construct_Aparty_material_constructId;				//项目id
	private String construct_Aparty_material_model;					//规格型号

	
	public int getConstruct_Aparty_material_id() {
		return construct_Aparty_material_id;
	}
	public void setConstruct_Aparty_material_id(int construct_Aparty_material_id) {
		this.construct_Aparty_material_id = construct_Aparty_material_id;
	}
	public String getConstruct_Aparty_material_name() {
		return construct_Aparty_material_name;
	}
	public void setConstruct_Aparty_material_name(
			String construct_Aparty_material_name) {
		this.construct_Aparty_material_name = construct_Aparty_material_name;
	}
	public String getConstruct_Aparty_material_unit() {
		return construct_Aparty_material_unit;
	}
	public void setConstruct_Aparty_material_unit(
			String construct_Aparty_material_unit) {
		this.construct_Aparty_material_unit = construct_Aparty_material_unit;
	}
	public String getConstruct_Aparty_material_category() {
		return construct_Aparty_material_category;
	}
	public void setConstruct_Aparty_material_category(
			String construct_Aparty_material_category) {
		this.construct_Aparty_material_category = construct_Aparty_material_category;
	}
	public String getConstruct_Aparty_material_remark() {
		return construct_Aparty_material_remark;
	}
	public void setConstruct_Aparty_material_remark(
			String construct_Aparty_material_remark) {
		this.construct_Aparty_material_remark = construct_Aparty_material_remark;
	}
	public String getConstruct_Aparty_material_model() {
		return construct_Aparty_material_model;
	}
	public void setConstruct_Aparty_material_model(
			String construct_Aparty_material_model) {
		this.construct_Aparty_material_model = construct_Aparty_material_model;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Double getConstruct_Aparty_material_num() {
		return construct_Aparty_material_num;
	}
	public void setConstruct_Aparty_material_num(
			Double construct_Aparty_material_num) {
		this.construct_Aparty_material_num = construct_Aparty_material_num;
	}
	public int getConstruct_Aparty_material_constructId() {
		return construct_Aparty_material_constructId;
	}
	public void setConstruct_Aparty_material_constructId(
			int construct_Aparty_material_constructId) {
		this.construct_Aparty_material_constructId = construct_Aparty_material_constructId;
	}

}
