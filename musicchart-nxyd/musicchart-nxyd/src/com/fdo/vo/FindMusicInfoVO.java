package com.fdo.vo;

public class FindMusicInfoVO {

	private Integer musicId;
	private String musicName;
	private String playerName;
	private Integer clicks;
	private Integer clickRens;
	public Integer getMusicId() {
		return musicId;
	}
	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Integer getClicks() {
		return clicks;
	}
	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}
	public Integer getClickRens() {
		return clickRens;
	}
	public void setClickRens(Integer clickRens) {
		this.clickRens = clickRens;
	}
	public FindMusicInfoVO(Integer musicId, String musicName, String playerName, Integer clicks, Integer clickRens) {
		super();
		this.musicId = musicId;
		this.musicName = musicName;
		this.playerName = playerName;
		this.clicks = clicks;
		this.clickRens = clickRens;
	}
	public FindMusicInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
