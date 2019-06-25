package com.fdo.hum;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String loginName;
	private String password;
	private String orgId;
	private Short userType;
	private String userDesc;
	private Short userSex;
	private String birth;
	private Short status;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String cpId;
	private Set sysUserRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(String loginName, Short userType, Timestamp modifyDateTime) {
		this.loginName = loginName;
		this.userType = userType;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public SysUser(String userName, String loginName, String password, String orgId, Short userType, String userDesc,
			Short userSex, String birth, Short status, Timestamp createDateTime, Timestamp modifyDateTime, String cpId,
			Set sysUserRoles) {
		this.userName = userName;
		this.loginName = loginName;
		this.password = password;
		this.orgId = orgId;
		this.userType = userType;
		this.userDesc = userDesc;
		this.userSex = userSex;
		this.birth = birth;
		this.status = status;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.cpId = cpId;
		this.sysUserRoles = sysUserRoles;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Short getUserType() {
		return this.userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	public String getUserDesc() {
		return this.userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public Short getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Short userSex) {
		this.userSex = userSex;
	}

	public String getBirth() {
		return this.birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
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

	public String getCpId() {
		return this.cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public Set getSysUserRoles() {
		return this.sysUserRoles;
	}

	public void setSysUserRoles(Set sysUserRoles) {
		this.sysUserRoles = sysUserRoles;
	}

}