package com.casd.entity.ownCenter;



import java.io.Serializable;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * 绩效考核
*/
public class Seal implements Serializable {

	
	private static final long serialVersionUID = -6107028475165779440L;
	
	private int own_seal_id; 				//id 
	private String own_seal_fileName;		//文件名称
	private Double own_seal_settle;			//预结算金额
	private int own_seal_company;			//用章公司
	private String own_seal_sender;			//主送单位
	private String own_seal_chapCategory;	//用章类别
	private String own_seal_filePath;		//文件路径
	private String own_seal_remark;			//备注
	private String own_seal_creatTime;		//创建时间
	private int own_seal_status;			//状态
	private String own_user_id;             //用户编号
	
	//非持久
	private MultipartFile sealFile;	//文件

	
	public int getOwn_seal_id() {
		return own_seal_id;
	}
	public void setOwn_seal_id(int own_seal_id) {
		this.own_seal_id = own_seal_id;
	}
	public String getOwn_seal_fileName() {
		return own_seal_fileName;
	}
	public void setOwn_seal_fileName(String own_seal_fileName) {
		this.own_seal_fileName = own_seal_fileName;
	}
	public Double getOwn_seal_settle() {
		return own_seal_settle;
	}
	public void setOwn_seal_settle(Double own_seal_settle) {
		this.own_seal_settle = own_seal_settle;
	}
	public int getOwn_seal_company() {
		return own_seal_company;
	}
	public void setOwn_seal_company(int own_seal_company) {
		this.own_seal_company = own_seal_company;
	}
	public String getOwn_seal_sender() {
		return own_seal_sender;
	}
	public void setOwn_seal_sender(String own_seal_sender) {
		this.own_seal_sender = own_seal_sender;
	}
	
	public String getOwn_seal_creatTime() {
		return own_seal_creatTime;
	}
	public void setOwn_seal_creatTime(String own_seal_creatTime) {
		this.own_seal_creatTime = own_seal_creatTime;
	}
	public String getOwn_seal_remark() {
		return own_seal_remark;
	}
	public void setOwn_seal_remark(String own_seal_remark) {
		this.own_seal_remark = own_seal_remark;
	}
	public String getOwn_seal_filePath() {
		return own_seal_filePath;
	}
	public void setOwn_seal_filePath(String own_seal_filePath) {
		this.own_seal_filePath = own_seal_filePath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public MultipartFile getSealFile() {
		return sealFile;
	}
	public void setSealFile(MultipartFile sealFile) {
		this.sealFile = sealFile;
	}
	public int getOwn_seal_status() {
		return own_seal_status;
	}
	public void setOwn_seal_status(int own_seal_status) {
		this.own_seal_status = own_seal_status;
	}
	public String getOwn_seal_chapCategory() {
		return own_seal_chapCategory;
	}
	public void setOwn_seal_chapCategory(String own_seal_chapCategory) {
		this.own_seal_chapCategory = own_seal_chapCategory;
	}
	public String getOwn_user_id() {
		return own_user_id;
	}
	public void setOwn_user_id(String own_user_id) {
		this.own_user_id = own_user_id;
	}
	
	
	
	
}
