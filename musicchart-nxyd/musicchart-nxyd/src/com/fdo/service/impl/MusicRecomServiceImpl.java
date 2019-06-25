package com.fdo.service.impl;

import java.util.List;

import com.fdo.dao.MusicRecomDao;
import com.fdo.hum.MusicRecom;
import com.fdo.service.MusicRecomService;

public class MusicRecomServiceImpl implements MusicRecomService {

	private MusicRecomDao musicRecomDao;
	
	public MusicRecomDao getMusicRecomDao() {
		return musicRecomDao;
	}
	public void setMusicRecomDao(MusicRecomDao musicRecomDao) {
		this.musicRecomDao = musicRecomDao;
	}

	@Override
	public List<MusicRecom> findSmallClass(String code) {
		// TODO Auto-generated method stub
		return musicRecomDao.findSmallClass(code);
	}

}
