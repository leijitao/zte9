package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicStay entity. @author MyEclipse Persistence Tools
 */

public class MusicStay implements java.io.Serializable {

	// Fields

	private Integer id;
	private String stayName;
	private String staydesc;
	private String musicId;
	private String picUrl;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private Integer orderSeq;
	private Integer activityType;

	// Constructors

	/** default constructor */
	public MusicStay() {
	}

	/** minimal constructor */
	public MusicStay(Timestamp createDateTime, Timestamp modifyDateTime) {
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicStay(String stayName, String staydesc, String musicId, String picUrl, Timestamp createDateTime,
			Timestamp modifyDateTime, Integer orderSeq, Integer activityType) {
		this.stayName = stayName;
		this.staydesc = staydesc;
		this.musicId = musicId;
		this.picUrl = picUrl;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.orderSeq = orderSeq;
		this.activityType = activityType;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStayName() {
		return this.stayName;
	}

	public void setStayName(String stayName) {
		this.stayName = stayName;
	}

	public String getStaydesc() {
		return this.staydesc;
	}

	public void setStaydesc(String staydesc) {
		this.staydesc = staydesc;
	}

	public String getMusicId() {
		return this.musicId;
	}

	public void setMusicId(String musicId) {
		this.musicId = musicId;
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

	public Timestamp getModifyDateTime() {
		return this.modifyDateTime;
	}

	public void setModifyDateTime(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	public Integer getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}

	public Integer getActivityType() {
		return this.activityType;
	}

	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}

}