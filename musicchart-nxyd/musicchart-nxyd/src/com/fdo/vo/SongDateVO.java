package com.fdo.vo;

public class SongDateVO {

	private String clickDate;
	private Integer sumSong;
	private Integer newSong;
	private Integer sumClick;
	private Integer sumClickRen;
	public String getClickDate() {
		return clickDate;
	}
	public void setClickDate(String clickDate) {
		this.clickDate = clickDate;
	}
	public Integer getSumSong() {
		return sumSong;
	}
	public void setSumSong(Integer sumSong) {
		this.sumSong = sumSong;
	}
	public Integer getNewSong() {
		return newSong;
	}
	public void setNewSong(Integer newSong) {
		this.newSong = newSong;
	}
	public Integer getSumClick() {
		return sumClick;
	}
	public void setSumClick(Integer sumClick) {
		this.sumClick = sumClick;
	}
	public Integer getSumClickRen() {
		return sumClickRen;
	}
	public void setSumClickRen(Integer sumClickRen) {
		this.sumClickRen = sumClickRen;
	}
	public SongDateVO(String clickDate, Integer sumSong, Integer newSong, Integer sumClick, Integer sumClickRen) {
		super();
		this.clickDate = clickDate;
		this.sumSong = sumSong;
		this.newSong = newSong;
		this.sumClick = sumClick;
		this.sumClickRen = sumClickRen;
	}
	public SongDateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
