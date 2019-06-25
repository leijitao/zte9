package com.fdo.hum;

/**
 * SysRoleModuleId entity. @author MyEclipse Persistence Tools
 */

public class SysRoleModuleId implements java.io.Serializable {

	// Fields

	private SysRole sysRole;
	private SysModule sysModule;

	// Constructors

	/** default constructor */
	public SysRoleModuleId() {
	}

	/** full constructor */
	public SysRoleModuleId(SysRole sysRole, SysModule sysModule) {
		this.sysRole = sysRole;
		this.sysModule = sysModule;
	}

	// Property accessors

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public SysModule getSysModule() {
		return this.sysModule;
	}

	public void setSysModule(SysModule sysModule) {
		this.sysModule = sysModule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SysRoleModuleId))
			return false;
		SysRoleModuleId castOther = (SysRoleModuleId) other;

		return ((this.getSysRole() == castOther.getSysRole()) || (this.getSysRole() != null
				&& castOther.getSysRole() != null && this.getSysRole().equals(castOther.getSysRole())))
				&& ((this.getSysModule() == castOther.getSysModule()) || (this.getSysModule() != null
						&& castOther.getSysModule() != null && this.getSysModule().equals(castOther.getSysModule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSysRole() == null ? 0 : this.getSysRole().hashCode());
		result = 37 * result + (getSysModule() == null ? 0 : this.getSysModule().hashCode());
		return result;
	}

}