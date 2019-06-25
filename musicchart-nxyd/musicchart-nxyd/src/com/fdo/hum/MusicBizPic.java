package com.fdo.hum;

import java.sql.Timestamp;

/**
 * MusicBizPic entity. @author MyEclipse Persistence Tools
 */

public class MusicBizPic implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer musicId;
	private String horBizPic;
	private String verBizPic;
	private Timestamp createDateTime;
	private Timestamp modifyDateTime;

	// Constructors

	/** default constructor */
	public MusicBizPic() {
	}

	/** minimal constructor */
	public MusicBizPic(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	/** full constructor */
	public MusicBizPic(Integer musicId, String horBizPic, String verBizPic, Timestamp createDateTime,
			Timestamp modifyDateTime) {
		this.musicId = musicId;
		this.horBizPic = horBizPic;
		this.verBizPic = verBizPic;
		this.createDateTime = createDateTime;
		this.modifyDateTime = modifyDateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMusicId() {
		return this.musicId;
	}

	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}

	public String getHorBizPic() {
		return this.horBizPic;
	}

	public void setHorBizPic(String horBizPic) {
		this.horBizPic = horBizPic;
	}

	public String getVerBizPic() {
		return this.verBizPic;
	}

	public void setVerBizPic(String verBizPic) {
		this.verBizPic = verBizPic;
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

}