package com.fdo.hum;

import java.sql.Timestamp;

/**
 * SysLog entity. @author MyEclipse Persistence Tools
 */

public class SysLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String loginUser;
	private String content;
	private String operation;
	private Timestamp createDateTime;

	// Constructors

	/** default constructor */
	public SysLog() {
	}

	/** minimal constructor */
	public SysLog(String loginUser) {
		this.loginUser = loginUser;
	}

	/** full constructor */
	public SysLog(String loginUser, String content, String operation, Timestamp createDateTime) {
		this.loginUser = loginUser;
		this.content = content;
		this.operation = operation;
		this.createDateTime = createDateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginUser() {
		return this.loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Timestamp getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

}