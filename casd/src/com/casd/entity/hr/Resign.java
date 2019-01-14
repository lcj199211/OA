package com.casd.entity.hr;

import java.io.Serializable;

public class Resign implements Serializable {

	/**
	 *  辞职申请hr_resign
	 */
	private static final long serialVersionUID = -1359978093791375770L;
	
		private int hr_resign_id; 					//合同id 
		private int hr_resign_userid;				//申请人id
		private String hr_resign_applyDate; 		//申请时间
		private int hr_resign_category;				//类型
		private String hr_resign_schLeave;			//预定离职日期
		private String hr_resign_realLeave;			//实际离公司日期
		private String hr_resign_reason;			//原因
		private String hr_resign_dataHandover;		//资料交接
		private String hr_resign_workHandover;		//工作交接
		private String hr_resign_stationeryHandover;//文具交接
		private String hr_resign_otherHandover;		//其他事项
		private String hr_resign_hrOpinion;			//资源中心手续
		private String hr_resign_payroll;			//工资计发
		private String hr_resign_financeOthers;		//财务其他
		private String hr_resign_topOpinion;		//总经理意见
		private String hr_resign_confirmTime;		//申请人确认时间
		private String hr_resign_autoPath;			//签名路径
		private String hr_resign_sysManage;			//系统账号管理
		
		
		public int getHr_resign_id() {
			return hr_resign_id;
		}
		public void setHr_resign_id(int hr_resign_id) {
			this.hr_resign_id = hr_resign_id;
		}
		public int getHr_resign_userid() {
			return hr_resign_userid;
		}
		public void setHr_resign_userid(int hr_resign_userid) {
			this.hr_resign_userid = hr_resign_userid;
		}
		public String getHr_resign_applyDate() {
			return hr_resign_applyDate;
		}
		public void setHr_resign_applyDate(String hr_resign_applyDate) {
			this.hr_resign_applyDate = hr_resign_applyDate;
		}
		public int getHr_resign_category() {
			return hr_resign_category;
		}
		public void setHr_resign_category(int hr_resign_category) {
			this.hr_resign_category = hr_resign_category;
		}
		public String getHr_resign_schLeave() {
			return hr_resign_schLeave;
		}
		public void setHr_resign_schLeave(String hr_resign_schLeave) {
			this.hr_resign_schLeave = hr_resign_schLeave;
		}
		public String getHr_resign_realLeave() {
			return hr_resign_realLeave;
		}
		public void setHr_resign_realLeave(String hr_resign_realLeave) {
			this.hr_resign_realLeave = hr_resign_realLeave;
		}
		public String getHr_resign_reason() {
			return hr_resign_reason;
		}
		public void setHr_resign_reason(String hr_resign_reason) {
			this.hr_resign_reason = hr_resign_reason;
		}
		public String getHr_resign_dataHandover() {
			return hr_resign_dataHandover;
		}
		public void setHr_resign_dataHandover(String hr_resign_dataHandover) {
			this.hr_resign_dataHandover = hr_resign_dataHandover;
		}
		public String getHr_resign_workHandover() {
			return hr_resign_workHandover;
		}
		public void setHr_resign_workHandover(String hr_resign_workHandover) {
			this.hr_resign_workHandover = hr_resign_workHandover;
		}
		public String getHr_resign_stationeryHandover() {
			return hr_resign_stationeryHandover;
		}
		public void setHr_resign_stationeryHandover(String hr_resign_stationeryHandover) {
			this.hr_resign_stationeryHandover = hr_resign_stationeryHandover;
		}
		public String getHr_resign_otherHandover() {
			return hr_resign_otherHandover;
		}
		public void setHr_resign_otherHandover(String hr_resign_otherHandover) {
			this.hr_resign_otherHandover = hr_resign_otherHandover;
		}
		public String getHr_resign_hrOpinion() {
			return hr_resign_hrOpinion;
		}
		public void setHr_resign_hrOpinion(String hr_resign_hrOpinion) {
			this.hr_resign_hrOpinion = hr_resign_hrOpinion;
		}
		public String getHr_resign_payroll() {
			return hr_resign_payroll;
		}
		public void setHr_resign_payroll(String hr_resign_payroll) {
			this.hr_resign_payroll = hr_resign_payroll;
		}
		public String getHr_resign_financeOthers() {
			return hr_resign_financeOthers;
		}
		public void setHr_resign_financeOthers(String hr_resign_financeOthers) {
			this.hr_resign_financeOthers = hr_resign_financeOthers;
		}
		public String getHr_resign_topOpinion() {
			return hr_resign_topOpinion;
		}
		public void setHr_resign_topOpinion(String hr_resign_topOpinion) {
			this.hr_resign_topOpinion = hr_resign_topOpinion;
		}
		public String getHr_resign_confirmTime() {
			return hr_resign_confirmTime;
		}
		public void setHr_resign_confirmTime(String hr_resign_confirmTime) {
			this.hr_resign_confirmTime = hr_resign_confirmTime;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public String getHr_resign_autoPath() {
			return hr_resign_autoPath;
		}
		public void setHr_resign_autoPath(String hr_resign_autoPath) {
			this.hr_resign_autoPath = hr_resign_autoPath;
		}
		public String getHr_resign_sysManage() {
			return hr_resign_sysManage;
		}
		public void setHr_resign_sysManage(String hr_resign_sysManage) {
			this.hr_resign_sysManage = hr_resign_sysManage;
		}

		
	
}
