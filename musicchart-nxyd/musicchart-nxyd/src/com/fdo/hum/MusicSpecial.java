package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicSpecial entity. @author MyEclipse Persistence Tools
 */

public class MusicSpecial implements java.io.Serializable {

	// Fields

	private Integer id;
	private String channelId;
	private String imageUrl;
	private String specialName;
	private String specialDesc;
	private Integer orderSeq;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;

	// Constructors

	/** default constructor */
	public MusicSpecial() {
	}

	/** minimal constructor */
	public MusicSpecial(String specialName, Timestamp modifyDateTime) {
		this.specialName = specialName;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicSpecial(String channelId, String imageUrl, String specialName, String specialDesc, Integer orderSeq,
			Timestamp createDateTime, Timestamp modifyDateTime) {
		this.channelId = channelId;
		this.imageUrl = imageUrl;
		this.specialName = specialName;
		this.specialDesc = specialDesc;
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

	public String getChannelId() {
		return this.channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSpecialName() {
		return this.specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}

	public String getSpecialDesc() {
		return this.specialDesc;
	}

	public void setSpecialDesc(String specialDesc) {
		this.specialDesc = specialDesc;
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