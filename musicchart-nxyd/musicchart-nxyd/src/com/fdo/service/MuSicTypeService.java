package com.fdo.service;

import java.util.List;

import com.fdo.hum.MusicType;

public interface MuSicTypeService {
	
	public List<MusicType> findClass();
	
	public MusicType findObjectClass(String id);
	public List<MusicType> findBigClass();
	public List<MusicType> findSmaClass(String code);
	public MusicType findTypeCode(String typeId);

}
