package com.fdo.hum;

import java.sql.Timestamp;

/**
 * CountMusicRec entity. @author MyEclipse Persistence Tools
 */

public class CountMusicRec implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private Integer recommdId;
	private String mac;
	private Timestamp recClickTime;
	private String pageName;
	private String ipAddress;
	private String country;
	private String province;
	private String city;
	private String model;
	private String version;
	private String release;
	private String versionCode;
	private String versionName;

	// Constructors

	/** default constructor */
	public CountMusicRec() {
	}

	/** full constructor */
	public CountMusicRec(String userId, Integer recommdId, String mac, Timestamp recClickTime, String pageName,
			String ipAddress, String country, String province, String city, String model, String version,
			String release, String versionCode, String versionName) {
		this.userId = userId;
		this.recommdId = recommdId;
		this.mac = mac;
		this.recClickTime = recClickTime;
		this.pageName = pageName;
		this.ipAddress = ipAddress;
		this.country = country;
		this.province = province;
		this.city = city;
		this.model = model;
		this.version = version;
		this.release = release;
		this.versionCode = versionCode;
		this.versionName = versionName;
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

	public Integer getRecommdId() {
		return this.recommdId;
	}

	public void setRecommdId(Integer recommdId) {
		this.recommdId = recommdId;
	}

	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Timestamp getRecClickTime() {
		return this.recClickTime;
	}

	public void setRecClickTime(Timestamp recClickTime) {
		this.recClickTime = recClickTime;
	}

	public String getPageName() {
		return this.pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
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

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRelease() {
		return this.release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getVersionCode() {
		return this.versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return this.versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

}