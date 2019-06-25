package com.fdo.hum;

/**
 * MusicPastspecialClassify entity. @author MyEclipse Persistence Tools
 */

public class MusicPastspecialClassify implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer pastSpecialId;
	private Integer musicId;
	private Short orderSeq;

	// Constructors

	/** default constructor */
	public MusicPastspecialClassify() {
	}

	/** full constructor */
	public MusicPastspecialClassify(Integer pastSpecialId, Integer musicId, Short orderSeq) {
		this.pastSpecialId = pastSpecialId;
		this.musicId = musicId;
		this.orderSeq = orderSeq;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPastSpecialId() {
		return this.pastSpecialId;
	}

	public void setPastSpecialId(Integer pastSpecialId) {
		this.pastSpecialId = pastSpecialId;
	}

	public Integer getMusicId() {
		return this.musicId;
	}

	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}

	public Short getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Short orderSeq) {
		this.orderSeq = orderSeq;
	}

}