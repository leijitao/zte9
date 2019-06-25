package com.fdo.service.impl;

import java.util.List;

import com.fdo.dao.CountMusicVisitDao;
import com.fdo.service.CountMusicVisitService;
import com.fdo.vo.ActiveDateVO;
import com.fdo.vo.ActiveVO;

public class CountMusicVisitServiceImpl implements CountMusicVisitService {

	private CountMusicVisitDao countMusicVisitDao;
	
	public CountMusicVisitDao getCountMusicVisitDao() {
		return countMusicVisitDao;
	}
	public void setCountMusicVisitDao(CountMusicVisitDao countMusicVisitDao) {
		this.countMusicVisitDao = countMusicVisitDao;
	}
	
	@Override
	public List<ActiveDateVO> findSevenDay(String day) {
		// TODO Auto-generated method stub
		return countMusicVisitDao.findSevenDay(day);
	}
	
	@Override
	public List<ActiveDateVO> findMon() {
		// TODO Auto-generated method stub
		return countMusicVisitDao.findMon();
	}
	
	@Override
	public ActiveVO findAll(String mub) {
		// TODO Auto-generated method stub
		return countMusicVisitDao.findAll(mub);
	}
	
	@Override
	public List<ActiveDateVO> findYesrMon(String codeId) {
		// TODO Auto-generated method stub
		return countMusicVisitDao.findYesrMon(codeId);
	}
	@Override
	public List<ActiveVO> findCountMuSicVisitDay() {
		// TODO Auto-generated method stub
		return countMusicVisitDao.findCountMuSicVisitDay();
	}
	@Override
	public List<ActiveVO> findCountMuSicVisitYesterday() {
		// TODO Auto-generated method stub
		return countMusicVisitDao.findCountMuSicVisitYesterday();
	}

}
