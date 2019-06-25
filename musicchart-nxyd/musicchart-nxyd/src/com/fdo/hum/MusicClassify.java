package com.fdo.hum;

/**
 * MusicClassify entity. @author MyEclipse Persistence Tools
 */

public class MusicClassify implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer categoryId;
	private Integer musicId;
	private Short orderSeq;

	// Constructors

	/** default constructor */
	public MusicClassify() {
	}

	/** full constructor */
	public MusicClassify(Integer categoryId, Integer musicId, Short orderSeq) {
		this.categoryId = categoryId;
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

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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