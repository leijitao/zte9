package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicCategory entity. @author MyEclipse Persistence Tools
 */

public class MusicCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String categoryName;
	private String categoryCode;
	private String icon;
	private String newImgUrl;
	private Short orderSeq;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String jumpAddress;

	// Constructors

	/** default constructor */
	public MusicCategory() {
	}

	/** minimal constructor */
	public MusicCategory(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicCategory(String categoryName, String categoryCode, String icon, String newImgUrl, Short orderSeq,
			Timestamp createDateTime, Timestamp modifyDateTime, String jumpAddress) {
		this.categoryName = categoryName;
		this.categoryCode = categoryCode;
		this.icon = icon;
		this.newImgUrl = newImgUrl;
		this.orderSeq = orderSeq;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.jumpAddress = jumpAddress;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getNewImgUrl() {
		return this.newImgUrl;
	}

	public void setNewImgUrl(String newImgUrl) {
		this.newImgUrl = newImgUrl;
	}

	public Short getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Short orderSeq) {
		this.orderSeq = orderSeq;
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

}