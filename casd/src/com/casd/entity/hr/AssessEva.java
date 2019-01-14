package com.casd.entity.hr;

import java.io.Serializable;
import java.sql.Date;

/**
 *  考核内容表
 * */
public class AssessEva implements Serializable{
	
	private int evaluator_id;	//审核人id
	private String evaluator;	//评估人
	private int status;			//状态
	
	
	public int getEvaluator_id() {
		return evaluator_id;
	}
	public void setEvaluator_id(int evaluator_id) {
		this.evaluator_id = evaluator_id;
	}
	public String getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(String evaluator) {
		this.evaluator = evaluator;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
