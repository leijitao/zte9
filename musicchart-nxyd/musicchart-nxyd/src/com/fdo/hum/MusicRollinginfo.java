package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicRollinginfo entity. @author MyEclipse Persistence Tools
 */

public class MusicRollinginfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String message;
	private String cpId;
	private Timestamp modifyDateTime;
	private Integer orderSeq;

	// Constructors

	/** default constructor */
	public MusicRollinginfo() {
	}

	/** full constructor */
	public MusicRollinginfo(String title, String message, String cpId, Timestamp modifyDateTime, Integer orderSeq) {
		this.title = title;
		this.message = message;
		this.cpId = cpId;
		this.modifyDateTime = modifyDateTime;
		this.orderSeq = orderSeq;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCpId() {
		return this.cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
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

}