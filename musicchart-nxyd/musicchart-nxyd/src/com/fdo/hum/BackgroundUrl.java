package com.fdo.hum;

import java.sql.Timestamp;

/**
 * BackgroundUrl entity. @author MyEclipse Persistence Tools
 */

public class BackgroundUrl implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer orderSeq;
	private String picUrl;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String title;
	private String desc;

	// Constructors

	/** default constructor */
	public BackgroundUrl() {
	}

	/** minimal constructor */
	public BackgroundUrl(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public BackgroundUrl(Integer orderSeq, String picUrl, Timestamp createDateTime, Timestamp modifyDateTime,
			String title, String desc) {
		this.orderSeq = orderSeq;
		this.picUrl = picUrl;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.title = title;
		this.desc = desc;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}