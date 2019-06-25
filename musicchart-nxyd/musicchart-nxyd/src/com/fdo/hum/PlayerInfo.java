package com.fdo.hum;

import java.sql.Timestamp;

/**
 * PlayerInfo entity. @author MyEclipse Persistence Tools
 */

public class PlayerInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String playerName;
	private String playerDesc;
	private String playerLetter;
	private Short orderSeq;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String playerAllPy;
	private String picUrl;
	private Integer sex;

	// Constructors

	/** default constructor */
	public PlayerInfo() {
	}

	/** minimal constructor */
	public PlayerInfo(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public PlayerInfo(String playerName, String playerDesc, String playerLetter, Short orderSeq,
			Timestamp createDateTime, Timestamp modifyDateTime, String playerAllPy, String picUrl, Integer sex) {
		this.playerName = playerName;
		this.playerDesc = playerDesc;
		this.playerLetter = playerLetter;
		this.orderSeq = orderSeq;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.playerAllPy = playerAllPy;
		this.picUrl = picUrl;
		this.sex = sex;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerDesc() {
		return this.playerDesc;
	}

	public void setPlayerDesc(String playerDesc) {
		this.playerDesc = playerDesc;
	}

	public String getPlayerLetter() {
		return this.playerLetter;
	}

	public void setPlayerLetter(String playerLetter) {
		this.playerLetter = playerLetter;
	}

	public Short getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Short orderSeq) {
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

	public String getPlayerAllPy() {
		return this.playerAllPy;
	}

	public void setPlayerAllPy(String playerAllPy) {
		this.playerAllPy = playerAllPy;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

}