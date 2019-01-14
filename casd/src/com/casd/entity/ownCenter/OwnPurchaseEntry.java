package com.casd.entity.ownCenter;

import java.io.Serializable;

public class OwnPurchaseEntry implements Serializable{
	
	private int own_purchase_entryId;             //编号
	private String own_purchase_material;         //材料名称
	private String own_purchase_model;            //型号规格
	private String own_purchase_unit;             //单位
	private int own_purchase_quantities;          //合同工程量
	private int own_purchase_stock;               //库存
	private Double own_purchase_applyNum;            //计划采购量
	private Double own_purchase_leastPrice;       //最低价
	private Double own_purchase_price;            //本次单价
	private Double own_purchase_purchaseTotal;    //采购小计
	private int own_purchase_parentId;            //审核单据编号
	private String own_purchase_remarks;          //备注
	
	
	public int getOwn_purchase_entryId() {
		return own_purchase_entryId;
	}
	public void setOwn_purchase_entryId(int own_purchase_entryId) {
		this.own_purchase_entryId = own_purchase_entryId;
	}
	public String getOwn_purchase_material() {
		return own_purchase_material;
	}
	public void setOwn_purchase_material(String own_purchase_material) {
		this.own_purchase_material = own_purchase_material;
	}
	public String getOwn_purchase_model() {
		return own_purchase_model;
	}
	public void setOwn_purchase_model(String own_purchase_model) {
		this.own_purchase_model = own_purchase_model;
	}
	public String getOwn_purchase_unit() {
		return own_purchase_unit;
	}
	public void setOwn_purchase_unit(String own_purchase_unit) {
		this.own_purchase_unit = own_purchase_unit;
	}
	public int getOwn_purchase_quantities() {
		return own_purchase_quantities;
	}
	public void setOwn_purchase_quantities(int own_purchase_quantities) {
		this.own_purchase_quantities = own_purchase_quantities;
	}

	public Double getOwn_purchase_leastPrice() {
		return own_purchase_leastPrice;
	}
	public void setOwn_purchase_leastPrice(Double own_purchase_leastPrice) {
		this.own_purchase_leastPrice = own_purchase_leastPrice;
	}
	public Double getOwn_purchase_price() {
		return own_purchase_price;
	}
	public void setOwn_purchase_price(Double own_purchase_price) {
		this.own_purchase_price = own_purchase_price;
	}
	public Double getOwn_purchase_purchaseTotal() {
		return own_purchase_purchaseTotal;
	}
	public void setOwn_purchase_purchaseTotal(Double own_purchase_purchaseTotal) {
		this.own_purchase_purchaseTotal = own_purchase_purchaseTotal;
	}
	public int getOwn_purchase_parentId() {
		return own_purchase_parentId;
	}
	public void setOwn_purchase_parentId(int own_purchase_parentId) {
		this.own_purchase_parentId = own_purchase_parentId;
	}
	public String getOwn_purchase_remarks() {
		return own_purchase_remarks;
	}
	public void setOwn_purchase_remarks(String own_purchase_remarks) {
		this.own_purchase_remarks = own_purchase_remarks;
	}
	public int getOwn_purchase_stock() {
		return own_purchase_stock;
	}
	public void setOwn_purchase_stock(int own_purchase_stock) {
		this.own_purchase_stock = own_purchase_stock;
	}
	public Double getOwn_purchase_applyNum() {
		return own_purchase_applyNum;
	}
	public void setOwn_purchase_applyNum(Double own_purchase_applyNum) {
		this.own_purchase_applyNum = own_purchase_applyNum;
	}

}
