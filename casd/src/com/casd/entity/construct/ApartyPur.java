package com.casd.entity.construct;

import java.io.Serializable;


/**
 *     甲供材料采购 construct_aparty_purchase
 * */
public class ApartyPur implements Serializable {
	
	private static final long serialVersionUID = 5255411984322554500L;
	private int construct_Aparty_purchase_id;						//id
	private String construct_Aparty_purchase_constructId;			//项目id
	private String construct_Aparty_purchase_orderNum;				//订单号
	private String construct_Aparty_purchase_supplier;				//供货单位	
	private String construct_Aparty_purchase_contacts;				//联系人
	private String construct_Aparty_purchase_tel;					//联系电话
	private String construct_Aparty_purchase_status;				//状态
	private String construct_Aparty_purchase_remarks;				//备注
	private String construct_Aparty_purchase_creatTime;				//创建时间

	public int getConstruct_Aparty_purchase_id() {
		return construct_Aparty_purchase_id;
	}
	public void setConstruct_Aparty_purchase_id(int construct_Aparty_purchase_id) {
		this.construct_Aparty_purchase_id = construct_Aparty_purchase_id;
	}
	public String getConstruct_Aparty_purchase_constructId() {
		return construct_Aparty_purchase_constructId;
	}
	public void setConstruct_Aparty_purchase_constructId(
			String construct_Aparty_purchase_constructId) {
		this.construct_Aparty_purchase_constructId = construct_Aparty_purchase_constructId;
	}
	public String getConstruct_Aparty_purchase_orderNum() {
		return construct_Aparty_purchase_orderNum;
	}
	public void setConstruct_Aparty_purchase_orderNum(
			String construct_Aparty_purchase_orderNum) {
		this.construct_Aparty_purchase_orderNum = construct_Aparty_purchase_orderNum;
	}
	public String getConstruct_Aparty_purchase_supplier() {
		return construct_Aparty_purchase_supplier;
	}
	public void setConstruct_Aparty_purchase_supplier(
			String construct_Aparty_purchase_supplier) {
		this.construct_Aparty_purchase_supplier = construct_Aparty_purchase_supplier;
	}
	public String getConstruct_Aparty_purchase_contacts() {
		return construct_Aparty_purchase_contacts;
	}
	public void setConstruct_Aparty_purchase_contacts(
			String construct_Aparty_purchase_contacts) {
		this.construct_Aparty_purchase_contacts = construct_Aparty_purchase_contacts;
	}
	public String getConstruct_Aparty_purchase_tel() {
		return construct_Aparty_purchase_tel;
	}
	public void setConstruct_Aparty_purchase_tel(
			String construct_Aparty_purchase_tel) {
		this.construct_Aparty_purchase_tel = construct_Aparty_purchase_tel;
	}
	public String getConstruct_Aparty_purchase_status() {
		return construct_Aparty_purchase_status;
	}
	public void setConstruct_Aparty_purchase_status(
			String construct_Aparty_purchase_status) {
		this.construct_Aparty_purchase_status = construct_Aparty_purchase_status;
	}
	public String getConstruct_Aparty_purchase_remarks() {
		return construct_Aparty_purchase_remarks;
	}
	public void setConstruct_Aparty_purchase_remarks(
			String construct_Aparty_purchase_remarks) {
		this.construct_Aparty_purchase_remarks = construct_Aparty_purchase_remarks;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getConstruct_Aparty_purchase_creatTime() {
		return construct_Aparty_purchase_creatTime;
	}
	public void setConstruct_Aparty_purchase_creatTime(
			String construct_Aparty_purchase_creatTime) {
		this.construct_Aparty_purchase_creatTime = construct_Aparty_purchase_creatTime;
	}

}
