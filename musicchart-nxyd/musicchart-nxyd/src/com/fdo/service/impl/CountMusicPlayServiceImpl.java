package com.fdo.service.impl;

import java.util.List;

import com.fdo.dao.CountMusicPlayDao;
import com.fdo.hum.MusicCp;
import com.fdo.service.CountMusicPlayService;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.FindMusicInfoVO;
import com.fdo.vo.SongDateVO;
import com.fdo.vo.SongVO;

public class CountMusicPlayServiceImpl implements CountMusicPlayService {

	private CountMusicPlayDao countMusicPlayDao;
	
	public CountMusicPlayDao getCountMusicPlayDao() {
		return countMusicPlayDao;
	}
	public void setCountMusicPlayDao(CountMusicPlayDao countMusicPlayDao) {
		this.countMusicPlayDao = countMusicPlayDao;
	}

	@Override
	public SongVO findCountMusicPlayDay() {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findCountMusicPlayDay();
	}

	@Override
	public SongVO findCountMusicPlayYesterday() {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findCountMusicPlayYesterday();
	}

	@Override
	public List<SongDateVO> findSevenDay(String day) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findSevenDay(day);
	}

	@Override
	public List<SongDateVO> findMon() {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findMon();
	}

	@Override
	public SongVO findAll(String day) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findAll(day);
	}

	@Override
	public List<SongDateVO> findYesrMon(String year) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findYesrMon(year);
	}
	@Override
	public List<SongDateVO> findMon2() {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findMon2();
	}
	@Override
	public List<SongDateVO> findYesrMon2(String year) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findYesrMon2(year);
	}
	@Override
	public List<FindMusicInfoVO> findMusicInfoVOs() {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findMusicInfoVOs();
	}
	@Override
	public List<FindMusicInfoVO> findLikesMusicInfoVOs(String musiceName, String playerName,Integer page) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findLikesMusicInfoVOs(musiceName, playerName,page);
	}
	@Override
	public SongVO findUserCPCountMusicPlayDay(String cpId,String musicId) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findUserCPCountMusicPlayDay(cpId,musicId);
	}
	@Override
	public SongVO findUserCPCountMusicPlayYesterday(String cpId,String musicId) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findUserCPCountMusicPlayYesterday(cpId,musicId);
	}
	@Override
	public List<SongDateVO> findUserCPSevenDay(String day, String cpId,String musicId) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findUserCPSevenDay(day, cpId,musicId);
	}
	@Override
	public SongVO findUserCPAll(String day, String cpId,String musicId) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findUserCPAll(day, cpId,musicId);
	}
	@Override
	public List<FindMusicInfoVO> findUserCPMusicInfoVOs(String cpId) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findUserCPMusicInfoVOs(cpId);
	}
	@Override
	public List<FindMusicInfoVO> findUserCPLikesMusicInfoVOs(String musiceName, String playerName, String cpId) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findUserCPLikesMusicInfoVOs(musiceName, playerName, cpId);
	}
	@Override
	public List<CPShouRuVO> findObjects(String day,Integer yu) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findObjects(day,yu);
	}
	@Override
	public List<MusicCp> findAll() {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findAll();
	}
	@Override
	public String findZBY(String day,Integer yu) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findZBY(day,yu);
	}
	@Override
	public Integer findLikesMusicInfoVOsCount(String musiceName, String playerName) {
		// TODO Auto-generated method stub
		return countMusicPlayDao.findLikesMusicInfoVOsCount(musiceName, playerName);
	}

}
