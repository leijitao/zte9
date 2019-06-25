package com.fdo.service.impl;

import java.util.List;

import com.fdo.dao.MuSicTypeDao;
import com.fdo.hum.MusicType;
import com.fdo.service.MuSicTypeService;

public class MuSicTypeServiceImpl implements MuSicTypeService {

	private MuSicTypeDao muSicTypeDao;
	
	public MuSicTypeDao getMuSicTypeDao() {
		return muSicTypeDao;
	}
	public void setMuSicTypeDao(MuSicTypeDao muSicTypeDao) {
		this.muSicTypeDao = muSicTypeDao;
	}

	@Override
	public List<MusicType> findClass() {
		// TODO Auto-generated method stub
		return muSicTypeDao.findClass();
	}
	@Override
	public MusicType findObjectClass(String id) {
		// TODO Auto-generated method stub
		return muSicTypeDao.findObjectClass(id);
	}
	@Override
	public List<MusicType> findBigClass() {
		// TODO Auto-generated method stub
		return muSicTypeDao.findBigClass();
	}
	@Override
	public List<MusicType> findSmaClass(String code) {
		// TODO Auto-generated method stub
		return muSicTypeDao.findSmaClass(code);
	}
	@Override
	public MusicType findTypeCode(String typeId) {
		// TODO Auto-generated method stub
		return muSicTypeDao.findTypeCode(typeId);
	}
}
