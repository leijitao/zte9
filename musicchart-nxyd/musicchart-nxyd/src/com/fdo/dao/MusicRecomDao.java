package com.fdo.dao;

import java.util.List;

import com.fdo.hum.MusicRecom;

public interface MusicRecomDao {

	public List<MusicRecom> findSmallClass(String code);
}
