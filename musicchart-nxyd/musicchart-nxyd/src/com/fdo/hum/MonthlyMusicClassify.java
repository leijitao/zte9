package com.fdo.hum;

/**
 * MonthlyMusicClassify entity. @author MyEclipse Persistence Tools
 */

public class MonthlyMusicClassify implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer monthlyCategoryId;
	private Integer typeCode;
	private Short orderSeq;

	// Constructors

	/** default constructor */
	public MonthlyMusicClassify() {
	}

	/** full constructor */
	public MonthlyMusicClassify(Integer monthlyCategoryId, Integer typeCode, Short orderSeq) {
		this.monthlyCategoryId = monthlyCategoryId;
		this.typeCode = typeCode;
		this.orderSeq = orderSeq;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMonthlyCategoryId() {
		return this.monthlyCategoryId;
	}

	public void setMonthlyCategoryId(Integer monthlyCategoryId) {
		this.monthlyCategoryId = monthlyCategoryId;
	}

	public Integer getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(Integer typeCode) {
		this.typeCode = typeCode;
	}

	public Short getOrderSeq() {
		return this.orderSeq;
	}

	public void setOrderSeq(Short orderSeq) {
		this.orderSeq = orderSeq;
	}

}