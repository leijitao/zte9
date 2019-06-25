package com.fdo.hum;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private Integer roleLevel;
	private String roleDesc;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private Set sysRoleModules = new HashSet(0);
	private Set sysUserRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(String roleName, Integer roleLevel, Timestamp modifyDateTime) {
		this.roleName = roleName;
		this.roleLevel = roleLevel;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public SysRole(String roleName, Integer roleLevel, String roleDesc, Timestamp createDateTime,
			Timestamp modifyDateTime, Set sysRoleModules, Set sysUserRoles) {
		this.roleName = roleName;
		this.roleLevel = roleLevel;
		this.roleDesc = roleDesc;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.sysRoleModules = sysRoleModules;
		this.sysUserRoles = sysUserRoles;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleLevel() {
		return this.roleLevel;
	}

	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
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

	public Set getSysRoleModules() {
		return this.sysRoleModules;
	}

	public void setSysRoleModules(Set sysRoleModules) {
		this.sysRoleModules = sysRoleModules;
	}

	public Set getSysUserRoles() {
		return this.sysUserRoles;
	}

	public void setSysUserRoles(Set sysUserRoles) {
		this.sysUserRoles = sysUserRoles;
	}

}