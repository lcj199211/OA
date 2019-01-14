package com.casd.entity.flow;

import java.io.Serializable;
import java.util.List;

public class FlowLink implements Serializable {

	
	private int flow_link_id; 				//流程链id 
	private int flow_link_parentid;			//流程名
	private String flow_link_name;			//流程链名
	private int flow_link_present_nodeid;	//当前节点
	public int getFlow_link_id() {
		return flow_link_id;
	}
	public void setFlow_link_id(int flow_link_id) {
		this.flow_link_id = flow_link_id;
	}
	public int getFlow_link_parentid() {
		return flow_link_parentid;
	}
	public void setFlow_link_parentid(int flow_link_parentid) {
		this.flow_link_parentid = flow_link_parentid;
	}
	public String getFlow_link_name() {
		return flow_link_name;
	}
	public void setFlow_link_name(String flow_link_name) {
		this.flow_link_name = flow_link_name;
	}
	public int getFlow_link_present_nodeid() {
		return flow_link_present_nodeid;
	}
	public void setFlow_link_present_nodeid(int flow_link_present_nodeid) {
		this.flow_link_present_nodeid = flow_link_present_nodeid;
	}
	
}
