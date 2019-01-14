package com.casd.entity.manage;

import java.io.Serializable;


/***
 * manage_reqfunds 表
 * */
public class Reqfunds implements Serializable {

	/**
	 * 收款进度
	 */
	private static final long serialVersionUID = -3767021020385414183L;
	
	private int manage_reqfunds_id; 				//id 
	private int manage_reqfunds_contractId;			//合同id
	private String manage_reqfunds_time;			//请款时间
	private Double manage_reqfunds_amount;			//请款金额
	private String manage_reqfunds_ticketDate;		//开票日期
	private Double manage_reqfunds_ticketAmount;	//开票金额
	private String manage_reqfunds_receiveDate;		//收款日期
	private Double manage_reqfunds_receiveAmount;	//收款金额
	private String manage_reqfunds_remark;			//备注
	private String manage_first_party;              //甲方单位名称
	private String manage_ticket_content;           //开票内容
	private String manage_telephone;                //甲方电话
	private int manage_pay_taxes;                //纳税人类别
	private int manage_vat_category;             //增值税类别
	private String manage_credit_code;              //信用代码
	private String manage_company_address;          //公司地址
	private String manage_opening_bank;             //开户行
	private String manage_bank_account;             //银行账号
    private int  manage_status;                    //状态
    private String  manage_department;                //申请部门
	
	public int getManage_reqfunds_id() {
		return manage_reqfunds_id;
	}
	public void setManage_reqfunds_id(int manage_reqfunds_id) {
		this.manage_reqfunds_id = manage_reqfunds_id;
	}
	public int getManage_reqfunds_contractId() {
		return manage_reqfunds_contractId;
	}
	public void setManage_reqfunds_contractId(int manage_reqfunds_contractId) {
		this.manage_reqfunds_contractId = manage_reqfunds_contractId;
	}
	public String getManage_reqfunds_time() {
		return manage_reqfunds_time;
	}
	public void setManage_reqfunds_time(String manage_reqfunds_time) {
		this.manage_reqfunds_time = manage_reqfunds_time;
	}
	public Double getManage_reqfunds_amount() {
		return manage_reqfunds_amount;
	}
	public void setManage_reqfunds_amount(Double manage_reqfunds_amount) {
		this.manage_reqfunds_amount = manage_reqfunds_amount;
	}
	public String getManage_reqfunds_ticketDate() {
		return manage_reqfunds_ticketDate;
	}
	public void setManage_reqfunds_ticketDate(String manage_reqfunds_ticketDate) {
		this.manage_reqfunds_ticketDate = manage_reqfunds_ticketDate;
	}
	public Double getManage_reqfunds_ticketAmount() {
		return manage_reqfunds_ticketAmount;
	}
	public void setManage_reqfunds_ticketAmount(Double manage_reqfunds_ticketAmount) {
		this.manage_reqfunds_ticketAmount = manage_reqfunds_ticketAmount;
	}
	public String getManage_reqfunds_receiveDate() {
		return manage_reqfunds_receiveDate;
	}
	public void setManage_reqfunds_receiveDate(String manage_reqfunds_receiveDate) {
		this.manage_reqfunds_receiveDate = manage_reqfunds_receiveDate;
	}
	public Double getManage_reqfunds_receiveAmount() {
		return manage_reqfunds_receiveAmount;
	}
	public void setManage_reqfunds_receiveAmount(
			Double manage_reqfunds_receiveAmount) {
		this.manage_reqfunds_receiveAmount = manage_reqfunds_receiveAmount;
	}
	public String getManage_reqfunds_remark() {
		return manage_reqfunds_remark;
	}
	public void setManage_reqfunds_remark(String manage_reqfunds_remark) {
		this.manage_reqfunds_remark = manage_reqfunds_remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getManage_first_party() {
		return manage_first_party;
	}
	public void setManage_first_party(String manage_first_party) {
		this.manage_first_party = manage_first_party;
	}
	public String getManage_ticket_content() {
		return manage_ticket_content;
	}
	public void setManage_ticket_content(String manage_ticket_content) {
		this.manage_ticket_content = manage_ticket_content;
	}
	public String getManage_telephone() {
		return manage_telephone;
	}
	public void setManage_telephone(String manage_telephone) {
		this.manage_telephone = manage_telephone;
	}
	public int getManage_pay_taxes() {
		return manage_pay_taxes;
	}
	public void setManage_pay_taxes(int manage_pay_taxes) {
		this.manage_pay_taxes = manage_pay_taxes;
	}
	public int getManage_vat_category() {
		return manage_vat_category;
	}
	public void setManage_vat_category(int manage_vat_category) {
		this.manage_vat_category = manage_vat_category;
	}
	public String getManage_credit_code() {
		return manage_credit_code;
	}
	public void setManage_credit_code(String manage_credit_code) {
		this.manage_credit_code = manage_credit_code;
	}
	public String getManage_company_address() {
		return manage_company_address;
	}
	public void setManage_company_address(String manage_company_address) {
		this.manage_company_address = manage_company_address;
	}
	public String getManage_opening_bank() {
		return manage_opening_bank;
	}
	public void setManage_opening_bank(String manage_opening_bank) {
		this.manage_opening_bank = manage_opening_bank;
	}
	public String getManage_bank_account() {
		return manage_bank_account;
	}
	public void setManage_bank_account(String manage_bank_account) {
		this.manage_bank_account = manage_bank_account;
	}
	public int getManage_status() {
		return manage_status;
	}
	public void setManage_status(int manage_status) {
		this.manage_status = manage_status;
	}
	public String getManage_department() {
		return manage_department;
	}
	public void setManage_department(String manage_department) {
		this.manage_department = manage_department;
	}
	
}
