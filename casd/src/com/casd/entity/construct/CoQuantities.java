package com.casd.entity.construct;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 *  项目工程量 construct_project_quantities
 * */
public class CoQuantities implements Serializable{
	
	private int construct_project_quantities_id;     //合同工程量id
	private String construct_project_quantities_name;  //合同工程量材料名
	private String construct_project_quantities_model;//型号规格
	private BigDecimal construct_project_quantities_num;     //数量
	private String construct_project_quantities_unit; //单位
	private BigDecimal construct_project_quantities_price; //单价
	private String construct_project_quantities_remarks;//备注
	
	private int construct_project_quantities_conId;//项目id
	private int construct_project_quantities_modelId;//规格id

	
	public int getConstruct_project_quantities_id() {
		return construct_project_quantities_id;
	}

	public void setConstruct_project_quantities_id(
			int construct_project_quantities_id) {
		this.construct_project_quantities_id = construct_project_quantities_id;
	}

	public String getConstruct_project_quantities_name() {
		return construct_project_quantities_name;
	}

	public void setConstruct_project_quantities_name(
			String construct_project_quantities_name) {
		this.construct_project_quantities_name = construct_project_quantities_name;
	}

	public String getConstruct_project_quantities_model() {
		return construct_project_quantities_model;
	}

	public void setConstruct_project_quantities_model(
			String construct_project_quantities_model) {
		this.construct_project_quantities_model = construct_project_quantities_model;
	}

	
	public String getConstruct_project_quantities_unit() {
		return construct_project_quantities_unit;
	}

	public void setConstruct_project_quantities_unit(
			String construct_project_quantities_unit) {
		this.construct_project_quantities_unit = construct_project_quantities_unit;
	}


	public String getConstruct_project_quantities_remarks() {
		return construct_project_quantities_remarks;
	}

	public void setConstruct_project_quantities_remarks(
			String construct_project_quantities_remarks) {
		this.construct_project_quantities_remarks = construct_project_quantities_remarks;
	}

	public int getConstruct_project_quantities_conId() {
		return construct_project_quantities_conId;
	}

	public void setConstruct_project_quantities_conId(
			int construct_project_quantities_conId) {
		this.construct_project_quantities_conId = construct_project_quantities_conId;
	}


	public int getConstruct_project_quantities_modelId() {
		return construct_project_quantities_modelId;
	}

	public void setConstruct_project_quantities_modelId(
			int construct_project_quantities_modelId) {
		this.construct_project_quantities_modelId = construct_project_quantities_modelId;
	}

	public BigDecimal getConstruct_project_quantities_num() {
		return construct_project_quantities_num;
	}

	public void setConstruct_project_quantities_num(
			BigDecimal construct_project_quantities_num) {
		this.construct_project_quantities_num = construct_project_quantities_num;
	}

	public BigDecimal getConstruct_project_quantities_price() {
		return construct_project_quantities_price;
	}

	public void setConstruct_project_quantities_price(
			BigDecimal construct_project_quantities_price) {
		this.construct_project_quantities_price = construct_project_quantities_price;
	}   

}
