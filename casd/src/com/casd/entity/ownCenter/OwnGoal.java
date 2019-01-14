package com.casd.entity.ownCenter;

import java.io.Serializable;
import java.sql.Date;

import org.activiti.engine.task.Task;

/**
 * 	own_goal 表格
 * */
public class OwnGoal implements Serializable{
	/**
	 *  目标
	 */
	private static final long serialVersionUID = -2802253403377324022L;
	private int own_goal_id;             	//单据编号
	private int own_goal_userId;    		//工作分类
	private String own_goal_userName;       //工作内容
	private int own_goal_type;      		//指令人
	private String own_goal_year;      		//主办人
	private String own_goal_details;      	//协办人
	private String own_goal_creatTime;      //目前情况
	private String own_goal_finishTime;     //反馈问题
	private int own_goal_isFinish;      	//状态
	
	public int getOwn_goal_id() {
		return own_goal_id;
	}
	public void setOwn_goal_id(int own_goal_id) {
		this.own_goal_id = own_goal_id;
	}
	public int getOwn_goal_userId() {
		return own_goal_userId;
	}
	public void setOwn_goal_userId(int own_goal_userId) {
		this.own_goal_userId = own_goal_userId;
	}
	public String getOwn_goal_userName() {
		return own_goal_userName;
	}
	public void setOwn_goal_userName(String own_goal_userName) {
		this.own_goal_userName = own_goal_userName;
	}
	public int getOwn_goal_type() {
		return own_goal_type;
	}
	public void setOwn_goal_type(int own_goal_type) {
		this.own_goal_type = own_goal_type;
	}
	public String getOwn_goal_year() {
		return own_goal_year;
	}
	public void setOwn_goal_year(String own_goal_year) {
		this.own_goal_year = own_goal_year;
	}
	public String getOwn_goal_details() {
		return own_goal_details;
	}
	public void setOwn_goal_details(String own_goal_details) {
		this.own_goal_details = own_goal_details;
	}
	public String getOwn_goal_creatTime() {
		return own_goal_creatTime;
	}
	public void setOwn_goal_creatTime(String own_goal_creatTime) {
		this.own_goal_creatTime = own_goal_creatTime;
	}
	public String getOwn_goal_finishTime() {
		return own_goal_finishTime;
	}
	public void setOwn_goal_finishTime(String own_goal_finishTime) {
		this.own_goal_finishTime = own_goal_finishTime;
	}
	public int getOwn_goal_isFinish() {
		return own_goal_isFinish;
	}
	public void setOwn_goal_isFinish(int own_goal_isFinish) {
		this.own_goal_isFinish = own_goal_isFinish;
	}
	


}
