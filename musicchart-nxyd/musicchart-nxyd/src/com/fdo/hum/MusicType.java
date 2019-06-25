package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicType entity. @author MyEclipse Persistence Tools
 */

public class MusicType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typeCode;
	private String typeName;
	private String pcode;
	private String type;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private Integer orderSeq;

	// Constructors

	/** default constructor */
	public MusicType() {
	}

	/** full constructor */
	public MusicType(String typeCode, String typeName, String pcode, String type, Timestamp createDateTime,
			Timestamp modifyDateTime, Integer orderSeq) {
		this.typeCode = typeCode;
		this.typeName = typeName;
		this.pcode = pcode;
		this.type = type;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.orderSeq = orderSeq;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getPcode() {
		return this.pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Integer getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}

}