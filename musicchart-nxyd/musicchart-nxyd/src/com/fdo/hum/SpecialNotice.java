package com.fdo.hum;

import java.sql.Timestamp;

/**
 * SpecialNotice entity. @author MyEclipse Persistence Tools
 */

public class SpecialNotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private String imageUrl;
	private Integer orderSeq;
	private String memo;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String title;
	private String cpId;

	// Constructors

	/** default constructor */
	public SpecialNotice() {
	}

	/** minimal constructor */
	public SpecialNotice(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public SpecialNotice(String imageUrl, Integer orderSeq, String memo, Timestamp createDateTime,
			Timestamp modifyDateTime, String title, String cpId) {
		this.imageUrl = imageUrl;
		this.orderSeq = orderSeq;
		this.memo = memo;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.title = title;
		this.cpId = cpId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCpId() {
		return this.cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

}