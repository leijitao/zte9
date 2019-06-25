package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicMv entity. @author MyEclipse Persistence Tools
 */

public class MusicMv implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer musicId;
	private Integer orderSeq;
	private String picUrl;
	private String videoUrl;
	private Timestamp modifyDateTime;
	private String activityType;
	private Timestamp createDateTime;
	private String shortdesc;
	private String specialName;

	// Constructors

	/** default constructor */
	public MusicMv() {
	}

	/** minimal constructor */
	public MusicMv(Integer musicId, Timestamp modifyDateTime) {
		this.musicId = musicId;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicMv(Integer musicId, Integer orderSeq, String picUrl, String videoUrl, Timestamp modifyDateTime,
			String activityType, Timestamp createDateTime, String shortdesc, String specialName) {
		this.musicId = musicId;
		this.orderSeq = orderSeq;
		this.picUrl = picUrl;
		this.videoUrl = videoUrl;
		this.modifyDateTime = modifyDateTime;
		this.activityType = activityType;
		this.createDateTime = createDateTime;
		this.shortdesc = shortdesc;
		this.specialName = specialName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMusicId() {
		return this.musicId;
	}

	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}

	public Integer getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Timestamp getModifyDateTime() {
		return this.modifyDateTime;
	}

	public void setModifyDateTime(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	public String getActivityType() {
		return this.activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public Timestamp getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getShortdesc() {
		return this.shortdesc;
	}

	public void setShortdesc(String shortdesc) {
		this.shortdesc = shortdesc;
	}

	public String getSpecialName() {
		return this.specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}

}