package com.casd.entity.construct;

import java.io.Serializable;

/**
 *    项目 purChangeEntryTab
 * */
public class PurChangeEmtry implements Serializable {
	
	private int purChangeEntryTab_id;				//编号
	private String purChangeEntryTab_material;		//材料名
	private String purChangeEntryTab_model;			//规格
	private int purChangeEntryTab_quarityNum;		//合同工程量
	private int purChangeEntryTab_purNum;			//已采购工程量
	private int purChangeEntryTab_applyNum;			//申请增加工程量
	private String purChangeEntryTab_remarks;		//备注
	private double purChangeEntryTab_total;			//金额
	private double purChangeEntryTab_price;			//总金额
	private String purChangeEntryTab_unit;			//单位
	private int purChangeEntryTab_parentId;			//父id
	public int getPurChangeEntryTab_id() {
		return purChangeEntryTab_id;
	}
	public void setPurChangeEntryTab_id(int purChangeEntryTab_id) {
		this.purChangeEntryTab_id = purChangeEntryTab_id;
	}
	public String getPurChangeEntryTab_material() {
		return purChangeEntryTab_material;
	}
	public void setPurChangeEntryTab_material(String purChangeEntryTab_material) {
		this.purChangeEntryTab_material = purChangeEntryTab_material;
	}
	public String getPurChangeEntryTab_model() {
		return purChangeEntryTab_model;
	}
	public void setPurChangeEntryTab_model(String purChangeEntryTab_model) {
		this.purChangeEntryTab_model = purChangeEntryTab_model;
	}
	public int getPurChangeEntryTab_quarityNum() {
		return purChangeEntryTab_quarityNum;
	}
	public void setPurChangeEntryTab_quarityNum(int purChangeEntryTab_quarityNum) {
		this.purChangeEntryTab_quarityNum = purChangeEntryTab_quarityNum;
	}
	public int getPurChangeEntryTab_purNum() {
		return purChangeEntryTab_purNum;
	}
	public void setPurChangeEntryTab_purNum(int purChangeEntryTab_purNum) {
		this.purChangeEntryTab_purNum = purChangeEntryTab_purNum;
	}
	public int getPurChangeEntryTab_applyNum() {
		return purChangeEntryTab_applyNum;
	}
	public void setPurChangeEntryTab_applyNum(int purChangeEntryTab_applyNum) {
		this.purChangeEntryTab_applyNum = purChangeEntryTab_applyNum;
	}
	public String getPurChangeEntryTab_remarks() {
		return purChangeEntryTab_remarks;
	}
	public void setPurChangeEntryTab_remarks(String purChangeEntryTab_remarks) {
		this.purChangeEntryTab_remarks = purChangeEntryTab_remarks;
	}
	public double getPurChangeEntryTab_total() {
		return purChangeEntryTab_total;
	}
	public void setPurChangeEntryTab_total(double purChangeEntryTab_total) {
		this.purChangeEntryTab_total = purChangeEntryTab_total;
	}
	public double getPurChangeEntryTab_price() {
		return purChangeEntryTab_price;
	}
	public void setPurChangeEntryTab_price(double purChangeEntryTab_price) {
		this.purChangeEntryTab_price = purChangeEntryTab_price;
	}
	public String getPurChangeEntryTab_unit() {
		return purChangeEntryTab_unit;
	}
	public void setPurChangeEntryTab_unit(String purChangeEntryTab_unit) {
		this.purChangeEntryTab_unit = purChangeEntryTab_unit;
	}
	public int getPurChangeEntryTab_parentId() {
		return purChangeEntryTab_parentId;
	}
	public void setPurChangeEntryTab_parentId(int purChangeEntryTab_parentId) {
		this.purChangeEntryTab_parentId = purChangeEntryTab_parentId;
	}
	
}
