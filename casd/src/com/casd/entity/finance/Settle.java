package com.casd.entity.finance;

import java.io.Serializable;
import java.util.List;

/**
 * 采购付款finance_settlepay_table
 */
public class Settle implements Serializable {

	private int finance_settlepay_id; // 付款单号
	private int finance_settlepay_owe; // 欠款
	private int finance_settlepay_payed; // 已付
	private String finance_settlepay_supplier; // 供应商
	private int finance_settlepay_projectid; // 项目id
	private String finance_settlepay_paytime;//创建时间
	
	public int getFinance_settlepay_id() {
		return finance_settlepay_id;
	}
	public void setFinance_settlepay_id(int finance_settlepay_id) {
		this.finance_settlepay_id = finance_settlepay_id;
	}
	public int getFinance_settlepay_owe() {
		return finance_settlepay_owe;
	}
	public void setFinance_settlepay_owe(int finance_settlepay_owe) {
		this.finance_settlepay_owe = finance_settlepay_owe;
	}
	public int getFinance_settlepay_payed() {
		return finance_settlepay_payed;
	}
	public void setFinance_settlepay_payed(int finance_settlepay_payed) {
		this.finance_settlepay_payed = finance_settlepay_payed;
	}
	public String getFinance_settlepay_supplier() {
		return finance_settlepay_supplier;
	}
	public void setFinance_settlepay_supplier(String finance_settlepay_supplier) {
		this.finance_settlepay_supplier = finance_settlepay_supplier;
	}
	public int getFinance_settlepay_projectid() {
		return finance_settlepay_projectid;
	}
	public void setFinance_settlepay_projectid(int finance_settlepay_projectid) {
		this.finance_settlepay_projectid = finance_settlepay_projectid;
	}
	public String getFinance_settlepay_paytime() {
		return finance_settlepay_paytime;
	}
	public void setFinance_settlepay_paytime(String finance_settlepay_paytime) {
		this.finance_settlepay_paytime = finance_settlepay_paytime;
	}
	

}
