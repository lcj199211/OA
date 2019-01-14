package com.casd.entity.hr;

import java.io.Serializable;


/**
 *用户转正申请表 
 * 
 * */
public class HrMembe implements Serializable{
	
	private int turn_id;     //转正编号
	private String turn_round;//试用期审核
	private String correction;//转正
	private String treatment;//转正待遇
	private String signature;// 部门经理签名
	private String signature_time; //部门签名时间
	private String center_opinion;//资源中心意见
	private String center_signature;//资源中心签名
	private String center_time;//资源中心签名时间
	private String manager_opinion;//总经理签名
	private String signing_Date;//总经理签名时间
	private int user_id;//用户编号
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTurn_id() {
		return turn_id;
	}
	public void setTurn_id(int turn_id) {
		this.turn_id = turn_id;
	}
	public String getTurn_round() {
		return turn_round;
	}
	public void setTurn_round(String turn_round) {
		this.turn_round = turn_round;
	}
	public String getCorrection() {
		return correction;
	}
	public void setCorrection(String correction) {
		this.correction = correction;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getSignature_time() {
		return signature_time;
	}
	public void setSignature_time(String signature_time) {
		this.signature_time = signature_time;
	}
	public String getCenter_opinion() {
		return center_opinion;
	}
	public void setCenter_opinion(String center_opinion) {
		this.center_opinion = center_opinion;
	}
	public String getCenter_signature() {
		return center_signature;
	}
	public void setCenter_signature(String center_signature) {
		this.center_signature = center_signature;
	}
	public String getCenter_time() {
		return center_time;
	}
	public void setCenter_time(String center_time) {
		this.center_time = center_time;
	}
	public String getManager_opinion() {
		return manager_opinion;
	}
	public void setManager_opinion(String manager_opinion) {
		this.manager_opinion = manager_opinion;
	}
	public String getSigning_Date() {
		return signing_Date;
	}
	public void setSigning_Date(String signing_Date) {
		this.signing_Date = signing_Date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	private String evaluate;//自我评价
	
	

}
