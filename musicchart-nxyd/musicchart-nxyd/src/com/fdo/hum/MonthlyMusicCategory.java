package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MonthlyMusicCategory entity. @author MyEclipse Persistence Tools
 */

public class MonthlyMusicCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String monthlyCategoryName;
	private String spId;
	private String monthlyCategoryCode;
	private String icon;
	private String newImgUrl;
	private Short orderSeq;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String isTest;
	private String monthDesc;
	private String typeCode;

	// Constructors

	/** default constructor */
	public MonthlyMusicCategory() {
	}

	/** minimal constructor */
	public MonthlyMusicCategory(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MonthlyMusicCategory(String monthlyCategoryName, String spId, String monthlyCategoryCode, String icon,
			String newImgUrl, Short orderSeq, Timestamp createDateTime, Timestamp modifyDateTime, String isTest,
			String monthDesc, String typeCode) {
		this.monthlyCategoryName = monthlyCategoryName;
		this.spId = spId;
		this.monthlyCategoryCode = monthlyCategoryCode;
		this.icon = icon;
		this.newImgUrl = newImgUrl;
		this.orderSeq = orderSeq;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.isTest = isTest;
		this.monthDesc = monthDesc;
		this.typeCode = typeCode;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMonthlyCategoryName() {
		return this.monthlyCategoryName;
	}

	public void setMonthlyCategoryName(String monthlyCategoryName) {
		this.monthlyCategoryName = monthlyCategoryName;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getMonthlyCategoryCode() {
		return this.monthlyCategoryCode;
	}

	public void setMonthlyCategoryCode(String monthlyCategoryCode) {
		this.monthlyCategoryCode = monthlyCategoryCode;
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

	public String getIsTest() {
		return this.isTest;
	}

	public void setIsTest(String isTest) {
		this.isTest = isTest;
	}

	public String getMonthDesc() {
		return this.monthDesc;
	}

	public void setMonthDesc(String monthDesc) {
		this.monthDesc = monthDesc;
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

}