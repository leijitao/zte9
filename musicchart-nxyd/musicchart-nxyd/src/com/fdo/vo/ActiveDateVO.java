package com.fdo.vo;

public class ActiveDateVO {
	
	private Integer totalUser;
	private Integer activeUser;
	private String ratio;
	private String clickDate;
	private Integer ypv;
	private Integer wpv;
	private Integer wuv;
	private Integer yuv;
	
	public Integer getYpv() {
		return ypv;
	}
	public void setYpv(Integer ypv) {
		this.ypv = ypv;
	}
	public Integer getWpv() {
		return wpv;
	}
	public void setWpv(Integer wpv) {
		this.wpv = wpv;
	}
	public Integer getWuv() {
		return wuv;
	}
	public void setWuv(Integer wuv) {
		this.wuv = wuv;
	}
	public Integer getYuv() {
		return yuv;
	}
	public void setYuv(Integer yuv) {
		this.yuv = yuv;
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
	public String getClickDate() {
		return clickDate;
	}
	public void setClickDate(String clickDate) {
		this.clickDate = clickDate;
	}
	public ActiveDateVO(Integer totalUser, Integer activeUser, String ratio, String clickDate) {
		super();
		this.totalUser = totalUser;
		this.activeUser = activeUser;
		this.ratio = ratio;
		this.clickDate = clickDate;
	}
	public ActiveDateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
