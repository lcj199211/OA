package com.casd.entity.activiti;

import java.io.Serializable;

/**
 *  相对应表格 
 *  act_hi_taskinst
 * */
public class Taskinst implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = -7112389626876729121L;
	//历史节点id
	 private String id_; //
	
	private String  description_; //历史描述


	public String getId_() {
		return id_;
	}

	public String getDescription_() {
		return description_;
	}

	public void setId_(String id_) {
		this.id_ = id_;
	}

	public void setDescription_(String description_) {
		this.description_ = description_;
	}
	
}
