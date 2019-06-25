package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicCp entity. @author MyEclipse Persistence Tools
 */

public class MusicCp implements java.io.Serializable {

	// Fields

	private Integer id;
	private String cpId;
	private String cpName;
	private String memo;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String packageNames;
	private String classNames;

	// Constructors

	/** default constructor */
	public MusicCp() {
	}

	/** minimal constructor */
	public MusicCp(String cpId, Timestamp modifyDateTime) {
		this.cpId = cpId;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicCp(String cpId, String cpName, String memo, Timestamp createDateTime, Timestamp modifyDateTime,
			String packageNames, String classNames) {
		this.cpId = cpId;
		this.cpName = cpName;
		this.memo = memo;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.packageNames = packageNames;
		this.classNames = classNames;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpId() {
		return this.cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public String getCpName() {
		return this.cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public String getPackageNames() {
		return this.packageNames;
	}

	public void setPackageNames(String packageNames) {
		this.packageNames = packageNames;
	}

	public String getClassNames() {
		return this.classNames;
	}

	public void setClassNames(String classNames) {
		this.classNames = classNames;
	}

}