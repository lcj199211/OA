package com.casd.entity.finance;

import java.io.Serializable;


  /**
   * 价格变更表格
   * construct_change_price
   * 
   * **/
public class Construct_change_price implements Serializable{
	
	
	
	private int	construct_change_id;                    //变更编号
	
	private int construct_material_priceId;				//材料编号
	
	private String construct_material_name;				//材料名称
	
	private String construct_material_model;			//规格型号
	
	private String construct_material_unit;				//单位
	
	private String construct_material_supplier;			//供应商

	private double construct_material_price;			//现价
	
	private int construct_material_supplierId;			//供应商id
	
	private int construct_material_modelId;				//规格id
	
	private double construct_lowest_price;				//最低价
	
	private double construct_latest_price;				//原价
	
	private int construct_change_headId;  //单据id
	

	public int getConstruct_change_id() {
		return construct_change_id;
	}

	public void setConstruct_change_id(int construct_change_id) {
		this.construct_change_id = construct_change_id;
	}

	public int getConstruct_material_priceId() {
		return construct_material_priceId;
	}

	public void setConstruct_material_priceId(int construct_material_priceId) {
		this.construct_material_priceId = construct_material_priceId;
	}

	public String getConstruct_material_name() {
		return construct_material_name;
	}

	public void setConstruct_material_name(String construct_material_name) {
		this.construct_material_name = construct_material_name;
	}

	public String getConstruct_material_model() {
		return construct_material_model;
	}

	public void setConstruct_material_model(String construct_material_model) {
		this.construct_material_model = construct_material_model;
	}

	public String getConstruct_material_unit() {
		return construct_material_unit;
	}

	public void setConstruct_material_unit(String construct_material_unit) {
		this.construct_material_unit = construct_material_unit;
	}

	public String getConstruct_material_supplier() {
		return construct_material_supplier;
	}

	public void setConstruct_material_supplier(String construct_material_supplier) {
		this.construct_material_supplier = construct_material_supplier;
	}

	public double getConstruct_material_price() {
		return construct_material_price;
	}

	public void setConstruct_material_price(double construct_material_price) {
		this.construct_material_price = construct_material_price;
	}

	public int getConstruct_material_supplierId() {
		return construct_material_supplierId;
	}

	public void setConstruct_material_supplierId(int construct_material_supplierId) {
		this.construct_material_supplierId = construct_material_supplierId;
	}

	public int getConstruct_material_modelId() {
		return construct_material_modelId;
	}

	public void setConstruct_material_modelId(int construct_material_modelId) {
		this.construct_material_modelId = construct_material_modelId;
	}

	public double getConstruct_lowest_price() {
		return construct_lowest_price;
	}

	public void setConstruct_lowest_price(double construct_lowest_price) {
		this.construct_lowest_price = construct_lowest_price;
	}

	public double getConstruct_latest_price() {
		return construct_latest_price;
	}

	public void setConstruct_latest_price(double construct_latest_price) {
		this.construct_latest_price = construct_latest_price;
	}

	public int getConstruct_change_headId() {
		return construct_change_headId;
	}

	public void setConstruct_change_headId(int construct_change_headId) {
		this.construct_change_headId = construct_change_headId;
	}
	
	

}
