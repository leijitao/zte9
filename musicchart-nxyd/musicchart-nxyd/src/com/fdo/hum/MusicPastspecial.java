package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicPastspecial entity. @author MyEclipse Persistence Tools
 */

public class MusicPastspecial implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer orderSeq;
	private String picUrl;
	private String activityType;
	private String shortdesc;
	private String pastSpecialName;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;

	// Constructors

	/** default constructor */
	public MusicPastspecial() {
	}

	/** minimal constructor */
	public MusicPastspecial(String activityType, Timestamp createDateTime, Timestamp modifyDateTime) {
		this.activityType = activityType;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicPastspecial(Integer orderSeq, String picUrl, String activityType, String shortdesc,
			String pastSpecialName, Timestamp createDateTime, Timestamp modifyDateTime) {
		this.orderSeq = orderSeq;
		this.picUrl = picUrl;
		this.activityType = activityType;
		this.shortdesc = shortdesc;
		this.pastSpecialName = pastSpecialName;
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

	public String getPastSpecialName() {
		return this.pastSpecialName;
	}

	public void setPastSpecialName(String pastSpecialName) {
		this.pastSpecialName = pastSpecialName;
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