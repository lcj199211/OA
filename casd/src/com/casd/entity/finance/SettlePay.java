package com.casd.entity.finance;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 采购付款finance_settlepay_payNum
 */
public class SettlePay implements Serializable {

	private int finance_settlepay_payNum_id; //付款次数id
	private int finance_settlepay_purNum_parentid; // 付款id
	private String finance_settlepay_purNum_date; // 时间
	private double finance_settlepay_purNum_payable; // 应付
	private double finance_settlepay_purNum_nowpay; // 本次付款
	private double finance_settlepay_purNum_payed; // 累计付款
	private double finance_settlepay_purNum_owe; // 未付
	private int finance_settlepay_purNum_status; //付款状态
	private int finance_settlepay_purNum_paytype; //付款类型
	private int finance_settlepay_purNum_paypercent; //付款百分比
	
	public int getFinance_settlepay_purNum_parentid() {
		return finance_settlepay_purNum_parentid;
	}
	public void setFinance_settlepay_purNum_parentid(
			int finance_settlepay_purNum_parentid) {
		this.finance_settlepay_purNum_parentid = finance_settlepay_purNum_parentid;
	}
	
	public void setFinance_settlepay_purNum_nowpay(
			int finance_settlepay_purNum_nowpay) {
		this.finance_settlepay_purNum_nowpay = finance_settlepay_purNum_nowpay;
	}
	public double getFinance_settlepay_purNum_payed() {
		return finance_settlepay_purNum_payed;
	}
	public void setFinance_settlepay_purNum_payed(
			double finance_settlepay_purNum_payed) {
		this.finance_settlepay_purNum_payed = finance_settlepay_purNum_payed;
	}
	public double getFinance_settlepay_purNum_owe() {
		return finance_settlepay_purNum_owe;
	}
	public void setFinance_settlepay_purNum_owe(double finance_settlepay_purNum_owe) {
		this.finance_settlepay_purNum_owe = finance_settlepay_purNum_owe;
	}
	public double getFinance_settlepay_purNum_nowpay() {
		return finance_settlepay_purNum_nowpay;
	}
	public void setFinance_settlepay_purNum_nowpay(
			double finance_settlepay_purNum_nowpay) {
		this.finance_settlepay_purNum_nowpay = finance_settlepay_purNum_nowpay;
	}
	public double getFinance_settlepay_purNum_payable() {
		return finance_settlepay_purNum_payable;
	}
	public void setFinance_settlepay_purNum_payable(
			double finance_settlepay_purNum_payable) {
		this.finance_settlepay_purNum_payable = finance_settlepay_purNum_payable;
	}
	public String getFinance_settlepay_purNum_date() {
		return finance_settlepay_purNum_date;
	}
	public void setFinance_settlepay_purNum_date(
			String finance_settlepay_purNum_date) {
		this.finance_settlepay_purNum_date = finance_settlepay_purNum_date;
	}
	public int getFinance_settlepay_purNum_status() {
		return finance_settlepay_purNum_status;
	}
	public void setFinance_settlepay_purNum_status(
			int finance_settlepay_purNum_status) {
		this.finance_settlepay_purNum_status = finance_settlepay_purNum_status;
	}
	public int getFinance_settlepay_payNum_id() {
		return finance_settlepay_payNum_id;
	}
	public void setFinance_settlepay_payNum_id(int finance_settlepay_payNum_id) {
		this.finance_settlepay_payNum_id = finance_settlepay_payNum_id;
	}
	public int getFinance_settlepay_purNum_paytype() {
		return finance_settlepay_purNum_paytype;
	}
	public void setFinance_settlepay_purNum_paytype(
			int finance_settlepay_purNum_paytype) {
		this.finance_settlepay_purNum_paytype = finance_settlepay_purNum_paytype;
	}
	public int getFinance_settlepay_purNum_paypercent() {
		return finance_settlepay_purNum_paypercent;
	}
	public void setFinance_settlepay_purNum_paypercent(
			int finance_settlepay_purNum_paypercent) {
		this.finance_settlepay_purNum_paypercent = finance_settlepay_purNum_paypercent;
	}

	

}
