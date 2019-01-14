package com.casd.entity.manage;

import java.io.Serializable;

public class Supplierform implements Serializable {

	/**
	 *  合同管理
	 */
	private static final long serialVersionUID = -1359978093791375770L;
	
		private int supplierform_id; 				//id 
		private String supplierform_date;			//时间
		private String supplierform_loadcenter;		//上传中心
		private String supplierform_fileway;			//文件方法
		
		public int getSupplierform_id() {
			return supplierform_id;
		}
		public void setSupplierform_id(int supplierform_id) {
			this.supplierform_id = supplierform_id;
		}
		public String getSupplierform_date() {
			return supplierform_date;
		}
		public void setSupplierform_date(String supplierform_date) {
			this.supplierform_date = supplierform_date;
		}
		public String getSupplierform_loadcenter() {
			return supplierform_loadcenter;
		}
		public void setSupplierform_loadcenter(String supplierform_loadcenter) {
			this.supplierform_loadcenter = supplierform_loadcenter;
		}
		public String getSupplierform_fileway() {
			return supplierform_fileway;
		}
		public void setSupplierform_fileway(String supplierform_fileway) {
			this.supplierform_fileway = supplierform_fileway;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
	
	
}

