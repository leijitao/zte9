package com.fdo.hum;

/**
 * SysRoleModule entity. @author MyEclipse Persistence Tools
 */

public class SysRoleModule implements java.io.Serializable {

	// Fields

	private SysRoleModuleId id;

	// Constructors

	/** default constructor */
	public SysRoleModule() {
	}

	/** full constructor */
	public SysRoleModule(SysRoleModuleId id) {
		this.id = id;
	}

	// Property accessors

	public SysRoleModuleId getId() {
		return this.id;
	}

	public void setId(SysRoleModuleId id) {
		this.id = id;
	}

}