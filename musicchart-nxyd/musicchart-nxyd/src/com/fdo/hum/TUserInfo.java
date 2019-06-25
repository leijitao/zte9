package com.fdo.hum;

import java.sql.Timestamp;

/**
 * TUserInfo entity. @author MyEclipse Persistence Tools
 */

public class TUserInfo implements java.io.Serializable {

	// Fields

	private String userId;
	private Integer realBalance;
	private Integer virtualBalance;
	private String payPwd;
	private Integer bossId;
	private String phone;
	private String address;
	private String ipAddress;
	private String remark1;
	private String remark2;
	private String remark3;
	private String remark4;
	private String remark5;
	private String remarkDesc;
	private Integer status;
	private Timestamp createtime;
	private Timestamp updatetime;

	// Constructors

	/** default constructor */
	public TUserInfo() {
	}

	/** minimal constructor */
	public TUserInfo(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public TUserInfo(String userId, Integer realBalance, Integer virtualBalance, String payPwd, Integer bossId,
			String phone, String address, String ipAddress, String remark1, String remark2, String remark3,
			String remark4, String remark5, String remarkDesc, Integer status, Timestamp createtime,
			Timestamp updatetime) {
		this.userId = userId;
		this.realBalance = realBalance;
		this.virtualBalance = virtualBalance;
		this.payPwd = payPwd;
		this.bossId = bossId;
		this.phone = phone;
		this.address = address;
		this.ipAddress = ipAddress;
		this.remark1 = remark1;
		this.remark2 = remark2;
		this.remark3 = remark3;
		this.remark4 = remark4;
		this.remark5 = remark5;
		this.remarkDesc = remarkDesc;
		this.status = status;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getRealBalance() {
		return this.realBalance;
	}

	public void setRealBalance(Integer realBalance) {
		this.realBalance = realBalance;
	}

	public Integer getVirtualBalance() {
		return this.virtualBalance;
	}

	public void setVirtualBalance(Integer virtualBalance) {
		this.virtualBalance = virtualBalance;
	}

	public String getPayPwd() {
		return this.payPwd;
	}

	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}

	public Integer getBossId() {
		return this.bossId;
	}

	public void setBossId(Integer bossId) {
		this.bossId = bossId;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark5() {
		return this.remark5;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemarkDesc() {
		return this.remarkDesc;
	}

	public void setRemarkDesc(String remarkDesc) {
		this.remarkDesc = remarkDesc;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

}