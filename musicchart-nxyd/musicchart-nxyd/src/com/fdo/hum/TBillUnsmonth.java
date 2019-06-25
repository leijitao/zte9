package com.fdo.hum;

import java.sql.Timestamp;

/**
 * TBillUnsmonth entity. @author MyEclipse Persistence Tools
 */

public class TBillUnsmonth implements java.io.Serializable {

	// Fields

	private String orderNo;
	private String transactionId;
	private String userId;
	private String productId;
	private Integer status;
	private Integer uploadFlag;
	private String ipAddress;
	private Timestamp createTime;
	private Timestamp endTime;
	private Timestamp updateTime;
	private Double totalFee;
	private String isRenew;
	private String productName;
	private String monthlyName;
	private String monthlyNo;
	private String isParent;

	// Constructors

	/** default constructor */
	public TBillUnsmonth() {
	}

	/** minimal constructor */
	public TBillUnsmonth(String orderNo) {
		this.orderNo = orderNo;
	}

	/** full constructor */
	public TBillUnsmonth(String orderNo, String transactionId, String userId, String productId, Integer status,
			Integer uploadFlag, String ipAddress, Timestamp createTime, Timestamp endTime, Timestamp updateTime,
			Double totalFee, String isRenew, String productName, String monthlyName, String monthlyNo,
			String isParent) {
		this.orderNo = orderNo;
		this.transactionId = transactionId;
		this.userId = userId;
		this.productId = productId;
		this.status = status;
		this.uploadFlag = uploadFlag;
		this.ipAddress = ipAddress;
		this.createTime = createTime;
		this.endTime = endTime;
		this.updateTime = updateTime;
		this.totalFee = totalFee;
		this.isRenew = isRenew;
		this.productName = productName;
		this.monthlyName = monthlyName;
		this.monthlyNo = monthlyNo;
		this.isParent = isParent;
	}

	// Property accessors

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUploadFlag() {
		return this.uploadFlag;
	}

	public void setUploadFlag(Integer uploadFlag) {
		this.uploadFlag = uploadFlag;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Double getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	public String getIsRenew() {
		return this.isRenew;
	}

	public void setIsRenew(String isRenew) {
		this.isRenew = isRenew;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMonthlyName() {
		return this.monthlyName;
	}

	public void setMonthlyName(String monthlyName) {
		this.monthlyName = monthlyName;
	}

	public String getMonthlyNo() {
		return this.monthlyNo;
	}

	public void setMonthlyNo(String monthlyNo) {
		this.monthlyNo = monthlyNo;
	}

	public String getIsParent() {
		return this.isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

}