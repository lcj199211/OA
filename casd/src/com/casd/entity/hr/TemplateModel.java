package com.casd.entity.hr;

import java.io.Serializable;


/**
 * 模板列表
 * hr_template_model
 * */
public class TemplateModel implements Serializable{
	
		
	private int hr_templatel_id;          //模板编号
	
	private String hr_template_name;      //模板名称
	
	private String hr_template_path;      //模板路径
	
	private String hr_templatel_describe; //描述
	
	private int hr_templatel_type;      //模板类型
	
	private String hr_templatel_time;   // 建单时间
	
	public int getHr_templatel_id() {
		return hr_templatel_id;
	}

	public void setHr_templatel_id(int hr_templatel_id) {
		this.hr_templatel_id = hr_templatel_id;
	}

	public String getHr_template_name() {
		return hr_template_name;
	}

	public void setHr_template_name(String hr_template_name) {
		this.hr_template_name = hr_template_name;
	}

	public String getHr_template_path() {
		return hr_template_path;
	}

	public void setHr_template_path(String hr_template_path) {
		this.hr_template_path = hr_template_path;
	}

	public String getHr_templatel_describe() {
		return hr_templatel_describe;
	}

	public void setHr_templatel_describe(String hr_templatel_describe) {
		this.hr_templatel_describe = hr_templatel_describe;
	}

	public int getHr_templatel_type() {
		return hr_templatel_type;
	}

	public void setHr_templatel_type(int hr_templatel_type) {
		this.hr_templatel_type = hr_templatel_type;
	}

	public String getHr_templatel_time() {
		return hr_templatel_time;
	}

	public void setHr_templatel_time(String hr_templatel_time) {
		this.hr_templatel_time = hr_templatel_time;
	}

	

}
