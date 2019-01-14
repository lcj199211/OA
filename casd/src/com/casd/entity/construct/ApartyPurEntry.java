package com.casd.entity.construct;

import java.io.Serializable;


/**
 *     甲供材料采购分录  construct_aparty_purentry
 * */
public class ApartyPurEntry implements Serializable {
	
	private static final long serialVersionUID = 5255411984322554500L;
	private int construct_Aparty_purEntry_id;						//id
	private int construct_Aparty_purEntry_materialId;				//合同材料id
	private Double construct_Aparty_purEntry_num;					//采购量
	private String construct_Aparty_purEntry_remark;				//备注	
	private int construct_Aparty_purEntry_parentId;					//父ID
	private Double construct_aParty_byedNum;						//累计采购量

	public int getConstruct_Aparty_purEntry_materialId() {
		return construct_Aparty_purEntry_materialId;
	}
	public void setConstruct_Aparty_purEntry_materialId(
			int construct_Aparty_purEntry_materialId) {
		this.construct_Aparty_purEntry_materialId = construct_Aparty_purEntry_materialId;
	}
	public Double getConstruct_Aparty_purEntry_num() {
		return construct_Aparty_purEntry_num;
	}
	public void setConstruct_Aparty_purEntry_num(
			Double construct_Aparty_purEntry_num) {
		this.construct_Aparty_purEntry_num = construct_Aparty_purEntry_num;
	}
	public int getConstruct_Aparty_purEntry_parentId() {
		return construct_Aparty_purEntry_parentId;
	}
	public void setConstruct_Aparty_purEntry_parentId(
			int construct_Aparty_purEntry_parentId) {
		this.construct_Aparty_purEntry_parentId = construct_Aparty_purEntry_parentId;
	}
	public int getConstruct_Aparty_purEntry_id() {
		return construct_Aparty_purEntry_id;
	}
	public void setConstruct_Aparty_purEntry_id(int construct_Aparty_purEntry_id) {
		this.construct_Aparty_purEntry_id = construct_Aparty_purEntry_id;
	}
	public String getConstruct_Aparty_purEntry_remark() {
		return construct_Aparty_purEntry_remark;
	}
	public void setConstruct_Aparty_purEntry_remark(
			String construct_Aparty_purEntry_remark) {
		this.construct_Aparty_purEntry_remark = construct_Aparty_purEntry_remark;
	}
	public Double getConstruct_aParty_byedNum() {
		return construct_aParty_byedNum;
	}
	public void setConstruct_aParty_byedNum(Double construct_aParty_byedNum) {
		this.construct_aParty_byedNum = construct_aParty_byedNum;
	}

}
