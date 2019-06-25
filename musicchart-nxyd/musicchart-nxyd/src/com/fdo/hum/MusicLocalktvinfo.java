package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicLocalktvinfo entity. @author MyEclipse Persistence Tools
 */

public class MusicLocalktvinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ktvName;
	private String ktvDesc;
	private String needAttention;
	private String telePhone;
	private String adress;
	private String imageUrl;
	private Integer orderSeq;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;

	// Constructors

	/** default constructor */
	public MusicLocalktvinfo() {
	}

	/** minimal constructor */
	public MusicLocalktvinfo(String ktvName, Timestamp modifyDateTime) {
		this.ktvName = ktvName;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicLocalktvinfo(String ktvName, String ktvDesc, String needAttention, String telePhone, String adress,
			String imageUrl, Integer orderSeq, Timestamp createDateTime, Timestamp modifyDateTime) {
		this.ktvName = ktvName;
		this.ktvDesc = ktvDesc;
		this.needAttention = needAttention;
		this.telePhone = telePhone;
		this.adress = adress;
		this.imageUrl = imageUrl;
		this.orderSeq = orderSeq;
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

	public String getKtvName() {
		return this.ktvName;
	}

	public void setKtvName(String ktvName) {
		this.ktvName = ktvName;
	}

	public String getKtvDesc() {
		return this.ktvDesc;
	}

	public void setKtvDesc(String ktvDesc) {
		this.ktvDesc = ktvDesc;
	}

	public String getNeedAttention() {
		return this.needAttention;
	}

	public void setNeedAttention(String needAttention) {
		this.needAttention = needAttention;
	}

	public String getTelePhone() {
		return this.telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
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