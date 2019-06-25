package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicTypeClassify entity. @author MyEclipse Persistence Tools
 */

public class MusicTypeClassify implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typeCode;
	private Integer musicId;
	private Short orderSeq;
	private Integer activityType;
	private String picUrl;
	private Timestamp createDateTime;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public MusicTypeClassify() {
	}

	/** minimal constructor */
	public MusicTypeClassify(Integer musicId) {
		this.musicId = musicId;
	}

	/** full constructor */
	public MusicTypeClassify(String typeCode, Integer musicId, Short orderSeq, Integer activityType, String picUrl,
			Timestamp createDateTime, Timestamp updateTime) {
		this.typeCode = typeCode;
		this.musicId = musicId;
		this.orderSeq = orderSeq;
		this.activityType = activityType;
		this.picUrl = picUrl;
		this.createDateTime = createDateTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Integer getMusicId() {
		return this.musicId;
	}

	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}

	public Short getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Short orderSeq) {
		this.orderSeq = orderSeq;
	}

	public Integer getActivityType() {
		return this.activityType;
	}

	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Timestamp getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}