package com.fdo.hum;

import java.sql.Timestamp;

/**
 * UserMusicClassify entity. @author MyEclipse Persistence Tools
 */

public class UserMusicClassify implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private Integer musicId;
	private Timestamp createDateTime;
	private Timestamp updateDateTime;
	private Integer isuse;
	private Integer type;

	// Constructors

	/** default constructor */
	public UserMusicClassify() {
	}

	/** minimal constructor */
	public UserMusicClassify(Integer musicId) {
		this.musicId = musicId;
	}

	/** full constructor */
	public UserMusicClassify(String userId, Integer musicId, Timestamp createDateTime, Timestamp updateDateTime,
			Integer isuse, Integer type) {
		this.userId = userId;
		this.musicId = musicId;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.isuse = isuse;
		this.type = type;
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

	public Integer getMusicId() {
		return this.musicId;
	}

	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}