package com.fdo.hum;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * SysModule entity. @author MyEclipse Persistence Tools
 */

public class SysModule implements java.io.Serializable {

	// Fields

	private Integer moduleId;
	private String moduleCode;
	private String moduleName;
	private Short resType;
	private String internalCode;
	private String moduleLink;
	private Short seqNo;
	private Short isEnable;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;
	private String memo;
	private Set sysRoleModules = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysModule() {
	}

	/** minimal constructor */
	public SysModule(String moduleCode, String moduleName, String moduleLink, Timestamp modifyDateTime) {
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.moduleLink = moduleLink;
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public SysModule(String moduleCode, String moduleName, Short resType, String internalCode, String moduleLink,
			Short seqNo, Short isEnable, Timestamp createDateTime, Timestamp modifyDateTime, String memo,
			Set sysRoleModules) {
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.resType = resType;
		this.internalCode = internalCode;
		this.moduleLink = moduleLink;
		this.seqNo = seqNo;
		this.isEnable = isEnable;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
		this.memo = memo;
		this.sysRoleModules = sysRoleModules;
	}

	// Property accessors

	public Integer getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleCode() {
		return this.moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Short getResType() {
		return this.resType;
	}

	public void setResType(Short resType) {
		this.resType = resType;
	}

	public String getInternalCode() {
		return this.internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public String getModuleLink() {
		return this.moduleLink;
	}

	public void setModuleLink(String moduleLink) {
		this.moduleLink = moduleLink;
	}

	public Short getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(Short seqNo) {
		this.seqNo = seqNo;
	}

	public Short getIsEnable() {
		return this.isEnable;
	}

	public void setIsEnable(Short isEnable) {
		this.isEnable = isEnable;
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

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set getSysRoleModules() {
		return this.sysRoleModules;
	}

	public void setSysRoleModules(Set sysRoleModules) {
		this.sysRoleModules = sysRoleModules;
	}

}