package com.fdo.hum;

import java.sql.Timestamp;

/**
 * TBillMonthLog entity. @author MyEclipse Persistence Tools
 */

public class TBillMonthLog implements java.io.Serializable {

	// Fields

	private String orderNo;
	private String userId;
	private Double totalFee;
	private Integer status;
	private String ipAddress;
	private Timestamp createTime;
	private Timestamp endTime;
	private Timestamp updateTime;
	private String transactionId;
	private String isRenew;
	private String productId;
	private String productName;
	private String spId;
	private String monthlyName;
	private String monthlyNo;
	private String description;
	private String isParent;

	// Constructors

	/** default constructor */
	public TBillMonthLog() {
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	/** minimal constructor */
	public TBillMonthLog(String orderNo) {
		this.orderNo = orderNo;
	}

	/** full constructor */
	public TBillMonthLog(String orderNo, String userId, Double totalFee, Integer status, String ipAddress,
			Timestamp createTime, Timestamp endTime, Timestamp updateTime, String transactionId, String isRenew,
			String productId, String productName, String spId, String monthlyName, String monthlyNo) {
		this.orderNo = orderNo;
		this.userId = userId;
		this.totalFee = totalFee;
		this.status = status;
		this.ipAddress = ipAddress;
		this.createTime = createTime;
		this.endTime = endTime;
		this.updateTime = updateTime;
		this.transactionId = transactionId;
		this.isRenew = isRenew;
		this.productId = productId;
		this.productName = productName;
		this.spId = spId;
		this.monthlyName = monthlyName;
		this.monthlyNo = monthlyNo;
	}

	// Property accessors

	public String getOrderNo() {
		return this.orderNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getIsRenew() {
		return this.isRenew;
	}

	public void setIsRenew(String isRenew) {
		this.isRenew = isRenew;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
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

}