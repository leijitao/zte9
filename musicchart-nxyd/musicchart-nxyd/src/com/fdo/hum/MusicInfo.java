package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicInfo entity. @author MyEclipse Persistence Tools
 */

public class MusicInfo implements java.io.Serializable {

	// Fields

	private Integer musicId;
	private String cpId;
	private String musicName;
	private String playerName;
	private String versionCode;
	private String musicUrl;
	private String iconBigUrl;
	private Long byteSize;
	private String locationUrl;
	private String musicDesc;
	private Short online;
	private Integer dlCounter;
	private Double downloadFee;
	private Short isFree;
	private Short language;
	private Timestamp lastUpdateTime;
	private Short status;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String smallPic;
	private String bigPic;
	private String firstLetter;
	private String beginDate;
	private String endDate;
	private String typeOne;
	private String typeTwo;
	private String typeThree;
	private String contentId;
	private String musicType;
	private String musicSize;
	private String injectionNo;
	private String correlateId;
	private String cmdResult;
	private String musicLanguage;
	private String isHd;

	// Constructors

	/** default constructor */
	public MusicInfo() {
	}

	/** minimal constructor */
	public MusicInfo(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicInfo(String cpId, String musicName, String playerName, String versionCode, String musicUrl,
			String iconBigUrl, Long byteSize, String locationUrl, String musicDesc, Short online, Integer dlCounter,
			Double downloadFee, Short isFree, Short language, Timestamp lastUpdateTime, Short status,
			Timestamp createDateTime, Timestamp modifyDateTime, String smallPic, String bigPic, String firstLetter,
			String beginDate, String endDate, String typeOne, String typeTwo, String typeThree, String contentId,
			String musicType, String musicSize, String injectionNo, String correlateId, String cmdResult,
			String musicLanguage, String isHd) {
		this.cpId = cpId;
		this.musicName = musicName;
		this.playerName = playerName;
		this.versionCode = versionCode;
		this.musicUrl = musicUrl;
		this.iconBigUrl = iconBigUrl;
		this.byteSize = byteSize;
		this.locationUrl = locationUrl;
		this.musicDesc = musicDesc;
		this.online = online;
		this.dlCounter = dlCounter;
		this.downloadFee = downloadFee;
		this.isFree = isFree;
		this.language = language;
		this.lastUpdateTime = lastUpdateTime;
		this.status = status;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.smallPic = smallPic;
		this.bigPic = bigPic;
		this.firstLetter = firstLetter;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.typeOne = typeOne;
		this.typeTwo = typeTwo;
		this.typeThree = typeThree;
		this.contentId = contentId;
		this.musicType = musicType;
		this.musicSize = musicSize;
		this.injectionNo = injectionNo;
		this.correlateId = correlateId;
		this.cmdResult = cmdResult;
		this.musicLanguage = musicLanguage;
		this.isHd = isHd;
	}

	// Property accessors

	public Integer getMusicId() {
		return this.musicId;
	}

	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}

	public String getCpId() {
		return this.cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public String getMusicName() {
		return this.musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getVersionCode() {
		return this.versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getMusicUrl() {
		return this.musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getIconBigUrl() {
		return this.iconBigUrl;
	}

	public void setIconBigUrl(String iconBigUrl) {
		this.iconBigUrl = iconBigUrl;
	}

	public Long getByteSize() {
		return this.byteSize;
	}

	public void setByteSize(Long byteSize) {
		this.byteSize = byteSize;
	}

	public String getLocationUrl() {
		return this.locationUrl;
	}

	public void setLocationUrl(String locationUrl) {
		this.locationUrl = locationUrl;
	}

	public String getMusicDesc() {
		return this.musicDesc;
	}

	public void setMusicDesc(String musicDesc) {
		this.musicDesc = musicDesc;
	}

	public Short getOnline() {
		return this.online;
	}

	public void setOnline(Short online) {
		this.online = online;
	}

	public Integer getDlCounter() {
		return this.dlCounter;
	}

	public void setDlCounter(Integer dlCounter) {
		this.dlCounter = dlCounter;
	}

	public Double getDownloadFee() {
		return this.downloadFee;
	}

	public void setDownloadFee(Double downloadFee) {
		this.downloadFee = downloadFee;
	}

	public Short getIsFree() {
		return this.isFree;
	}

	public void setIsFree(Short isFree) {
		this.isFree = isFree;
	}

	public Short getLanguage() {
		return this.language;
	}

	public void setLanguage(Short language) {
		this.language = language;
	}

	public Timestamp getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
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

	public String getSmallPic() {
		return this.smallPic;
	}

	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}

	public String getBigPic() {
		return this.bigPic;
	}

	public void setBigPic(String bigPic) {
		this.bigPic = bigPic;
	}

	public String getFirstLetter() {
		return this.firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	public String getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTypeOne() {
		return this.typeOne;
	}

	public void setTypeOne(String typeOne) {
		this.typeOne = typeOne;
	}

	public String getTypeTwo() {
		return this.typeTwo;
	}

	public void setTypeTwo(String typeTwo) {
		this.typeTwo = typeTwo;
	}

	public String getTypeThree() {
		return this.typeThree;
	}

	public void setTypeThree(String typeThree) {
		this.typeThree = typeThree;
	}

	public String getContentId() {
		return this.contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getMusicType() {
		return this.musicType;
	}

	public void setMusicType(String musicType) {
		this.musicType = musicType;
	}

	public String getMusicSize() {
		return this.musicSize;
	}

	public void setMusicSize(String musicSize) {
		this.musicSize = musicSize;
	}

	public String getInjectionNo() {
		return this.injectionNo;
	}

	public void setInjectionNo(String injectionNo) {
		this.injectionNo = injectionNo;
	}

	public String getCorrelateId() {
		return this.correlateId;
	}

	public void setCorrelateId(String correlateId) {
		this.correlateId = correlateId;
	}

	public String getCmdResult() {
		return this.cmdResult;
	}

	public void setCmdResult(String cmdResult) {
		this.cmdResult = cmdResult;
	}

	public String getMusicLanguage() {
		return this.musicLanguage;
	}

	public void setMusicLanguage(String musicLanguage) {
		this.musicLanguage = musicLanguage;
	}

	public String getIsHd() {
		return this.isHd;
	}

	public void setIsHd(String isHd) {
		this.isHd = isHd;
	}

}