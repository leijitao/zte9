package com.fdo.vo;

import java.sql.Timestamp;

public class ClickDateVO {

	private Integer clicks;
	private Integer clickRen;
	private String clickDate;

	public String getClickDate() {
		return clickDate;
	}
	public void setClickDate(String clickDate) {
		this.clickDate = clickDate;
	}
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
	public ClickDateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClickDateVO(Integer clicks, Integer clickRen, String clickDate) {
		super();
		this.clicks = clicks;
		this.clickRen = clickRen;
		this.clickDate = clickDate;
	}
}
