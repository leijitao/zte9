package com.fdo.service.impl;

import java.util.List;

import com.fdo.dao.CountMusicRecDao;
import com.fdo.service.CountMusicRecService;
import com.fdo.vo.ClickDateVO;
import com.fdo.vo.ClickVO;
import com.fdo.vo.RecClicksStatVO;

public class CountMusicRecServiceImpl implements CountMusicRecService {

	private CountMusicRecDao countMusicRecDao;
	
	public CountMusicRecDao getCountMusicRecDao() {
		return countMusicRecDao;
	}
	public void setCountMusicRecDao(CountMusicRecDao countMusicRecDao) {
		this.countMusicRecDao = countMusicRecDao;
	}

	@Override
	public List<ClickVO> findCountMusicRecs(String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findCountMusicRecs(codeId);
	}
	@Override
	public List<ClickVO> findClickVOs(String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findClickVOs(codeId);
	}
	@Override
	public List<ClickDateVO> findSevenDay(String day,String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findSevenDay(day,codeId);
	}
	@Override
	public List<ClickDateVO> findMon(String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findMon(codeId);
	}
	@Override
	public ClickVO findAll(String day,String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findAll(day,codeId);
	}
	@Override
	public List<ClickDateVO> findYesrMon(String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findYesrMon(codeId);
	}
	@Override
	public ClickVO findfzd(String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findfzd(codeId);
	}
	@Override
	public ClickVO findfzy(String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findfzy(codeId);
	}
	@Override
	public List<ClickDateVO> findSevenDayTJW(String day, String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findSevenDayTJW(day, codeId);
	}
	@Override
	public ClickVO findAllTJW(String day, String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findAllTJW(day, codeId);
	}
	@Override
	public ClickVO findAllzd(String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findAllzd(codeId);
	}
	@Override
	public ClickVO findAllzy(String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findAllzy(codeId);
	}
	@Override
	public List<ClickDateVO> findAllSevenDay(String day, String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findAllSevenDay(day, codeId);
	}
	@Override
	public ClickVO findAllClickVO(String day, String codeId) {
		// TODO Auto-generated method stub
		return countMusicRecDao.findAllClickVO(day, codeId);
	}

	@Override
	public List<RecClicksStatVO> selectRecClicks(String className, String day) {
		return countMusicRecDao.selectRecClicks(className, day);
	}
	
}
