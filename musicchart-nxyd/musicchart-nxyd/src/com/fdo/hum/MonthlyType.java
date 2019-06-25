package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MonthlyType entity. @author MyEclipse Persistence Tools
 */

public class MonthlyType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String imageUrl;
	private Integer orderSeq;
	private String memo1;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String title;
	private String memo2;
	private String price;
	private String dayNum;
	private String monthlyCategoryId;
	private String productId;

	// Constructors

	/** default constructor */
	public MonthlyType() {
	}

	/** minimal constructor */
	public MonthlyType(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MonthlyType(String imageUrl, Integer orderSeq, String memo1, Timestamp createDateTime,
			Timestamp modifyDateTime, String title, String memo2, String price, String dayNum, String monthlyCategoryId,
			String productId) {
		this.imageUrl = imageUrl;
		this.orderSeq = orderSeq;
		this.memo1 = memo1;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.title = title;
		this.memo2 = memo2;
		this.price = price;
		this.dayNum = dayNum;
		this.monthlyCategoryId = monthlyCategoryId;
		this.productId = productId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getMemo1() {
		return this.memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemo2() {
		return this.memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDayNum() {
		return this.dayNum;
	}

	public void setDayNum(String dayNum) {
		this.dayNum = dayNum;
	}

	public String getMonthlyCategoryId() {
		return this.monthlyCategoryId;
	}

	public void setMonthlyCategoryId(String monthlyCategoryId) {
		this.monthlyCategoryId = monthlyCategoryId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}