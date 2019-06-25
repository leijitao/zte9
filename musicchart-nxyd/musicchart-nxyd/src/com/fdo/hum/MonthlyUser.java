package com.fdo.hum;

/**
 * MonthlyUser entity. @author MyEclipse Persistence Tools
 */

public class MonthlyUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private String productName;
	private String createDateTime;
	private String licenseCpId;

	// Constructors

	/** default constructor */
	public MonthlyUser() {
	}

	/** full constructor */
	public MonthlyUser(String userId, String productName, String createDateTime, String licenseCpId) {
		this.userId = userId;
		this.productName = productName;
		this.createDateTime = createDateTime;
		this.licenseCpId = licenseCpId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getLicenseCpId() {
		return this.licenseCpId;
	}

	public void setLicenseCpId(String licenseCpId) {
		this.licenseCpId = licenseCpId;
	}

}