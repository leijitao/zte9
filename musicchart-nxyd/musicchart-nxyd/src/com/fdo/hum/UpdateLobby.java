package com.fdo.hum;

import java.sql.Timestamp;

/**
 * UpdateLobby entity. @author MyEclipse Persistence Tools
 */

public class UpdateLobby implements java.io.Serializable {

	// Fields

	private Integer id;
	private String packageName;
	private Integer versionCode;
	private String appByteSize;
	private String appSize;
	private String downloadUrl;
	private String instructions;
	private String status;
	private Timestamp createDateTime;
	private Integer orderSeq;

	// Constructors

	/** default constructor */
	public UpdateLobby() {
	}

	/** full constructor */
	public UpdateLobby(String packageName, Integer versionCode, String appByteSize, String appSize, String downloadUrl,
			String instructions, String status, Timestamp createDateTime, Integer orderSeq) {
		this.packageName = packageName;
		this.versionCode = versionCode;
		this.appByteSize = appByteSize;
		this.appSize = appSize;
		this.downloadUrl = downloadUrl;
		this.instructions = instructions;
		this.status = status;
		this.createDateTime = createDateTime;
		this.orderSeq = orderSeq;
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

	public Integer getVersionCode() {
		return this.versionCode;
	}

	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}

	public String getAppByteSize() {
		return this.appByteSize;
	}

	public void setAppByteSize(String appByteSize) {
		this.appByteSize = appByteSize;
	}

	public String getAppSize() {
		return this.appSize;
	}

	public void setAppSize(String appSize) {
		this.appSize = appSize;
	}

	public String getDownloadUrl() {
		return this.downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getInstructions() {
		return this.instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Integer getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}

}