package com.casd.entity.construct;

import java.io.Serializable;


/**
 *    项目部 construct_project_dep
 * */
public class ConstructDep implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6415420664462454663L;
	private int constuct_project_dep_id;				//id
	private String constuct_project_dep_name;			//名称
	private String constuct_project_dep_leader;			//项目经理
	private String constuct_project_dep_list;           //允许访问人员
	private int constuct_project_dep_company;        	//公司（1建设公司，2发展公司）
	public int getConstuct_project_dep_id() {
		return constuct_project_dep_id;
	}
	public void setConstuct_project_dep_id(int constuct_project_dep_id) {
		this.constuct_project_dep_id = constuct_project_dep_id;
	}
	public String getConstuct_project_dep_name() {
		return constuct_project_dep_name;
	}
	public void setConstuct_project_dep_name(String constuct_project_dep_name) {
		this.constuct_project_dep_name = constuct_project_dep_name;
	}
	public String getConstuct_project_dep_leader() {
		return constuct_project_dep_leader;
	}
	public void setConstuct_project_dep_leader(
			String constuct_project_dep_leader) {
		this.constuct_project_dep_leader = constuct_project_dep_leader;
	}
	public String getConstuct_project_dep_list() {
		return constuct_project_dep_list;
	}
	public void setConstuct_project_dep_list(String constuct_project_dep_list) {
		this.constuct_project_dep_list = constuct_project_dep_list;
	}
	public int getConstuct_project_dep_company() {
		return constuct_project_dep_company;
	}
	public void setConstuct_project_dep_company(int constuct_project_dep_company) {
		this.constuct_project_dep_company = constuct_project_dep_company;
	}
	

}
