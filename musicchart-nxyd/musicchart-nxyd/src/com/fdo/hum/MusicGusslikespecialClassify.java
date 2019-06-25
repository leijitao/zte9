package com.fdo.hum;

/**
 * MusicGusslikespecialClassify entity. @author MyEclipse Persistence Tools
 */

public class MusicGusslikespecialClassify implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer gusslikeSpecialId;
	private Integer musicId;
	private Short orderSeq;

	// Constructors

	/** default constructor */
	public MusicGusslikespecialClassify() {
	}

	/** full constructor */
	public MusicGusslikespecialClassify(Integer gusslikeSpecialId, Integer musicId, Short orderSeq) {
		this.gusslikeSpecialId = gusslikeSpecialId;
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

	public Integer getGusslikeSpecialId() {
		return this.gusslikeSpecialId;
	}

	public void setGusslikeSpecialId(Integer gusslikeSpecialId) {
		this.gusslikeSpecialId = gusslikeSpecialId;
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