package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicGusslikespecial entity. @author MyEclipse Persistence Tools
 */

public class MusicGusslikespecial implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer orderSeq;
	private String picUrl;
	private String activityType;
	private String shortdesc;
	private String gusslikeSpecialName;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;

	// Constructors

	/** default constructor */
	public MusicGusslikespecial() {
	}

	/** minimal constructor */
	public MusicGusslikespecial(String activityType, Timestamp createDateTime, Timestamp modifyDateTime) {
		this.activityType = activityType;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicGusslikespecial(Integer orderSeq, String picUrl, String activityType, String shortdesc,
			String gusslikeSpecialName, Timestamp createDateTime, Timestamp modifyDateTime) {
		this.orderSeq = orderSeq;
		this.picUrl = picUrl;
		this.activityType = activityType;
		this.shortdesc = shortdesc;
		this.gusslikeSpecialName = gusslikeSpecialName;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getActivityType() {
		return this.activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getShortdesc() {
		return this.shortdesc;
	}

	public void setShortdesc(String shortdesc) {
		this.shortdesc = shortdesc;
	}

	public String getGusslikeSpecialName() {
		return this.gusslikeSpecialName;
	}

	public void setGusslikeSpecialName(String gusslikeSpecialName) {
		this.gusslikeSpecialName = gusslikeSpecialName;
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

}