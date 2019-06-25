package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MuiscActivities entity. @author MyEclipse Persistence Tools
 */

public class MuiscActivities implements java.io.Serializable {

	// Fields

	private Integer id;
	private String viodeoUrl;
	private Integer orderSeq;
	private String memo;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String jumpAddress;

	// Constructors

	/** default constructor */
	public MuiscActivities() {
	}

	/** minimal constructor */
	public MuiscActivities(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MuiscActivities(String viodeoUrl, Integer orderSeq, String memo, Timestamp createDateTime,
			Timestamp modifyDateTime, String jumpAddress) {
		this.viodeoUrl = viodeoUrl;
		this.orderSeq = orderSeq;
		this.memo = memo;
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

	public String getViodeoUrl() {
		return this.viodeoUrl;
	}

	public void setViodeoUrl(String viodeoUrl) {
		this.viodeoUrl = viodeoUrl;
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

	public String getJumpAddress() {
		return this.jumpAddress;
	}

	public void setJumpAddress(String jumpAddress) {
		this.jumpAddress = jumpAddress;
	}

}