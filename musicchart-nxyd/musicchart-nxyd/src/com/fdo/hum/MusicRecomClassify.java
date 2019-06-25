package com.fdo.hum;

/**
 * MusicRecomClassify entity. @author MyEclipse Persistence Tools
 */

public class MusicRecomClassify implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer recomId;
	private Integer musicId;
	private Short orderSeq;

	// Constructors

	/** default constructor */
	public MusicRecomClassify() {
	}

	/** full constructor */
	public MusicRecomClassify(Integer recomId, Integer musicId, Short orderSeq) {
		this.recomId = recomId;
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

	public Integer getRecomId() {
		return this.recomId;
	}

	public void setRecomId(Integer recomId) {
		this.recomId = recomId;
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