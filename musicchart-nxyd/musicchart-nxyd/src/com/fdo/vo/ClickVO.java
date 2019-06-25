package com.fdo.vo;

public class ClickVO {

	Integer clicks;
	Integer clickRen;
	public Integer getClicks() {
		return clicks;
	}
	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}
	public Integer getClickRen() {
		return clickRen;
	}
	public void setClickRen(Integer clickRen) {
		this.clickRen = clickRen;
	}
	public ClickVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClickVO(Integer clicks, Integer clickRen) {
		super();
		this.clicks = clicks;
		this.clickRen = clickRen;
	}
}
