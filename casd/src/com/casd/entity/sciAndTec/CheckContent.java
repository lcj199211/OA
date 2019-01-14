package com.casd.entity.sciAndTec;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 保养详细内容  maintain_checkPro
*/
public class CheckContent implements Serializable {

	
	private static final long serialVersionUID = 7448177385949574240L;
	private int maintain_checkContent_id; 				//id
	private int maintain_checkContent_parentId; 		//父id 
	private String maintain_checkContent_name;			//系统名
	public int getMaintain_checkContent_id() {
		return maintain_checkContent_id;
	}
	public void setMaintain_checkContent_id(int maintain_checkContent_id) {
		this.maintain_checkContent_id = maintain_checkContent_id;
	}
	public int getMaintain_checkContent_parentId() {
		return maintain_checkContent_parentId;
	}
	public void setMaintain_checkContent_parentId(int maintain_checkContent_parentId) {
		this.maintain_checkContent_parentId = maintain_checkContent_parentId;
	}
	public String getMaintain_checkContent_name() {
		return maintain_checkContent_name;
	}
	public void setMaintain_checkContent_name(String maintain_checkContent_name) {
		this.maintain_checkContent_name = maintain_checkContent_name;
	}
	
	
}
