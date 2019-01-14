package com.casd.entity.hr;

import java.io.Serializable;
import java.sql.Date;

//职员培训记录档案表
public class Htrainingrecord implements Serializable{
	
     
	   private int id;
	   private int user_id; //培训人编号
	   private String begin_date; //开始培训时间
	   private String end_date; //培训结束时间
	   private String train_theme; //培训主题
	   private String train_mechanism;//培训机构
	   private String certifications;//所获证书
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getTrain_theme() {
		return train_theme;
	}
	public void setTrain_theme(String train_theme) {
		this.train_theme = train_theme;
	}
	public String getTrain_mechanism() {
		return train_mechanism;
	}
	public void setTrain_mechanism(String train_mechanism) {
		this.train_mechanism = train_mechanism;
	}
	public String getCertifications() {
		return certifications;
	}
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	   
	   
}