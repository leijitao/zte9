package com.fdo.hum;

import java.sql.Timestamp;

/**
 * AppBlacklist entity. @author MyEclipse Persistence Tools
 */

public class AppBlacklist implements java.io.Serializable {

	// Fields

	private Integer id;
	private String packageName;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;

	// Constructors

	/** default constructor */
	public AppBlacklist() {
	}

	/** minimal constructor */
	public AppBlacklist(String packageName, Timestamp modifyDateTime) {
		this.packageName = packageName;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public AppBlacklist(String packageName, Timestamp createDateTime, Timestamp modifyDateTime) {
		this.packageName = packageName;
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

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
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