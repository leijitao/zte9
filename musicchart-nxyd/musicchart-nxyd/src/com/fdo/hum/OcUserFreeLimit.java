package com.fdo.hum;

import java.sql.Timestamp;

/**
 * OcUserFreeLimit entity. @author MyEclipse Persistence Tools
 */

public class OcUserFreeLimit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String orderId;
	private String userId;
	private String prizeId;
	private String type;
	private Timestamp freeBeginTime;
	private Timestamp freeEndTime;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String statue;

	// Constructors

	/** default constructor */
	public OcUserFreeLimit() {
	}

	/** full constructor */
	public OcUserFreeLimit(String orderId, String userId, String prizeId, String type, Timestamp freeBeginTime,
			Timestamp freeEndTime, Timestamp createDateTime, Timestamp modifyDateTime, String statue) {
		this.orderId = orderId;
		this.userId = userId;
		this.prizeId = prizeId;
		this.type = type;
		this.freeBeginTime = freeBeginTime;
		this.freeEndTime = freeEndTime;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.statue = statue;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPrizeId() {
		return this.prizeId;
	}

	public void setPrizeId(String prizeId) {
		this.prizeId = prizeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getFreeBeginTime() {
		return this.freeBeginTime;
	}

	public void setFreeBeginTime(Timestamp freeBeginTime) {
		this.freeBeginTime = freeBeginTime;
	}

	public Timestamp getFreeEndTime() {
		return this.freeEndTime;
	}

	public void setFreeEndTime(Timestamp freeEndTime) {
		this.freeEndTime = freeEndTime;
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

	public String getStatue() {
		return this.statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

}