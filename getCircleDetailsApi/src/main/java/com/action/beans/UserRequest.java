package com.action.beans;

public class UserRequest {

	private String msisdn;
	private String appTid;
	private String userInterface;
	private String status;
	
	public String getUserInterface() {
		return userInterface;
	}
	public void setUserInterface(String userInterface) {
		this.userInterface = userInterface;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getAppTid() {
		return appTid;
	}
	public void setAppTid(String appTid) {
		this.appTid = appTid;
	}
	
	
}
