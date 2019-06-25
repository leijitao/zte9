package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicDlcount entity. @author MyEclipse Persistence Tools
 */

public class MusicDlcount implements java.io.Serializable {

	// Fields

	private Integer id;
	private String musicName;
	private Integer downloadCount;
	private Timestamp modifyDateTime;
	private Integer xiezaiCount;

	// Constructors

	/** default constructor */
	public MusicDlcount() {
	}

	/** minimal constructor */
	public MusicDlcount(String musicName, Timestamp modifyDateTime) {
		this.musicName = musicName;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicDlcount(String musicName, Integer downloadCount, Timestamp modifyDateTime, Integer xiezaiCount) {
		this.musicName = musicName;
		this.downloadCount = downloadCount;
		this.modifyDateTime = modifyDateTime;
		this.xiezaiCount = xiezaiCount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMusicName() {
		return this.musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public Integer getDownloadCount() {
		return this.downloadCount;
	}

	public void setDownloadCount(Integer downloadCount) {
		this.downloadCount = downloadCount;
	}

	public Timestamp getModifyDateTime() {
		return this.modifyDateTime;
	}

	public void setModifyDateTime(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	public Integer getXiezaiCount() {
		return this.xiezaiCount;
	}

	public void setXiezaiCount(Integer xiezaiCount) {
		this.xiezaiCount = xiezaiCount;
	}

}