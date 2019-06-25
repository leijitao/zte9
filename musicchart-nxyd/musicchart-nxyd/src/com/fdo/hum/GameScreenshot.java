package com.fdo.hum;

import java.sql.Timestamp;

/**
 * GameScreenshot entity. @author MyEclipse Persistence Tools
 */

public class GameScreenshot implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer gameId;
	private String screenshot;
	private Integer seqNo;
	private Short status;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String memo;

	// Constructors

	/** default constructor */
	public GameScreenshot() {
	}

	/** minimal constructor */
	public GameScreenshot(Integer gameId, Timestamp modifyDateTime) {
		this.gameId = gameId;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public GameScreenshot(Integer gameId, String screenshot, Integer seqNo, Short status, Timestamp createDateTime,
			Timestamp modifyDateTime, String memo) {
		this.gameId = gameId;
		this.screenshot = screenshot;
		this.seqNo = seqNo;
		this.status = status;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.memo = memo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getScreenshot() {
		return this.screenshot;
	}

	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}

	public Integer getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
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

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}