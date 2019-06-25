package com.fdo.vo;

public class UserInfoVO {

	private Integer userId;
	private String userName;
	private String loginName;
	private String cpId;
	private String cpName;
	private String date;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public UserInfoVO(String userName, String loginName, String cpId, String cpName, String date) {
		super();
		this.userName = userName;
		this.loginName = loginName;
		this.cpId = cpId;
		this.cpName = cpName;
		this.date = date;
	}
	public UserInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
