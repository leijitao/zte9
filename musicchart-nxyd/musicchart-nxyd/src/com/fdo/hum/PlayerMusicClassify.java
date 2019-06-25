package com.fdo.hum;

/**
 * PlayerMusicClassify entity. @author MyEclipse Persistence Tools
 */

public class PlayerMusicClassify implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer playerId;
	private Integer musicId;
	private Short orderSeq;

	// Constructors

	/** default constructor */
	public PlayerMusicClassify() {
	}

	/** full constructor */
	public PlayerMusicClassify(Integer playerId, Integer musicId, Short orderSeq) {
		this.playerId = playerId;
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

	public Integer getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
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