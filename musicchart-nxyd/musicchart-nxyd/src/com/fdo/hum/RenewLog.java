package com.fdo.hum;

import java.sql.Timestamp;

/**
 * RenewLog entity. @author MyEclipse Persistence Tools
 */

public class RenewLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String renewMonth;
	private String unsubscribeMonth;
	private String status;
	private Timestamp createDateTime;
	private Timestamp updateDateTime;

	// Constructors

	/** default constructor */
	public RenewLog() {
	}

	/** full constructor */
	public RenewLog(String renewMonth, String unsubscribeMonth, String status, Timestamp createDateTime,
			Timestamp updateDateTime) {
		this.renewMonth = renewMonth;
		this.unsubscribeMonth = unsubscribeMonth;
		this.status = status;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRenewMonth() {
		return this.renewMonth;
	}

	public void setRenewMonth(String renewMonth) {
		this.renewMonth = renewMonth;
	}

	public String getUnsubscribeMonth() {
		return this.unsubscribeMonth;
	}

	public void setUnsubscribeMonth(String unsubscribeMonth) {
		this.unsubscribeMonth = unsubscribeMonth;
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

	public Timestamp getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}