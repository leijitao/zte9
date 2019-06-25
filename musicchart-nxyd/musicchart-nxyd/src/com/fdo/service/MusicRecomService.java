package com.fdo.service;

import java.util.List;

import com.fdo.hum.MusicRecom;

public interface MusicRecomService {

	public List<MusicRecom> findSmallClass(String code);
}
