package com.fdo.vo;

public class ActiveVO {

	private Integer totalUser;
	private Integer activeUser;
	private Integer wpvInteger;
	private Integer wuvInteger;
	private Integer ypvInteger;
	private Integer yuvInteger;
	private String ratio;
	
	public Integer getWpvInteger() {
		return wpvInteger;
	}
	public void setWpvInteger(Integer wpvInteger) {
		this.wpvInteger = wpvInteger;
	}
	public Integer getWuvInteger() {
		return wuvInteger;
	}
	public void setWuvInteger(Integer wuvInteger) {
		this.wuvInteger = wuvInteger;
	}
	public Integer getYpvInteger() {
		return ypvInteger;
	}
	public void setYpvInteger(Integer ypvInteger) {
		this.ypvInteger = ypvInteger;
	}
	public Integer getYuvInteger() {
		return yuvInteger;
	}
	public void setYuvInteger(Integer yuvInteger) {
		this.yuvInteger = yuvInteger;
	}
	public Integer getTotalUser() {
		return totalUser;
	}
	public void setTotalUser(Integer totalUser) {
		this.totalUser = totalUser;
	}
	public Integer getActiveUser() {
		return activeUser;
	}
	public void setActiveUser(Integer activeUser) {
		this.activeUser = activeUser;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public ActiveVO(Integer totalUser, Integer activeUser, String ratio) {
		super();
		this.totalUser = totalUser;
		this.activeUser = activeUser;
		this.ratio = ratio;
	}
	public ActiveVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
