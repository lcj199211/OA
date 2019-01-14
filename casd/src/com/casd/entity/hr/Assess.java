package com.casd.entity.hr;

import java.io.Serializable;
import java.sql.Date;

/**
 *  考核内容表
 * */
public class Assess implements Serializable{
	
	private int assess_id;				//考核id
	private String assess_content;		//评估内容
	private int assess_grade;			//内容项总分
	private String assess_deduct;       //扣分情况
	private int assess_score;			//得分
	private String assess_category;		//分类
	public int getAssess_id() {
		return assess_id;
	}
	public void setAssess_id(int assess_id) {
		this.assess_id = assess_id;
	}
	public String getAssess_content() {
		return assess_content;
	}
	public void setAssess_content(String assess_content) {
		this.assess_content = assess_content;
	}
	public int getAssess_grade() {
		return assess_grade;
	}
	public void setAssess_grade(int assess_grade) {
		this.assess_grade = assess_grade;
	}
	public String getAssess_deduct() {
		return assess_deduct;
	}
	public void setAssess_deduct(String assess_deduct) {
		this.assess_deduct = assess_deduct;
	}
	public int getAssess_score() {
		return assess_score;
	}
	public void setAssess_score(int assess_score) {
		this.assess_score = assess_score;
	}
	public String getAssess_category() {
		return assess_category;
	}
	public void setAssess_category(String assess_category) {
		this.assess_category = assess_category;
	}

}
