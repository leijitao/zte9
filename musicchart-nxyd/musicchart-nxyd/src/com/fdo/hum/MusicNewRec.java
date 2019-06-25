package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicNewRec entity. @author MyEclipse Persistence Tools
 */

public class MusicNewRec implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer musicId;
	private Integer orderSeq;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;

	// Constructors

	/** default constructor */
	public MusicNewRec() {
	}

	/** minimal constructor */
	public MusicNewRec(Integer musicId, Timestamp modifyDateTime) {
		this.musicId = musicId;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicNewRec(Integer musicId, Integer orderSeq, Timestamp createDateTime, Timestamp modifyDateTime) {
		this.musicId = musicId;
		this.orderSeq = orderSeq;
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

	public Integer getMusicId() {
		return this.musicId;
	}

	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}

	public Integer getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
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

}