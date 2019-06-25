package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MuiscHotActivities entity. @author MyEclipse Persistence Tools
 */

public class MuiscHotActivities implements java.io.Serializable {

	// Fields

	private Integer id;
	private String picUrl;
	private Integer orderSeq;
	private String activityName;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String jumpAddress;
	private String apkAdress;
	private Integer type;

	// Constructors

	/** default constructor */
	public MuiscHotActivities() {
	}

	/** minimal constructor */
	public MuiscHotActivities(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MuiscHotActivities(String picUrl, Integer orderSeq, String activityName, Timestamp createDateTime,
			Timestamp modifyDateTime, String jumpAddress, String apkAdress, Integer type) {
		this.picUrl = picUrl;
		this.orderSeq = orderSeq;
		this.activityName = activityName;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.jumpAddress = jumpAddress;
		this.apkAdress = apkAdress;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
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

	public String getJumpAddress() {
		return this.jumpAddress;
	}

	public void setJumpAddress(String jumpAddress) {
		this.jumpAddress = jumpAddress;
	}

	public String getApkAdress() {
		return this.apkAdress;
	}

	public void setApkAdress(String apkAdress) {
		this.apkAdress = apkAdress;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}