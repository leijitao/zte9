package com.fdo.hum;

import java.sql.Timestamp;

/**
 * NewUser entity. @author MyEclipse Persistence Tools
 */

public class NewUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mac;
	private String userId;
	private Timestamp createDateTime;
	private String ip;
	private String country;
	private String province;
	private String city;
	private String licenseCpId;

	// Constructors

	/** default constructor */
	public NewUser() {
	}

	/** full constructor */
	public NewUser(String mac, String userId, Timestamp createDateTime, String ip, String country, String province,
			String city, String licenseCpId) {
		this.mac = mac;
		this.userId = userId;
		this.createDateTime = createDateTime;
		this.ip = ip;
		this.country = country;
		this.province = province;
		this.city = city;
		this.licenseCpId = licenseCpId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLicenseCpId() {
		return this.licenseCpId;
	}

	public void setLicenseCpId(String licenseCpId) {
		this.licenseCpId = licenseCpId;
	}

}