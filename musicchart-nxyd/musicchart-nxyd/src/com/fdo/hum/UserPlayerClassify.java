package com.fdo.hum;

import java.sql.Timestamp;

/**
 * UserPlayerClassify entity. @author MyEclipse Persistence Tools
 */

public class UserPlayerClassify implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private Integer playerId;
	private Timestamp createDateTime;
	private Timestamp updateDateTime;
	private Integer isuse;

	// Constructors

	/** default constructor */
	public UserPlayerClassify() {
	}

	/** minimal constructor */
	public UserPlayerClassify(Integer playerId) {
		this.playerId = playerId;
	}

	/** full constructor */
	public UserPlayerClassify(String userId, Integer playerId, Timestamp createDateTime, Timestamp updateDateTime,
			Integer isuse) {
		this.userId = userId;
		this.playerId = playerId;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.isuse = isuse;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Timestamp getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Timestamp getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Integer getIsuse() {
		return this.isuse;
	}

	public void setIsuse(Integer isuse) {
		this.isuse = isuse;
	}

}