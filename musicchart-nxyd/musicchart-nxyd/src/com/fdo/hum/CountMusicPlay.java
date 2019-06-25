package com.fdo.hum;

import java.sql.Timestamp;

/**
 * CountMusicPlay entity. @author MyEclipse Persistence Tools
 */

public class CountMusicPlay implements java.io.Serializable {

	// Fields

	private Integer id;
	private String musicId;
	private String pageName;
	private String mac;
	private String userId;
	private Timestamp palyTime;
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
	public CountMusicPlay() {
	}

	/** full constructor */
	public CountMusicPlay(String musicId, String pageName, String mac, String userId, Timestamp palyTime,
			String ipAddress, String country, String province, String city, String model, String version,
			String release, String versionCode, String versionName) {
		this.musicId = musicId;
		this.pageName = pageName;
		this.mac = mac;
		this.userId = userId;
		this.palyTime = palyTime;
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

	public String getMusicId() {
		return this.musicId;
	}

	public void setMusicId(String musicId) {
		this.musicId = musicId;
	}

	public String getPageName() {
		return this.pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
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

	public Timestamp getPalyTime() {
		return this.palyTime;
	}

	public void setPalyTime(Timestamp palyTime) {
		this.palyTime = palyTime;
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