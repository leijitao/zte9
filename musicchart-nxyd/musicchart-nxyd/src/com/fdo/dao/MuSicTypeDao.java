package com.fdo.dao;

import java.util.List;

import com.fdo.hum.MusicType;

public interface MuSicTypeDao {
	/**
	 * findClass
	 */
	public List<MusicType> findClass();
	/**
	 * ObjectClass
	 */
	public MusicType findObjectClass(String id);
	
	public List<MusicType> findBigClass();
	public List<MusicType> findSmaClass(String code);
	public MusicType findTypeCode(String typeId);
}
