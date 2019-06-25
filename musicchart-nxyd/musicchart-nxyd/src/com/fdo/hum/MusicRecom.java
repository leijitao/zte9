package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicRecom entity. @author MyEclipse Persistence Tools
 */

public class MusicRecom implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typeCode;
	private Integer orderSeq;
	private String picUrl;
	private String backPicUrl;
	private String videoUrl;
	private String activityType;
	private String cpId;
	private String shortdesc;
	private String specialName;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String musicId;
	private String jumpTypeCode;
	private String onwClassName;

	// Constructors

	/** default constructor */
	public MusicRecom() {
	}

	/** minimal constructor */
	public MusicRecom(String typeCode, String activityType, Timestamp createDateTime, Timestamp modifyDateTime) {
		this.typeCode = typeCode;
		this.activityType = activityType;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicRecom(String typeCode, Integer orderSeq, String picUrl, String backPicUrl, String videoUrl,
			String activityType, String cpId, String shortdesc, String specialName, Timestamp createDateTime,
			Timestamp modifyDateTime, String musicId, String jumpTypeCode, String onwClassName) {
		this.typeCode = typeCode;
		this.orderSeq = orderSeq;
		this.picUrl = picUrl;
		this.backPicUrl = backPicUrl;
		this.videoUrl = videoUrl;
		this.activityType = activityType;
		this.cpId = cpId;
		this.shortdesc = shortdesc;
		this.specialName = specialName;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.musicId = musicId;
		this.jumpTypeCode = jumpTypeCode;
		this.onwClassName = onwClassName;
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

	public String getBackPicUrl() {
		return this.backPicUrl;
	}

	public void setBackPicUrl(String backPicUrl) {
		this.backPicUrl = backPicUrl;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getActivityType() {
		return this.activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getCpId() {
		return this.cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
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

	public Timestamp getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Timestamp getModifyDateTime() {
		return this.modifyDateTime;
	}

	public void setModifyDateTime(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	public String getMusicId() {
		return this.musicId;
	}

	public void setMusicId(String musicId) {
		this.musicId = musicId;
	}

	public String getJumpTypeCode() {
		return this.jumpTypeCode;
	}

	public void setJumpTypeCode(String jumpTypeCode) {
		this.jumpTypeCode = jumpTypeCode;
	}

	public String getOnwClassName() {
		return this.onwClassName;
	}

	public void setOnwClassName(String onwClassName) {
		this.onwClassName = onwClassName;
	}

}