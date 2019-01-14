package com.casd.entity.construct;

import java.io.Serializable;


/**
 *    采购材料分录 construct_purchase_entry
 * */
public class PurchaseEntry implements Serializable{
	
	private int construct_purchase_entryId;				//id
	private String construct_purchase_material;			//材料名称
	private String construct_purchase_model;			//型号规格
	private String construct_purchase_unit;				//单位
	private int construct_purchase_quantities;			//合同工程量
	private int construct_purchase_approvalNum;			//累计审批量
	private int construct_purchase_applyNum;			//计划采购量
	private Double construct_purchase_contractPrice;	//合同单价
	private Double construct_purchase_purchasePrice;	//采购单价
	private Double construct_purchase_purchaseTotal;	//采购小计
	private int construct_purchase_parentId;			//单头id
	private String construct_purchase_remarks;			//备注
	private String construct_purchase_brand;			//材料品牌
	private int construct_purchase_quantitiesId;		//合同工程量id
	public int getConstruct_purchase_entryId() {
		return construct_purchase_entryId;
	}
	public void setConstruct_purchase_entryId(int construct_purchase_entryId) {
		this.construct_purchase_entryId = construct_purchase_entryId;
	}
	public String getConstruct_purchase_material() {
		return construct_purchase_material;
	}
	public void setConstruct_purchase_material(String construct_purchase_material) {
		this.construct_purchase_material = construct_purchase_material;
	}
	public String getConstruct_purchase_model() {
		return construct_purchase_model;
	}
	public void setConstruct_purchase_model(String construct_purchase_model) {
		this.construct_purchase_model = construct_purchase_model;
	}
	public String getConstruct_purchase_unit() {
		return construct_purchase_unit;
	}
	public void setConstruct_purchase_unit(String construct_purchase_unit) {
		this.construct_purchase_unit = construct_purchase_unit;
	}
	public int getConstruct_purchase_quantities() {
		return construct_purchase_quantities;
	}
	public void setConstruct_purchase_quantities(int construct_purchase_quantities) {
		this.construct_purchase_quantities = construct_purchase_quantities;
	}
	public int getConstruct_purchase_approvalNum() {
		return construct_purchase_approvalNum;
	}
	public void setConstruct_purchase_approvalNum(int construct_purchase_approvalNum) {
		this.construct_purchase_approvalNum = construct_purchase_approvalNum;
	}
	public int getConstruct_purchase_applyNum() {
		return construct_purchase_applyNum;
	}
	public void setConstruct_purchase_applyNum(int construct_purchase_applyNum) {
		this.construct_purchase_applyNum = construct_purchase_applyNum;
	}
	public int getConstruct_purchase_parentId() {
		return construct_purchase_parentId;
	}
	public void setConstruct_purchase_parentId(int construct_purchase_parentId) {
		this.construct_purchase_parentId = construct_purchase_parentId;
	}
	public String getConstruct_purchase_remarks() {
		return construct_purchase_remarks;
	}
	public void setConstruct_purchase_remarks(String construct_purchase_remarks) {
		this.construct_purchase_remarks = construct_purchase_remarks;
	}
	public String getConstruct_purchase_brand() {
		return construct_purchase_brand;
	}
	public void setConstruct_purchase_brand(String construct_purchase_brand) {
		this.construct_purchase_brand = construct_purchase_brand;
	}
	public Double getConstruct_purchase_contractPrice() {
		return construct_purchase_contractPrice;
	}
	public void setConstruct_purchase_contractPrice(
			Double construct_purchase_contractPrice) {
		this.construct_purchase_contractPrice = construct_purchase_contractPrice;
	}
	public Double getConstruct_purchase_purchasePrice() {
		return construct_purchase_purchasePrice;
	}
	public void setConstruct_purchase_purchasePrice(
			Double construct_purchase_purchasePrice) {
		this.construct_purchase_purchasePrice = construct_purchase_purchasePrice;
	}
	public Double getConstruct_purchase_purchaseTotal() {
		return construct_purchase_purchaseTotal;
	}
	public void setConstruct_purchase_purchaseTotal(
			Double construct_purchase_purchaseTotal) {
		this.construct_purchase_purchaseTotal = construct_purchase_purchaseTotal;
	}
	public int getConstruct_purchase_quantitiesId() {
		return construct_purchase_quantitiesId;
	}
	public void setConstruct_purchase_quantitiesId(
			int construct_purchase_quantitiesId) {
		this.construct_purchase_quantitiesId = construct_purchase_quantitiesId;
	}
	
	
}
