package com.casd.entity.flow;

public class Comment {
	
	/**
	 * act_hi_comment 表
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String ID_; // 主键ID
	
	private String TYPE_; // 类型：event（事件）comment（意见）
	
	private String TIME_; //填写时间
	
	private String USER_ID_; // 填写人
	
	private String TASK_ID_; // 节点实例ID
	
	private String PROC_INST_ID_; //流程实例ID
	
	private String ACTION_; //值为下列内容中的一种：AddUserLink、DeleteUserLink、AddGroupLink、DeleteGroupLink、AddComment、AddAttachment、DeleteAttachment
	
	private String MESSAGE_; //用于存放流程产生的信息，比如审批意见
	
	private String FULL_MSG_;
	
	private String TXNE1; // 附带字段

	public String getID_() {
		return ID_;
	}

	public void setID_(String iD_) {
		ID_ = iD_;
	}

	public String getTYPE_() {
		return TYPE_;
	}

	public void setTYPE_(String tYPE_) {
		TYPE_ = tYPE_;
	}

	public String getTIME_() {
		return TIME_;
	}

	public void setTIME_(String tIME_) {
		TIME_ = tIME_;
	}

	public String getUSER_ID_() {
		return USER_ID_;
	}

	public void setUSER_ID_(String uSER_ID_) {
		USER_ID_ = uSER_ID_;
	}

	public String getTASK_ID_() {
		return TASK_ID_;
	}

	public void setTASK_ID_(String tASK_ID_) {
		TASK_ID_ = tASK_ID_;
	}

	public String getPROC_INST_ID_() {
		return PROC_INST_ID_;
	}

	public void setPROC_INST_ID_(String pROC_INST_ID_) {
		PROC_INST_ID_ = pROC_INST_ID_;
	}

	public String getACTION_() {
		return ACTION_;
	}

	public void setACTION_(String aCTION_) {
		ACTION_ = aCTION_;
	}

	public String getMESSAGE_() {
		return MESSAGE_;
	}

	public void setMESSAGE_(String mESSAGE_) {
		MESSAGE_ = mESSAGE_;
	}

	public String getFULL_MSG_() {
		return FULL_MSG_;
	}

	public void setFULL_MSG_(String fULL_MSG_) {
		FULL_MSG_ = fULL_MSG_;
	}

	public String getTXNE1() {
		return TXNE1;
	}

	public void setTXNE1(String tXNE1) {
		TXNE1 = tXNE1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
